package com.example.demo.mapper;


import com.example.demo.pojo.AdminRegister;
import com.example.demo.pojo.AdminRegisterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRegisterMapper {
    long countByExample(AdminRegisterExample example);

    int deleteByExample(AdminRegisterExample example);

    int deleteByPrimaryKey(String accId);

    int insert(AdminRegister record);

    int insertSelective(AdminRegister record);

    List<AdminRegister> selectByExample(AdminRegisterExample example);

    AdminRegister selectByPrimaryKey(String accId);

    int updateByExampleSelective(@Param("record") AdminRegister record, @Param("example") AdminRegisterExample example);

    int updateByExample(@Param("record") AdminRegister record, @Param("example") AdminRegisterExample example);

    int updateByPrimaryKeySelective(AdminRegister record);

    int updateByPrimaryKey(AdminRegister record);
}