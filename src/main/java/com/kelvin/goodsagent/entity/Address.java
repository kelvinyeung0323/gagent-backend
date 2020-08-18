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
@Table(name = "g_address")
public class Address {


    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;

    @ManyToOne
    private User user;

    //发货人
    @Column(length = 64)
    private String consignor;

    @Column(length = 16)
    private String phoneNo;


    @OneToOne(fetch = FetchType.LAZY)
    private Area area;

    @Column(name = "is_default")
    private boolean isDefault;

    @Column(length = 255)
    private String detailAddr;

    private Date createTime;
    private Date updateTime;
}
