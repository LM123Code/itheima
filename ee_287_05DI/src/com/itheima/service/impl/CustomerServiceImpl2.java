package com.itheima.service.impl;

import com.itheima.service.ICustomerService;

import java.util.Date;

/**
 * 客户的业务层实现类
 * @author LM_Code
 * @create 2019-02-21-14:30
 */
public class CustomerServiceImpl2 implements ICustomerService {

   private String driver;
   private Integer port;
   private Date tody;
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public void setPort(Integer port) {
        this.port = port;
    }
    public void setTody(Date tody) {
        this.tody = tody;
    }


    public void saveCustomer(){
        System.out.println("业务层调用持久层" + driver + "," + port + "," + tody);
    }
}
