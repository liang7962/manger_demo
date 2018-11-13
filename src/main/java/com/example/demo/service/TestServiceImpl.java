package com.example.demo.service;

import com.example.demo.mapper.AdminRegisterMapper;
import com.example.demo.pojo.AdminRegister;
import com.example.demo.pojo.AdminRegisterExample;
import com.example.demo.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
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

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false, rollbackFor=Exception.class)
    public AdminRegister addAdminRegistert(AdminRegister adminRegister) {
        adminRegisterMapper.insert(adminRegister);
//        adminRegister.setMobileNo("13112345678");
//        adminRegisterMapper.updateByPrimaryKey(adminRegister);
//        int i=1/0;
        return null;
    }

//    @Transactional(propagation=Propagation.REQUIRED,readOnly=false, rollbackFor=Exception.class)
//    public AdminRegister updAdminRegistert(AdminRegister adminRegister) {
//        adminRegisterMapper.updateByPrimaryKey(adminRegister);
//        return null;
//    }
//
//    @Transactional(propagation=Propagation.REQUIRED,readOnly=false, rollbackFor=Exception.class)
//    public AdminRegister addAdminRegistert2(AdminRegister adminRegister) {
//        adminRegisterMapper.insert(adminRegister);
//        return null;
//    }
}
