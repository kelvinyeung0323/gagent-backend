package com.kelvin.goodsagent.entity;

import com.kelvin.goodsagent.enums.TradeType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:27
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "g_account_flow")
public class AccountFlow {
    @Id
    @GeneratedValue(generator="sys_uid")
    @GenericGenerator(name="sys_uid", strategy="uuid")
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String userId;

    private TradeType tradeType;
    @Column(length = 32)
    private String orderNo;
    private Date tradeTime;
    @Column(length = 16)
    private String tradeAmt;
    @Column(length = 16)
    private String beforeBal;
    @Column(length = 16)
    private String afterBal;
    private String remark;


}
