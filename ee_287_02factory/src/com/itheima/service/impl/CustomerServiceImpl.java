package com.itheima.service.impl;

import com.itheima.factory.BeanFactory;
import com.itheima.service.ICustomerService;
import com.itheima.dao.ICustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;

/**
 * 客户的业务层实现类
 * @author LM_Code
 * @create 2019-02-21-14:30
 */
public class
CustomerServiceImpl implements ICustomerService {
//    private  ICustomerDao customerDao = new CustomerDaoImpl();
//    private ICustomerDao customerDao = BeanFactory.getCustomerDao();
    private ICustomerDao customerDao = (ICustomerDao) BeanFactory.getBean("CUSTOMERDAO");
    public void saveCustomer(){
        System.out.println("业务层调用持久层");
        customerDao.saveCustomer();
    }
}
