package com.itheima.factory;

import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

/**
 * 模拟一个动态方法
 * @author LM_Code
 * @create 2019-02-24-10:01
 */
public class InstanceFactory {
    public ICustomerService getCustomerService(){
        return new CustomerServiceImpl();
    }
}
