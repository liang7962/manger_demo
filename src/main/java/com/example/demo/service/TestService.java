package com.example.demo.service;


import com.example.demo.pojo.AdminRegister;
import com.example.demo.pojo.AdminRegisterExample;

import java.util.List;

public interface TestService {

    public AdminRegister getAdminRegistert(String accId);

    public List<AdminRegisterExample> getAll(AdminRegisterExample adminRegisterExample);
}
