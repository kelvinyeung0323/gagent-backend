package com.kelvin.goodsagent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 9:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_order_detail")
public class OrderDetail {


    @Id
    @GeneratedValue(generator="orderGenerator")
    @GenericGenerator(name="orderGenerator", strategy="com.kelvin.goodsagent.common.idgenerator.OrderGenerator")
    private String id;


    /** 收货人*/
    @Column(length = 64)
    private String consignee;

    @Column(length = 16)
    private String phoneNo;


    @Column(length = 32)
    private String province;

    @Column(length = 32)
    private String city;
    @Column(length = 32)
    private String area;
    private String address;
    @Column(length = 6)
    private String postCode;

    //订单号
    @Column(length = 128)
    private String orderNo;


    /**
     * 快递单号
     */
    @Column(length = 128)
    private String expressNo;

    private Date createTime;
    private Date updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}
