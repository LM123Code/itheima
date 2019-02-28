package com.itheima13.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate的最基本的用法
 * @author LM_Code
 * @create 2019-02-28-16:41
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        /*//定义数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/addressbook");
        ds.setUsername("root");
        ds.setPassword("nanshen166013");
        //1.获取对象
        //JdbcTemplate jt = new JdbcTemplate(ds);//初始化时传数据源对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);*/
//------------------------------------------------------
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        //2.执行操作
        jt.execute("insert into account(name, money) values ('ddd',1234)");
    }
}
