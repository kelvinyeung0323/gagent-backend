package com.kelvin.goodsagent.entity;

import com.kelvin.goodsagent.enums.OrderStatus;
import com.kelvin.goodsagent.enums.OrderType;
import com.kelvin.goodsagent.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 9:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_order")
public class Order {


    /**
     * 下单批次
     */
    @Id
    @GeneratedValue(generator="orderGenerator")
    @GenericGenerator(name="orderGenerator", strategy="com.kelvin.goodsagent.common.idgenerator.OrderGenerator")
    private String id;


    @OneToOne
    private User user;
    private OrderStatus status;

    private OrderType orderType;
    /**
     * 电商平台
     */
    private Platform platform;

    /**
     * 快递公司
     */
    @OneToOne
    private ExpressCompany expressCompany;

    /**
     * 发货人地址
     */
    @OneToOne()
    private Address consignorAddress;


    @OneToOne
    private Warehouse warehouse;


    @OneToOne
    private GoodsSku goodsSku;


    /**
     * 包裹里面的物吕名称(optional)
     */
    private String remark1;


    /**
     * 包裹实际重果（optional）
     */
    private String remark2;


    /**
     * 每个包裹的物品数量
     */
    private String rmark3;

    /**
     * 会员总价
     */
    private String totalAmt;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    private Date createTime;
    private Date updateTime;

}
