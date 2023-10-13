package com.lou.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
//    @ResponseBody
    public String hello(Model model, @RequestParam(value = "description",
            required = false, defaultValue = "springboot-thymeleaf") String description) {

//        request.setAttribute("description", description);
        model.addAttribute("description", description);
        return "thymeleaf";
    }

    @GetMapping("/attributes")
    public String attributes(ModelMap map) {
        map.put("th_background", "#D0D0D0");
        // change h1
        map.put("title", "Thymeleaf label demo");
        // change id, name, value
        map.put("th_id", "thymeleaf-input");
        map.put("th_name", "thymeleaf-input");
        map.put("th_value", 13);
        // change class, href
        map.put("th_class", "thymeleaf-class");
        map.put("th_href", "http://13blog.site");
        return "attributes";
    }

    @GetMapping("/simple")
    public String simple(ModelMap map) {
        map.put("thymeleafText", "shiyanlou");
        return "simple";
    }

    @GetMapping("/test")
    public String test(ModelMap map) {
        map.put("title", "Thymeleaf syntax test");
        map.put("testString", "Play Spring Boot");
        map.put("bool", true);
        map.put("testArray", new Integer[]{2019, 2020, 2021, 2022, 2023});
        map.put("testList", Arrays.asList("Spring", "Spring Boot", "Thymeleaf", "MyBatis", "Java"));
        Map testMap = new HashMap();
        testMap.put("platform", "shiyanlou");
        testMap.put("title", "Play Spring Boot");
        testMap.put("author", "thirteen");
        map.put("testMap", testMap);
        map.put("testDate", new Date());
        return "test";
    }
}
