package com.kelvin.goodsagent.admin;

import com.kelvin.goodsagent.admin.vo.AreaVo;
import com.kelvin.goodsagent.common.http.RestResult;
import com.kelvin.goodsagent.entity.Area;
import com.kelvin.goodsagent.service.AreaService;
import com.kelvin.goodsagent.util.DozerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 17:34
 * @description:
 */
@RestController
@RequestMapping("admin/common")
public class CommonController {

    @Autowired
    private AreaService areaService;

    @GetMapping("areas")
    public RestResult<List<AreaVo>> getAllArea(){
        List<Area> areaList= areaService.getAllArea();
        return RestResult.success(DozerUtil.mapList(areaList,AreaVo.class));
    }


}
