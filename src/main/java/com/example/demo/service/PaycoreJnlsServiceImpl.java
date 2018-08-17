package com.example.demo.service;

import com.example.demo.dto.PaycoreJnlsDto;
import com.example.demo.mapper.PaycoreJnlsMapper;
import com.example.demo.pojo.PaycoreJnlsExample;
import com.example.demo.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaycoreJnlsServiceImpl implements PaycoreJnlsService{

    @Autowired
    PaycoreJnlsMapper paycoreJnlsMapper;

    @Override
    public List<PaycoreJnlsDto> FindPaycoreJnlsListByModel(PaycoreJnlsExample paycoreJnlsExample) {
        return BeanCopyUtil.copyTo(paycoreJnlsMapper.selectByExample(paycoreJnlsExample),PaycoreJnlsDto.class) ;
    }
}
