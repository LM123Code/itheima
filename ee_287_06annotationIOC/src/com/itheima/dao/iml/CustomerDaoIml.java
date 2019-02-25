package com.itheima.dao.iml;

import com.itheima.dao.ICustomerdao;
import org.springframework.stereotype.Repository;

/**
 * 持久层实现类
 * @author LM_Code
 * @create 2019-02-24-16:26
 */
@Repository("customerDaoIml1")
public class CustomerDaoIml implements ICustomerdao {
    @Override
    public void saveCustomer() {
        System.out.println("持久层保存客户111111111");
    }
}
