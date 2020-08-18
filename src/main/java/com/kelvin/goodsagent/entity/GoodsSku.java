package com.kelvin.goodsagent.entity;

import com.kelvin.goodsagent.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:00
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_goods_sku")
public class GoodsSku {
    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;


    private Platform platform;

    @OneToOne
    private ExpressCompany expressCompany;

    @ManyToOne
    private Warehouse warehouse;

    @Column(length = 64)
    private String title;

    @Column(length = 16)
    private String price1;
    @Column(length = 16)
    private String price2;
    @Column(length = 16)
    private String price3;
    @Column(length = 16)
    private String price4;
    @Column(length = 16)
    private String price5;


    private Date createTime;
    private Date updateTime;

    /**
     * 库存
     */
    private Long stock;


    @ManyToOne
    private Goods goods;
}
