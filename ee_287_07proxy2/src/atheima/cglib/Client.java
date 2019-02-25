package atheima.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟一个剧组
 * @author LM_Code
 * @create 2019-02-25-16:49
 */
public class Client {
    public static void main(String[] args) {
        final Actor actor = new Actor();
       /* actor.basicAct(100f);
        actor.dangerAct(500f);*/
        /**
         * 动态代理：
         *      作用：不改变源码的基础上，对已有方法的增强。（他是AOP思想的实现技术）
         *      分类：
         *          基于接口的动态代理：
         *                  要求：被代理类最少实现一个接口
         *                  提供者：JDK官方
         *                  涉及的类：Proxy
         *              创建代理对象的方法：newProxyInstance(ClassLoader,Class[],InvocationHandler)
         *                  参数的含义：
         *                      ClassLoader：类加载器。和被代理对象使用相同的类加载器。一般都是固定写法。
         *                      Class[]：字节码数组。被代理类实现的接口，（要求代理对象和被代理对象具有相同的行为）。一般都是固定写法
         *                      InvocationHandler：他是一个接口，就是用于我们提供增强代码的。我们一般都是写一些接口的实现类。实现类可以是匿名内部类。
         *                                         他的含义是：如何代理。此处的代码只能是谁用谁提供。
         *                                       策略模式：要求有数据，目的明确，中间达成目标的过程就是策略
         *
         *          基于子类的动态代理
         *                  要求：被代理类不能是最终类。不能被final修饰
         *                  提供者：第三方CGLib
         *                  涉及的类：Enhancer
         *                  创建代理对象的方法：creat(Class,Callback);
         *                      参数的含义：
         *                          Class：被代理对象的字节码
         *                          Callback：如何代理。他和InvocationHandler的作用是一样的。他也是一个接口，我们一般使用该接口的子接口MethodInterceptor
         *                                  在使用时我们也是使用该接口的实现类，或匿名内部类
         *
         *
         */

        Actor cglibActor = (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {
            /*
                执行被代理类的任何方法，都会经过该方法，他和基于接口动态代理的invoke方法的作用是一模一样的
                方法参数：
                    前三个和invoke方法的参数含义和作用都一样。
                    MethodProxy methodProxy：当前执行方法的代理对象。一般不用
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;
                //1.取出执行方法中的参数：给的多少钱
                Float money = (Float) args[0];
                //2.判断当前执行的是什么方法
                if ("basicAct".equals(method.getName())) {
                    //基本演出
                    if (money > 10000) {
                        //执行方法
                        rtValue = method.invoke(actor, money / 2);
                    }
                }
                if ("dangerAct".equals(method.getName())) {
                    //危险演出
                    if (money > 50000) {
                        //执行方法
                        rtValue = method.invoke(actor, money / 2);
                    }
                }
                return rtValue;
            }
        });
        cglibActor.basicAct(50000);
        cglibActor.dangerAct(100000);
    }
}
