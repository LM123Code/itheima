package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 * @author LM_Code
 * @create 2019-02-21-14:41
 */
public class Client {
    public static void main(String[] args) {

//        ICustomerService customerService = BeanFactory.getCustomerService();
//        ICustomerService customerService = new CustomerServiceImpl();
        ICustomerService customerService = (ICustomerService) BeanFactory.getBean("CUTOMERSERVICE");
        customerService.saveCustomer();

    }
}
