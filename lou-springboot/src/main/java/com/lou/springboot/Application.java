package com.lou.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello shiyanlou!
 *
 */
@SpringBootApplication
@MapperScan("com.lou.springboot.dao")   // add @Mapper
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println("running Spring Boot...");
        SpringApplication.run(Application.class, args);
    }
}