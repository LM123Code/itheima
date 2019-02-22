package com.itheima.service.impl;

import com.itheima.dao.ICustomerDao;
import com.itheima.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户的业务层实现类
 * @author LM_Code
 * @create 2019-02-21-14:30
 */
public class CustomerServiceImpl implements ICustomerService {
//    private  ICustomerDao customerDao = new CustomerDaoImpl();
//    private ICustomerDao customerDao = BeanFactory.getCustomerDao();
    ApplicationContext ac = null;
    private ICustomerDao customerDao = null;
    public void saveCustomer(ApplicationContext ac){
        customerDao = (ICustomerDao) ac.getBean("customerDao");
        System.out.println("业务层调用持久层");
        customerDao.saveCustomer();
    }
}
