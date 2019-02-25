package com.itheima.dao.iml;

import com.itheima.dao.ICustomerdao;
import org.springframework.stereotype.Repository;

/**
 * 持久层实现类
 * @author LM_Code
 * @create 2019-02-24-16:26
 */
@Repository("customerDaoIml2")
public class CustomerDaoIml2 implements ICustomerdao {
    @Override
    public void saveCustomer() {
        System.out.println("持久层保存客户222222222");
    }
}
