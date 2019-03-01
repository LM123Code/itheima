package com.itheima15.service.impl;

import com.itheima15.dao.IAccountDao;
import com.itheima15.domain.Account;
import com.itheima15.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 * @author LM_Code
 * @create 2019-03-01-15:08
 */
@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //1.根据名称查询账户信息
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        //2.转出账户，减钱，转入账户加钱
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        //3.更新账户信息
        accountDao.updateAccount(source);
        int a = 1/0;
        accountDao.updateAccount(target);
    }
}
