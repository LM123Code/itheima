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
     *  第一种：调用默认的无参构造   此种方使用的最多
     *  第二种：使用静态工厂中的方法创建对象  需要使用bean标签的factory-method属性指定静态工厂中创建对象的方法
     *  第三种：使用实例工厂中的方法创建
     * Bean的作用范围：
     *      它是可以通过配置的方式调整作用范围   bean标签的scope属性
     *          属性取值：
     *              singleton：单例   （默认值）
     *              prototype：多例   （action必须配置次值）
     *              request：一次请求，和当前请求的转发
     *              session：一次会话
     *              globalsession：一次全局会话。
     * Bean的生命周期
     *      涉及bean标签的两个属性：
     *          init-method
     *          destory-method
     *      单例：
     *          出生：容器创建
     *          活着：容器存在
     *          死亡：容器销毁
     *      多例：
     *          出生：每次使用时创建对象
     *          活着：存在引用时就是存活的
     *          死亡：无引用时，有垃圾回收期按周期收回
     * @param args
     */
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//立即加载
        //根据id获取对象
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
//        ICustomerService cs = (ICustomerService) ac.getBean("staticCustoemrService");
        ((ClassPathXmlApplicationContext) ac).close();
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
