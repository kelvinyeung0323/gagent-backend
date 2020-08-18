package com.kelvin.goodsagent.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 16:34
 * @description:
 */
@Data
@Entity
@Table(name = "g_area")
public class Area {

    @Column(length = 32)
    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;

    @Column(length = 32)
    private String parentId;

    @Column(length = 32)
    private String shortName;
    @Column(length = 32)
    private String name;

    @Column(length = 50)
    private String mergeName;
    private Integer lvl;
    @Column(length = 50)
    private String pinyin;
    @Column(length = 50)
    private String code;
    @Column(length = 12)
    private String zipCode;
    @Column(length = 2)
    private String firstLetter;
    @Column(length = 50)
    private String lng;

    @Column(length = 50)
    private String lat;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private List<Area> child;
}
