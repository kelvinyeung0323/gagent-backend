package com.kelvin.goodsagent.api;

import com.kelvin.goodsagent.api.vo.OrderVo;
import com.kelvin.goodsagent.common.http.RestResult;
import com.kelvin.goodsagent.dto.OrderDto;
import com.kelvin.goodsagent.dto.OrderQueryDto;
import com.kelvin.goodsagent.entity.Order;
import com.kelvin.goodsagent.entity.OrderDetail;
import com.kelvin.goodsagent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:57
 * @description:
 */
@RestController()
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order")
    public RestResult placeOrder(@RequestBody @Valid OrderDto dto){

        Order order= orderService.placeOrder(dto);
        return RestResult.success();
    }

    @GetMapping("orders")
    public RestResult<List<OrderVo>> queryOrder(OrderQueryDto queryDto){

        Page<OrderDetail> page =orderService.queryOrder(queryDto);
        return RestResult.page(page,OrderVo.class);
    }
}
