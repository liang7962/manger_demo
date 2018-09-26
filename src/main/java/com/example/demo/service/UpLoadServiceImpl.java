package com.example.demo.service;

import com.example.demo.util.FTPUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class UpLoadServiceImpl implements UploadService{

    // ftp服务器ip地址
    @Value("${ftpAddress}")
    private String ftpAddress;
    // 端口号
    @Value("${ftpPort}")
    private int ftpPort;
    // 用户名
    @Value("${ftpName}")
    private String ftpName;
    // 密码
    @Value("${ftpPassWord}")
    private String ftpPassWord;
    // 图片路径
    @Value("${ftpBasePath}")
    private String ftpBasePath;

    @Override
    public void upLoadImg(String path) {
        // TODO Auto-generated method stub
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Boolean flag = FTPUtils.uploadFile(path, inputStream,ftpAddress,ftpPort,ftpName,ftpPassWord,ftpBasePath);
        if (flag == true) {
            System.out.println("ftp上传成功！");
        }
    }


}
