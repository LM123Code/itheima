package com.itheima.factory;


import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

/**
 * 模拟一个静态方法
 * @author LM_Code
 * @create 2019-02-24-9:49
 */
public class StaticFactory {
    public static ICustomerService getICustomerService(){
        return new CustomerServiceImpl();
    }
}
