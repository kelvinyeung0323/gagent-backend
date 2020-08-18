package com.kelvin.goodsagent.enums;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 10:03
 * @description: 平台
 */
public enum  Platform {
    TAOBAO("taobao","淘宝/天猫"),PIN("pin","拼多多"),JD("jingdong","京东"),ALI("ali","阿里巴巴"),ORTHER("other","其他");

    private String code;
    private String msg;


     Platform(String code,String msg){
        this.code = code;
        this.msg = msg;
    }


}
