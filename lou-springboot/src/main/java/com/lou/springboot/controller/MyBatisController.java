package com.lou.springboot.controller;

import com.lou.springboot.dao.UserDao;
import com.lou.springboot.entity.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MyBatisController {

    @Resource
    UserDao userDao;

    @GetMapping("/users/mybatis/queryAll")
    public List<User> queryAll() {
        return userDao.findAllUsers();
    }

    @GetMapping("/users/mybatis/insert")
    public Boolean insert(String name, String password) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name) || StringUtils.isEmptyOrWhitespaceOnly(password))
            return false;

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return userDao.insertUser(user) > 0;
    }

    @GetMapping("/users/mybatis/update")
    public Boolean update(Integer id, String name, String password) {
        if (id == null || id < 1 || StringUtils.isEmptyOrWhitespaceOnly(name) || StringUtils.isEmptyOrWhitespaceOnly(password))
            return false;

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        return userDao.updateUser(user) > 0;
    }

    @GetMapping("/users/mybatis/delete")
    public Boolean delete(Integer id) {
        if (id == null || id < 1)
            return false;
        return userDao.deleteUser(id) > 0;
    }
}
