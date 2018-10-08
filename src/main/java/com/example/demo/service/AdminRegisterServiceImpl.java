package com.example.demo.service;

import com.example.demo.mapper.AdminRegisterMapper;
import com.example.demo.pojo.AdminRegister;
import com.example.demo.pojo.AdminRegisterExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRegisterServiceImpl implements AdminRegisterService{
    @Autowired
    AdminRegisterMapper adminRegisterMapper;

    @Override
    public void insertAdminRegiste(AdminRegister adminRegister) {
        adminRegisterMapper.insert(adminRegister);
    }

    @Override
    public List<AdminRegister> findAdminRegisterList() {
        AdminRegisterExample adminRegisterExample=new AdminRegisterExample();
        return adminRegisterMapper.selectByExample(adminRegisterExample);
    }
}
