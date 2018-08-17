package com.example.demo.controller.excel;

import com.example.demo.dto.PaycoreJnlsDto;
import com.example.demo.excel.ExecleExportAdminRegisterDto;
import com.example.demo.pojo.PaycoreJnlsExample;
import com.example.demo.service.PaycoreJnlsService;
import com.example.demo.service.TestService;
import com.example.demo.util.BeanCopyUtil;
import com.example.demo.util.DateConvertUtils;
import com.example.demo.util.LoggerUtils;
import com.example.demo.util.excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/excel")
public class ExecelController {

    @Autowired
    private PaycoreJnlsService paycoreJnlsService;

    @Autowired
    private TestService testService;

    @GetMapping("/form_builder.do")
    public String toFormBuilder(){
        return "view/excel/excel_export";
    }

    @GetMapping("/export.do")
    public String toExecel(){
        return "view/excel/excel_export";
    }

    @RequestMapping(value = {"/export_demo"})
    public void exportExcle(HttpServletResponse response, HttpServletRequest request, PaycoreJnlsExample dto) {
        try {
            List<PaycoreJnlsDto> paycoreJnlsDtoList = paycoreJnlsService.FindPaycoreJnlsListByModel(dto);
            if (null!=paycoreJnlsDtoList && paycoreJnlsDtoList.size()>0){

                Map<String, List<PaycoreJnlsDto>> listMap = getAcctBalanceJnlsList(paycoreJnlsDtoList);
                exportExcle(listMap,response,request);
            }else {
                LoggerUtils.error(getClass(), "查询数据异常");
            }
        }
        catch (Exception e) {
            LoggerUtils.error(getClass(), "导出excel数据异常", e);
        }

    }

    //通过数据集合导出excel数据
    public void exportExcle(Map<String, List<PaycoreJnlsDto>> map , HttpServletResponse response, HttpServletRequest request) {
        int index = 0;
        List[] arrList = new List[map.size()];
        String[] str = new String[map.size()];

        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                arrList[index] = getExeclData(map.get(key));
                str[index] = key;
            } else {
                return;
            }
            index++;
        }
        try {
            String fileName = DateConvertUtils.formatYYYYMMDD(new Date());
            new ExcelUtil<ExecleExportAdminRegisterDto>(ExecleExportAdminRegisterDto.class).exportExcel(arrList, str,fileName,response);
        } catch (FileNotFoundException e) {
            LoggerUtils.error(getClass(), "文件未找到", e);
        } catch (IOException e) {
            LoggerUtils.error(getClass(), "IO异常", e);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.error(getClass(), "导出文件错", e);
        }
    }

    public Map<String,List<PaycoreJnlsDto>> getAcctBalanceJnlsList(List<PaycoreJnlsDto> paycoreJnlsExampleList){
        Map<String,List<PaycoreJnlsDto>> map=new HashMap<String, List<PaycoreJnlsDto>>();
        //根据日期获取个人用户余额流水
        String keyName = DateConvertUtils.formatYYYYMMDD(new Date());

        if (null!=paycoreJnlsExampleList&&paycoreJnlsExampleList.size()>0){

            map.put("流水_"+keyName,paycoreJnlsExampleList);
        }
        return map;
    }

    //将现有数据转化为最终导入Execl表的数据
    private List<ExecleExportAdminRegisterDto> getExeclData(List<PaycoreJnlsDto> paycoreJnlsExampleList) {
        return BeanCopyUtil.copyTo(paycoreJnlsExampleList, ExecleExportAdminRegisterDto.class);
    }
}
