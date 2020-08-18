package com.kelvin.goodsagent.service.impl;

import com.kelvin.goodsagent.common.exception.BizException;
import com.kelvin.goodsagent.dto.OrderDto;
import com.kelvin.goodsagent.dto.OrderQueryDto;
import com.kelvin.goodsagent.entity.*;
import com.kelvin.goodsagent.entity.Order;
import com.kelvin.goodsagent.enums.OrderStatus;
import com.kelvin.goodsagent.enums.OrderType;
import com.kelvin.goodsagent.repository.*;
import com.kelvin.goodsagent.service.BaseService;
import com.kelvin.goodsagent.service.OrderService;
import com.kelvin.goodsagent.util.DozerUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 13:38
 * @description:
 */
@Service
@Transactional
public class OrderServiceImpl extends BaseService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;


    @Autowired
    private ExpressCompanyRepository expressCompanyRepository;

    @Autowired
    private GoodsSkuReposity goodsSkuReposity;


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private AccountFlowRepository accountFlowRepository;


    @Override
    public Page<OrderDetail> queryOrder(OrderQueryDto query) {

        Specification<OrderDetail> specification = new Specification<OrderDetail>() {
            @Override
            public Predicate toPredicate(Root<OrderDetail> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Path<String> orderNo = root.get("orderNo");
                Path<String> expressNo = root.get("expressNo");
                Path<String> phoneNo = root.get("phoneNo");
                Path<OrderType> orderType = root.get("orderType");
                Path<Date> createTime = root.get("createTime");
                Path<String> orderId = root.get("order.id");
                Path<OrderStatus> orderStatus = root.get("orderStauts");
                Path<String> userId = root.get("order.user.id");

                List<Predicate> predicates = new ArrayList<>();
                Predicate p1 = cb.greaterThan(createTime,query.getStarTime());
                Predicate p2 = cb.lessThanOrEqualTo(createTime,query.getEndTime());
                Predicate p3 = cb.equal(userId,getCurrentUser().getId());
                predicates.add(p1);
                predicates.add(p2);
                predicates.add(p3);
                if(StringUtils.isNotBlank(query.getOrderNo())){
                    predicates.add(cb.like(orderNo,query.getOrderNo()));
                }

                if(StringUtils.isNotBlank(query.getExpressNo())){
                    predicates.add(cb.like(expressNo,query.getExpressNo()));
                }

                if(StringUtils.isNotBlank(query.getPhoneNo())){
                    predicates.add(cb.like(phoneNo,query.getPhoneNo()));
                }
                if(null != query.getOrderType()){
                    predicates.add(cb.equal(orderType,query.getOrderType()));
                }

                if(null != query.getOrderStatus()){
                    predicates.add(cb.equal(orderStatus,query.getOrderStatus()));
                }

                if(StringUtils.isNotBlank(query.getBatchId())){
                    predicates.add(cb.like(orderId,query.getBatchId()));
                }
                return cb.and((Predicate[]) predicates.toArray());
            }
        };
        Page<OrderDetail> page = orderDetailRepository.findAll(specification, PageRequest.of(query.getPageNum(), query.getPageSize()));
        return page;
    }

    @Override
    public Order placeOrder(OrderDto dto) {

        Order order = new Order();
        User user = getCurrentUser();
        order.setUser(user);

        //1.生成订单
        Optional<Address> o1 = addressRepository.findById(dto.getAddressId());
        if (!o1.isPresent()) {
            throw new BizException("地址错误");
        }
        order.setConsignorAddress(o1.get());


        Optional<ExpressCompany> o2 = expressCompanyRepository.findById(dto.getExpressCompanyId());
        if (!o2.isPresent()) {
            throw new BizException("快递信息错误");
        }
        order.setExpressCompany(o2.get());


        Optional<Warehouse> o3 = warehouseRepository.findById(dto.getWarehouseId());
        if (!o3.isPresent()) {
            throw new BizException("仓库信息错误");
        }
        order.setWarehouse(o3.get());


        Optional<GoodsSku> o4 = goodsSkuReposity.findById(dto.getGoodsSkuId());
        if (!o4.isPresent()) {
            throw new BizException("商品信息错误");
        }
        order.setGoodsSku(o4.get());


        order.setOrderType(dto.getOrderType());
        order.setPlatform(dto.getPlatform());
        order.setStatus(OrderStatus.ORDERED4SEND);
        order.setRemark1(dto.getRemark1());
        order.setRemark2(dto.getRemark2());
        order.setRmark3(dto.getRemark3());
        order.setTotalAmt(dto.getTotalAmt());
        order.setUpdateTime(new Date());
        order.setCreateTime(new Date());


        List<OrderDetail> orderDetailList = DozerUtil.mapList(dto.getOrderDetails(), OrderDetail.class);
        order.setOrderDetails(orderDetailList);

        order = orderRepository.save(order);

        //2.扣减余额
        AccountFlow accountFlow = new AccountFlow();

        Account account = accountRepository.findByUserId(user.getId());
        if (account == null) {
            throw new BizException("获取账户数据错误");
        }
        BigDecimal balance = new BigDecimal(account.getBalance());
        balance = balance.subtract(new BigDecimal(dto.getTotalAmt()));
        account.setBalance(balance.toPlainString());
        accountFlow.setTradeAmt(dto.getTotalAmt());
        accountFlow.setBeforeBal(account.getBalance());
        accountFlow.setAfterBal(account.getBalance());
        accountFlow.setUserId(user.getId());
        accountFlow.setTradeTime(new Date());

        accountRepository.save(account);
        accountFlowRepository.save(accountFlow);

        //TODO:记录交易流水


        return order;
    }


}
