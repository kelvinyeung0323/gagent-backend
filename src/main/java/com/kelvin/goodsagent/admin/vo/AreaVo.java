package com.kelvin.goodsagent.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;

import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 17:39
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaVo {
    private String id;
    private String  parentId;
    private String name;

    private List<AreaVo> child;
}
