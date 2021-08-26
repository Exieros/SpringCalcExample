package com.example.servingwebcontent.converters;


import com.example.servingwebcontent.enums.EnumConvertOperations;
import org.springframework.core.convert.converter.Converter;

public class StringToEnum_Convert implements Converter<String, EnumConvertOperations> {
    @Override
    public EnumConvertOperations convert(String source) {
        return EnumConvertOperations.valueOf(source.toUpperCase());
    }
}