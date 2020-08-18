package com.kelvin.goodsagent.dto;

import com.kelvin.goodsagent.enums.TradeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:42
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFlowQueryDto extends PageDto {

    private Date startTime;
    private Date endTime;
    private TradeType tradeType;
}
