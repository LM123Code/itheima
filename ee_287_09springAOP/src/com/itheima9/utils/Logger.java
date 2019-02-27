package com.itheima9.utils;

/**
 * 一个用于记录日志的类
 * 计划让其在业务核心方法（切入点方法）执行之前执行
 * @author LM_Code
 * @create 2019-02-26-16:58
 */
public class Logger {
    public void printLog(){
        System.out.println("Logger中方法开始记录日志");
    }
}
