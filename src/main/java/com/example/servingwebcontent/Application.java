package com.example.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({@PropertySource("classpath:application.properties")})
@SpringBootApplication
@ComponentScan({"com.example.servingwebcontent"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}