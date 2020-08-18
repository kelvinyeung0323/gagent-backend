package com.kelvin.goodsagent.dto;

import com.kelvin.goodsagent.enums.OrderStatus;
import com.kelvin.goodsagent.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:49
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderQueryDto extends PageDto{

    private Date starTime;
    private Date endTime;

    private OrderStatus orderStatus;
    private OrderType orderType;
    private String orderNo;
    private String expressNo;
    private String phoneNo;
    private String batchId;
}
