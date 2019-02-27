package com.itheima11.service;

/**
 * 模拟一个客户的业务层接口
 * @author LM_Code
 * @create 2019-02-26-16:51
 */
public interface ICustomerService {
    /*
    保存客户
     */
    void saveCustomer();
    /*
    更新客户
     */
    void updateCustomer(int i);
    /*
    删除客户
     */
    int deleteCustomer();
}
