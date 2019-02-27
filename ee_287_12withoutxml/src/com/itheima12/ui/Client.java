package com.itheima12.ui;

import com.itheima12.service.ICustomerService;
import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LM_Code
 * @create 2019-02-26-17:03
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
        cs.saveCustomer();
    }
}