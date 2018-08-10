package com.example.demo.mapper;

import com.example.demo.pojo.PaycoreJnls;
import com.example.demo.pojo.PaycoreJnlsExample;
import com.example.demo.pojo.PaycoreJnlsKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaycoreJnlsMapper {
    long countByExample(PaycoreJnlsExample example);

    int deleteByExample(PaycoreJnlsExample example);

    int deleteByPrimaryKey(PaycoreJnlsKey key);

    int insert(PaycoreJnls record);

    int insertSelective(PaycoreJnls record);

    List<PaycoreJnls> selectByExample(PaycoreJnlsExample example);

    PaycoreJnls selectByPrimaryKey(PaycoreJnlsKey key);

    int updateByExampleSelective(@Param("record") PaycoreJnls record, @Param("example") PaycoreJnlsExample example);

    int updateByExample(@Param("record") PaycoreJnls record, @Param("example") PaycoreJnlsExample example);

    int updateByPrimaryKeySelective(PaycoreJnls record);

    int updateByPrimaryKey(PaycoreJnls record);
}