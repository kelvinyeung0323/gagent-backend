package com.kelvin.goodsagent.enums;

import lombok.Data;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 10:45
 * @description:
 */

public enum  OrderStatus {

    SENDED("sended","快递已发出"),
    ORDERED4SEND("ordered4send","已下单待发出"),
    BILLING("billing","正在出单进号"),
    WAIT4SEND("wait4send","等待发出"),
    WAIT4BILL("wait4bill","等待出单号"),
    ERROR("error","有错误的订单");

    private String code;
    private String msg;

    OrderStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
