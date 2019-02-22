package com.itheima.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 一个工厂类
 * @author LM_Code
 * @create 2019-02-21-14:52
 */
public class BeanFactory {

    //1.定义一个properties对象
   /* private static Properties props = new Properties();
    //2.使用静态代码块给对象赋值
    static{
        try {
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
//            InputStream in = new FileInputStream("ee_287_02factory\\src\\bean.properties");//绝对不能用，web项目一旦发布src文件就不见了
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("读取配置文件失败" + e);
        }
    }*/

    //1.它只能读取properties文件，
    //2.不能用于写入
    //3.它只能读取类路径下的
    //注意方法参数的写法，是按照包名.类名的写法，不要后缀名
    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");

    //定义一个容器，存放需要的对象
    private static Map<String, Object> beans = new HashMap<String, Object>();

    //使用静态代码块，初始化map
    static{
        Enumeration<String> keys = bundle.getKeys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            String beanPath = bundle.getString(key);
            try {
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            } catch (Exception e) {
                throw new ExceptionInInitializerError("容器创建失败" + e);
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(props.get("CUTOMERSERVICE"));
//    }
    /**
     * 根据bean的名称创建类对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
//        try {
//            String beanPath = bundle.getString(beanName);
//            return Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
    /*public static CustomerServiceImpl getCustomerService() {
        try {
            return (CustomerServiceImpl) Class.forName("com.itheima.service.impl.CustomerServiceImpl").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static CustomerDaoImpl getCustomerDao(){
        try {
            return (CustomerDaoImpl) Class.forName("com.itheima.dao.impl.CustomerDaoImpl").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/


}
