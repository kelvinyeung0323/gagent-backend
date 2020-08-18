package com.kelvin.goodsagent.api;

import com.kelvin.goodsagent.api.vo.GoodsSkuVo;
import com.kelvin.goodsagent.api.vo.GoodsSummaryVo;
import com.kelvin.goodsagent.common.http.RestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:56
 * @description:
 */
@RestController()
@RequestMapping("api")
public class GoodsController {


    @GetMapping("goods")
    public RestResult<GoodsSummaryVo> getGoods(){


        return null;
    }

    @GetMapping("goods/{skuId}")
    public RestResult<GoodsSkuVo> getGoodsSku(@PathVariable("skuId") String skuId){

        return null;
    }
}
