package com.kelvin.goodsagent.entity;

import com.kelvin.goodsagent.enums.VipLvl;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 16:35
 * @description:
 */

@Data
@Entity
@Table(name = "g_user")
public class User {
    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    @Column(length = 32)
    private String  id;

    @Column(length = 255)
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(length = 64)
    private String nickName;
    @Column(length = 128)
    private String password;
    @Column(length = 64)
    private String username;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(length = 16)
    private String qq;

    private VipLvl vipLvl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(length = 10)
    private String role;

    @OneToOne(mappedBy = "user")
    private Account account;
}
