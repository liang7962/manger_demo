package com.example.demo.service;

import com.example.demo.dto.PaycoreJnlsDto;
import com.example.demo.router.RequestTransBody;
import com.example.demo.router.ResponseTransBody;

import java.util.List;


public interface PaycoreJnlsService {

    public List<PaycoreJnlsDto> FindPaycoreJnlsListByModel(RequestTransBody requestTransBody);

    public ResponseTransBody findPaycoreJnlsListByPage(RequestTransBody requestTransBody);
}
