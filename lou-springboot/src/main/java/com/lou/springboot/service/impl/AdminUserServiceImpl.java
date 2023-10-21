package com.lou.springboot.service.impl;

import com.lou.springboot.dao.AdminUserDao;
import com.lou.springboot.entity.AdminUser;
import com.lou.springboot.service.AdminUserService;
import com.lou.springboot.utils.NumberUtil;
import com.lou.springboot.utils.PageResult;
import com.lou.springboot.utils.PageUtil;
import com.lou.springboot.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public PageResult getAdminUserPage(PageUtil pageUtil) {
        // data list in cur page
        List<AdminUser> users = adminUserDao.findAdminUsers(pageUtil);
        // count total record
        int total = adminUserDao.getTotalAdminUser(pageUtil);
        PageResult pageResult = new PageResult(total, pageUtil.getLimit(), pageUtil.getPage(), users);
        return pageResult;
    }

    /**
     * get token
     * @param sessionId
     * @param userId
     * @return
     */
    private String getNewToken(String sessionId, Long userId) {
        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        AdminUser adminUser = adminUserDao.getAdminUserByUserNameAndPassword(userName, password);
        if (adminUser != null) {
            // update token after user login
            String token = getNewToken(System.currentTimeMillis() + "", adminUser.getId());
            if (adminUserDao.updateUserToken(adminUser.getId(), token) > 0) {
                // return user with new token
                adminUser.setUserToken(token);
                return adminUser;
            }
        }
        return null;
    }
}
