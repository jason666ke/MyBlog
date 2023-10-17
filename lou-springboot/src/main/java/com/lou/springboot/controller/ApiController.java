package com.lou.springboot.controller;

import com.lou.springboot.common.Result;
import com.lou.springboot.common.ResultGenerator;
import com.lou.springboot.entity.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api")
public class ApiController {

    static Map<Integer, User> userMap = Collections.synchronizedMap(new HashMap<Integer, User>());

    // initialize map
    static {
        User user = new User();
        user.setId(2);
        user.setName("user1");
        user.setPassword("123456");
        User user2 = new User();
        user2.setId(5);
        user2.setName("13-5");
        user2.setPassword("4");
        User user3 = new User();
        user3.setId(6);
        user3.setName("12");
        user3.setPassword("123");
        userMap.put(2, user);
        userMap.put(5, user2);
        userMap.put(6, user3);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<User> getOne(@PathVariable("id") Integer id) {
        if (id == null || id < 1)
            return ResultGenerator.genFailResult("Lack of parameters");
        User user = userMap.get(id);
        if (user == null)
            return ResultGenerator.genFailResult("No such data");

        return ResultGenerator.genSuccessResult(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<User>> queryAll() {
        List<User> users = new ArrayList<User>(userMap.values());
        return ResultGenerator.genSuccessResult(users);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> insert(@RequestBody User user) {
        if (StringUtils.isEmptyOrWhitespaceOnly(String.valueOf(user.getId())) ||
        StringUtils.isEmptyOrWhitespaceOnly(user.getName()) ||
        StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())) {
            return ResultGenerator.genFailResult("Lack of parameter");
        }

        if (userMap.containsKey(user.getId()))
            return ResultGenerator.genFailResult("Duplicate id");

        userMap.put(user.getId(), user);
        return ResultGenerator.genSuccessResult(true);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> update(@RequestBody User tempUser) {
        if (tempUser.getId() == null ||
        tempUser.getId() < 1 ||
        StringUtils.isEmptyOrWhitespaceOnly(tempUser.getName()) ||
        StringUtils.isEmptyOrWhitespaceOnly(tempUser.getPassword())) {
            return ResultGenerator.genFailResult("Lack of parameter");
        }

        // entity authentication
        User user = userMap.get(tempUser.getId());
        if (user == null)
            return ResultGenerator.genFailResult("No such User");

        user.setName(tempUser.getName());
        user.setPassword(tempUser.getPassword());
        userMap.put(tempUser.getId(), user);
        return ResultGenerator.genSuccessResult(true);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> delete(@PathVariable("id") Integer id) {
        if (id == null || id < 1)
            return ResultGenerator.genFailResult("Lack of parameter");
        userMap.remove(id);
        return ResultGenerator.genSuccessResult(true);
    }
}
