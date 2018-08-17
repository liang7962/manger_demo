package com.example.demo.service;

import com.example.demo.dto.PaycoreJnlsDto;
import com.example.demo.pojo.PaycoreJnlsExample;

import java.util.List;


public interface PaycoreJnlsService {

    public List<PaycoreJnlsDto> FindPaycoreJnlsListByModel(PaycoreJnlsExample paycoreJnlsExample);
}
