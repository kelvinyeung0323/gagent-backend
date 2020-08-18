package com.kelvin.goodsagent.common.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/10 18:45
 * @description:
 */
//@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<Object, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public Object convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Object.class);
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }
}
