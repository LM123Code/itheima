package com.itheima9.ui;

import com.itheima9.service.ICustomerService;
import com.itheima9.utils.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LM_Code
 * @create 2019-02-26-17:03
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
        cs.saveCustomer();
    }
}