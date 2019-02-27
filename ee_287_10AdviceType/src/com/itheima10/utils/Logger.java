package com.itheima10.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 一个用于记录日志的类
 * 计划让其在业务核心方法（切入点方法）执行之前执行
 * @author LM_Code
 * @create 2019-02-26-16:58
 */
public class Logger {
    public void BeforePrintLog(){
        System.out.println("Logger中BeforePrintLog方法开始记录日志");
    }
    public void AfterReturnPrintLog(){
        System.out.println("Logger中AfterReturnPrintLog方法开始记录日志");
    }
    public void AfterThrowingPrintLog(){
        System.out.println("Logger中AfterThrowingPrintLog方法开始记录日志");
    }
    public void AfterPrintLog(){
        System.out.println("Logger中AfterPrintLog方法开始记录日志");
    }
    /*
    环绕通知
        必须用明确的切入点方法调用  ProceedingJoinPoint接口作为形参传入环绕方法
        利用该接口proceed()方法。就等同于method.invoke方法
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object retVal = null;
        try {
            //前置
            System.out.println("环绕通知开始1");
            retVal = pjp.proceed();
            //后置
            System.out.println("环绕通知开始2");
        } catch (Throwable throwable) {
            //异常
            System.out.println("环绕通知开始3");
            throwable.printStackTrace();
        }finally {
            //最终
            System.out.println("环绕通知开始4");
        }
        return retVal;
    }
}
