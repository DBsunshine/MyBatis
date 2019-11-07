package com.tech.service.impl;

import com.tech.dao.AccountDao;
import com.tech.domain.Account;
import com.tech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层：查询");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存");
        accountDao.saveAccount(account);
    }

    public void saveAll(List<Account> AccountList) {
        System.out.println("xml批量保存");
        accountDao.saveAll(AccountList);
    }
}
