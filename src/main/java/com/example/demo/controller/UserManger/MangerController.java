package com.example.demo.controller.UserManger;

import com.example.demo.pojo.AdminRegister;
import com.example.demo.service.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("account")
public class MangerController {

    @Autowired
    AdminRegisterService adminRegisterService;

    @RequestMapping("/user_manger_list")
    public String userMangerListView(ModelMap modelMap){
        List<AdminRegister> adminRegisterList = adminRegisterService.findAdminRegisterList();
        modelMap.put("adminRegisterList",adminRegisterList);
        return "view/account/user_manger_list";
    }

    @RequestMapping("/account_add_view")
    public String accountAddView(ModelMap modelMap){

        return "view/account/account_add";
    }

    @RequestMapping("/account_add")
    public void accountAdd(ModelMap modelMap,AdminRegister adminRegister){
        adminRegisterService.insertAdminRegiste(adminRegister);
    }

}
