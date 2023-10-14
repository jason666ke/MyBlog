package com.lou.springboot.controller;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    // 自动配置，通过 @Autowired注入
    @Autowired
    JdbcTemplate jdbcTemplate;

    // search all record
    @GetMapping("/users/queryAll")
    public List<Map<String, Object>> queryAll() {
        return jdbcTemplate.queryForList("select * from tb_user");
    }

    // add new record
    @GetMapping("/users/insert")
    public Object insert(String name, String password) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name) || StringUtils.isEmptyOrWhitespaceOnly(password)) {
            return false;
        }
        String sql = "insert into tb_user(`name`, `password`) value (\"" + name + "\", \"" + password + "\")";
        System.out.println(sql);
        jdbcTemplate.execute(sql);
        return true;
    }

}
