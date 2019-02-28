package com.itheima13.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate的最基本的用法
 * @author LM_Code
 * @create 2019-02-28-16:41
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        //2.执行操作
        //保存
//        jt.update("insert into account(name,money)values (?,?)","fff",3456);
        //更新
//        jt.update("update account set money = ? where id=?",4567,3);
        //删除
//        jt.update("delete from account where id = ?",5);
        //查询所有
//        RowMapper rm = null;
//        List<Account> list = jt.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),1000);
//        for(Account account:list){
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> list = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        if(!list.isEmpty()){
//            System.out.println(list.get(0));
//        }
        //查询返回一行一列：聚合函数的使用
        Integer count1 = jt.queryForObject("select count(*) from account where money > ?", Integer.class, 1000);
        Long count2 = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000);
        System.out.println(count1);
        System.out.println(count2);
    }
}
