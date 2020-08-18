package com.kelvin.goodsagent.api.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 14:56
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "账户信息")
public class AccountVo {

    @Schema(description = "余额")
    private String balance;
    @Schema(description = "佣金")
    private String commission;
}
