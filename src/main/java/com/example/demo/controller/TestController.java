package com.example.demo.controller;

import com.example.demo.dto.LoanHoseDto;
import com.example.demo.pojo.AdminRegister;
import com.example.demo.service.TestService;
import com.example.demo.util.LoggerUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test.do")
    public String toTest(){
        AdminRegister ar = testService.getAdminRegistert("0120180724000004");

        return ar.getMobileNo()+"wewe";
    }

    @RequestMapping("/duoimg")
    public String Img() {
        return "framework/duoimg";
    }

    @RequestMapping(value = "/houseform")
    public String houseLoanImgForm2(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="myfile1") MultipartFile file,
                                    @RequestParam(value="myfile2") MultipartFile file2,@RequestParam(value="myfile3") MultipartFile file3,
                                    @RequestParam(value="myfile4") MultipartFile file4,@RequestParam(value="name")String name
                                    ) throws IOException {
        LoggerUtils.info(getClass(),"name>>>>>>>>"+name);
    //获取服务器中的真实file文件夹路径
        //生成真实的文件名称
        String truefile=file.getOriginalFilename();
        File mFile=new File("C:\\qt\\new");
        //判断是否已经有file文件夹
        if (mFile.exists()) {
            mFile.mkdirs();
        }
        //将文件名称放入文件夹中
        File myFile=new File(mFile, truefile);
        //执行文件上传
        file.transferTo(myFile);
        return "aa";
    }

}
