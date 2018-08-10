package com.example.demo.controller.excel;

import com.example.demo.excel.ExecleExportAdminRegisterDto;
import com.example.demo.pojo.AdminRegisterExample;
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
    private TestService testService;

    @GetMapping("/form_builder.do")
    public String toFormBuilder(){
        return "view/excel_demo/excel_export";
    }

    @GetMapping("/export.do")
    public String toExecel(){
        return "view/excel_demo/excel_export";
    }

    @RequestMapping(value = {"/export_demo"})
    public void exportExcle(HttpServletResponse response, HttpServletRequest request, AdminRegisterExample dto) {
        try {
            List<AdminRegisterExample> adminRegisterExampleList = testService.getAll(dto);
            if (null!=adminRegisterExampleList && adminRegisterExampleList.size()>0){

                Map<String, List<AdminRegisterExample>> acctBalanceJnlsList = getAcctBalanceJnlsList(adminRegisterExampleList);
                exportExcle(acctBalanceJnlsList,response,request);
            }else {
                LoggerUtils.error(getClass(), "查询数据异常");
            }
        }
        catch (Exception e) {
            LoggerUtils.error(getClass(), "导出excel数据异常", e);
        }

    }

    //通过数据集合导出excel数据
    public void exportExcle(Map<String, List<AdminRegisterExample>> map , HttpServletResponse response, HttpServletRequest request) {
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

    public Map<String,List<AdminRegisterExample>> getAcctBalanceJnlsList(List<AdminRegisterExample> xxOrderDtoList){
        Map<String,List<AdminRegisterExample>> map=new HashMap<String, List<AdminRegisterExample>>();
        //根据日期获取个人用户余额流水
        String keyName = DateConvertUtils.formatYYYYMMDD(new Date());

        if (null!=xxOrderDtoList&&xxOrderDtoList.size()>0){

            map.put("交易流水_"+keyName,xxOrderDtoList);
        }
        return map;
    }

    //将现有数据转化为最终导入Execl表的数据
    private List<ExecleExportAdminRegisterDto> getExeclData(List<AdminRegisterExample> adminRegisterExampleList) {
        return BeanCopyUtil.copyTo(adminRegisterExampleList, ExecleExportAdminRegisterDto.class);
    }
}
