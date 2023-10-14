package com.lou.springboot.dao;

import com.lou.springboot.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * return user list
     * @return
     */
    List<User> findAllUsers();

    /**
     * insert new user
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * update user
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * delete user
     * @param id
     * @return
     */
    int deleteUser(Integer id);
}
