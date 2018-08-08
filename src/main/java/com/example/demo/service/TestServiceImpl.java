package com.example.demo.service;

import com.example.demo.mapper.AdminRegisterMapper;
import com.example.demo.pojo.AdminRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private AdminRegisterMapper adminRegisterMapper;

    @Override
    public AdminRegister getList(String accId) {
        return adminRegisterMapper.selectByPrimaryKey(accId);
    }
}
