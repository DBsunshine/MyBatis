package com.tech.dao;

import com.tech.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

//    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);

    /**
     * xml方式批量保存
     */
    public void saveAll(@Param("AccountList") List<Account> accountList);

}
