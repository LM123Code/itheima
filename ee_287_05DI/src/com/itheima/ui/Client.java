package com.itheima.ui;

import com.itheima.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LM_Code
 * @create 2019-02-24-10:48
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        /*ICustomerService customerService = (ICustomerService) ac.getBean("customerService");
        customerService.saveCustomer();*/
        /*ICustomerService customerService2 = (ICustomerService) ac.getBean("customerService2");
        customerService2.saveCustomer();*/
        ICustomerService customerService3 = (ICustomerService) ac.getBean("customerService3");
        customerService3.saveCustomer();
    }
}
