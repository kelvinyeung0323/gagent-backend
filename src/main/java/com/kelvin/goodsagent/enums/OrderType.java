package com.kelvin.goodsagent.enums;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 10:52
 * @description:
 */
public enum OrderType {
    EXPRESS("express","普通快递"),
    MAIL("mail","寄信封件"),
    GIFT("gift","礼品代发");

    private String code;
    private String msg;

    OrderType(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
