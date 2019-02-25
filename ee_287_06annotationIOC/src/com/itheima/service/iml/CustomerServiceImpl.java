package com.itheima.service.iml;

import com.itheima.dao.ICustomerdao;
import com.itheima.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 业务层实现类
 * @author LM_Code
 * @create 2019-02-24-16:25
 * <bean id="customerService" class="com.itheima.service.iml.CustomerServiceImpl"></bean>
 * 1.用于创建bean对象
 *      @component
 *          作用：就相当于配置了一个bean标签
 *          位置：类上面
 *          属性：value。含义是指定bean的id。当不写时，默认当前类的短名首字母改小写
 *      由此注解衍生的三个注解：
 *          @Controller   一般用于表现层
 *          @Service      一般用于业务层
 *          @Repository   一般用于持久层
 *          他们和@Component的作用及属性一模一样
 * 2.用于注入数据的
 *      @Autowired
 *          作用：自动按照类型注入.只要有唯一的类型匹配就能注入成功。当我们使用注解注入时，不需要set方法
 *              如果注入的bean在容器中匹配的类型不唯一时，他会把变量名作为bean的id在容器中查找，找到后可注入成功。
 *              如果没有找到一致的bean的id，则报错
 *      @Qualifier
 *          作用：在自动按照类型注入的基础之上，再按照bean的id注入。
 *              它在给类成员注入数据时，不能独立使用。但是在给方法形参注入数据时，可以独立使用
 *          属性：
 *              value：用于指定bean的id。
 *      @Resource
 *          作用：直接按照bean的id注入
 *          属性：
 *              name：指定bean的id。
 *      以上三个注解都是用于注入其他bean类型的。
 *      @Value
 *          作用：用于注入基本类型和String类型数据。它可以借助spring的el表达式读取properties文件中的配置
 *          属性：
 *              value：用于指定要注入的数据
 * 3.用于改变作用范围的
 *      @Scope
 *          作用：用于改变bean的作用范围
 *          属性：
 *              value：用于指定范围的取值
 *                  取值和xml中scope属性的取值是一样的。singleton prototype request session globalsession
 * 4.和生命周期相关的
 * 5.spring的新注解
 *
 */
@Service("customerServiceImpl")
@Scope("prototype")
public class CustomerServiceImpl implements ICustomerService {
    @Value("泰斯特")
    private String name;

    /*@Autowired
    @Qualifier("customerDaoIml2")*/
    @Resource(name = "customerDaoIml2")
    private ICustomerdao customerDaoIml = null;
    @Override
    public void saveCustomer(){
        System.out.println("业务层调用持久层...." + name);
        customerDaoIml.saveCustomer();
    }
}