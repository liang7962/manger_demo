package com.example.demo.util.two.ftp;

import com.example.demo.util.LoggerUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.net.SocketException;

/**
 * Created by gavin on 2017/9/15.
 */
public class FTPUtil {

    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpPassword,
                                         String ftpUserName, int ftpPort) {
        FTPClient ftpClient = null;
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                LoggerUtils.info(FTPUtil.class,"未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                LoggerUtils.info(FTPUtil.class,"FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            LoggerUtils.info(FTPUtil.class,"FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            LoggerUtils.info(FTPUtil.class,"FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }
}
