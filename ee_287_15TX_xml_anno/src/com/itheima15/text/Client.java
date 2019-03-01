package com.itheima15.text;

import com.itheima15.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LM_Code
 * @create 2019-03-01-15:43
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
//        Account account = accountService.findAccountById(1);
//        System.out.println(account);
        accountService.transfer("aaa", "bbb", 100f);
    }
}
