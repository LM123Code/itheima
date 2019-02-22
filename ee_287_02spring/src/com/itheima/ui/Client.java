package com.itheima.ui;

import com.itheima.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring入门案例
 * @author LM_Code
 * @create 2019-02-22-13:21
 */
public class Client {
    /**
     * ClassPathXmlApplicationContext   只能加载类路径下的配置文件    用这个
     * FileSystemXmlApplicationContext    可以加载磁盘任意位置的配置文件
     * @param args
     */
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取对象
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
//        System.out.println(cs);
        cs.saveCustomer(ac);
    }
}
