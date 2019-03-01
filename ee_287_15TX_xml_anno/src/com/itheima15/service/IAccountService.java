package com.itheima15.service;

import com.itheima15.domain.Account;

/**
 * 账户的业务层接口
 * @author LM_Code
 * @create 2019-03-01-15:04
 */
public interface IAccountService {
    /*
    根据id查询账户信息
     */
    Account findAccountById(Integer accountId);
    /*
    转账
     */
    void transfer(String sourceName, String trageName, Float Money);
}
