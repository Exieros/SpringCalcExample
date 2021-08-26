package com.example.servingwebcontent.converters;


import com.example.servingwebcontent.enums.EnumMathOperations;
import org.springframework.core.convert.converter.Converter;

public class StringToEnum_Math implements Converter<String, EnumMathOperations> {
    @Override
    public EnumMathOperations convert(String source) {
        return EnumMathOperations.valueOf(source.toUpperCase());
    }
}