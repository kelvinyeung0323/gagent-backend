package com.kelvin.goodsagent.entity;

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
@Table(name = "g_warehouse")
public class Warehouse {


    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;

    @Column(length = 64)
    private String name;

    private Integer seqNo;

    @OneToOne(fetch = FetchType.LAZY)
    private Area area;

    @Column(length = 255)
    private String detailAddr;

    @Column(length = 6)
    private String postCode;

    private Date createTime;
    private Date updateTime;

    @OneToMany(mappedBy = "warehouse")
    private List<GoodsSku> goodsSkus;
}
