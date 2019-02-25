package com.itheima.ui;

import com.itheima.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LM_Code
 * @create 2019-02-24-17:04
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService cs = (ICustomerService) ac.getBean("customerServiceImpl");
        ICustomerService cs1 = (ICustomerService) ac.getBean("customerServiceImpl");
        cs.saveCustomer();
        System.out.println(cs1 == cs);
    }
}
