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
 * @createdAt: 2020/8/15 10:10
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_express_company")
public class ExpressCompany {

    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;
    private Platform platform;
    @Column(length = 64)
    private String name;
    private Integer seqNo;
    private String apiType;
    private Date createType;



}
