package com.lou.springboot;

import com.lou.springboot.config.ComandRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello shiyanlou!
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println("running Spring Boot...");
        SpringApplication.run(Application.class, args);

    }
}