package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FTPUtils {


    // ftp服务器ip地址
    private static String FTP_ADDRESS;
    // 端口号
    private static int FTP_PORT;
    // 用户名
    private static String FTP_USERNAME;
    // 密码
    private static String FTP_PASSWORD;
    // 图片路径
    private static String FTP_BASEPATH;

    private FTPClient ftpClient;

    @Value("${mangerdemo.ftp.ip}")
    private String strIp;  //ftp ip

    @Value("${mangerdemo.ftp.intPort}")
    private int intPort;   //ftp port

    @Value("${mangerdemo.ftp.user}")
    private String user;   //ftp username

    @Value("${mangerdemo.ftp.password}")
    private String password; //ftp password

    private Environment environment;

    /**
     * @author: jinliang
     * @create: 2018/9/10 11:18
     * @desc:   构建连接
     * @param
     **/
    public FTPUtils(String strIp,String strPort,String user,String password){

        this.strIp = StringUtils.isNotBlank(strIp)? strIp:this.strIp;
        this.intPort = StringUtils.isNotBlank(strPort)? Integer.valueOf(strPort):this.intPort;
        this.user = StringUtils.isNotBlank(user)? user:this.user;
        this.password = StringUtils.isNotBlank(password)? password:this.password;
        this.ftpClient = new FTPClient();
    }

    public FTPUtils() {
        this.ftpClient =  new FTPClient();
    }

    public FTPUtils(Environment environment){
        this.environment = environment;
        this.strIp = environment.getProperty("配置文件里咋写的你咋写");
        String strPort = environment.getProperty("配置文件里咋写的你咋写");
        if(!strPort.trim().equals("")){
            this.intPort = Integer.valueOf(strPort);
        }
        this.user = environment.getProperty("配置文件里咋写的你咋写");
        this.password = environment.getProperty("配置文件里咋写的你咋写");
        this.ftpClient = new FTPClient();
    }

    /**
     * 登录ftp服务器
     * @return
     */
    public boolean ftpLogin(){
        boolean isOk = false;
        // 这个编码的设定因情况而定，这里只告诉大家，能设置编码
        ftpClient.setControlEncoding("GBK");
        try {
            // 有没有端口都要登上去的意思
            if(intPort>0){
                ftpClient.connect(this.strIp, this.intPort);
            }else{
                ftpClient.connect(this.strIp);
            }
            isOk = this.ftpClient.login(this.user, this.password);
            this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            this.ftpClient.setBufferSize(1024 * 2);
            this.ftpClient.setDataTimeout(30 * 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    /**
     * 退出ftp服务器
     */
    public void ftpLogout(){
        if (null != this.ftpClient && this.ftpClient.isConnected()) {
            try {
                this.ftpClient.logout();// 退出FTP服务器
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    this.ftpClient.disconnect();// 关闭FTP服务器的连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @author: jinliang
     * @create: 2018/9/10 11:17
     * @desc:   下载文件
     * @param
     **/
    public void downloadFile(String remoteFileName ,ZipOutputStream zipOutputStream){
        try {
            zipOutputStream.putNextEntry(new ZipEntry(remoteFileName));
            this.ftpClient.enterLocalPassiveMode();
            boolean isRetrieOk = this.ftpClient.retrieveFile(remoteFileName, zipOutputStream);
            if(!isRetrieOk){
                return;
            }
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author: jinliang
     * @create: 2018/9/10 14:43
     * @desc:   上传图片
     * @param
     **/
    private static boolean uploadFile(String originFileName, InputStream input) {
        System.out.println(FTP_ADDRESS);
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH);
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * @author: jinliang
     * @create: 2018/9/10 14:43
     * @desc:   ftp上传文件
     * @param
     **/
    public static Boolean uploadFile(String path, InputStream inputStream, String ftpAddress, int ftpPort,
                                     String ftpName, String ftpPassWord, String ftpBasePath) {
        FTP_ADDRESS = ftpAddress;
        FTP_PORT = ftpPort;
        FTP_USERNAME = ftpName;
        FTP_PASSWORD = ftpPassWord;
        FTP_BASEPATH = ftpBasePath;
        uploadFile(path,inputStream);
        return true;
    }

}
