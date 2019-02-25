package com.itheima.dataSource;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义连接池
 * @author LM_Code
 * @create 2019-02-25-19:57
 */
public class MyDataSource {
    private static final String url = "jdbc:mysql://localhost:3306/addressbook";
    private static final String user = "root";
    private static final String password = "nanshen166013";
    //定义一个池用于存放连接
    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());//把ArrayList转成线程安全的
    //使用静态代码块给池中加入连接
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("注册驱动失败" + e);
        }
        for (int i = 0; i < 10; i++) {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("第" + i + "次获取连接失败失败" + e);
            }
            pool.add(conn);
        }
    }
    /*
    获取一个连接
     */
    public static Connection getConnection(){
        final Connection conn = pool.remove(0);
        Connection proxyConn = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtVal = null;
                if("close".equals(method.getName())){
                    pool.add(conn);//还回池中
                }else{
                    rtVal = method.invoke(conn, args);
                }
                return rtVal;
            }
        });
        return proxyConn;
    }
    /*
    获取池中的连接数
     */
    public static int getPoolSize(){
        return pool.size();
    }
}
