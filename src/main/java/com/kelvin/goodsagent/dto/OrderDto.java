package com.kelvin.goodsagent.dto;

import com.kelvin.goodsagent.enums.OrderType;
import com.kelvin.goodsagent.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 13:41
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {



    @NotNull
    private OrderType orderType;
    @NotBlank
    private Platform platform;
    @NotBlank
    private String expressCompanyId;
    @NotBlank
    private String addressId;
    @NotBlank
    private String warehouseId;
    @NotBlank
    private String goodsSkuId;
    @NotEmpty
    private List<OrderDetailDto> orderDetails;

    private String totalAmt;

    private String remark1;
    private String remark2;
    private String remark3;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetailDto{
        @NotBlank
        private String consignee;
        @NotBlank
        private String phoneNo;
        @NotBlank
        private String province;
        @NotBlank
        private String city;
        @NotBlank
        private String area;
        @NotBlank
        private String detailAddr;
        private String postCode;
        @NotBlank
        private String orderNo;


    }



}
