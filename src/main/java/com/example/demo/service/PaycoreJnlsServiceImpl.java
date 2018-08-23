package com.example.demo.service;

import com.example.demo.dto.PaycoreJnlsDto;
import com.example.demo.dto.page.Page;
import com.example.demo.mapper.PaycoreJnlsMapper;
import com.example.demo.pojo.PaycoreJnls;
import com.example.demo.pojo.PaycoreJnlsExample;
import com.example.demo.router.RequestTransBody;
import com.example.demo.router.ResponseTransBody;
import com.example.demo.util.BeanCopyUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaycoreJnlsServiceImpl implements PaycoreJnlsService{

    @Autowired
    PaycoreJnlsMapper paycoreJnlsMapper;

    @Override
    public List<PaycoreJnlsDto> FindPaycoreJnlsListByModel(RequestTransBody requestTransBody) {

        PaycoreJnlsExample paycoreJnlsExample = new PaycoreJnlsExample();
        try {
            BeanCopyUtil.copyUseCglib(requestTransBody.getReqModel(),paycoreJnlsExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return BeanCopyUtil.copyTo(paycoreJnlsMapper.selectByExample(paycoreJnlsExample),PaycoreJnlsDto.class) ;
    }

    @Override
    public ResponseTransBody findPaycoreJnlsListByPage(RequestTransBody requestTransBody) {
        ResponseTransBody responseTransBody=new ResponseTransBody();

        Page page = requestTransBody.getPage();
        PaycoreJnlsExample paycoreJnlsExample = new PaycoreJnlsExample();

        try {
            BeanCopyUtil.copyUseCglib(requestTransBody,paycoreJnlsExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        com.github.pagehelper.Page<Object> pageInfo = PageHelper.startPage(page.getPageNum(), page.getNumPerPage()).setOrderBy(page.getOrderBy());
        List<PaycoreJnls> paycoreJnls = paycoreJnlsMapper.selectByExample(paycoreJnlsExample);
        page.setTotalCount(pageInfo.getTotal());

        List<Object> list=new ArrayList<>();
        list.addAll( BeanCopyUtil.copyTo(paycoreJnls,PaycoreJnlsDto.class));

        responseTransBody.setResModel(list);
        responseTransBody.setPage(page);
        return responseTransBody;
    }
}
