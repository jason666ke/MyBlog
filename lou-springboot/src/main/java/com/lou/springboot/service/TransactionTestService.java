package com.lou.springboot.service;

import com.lou.springboot.dao.UserDao;
import com.lou.springboot.entity.User;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionTestService {

    @Resource
    UserDao userDao;

    public Boolean test1() {
        User user = new User();
        user.setName("test1");
        user.setPassword("test1-password");
        // add one new record in database
        userDao.insertUser(user);
        // error
        System.out.println(1 / 0);
        return true;
    }

    @Transactional
    public Boolean test2() {
        User user = new User();
        user.setName("test2");
        user.setPassword("test2-password");

        userDao.insertUser(user);
        System.out.println(1 / 0);
        return true;
    }
}
