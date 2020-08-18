package com.kelvin.goodsagent.api.vo;

import com.kelvin.goodsagent.enums.TradeType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:22
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "账户流水")
public class AccountFlowVo {

    @Schema(description = "id")
    private String id;


    @Schema(description = "交易类型")
    private TradeType tradeType;
    private String orderId;
    @Schema(description = "交易时间")
    private Date tradeTime;


    private String tradeAmt;
    @Schema(description = "交易后")
    private String beforeBal;
    @Schema(description = "交易后")
    private String afterBal;

    @Schema(description = "说明")
    private String remark;

}
