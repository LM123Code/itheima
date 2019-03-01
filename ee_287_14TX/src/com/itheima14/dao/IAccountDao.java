package com.itheima14.dao;

import com.itheima14.domain.Account;

/**
 * 账户的持久层接口
 * @author LM_Code
 * @create 2019-02-28-19:19
 */
public interface IAccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String name);
    void updateAccount(Account account);

}
