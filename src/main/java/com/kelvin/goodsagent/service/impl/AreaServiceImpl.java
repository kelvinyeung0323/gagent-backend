package com.kelvin.goodsagent.service.impl;

import com.kelvin.goodsagent.entity.Area;
import com.kelvin.goodsagent.repository.AreaRepository;
import com.kelvin.goodsagent.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 17:33
 * @description:
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getAllArea() {
       return areaRepository.findAll();
    }
}
