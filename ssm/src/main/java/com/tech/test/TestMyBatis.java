package com.tech.test;


import com.tech.dao.AccountDao;
import com.tech.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis{
    @Test
    public void run() throws Exception{
        //加载文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao ad = session.getMapper(AccountDao.class);
        //查询数据
        List<Account> all = ad.findAll();
        for (Account account : all){
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run1() throws Exception{
        Account ac = new Account();
        ac.setMoney(3000d);
        ac.setName("榴莲");
        //加载文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao ad = session.getMapper(AccountDao.class);
        //保存
        ad.saveAccount(ac);
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
