package com.kelvin.goodsagent.service;

import com.kelvin.goodsagent.dto.OrderDto;
import com.kelvin.goodsagent.dto.OrderQueryDto;
import com.kelvin.goodsagent.entity.Order;
import com.kelvin.goodsagent.entity.OrderDetail;
import org.springframework.data.domain.Page;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:53
 * @description:
 */
public interface OrderService {


    Page<OrderDetail> queryOrder(OrderQueryDto query);

    Order placeOrder(OrderDto orderDto);

}
