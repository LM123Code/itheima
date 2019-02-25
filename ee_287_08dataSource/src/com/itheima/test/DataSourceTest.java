package com.itheima.test;

import com.itheima.dataSource.MyDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LM_Code
 * @create 2019-02-25-20:39
 */
public class DataSourceTest {
    public static void main(String[] args) throws SQLException {
        int size = MyDataSource.getPoolSize();
        System.out.println(size);
        Connection conn = MyDataSource.getConnection();
        System.out.println(conn);
        conn.close();
        System.out.println(MyDataSource.getPoolSize());
    }
}
