package com.example.demo.service;

import com.example.demo.mapper.AdminRegisterMapper;
import com.example.demo.pojo.AdminRegister;
import com.example.demo.pojo.AdminRegisterExample;
import com.example.demo.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private AdminRegisterMapper adminRegisterMapper;

    @Override
    public AdminRegister getAdminRegistert(String accId) {
        return adminRegisterMapper.selectByPrimaryKey(accId);
    }

    @Override
    public List<AdminRegisterExample> getAll(AdminRegisterExample adminRegisterExample) {
        List<AdminRegister> adminRegisters = adminRegisterMapper.selectByExample(adminRegisterExample);
        return BeanCopyUtil.copyTo(adminRegisters,AdminRegisterExample.class);
    }
}
