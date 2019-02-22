package com.itheima.dao.impl;

import com.itheima.dao.ICustomerDao;

/**
 * 模拟客户的持久层实现类
 * @author LM_Code
 * @create 2019-02-21-14:37
 */
public class CustomerDaoImpl implements ICustomerDao {
    /**
     * 保存客户
     */
    @Override
    public void saveCustomer() {
        System.out.println("持久层保存了客户");
    }
}
