package com.kelvin.goodsagent.api.vo;

import com.kelvin.goodsagent.enums.OrderStatus;
import com.kelvin.goodsagent.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:54
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {

    private String orderId;
    private String createTime;
    private OrderType orderType;
    private String expressName;
    private String goodsName;
    private String consignorAddr;
    private String consigneeAddr;
    private String orderNo;
    private String expressNo;
    private OrderStatus orderStatus;
}
