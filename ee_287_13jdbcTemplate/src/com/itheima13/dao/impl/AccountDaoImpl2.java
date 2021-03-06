package com.itheima13.dao.impl;

import com.itheima13.dao.IAccountDao;
import com.itheima13.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的业务层实现类
 * @author LM_Code
 * @create 2019-02-28-19:23
 */
public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {


    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> list =  getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list =  getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if(list.isEmpty())
            return null;
        if(list.size()>1)
            throw new RuntimeException("结果集不唯一，请检查数据");
        return list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name =?,money =?where id = ?" +
                "",account.getName(), account.getMoney(),account.getId());
    }
}
