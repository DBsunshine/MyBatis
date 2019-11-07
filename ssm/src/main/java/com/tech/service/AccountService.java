package com.tech.service;

import com.tech.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public void saveAccount(Account account);

    public void saveAll(List<Account> AccountList);

}
