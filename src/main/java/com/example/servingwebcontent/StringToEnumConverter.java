package com.example.servingwebcontent;


import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, EnumOperations> {
    @Override
    public EnumOperations convert(String source) {
        return EnumOperations.valueOf(source.toUpperCase());
    }
}