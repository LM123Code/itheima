package com.itheima12.service.impl;

import com.itheima12.service.ICustomerService;
import org.springframework.stereotype.Service;

/**
 * 模拟客户业务层的实现类
 * @author LM_Code
 * @create 2019-02-26-16:54
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public void saveCustomer() {
        System.out.println("保存了客户");
        int i = 1/0;
    }

    @Override
    public void updateCustomer(int i) {
        System.out.println("更新了客户" + i);
    }

    @Override
    public int deleteCustomer() {
        System.out.println("删除了客户");
        return 0;
    }
}
