package com.lou.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class SpringBootWebMvcConfigurer implements WebMvcConfigurer {
    @Value("${upload.path}")
    private String FILE_UPLOAD_PATH;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/files/**").addResourceLocations("file:D:\\upload\\");
        // get absolute path
        File uploadDirectory = new File(FILE_UPLOAD_PATH);
        String absolutePath = uploadDirectory.getAbsolutePath();
        // map file:// ** to real file path
        registry.addResourceHandler("/files/**").addResourceLocations("file:" + absolutePath + "/");

//        registry.addResourceHandler("/files/**").addResourceLocations("file:/home/project/upload/");
    }
}
