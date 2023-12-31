package com.lou.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimeZone;

/**
 * @author 13
 * @link http:13blog.site
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    // 注入数据源对象
    @Autowired
    private DataSource dataSource;

    @Test
    public void datasourceTest() throws SQLException {
        // 获取数据源类型
        System.out.println("default data source：" + dataSource.getClass());
        // 获取当前虚拟机时区
        System.out.println(TimeZone.getDefault().getID());
//        System.out.println("中文是否可以正常显示呢");
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        // 判断连接对象是否为空
        System.out.println(connection != null);
        if (connection != null) {
            connection.close();
        }
    }
}
