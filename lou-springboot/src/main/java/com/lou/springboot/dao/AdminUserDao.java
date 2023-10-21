package com.lou.springboot.dao;

import com.lou.springboot.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminUserDao {

    // search user list based on parameter
    List<AdminUser> findAdminUsers(Map param);

    // return total user num
    int getTotalAdminUser(Map param);

    // get user record according to userName and password
    AdminUser getAdminUserByUserNameAndPassword(@Param("userName") String userName, @Param("passwordMD5") String passwordMD5);

    // get user record by token
    AdminUser getAdminUserByToken(String userToken);

    // get user record by id
    AdminUser getAdminUserById(Long id);

    // get user record by username
    AdminUser getAdminUserByUserName(String userName);

    // add user
    int addUser(AdminUser user);

    // batch add users
    int insertUsersBatch(@Param("adminUsers") List<AdminUser> adminUsers);

    // update user password
    int updateUserPassword(@Param("userId") Long userId, @Param("newPassword") String newPassword);

    // update user token
    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);

    // batch delete
    int deleteBatch(Object[] ids);

    // get all users
    List<AdminUser> getAllAdminUsers();
}
