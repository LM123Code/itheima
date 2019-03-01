package com.itheima16.text;

import com.itheima16.service.IAccountService;
import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LM_Code
 * @create 2019-03-01-15:43
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
//        Account account = accountService.findAccountById(1);
//        System.out.println(account);
        accountService.transfer("aaa", "bbb", 100f);
    }
}
