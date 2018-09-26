package com.example.demo.controller.img;

import com.example.demo.service.UploadService;
import com.example.demo.util.FTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("/ftp")
public class FTPController {

    @Autowired
    private UploadService uploadService;

    /**
     * @author: jinliang
     * @create: 2018/9/10 15:08
     * @desc: ftp在服务器下载文件
     * @param
     **/
    @RequestMapping("/downloadFile")
    public void downloadFile(HttpServletResponse res) throws UnsupportedEncodingException {
        // 刚才的一系列代码都是FtpUtils中的
        FTPUtils ftpUtils = new FTPUtils();
        boolean login =  ftpUtils.ftpLogin(); // 登录
        res.setContentType("application/pdf");
        // 这里重新编码以免中文名称的压缩包出不来
        String downloadFileName = new String("yy_soa.jar".getBytes("GBK"),"ISO-8859-1");
        res.setHeader("content-Disposition", "attachment;filename="+downloadFileName);
        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(res.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 这里只下载了一个文件，你也可以通过循环或其他形式，多次调用，只要在压缩流关闭之前都会压缩到一个包内，而且保留文件路径
        ftpUtils.downloadFile("你的文件",zipOutputStream);
        try {
            zipOutputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ftpUtils.ftpLogout();// 退出
    }


    @RequestMapping("/upload_view")
    public String uploadView(){
        return "view/img/ftpImg";
    }


    @RequestMapping("/upload")
    @ResponseBody
    public String upload(String path) {
        uploadService.upLoadImg(path);
        return "s";
    }

    @RequestMapping("/upload2")
    public String upload2() {
        String path="C:\\Users\\Tiffany\\Desktop\\个人\\NEW问题单checklist.txt";
        uploadService.upLoadImg(path);
        return "s";
    }
}
