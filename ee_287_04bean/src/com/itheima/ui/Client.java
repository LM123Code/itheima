package com.itheima.ui;

import com.itheima.service.ICustomerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Spring入门案例
 * @author LM_Code
 * @create 2019-02-22-13:21
 */
public class Client {
    /**
     * ClassPathXmlApplicationContext   只能加载类路径下的配置文件    用这个
     * FileSystemXmlApplicationContext    可以加载磁盘任意位置的配置文件
     *
     * Bean创建的两种规则：
     * BeanFactory:
     *      提供的是一个延迟加载思想来创建bean对象
     * ApplicationContext
     *      立即加载思想来创建bean对象
     *
     * Bean的三种创建方式：
     *  第一种：调用默认的无参构造
     *  第二种：使用工厂中的方法创建对象
     *
     * @param args
     */
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//立即加载
        //根据id获取对象
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
        System.out.println(cs);
    }
    /*public static void main(String[] args) {
        //获取容器
        Resource res = new ClassPathResource("bean.xml");
        BeanFactory bf = new XmlBeanFactory(res);//延迟加载
        //根据id获取对象
        ICustomerService cs = (ICustomerService) bf.getBean("customerService");
        cs.saveCustomer();
    }*/
}
