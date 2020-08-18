package com.kelvin.goodsagent.repository;

import com.kelvin.goodsagent.entity.Area;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:47
 * @description:
 */
public interface AreaRepository extends BaseRepository<Area,String> {


    @Query("select a from Area a where a.parentId = '0'")
    List<Area> findAll();
}
