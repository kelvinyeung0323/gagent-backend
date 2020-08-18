package com.kelvin.goodsagent.enums;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:30
 * @description:
 */


public enum TradeType {
    CHARGE("充值"), OPTIMIZE("店铺优化"), BILL("快递单号"), COMMISSION_IN("推广佣金"), COMMISSINO_OUT("佣金转出"), CASH("提现");

    private String msg;

    TradeType(String msg) {
        this.msg = msg;
    }
}
