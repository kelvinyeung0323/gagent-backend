package com.kelvin.goodsagent.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/10 12:42
 * @description:
 */
public class DozerUtil {
    private static Mapper mapper = new DozerBeanMapper();

    public static <T> List<T> mapList(List<?> sources, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (sources == null) {
            return list;
        }
        for (Object o : sources) {
            T t = map(o, clazz);
            list.add(t);
        }
        return list;
    }

    public static void map(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }

        mapper.map(source, target);
    }

    public static <T> T map(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }

        return mapper.map(source, target);
    }


}
