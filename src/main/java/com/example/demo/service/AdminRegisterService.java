package com.example.demo.service;

import com.example.demo.pojo.AdminRegister;

import java.util.List;

public interface AdminRegisterService {

    void insertAdminRegiste(AdminRegister adminRegister);
    List<AdminRegister> findAdminRegisterList();
}
