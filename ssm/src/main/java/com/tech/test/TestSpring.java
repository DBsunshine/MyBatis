package com.tech.test;

import com.tech.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class TestSpring {

    @Test
    public void runtest(){

        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        //调用方法
        as.findAll();

    }
}
