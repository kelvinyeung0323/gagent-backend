package com.kelvin.goodsagent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 9:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_account")
public class Account {


    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    private String id;

    @OneToOne
    private User user;


    @Column(length = 16)
    private String balance;

    //佣金
    @Column(length = 16)
    private String commission;


}
