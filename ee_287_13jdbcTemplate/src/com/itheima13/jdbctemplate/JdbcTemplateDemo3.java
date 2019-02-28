package com.itheima13.jdbctemplate;

import com.itheima13.dao.IAccountDao;
import com.itheima13.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate的最基本的用法
 * @author LM_Code
 * @create 2019-02-28-16:41
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao acc = (IAccountDao) ac.getBean("accountDao2");
        //执行操作
        Account account = acc.findAccountById(1);
        account.setMoney(5788f);
        acc.updateAccount(account);
        System.out.println(acc.findAccountById(1));
    }
}
