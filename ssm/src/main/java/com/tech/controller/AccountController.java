package com.tech.controller;

import com.tech.domain.Account;
import com.tech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：");
        List<Account> all = accountService.findAll();
        model.addAttribute("list",all);
        return "list";
    }

    /*
    保存完重定向到findAll 
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception{
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

    /*
    测试批量保存xml方式
     */
    @RequestMapping("/saveAll")
    public void saveAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Account> accountList = new ArrayList<Account>();
        Account ac = new Account();
        for (int i=0; i<3; i++){
            ac.setName("测试0"+1);
            ac.setMoney(200d);
            ac.setUserName("下划线"+i);
            accountList.add(ac);
        }
        accountService.saveAll(accountList);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
