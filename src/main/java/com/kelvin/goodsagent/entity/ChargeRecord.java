package com.kelvin.goodsagent.entity;

import com.kelvin.goodsagent.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 13:59
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_charge_record")
public class ChargeRecord {

    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;

    private PayType payType;

    @Column(length = 16)
    private String payAmt;


    private Date createTime;

    private Date updateTime;
}
