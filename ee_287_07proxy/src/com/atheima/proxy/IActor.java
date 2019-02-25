package com.atheima.proxy;

/**
 * @author LM_Code
 * @create 2019-02-25-16:52
 *
 * 经纪公司对签约艺人的标准
 */
public interface IActor {
    //基本的演出
    public void basicAct(float money);
    //危险的演出
    public void dangerAct(float money);
}