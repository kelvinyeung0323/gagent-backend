package com.kelvin.goodsagent.entity;

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
 * @createdAt: 2020/8/15 10:02
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_goods")
public class Goods {

    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;
    @Column(columnDefinition = "TEXT")
    private String details;
    private Date createTime;
    private Date updateTime;
    @Column(columnDefinition = "TEXT")
    private String images;
    @OneToMany(mappedBy = "goods")
    private List<GoodsSku> goodsSkus;




}
