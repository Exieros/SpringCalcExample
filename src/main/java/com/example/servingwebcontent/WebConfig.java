package com.example.servingwebcontent;

import com.example.servingwebcontent.converters.StringToEnum_Convert;
import com.example.servingwebcontent.converters.StringToEnum_Math;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter( new StringToEnum_Math() );
        registry.addConverter( new StringToEnum_Convert() );
    }
}