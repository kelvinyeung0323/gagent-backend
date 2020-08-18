package com.kelvin.goodsagent.service.impl;

import com.kelvin.goodsagent.dto.AccountFlowQueryDto;
import com.kelvin.goodsagent.entity.Account;
import com.kelvin.goodsagent.entity.AccountFlow;
import com.kelvin.goodsagent.entity.User;
import com.kelvin.goodsagent.enums.TradeType;
import com.kelvin.goodsagent.repository.AccountFlowRepository;
import com.kelvin.goodsagent.repository.AccountRepository;
import com.kelvin.goodsagent.service.AccountService;
import com.kelvin.goodsagent.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 14:59
 * @description:
 */
@Service
public class AccountServiceImpl extends BaseService implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountFlowRepository accountFlowRepository;

    @Override
    public Page<AccountFlow> queryAccountFlow(AccountFlowQueryDto query) {
        User user = getCurrentUser();
        Specification<AccountFlow> spec = new Specification<AccountFlow>() {
            @Override
            public Predicate toPredicate(Root<AccountFlow> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                Path<String> userId = root.get("userId");
                Path<Date> tradeTime = root.get("tradeTime");
                Path<TradeType> tradeType = root.get("tradeType");
                Predicate p1 = cb.lessThanOrEqualTo(tradeTime,query.getEndTime());
                Predicate p2 = cb.greaterThanOrEqualTo(tradeTime,query.getStartTime());
                Predicate p3 = cb.equal(userId,user.getId());
                Predicate p4 = cb.and(p1,p2,p3);
                if(null != tradeTime){
                   p4 = cb.and(p4,cb.equal(tradeType,query.getTradeType()));
                }
                return p4;
            }
        };

        return accountFlowRepository.findAll(spec, PageRequest.of(query.getPageNum(),query.getPageSize()));
    }

    @Override
    public Account getAccountByUserId(String userId) {
        return accountRepository.getOne(userId);
    }
}
