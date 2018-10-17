package com.example.demo.util.two.ftp;

import com.example.demo.util.LoggerUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.SocketException;

/**
 * Created by gavin on 2017/9/15.
 */
public class ReadFTPFile {


    /**
     * 去 服务器的FTP路径下上读取文件
     *
     * @param ftpUserName
     * @param ftpPassword
     * @param ftpPath
     * @param
     * @return
     */
    public String readConfigFileForFTP(String ftpUserName, String ftpPassword,
                                       String ftpPath, String ftpHost, int ftpPort, String fileName) {
        StringBuffer resultBuffer = new StringBuffer();
        FileInputStream inFile = null;
        InputStream in = null;
        FTPClient ftpClient = null;
        LoggerUtils.info(ReadFTPFile.class,"开始读取绝对路径" + ftpPath + "文件!");
        try {
            ftpClient = FTPUtil.getFTPClient(ftpHost, ftpPassword, ftpUserName,
                    ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            in = ftpClient.retrieveFileStream(fileName);
        } catch (FileNotFoundException e) {
            LoggerUtils.error(getClass(),"没有找到" + ftpPath + "文件");
            e.printStackTrace();
            return "下载配置文件失败，请联系管理员.";
        } catch (SocketException e) {
            LoggerUtils.error(getClass(),"连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            LoggerUtils.error(getClass(),"文件读取错误。");
            e.printStackTrace();
            return "配置文件读取失败，请联系管理员.";
        }
        if (in != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String data = null;
            try {
                while ((data = br.readLine()) != null) {
                    resultBuffer.append(data + "\n");
                }
            } catch (IOException e) {
                LoggerUtils.error(getClass(),"文件读取错误。");
                e.printStackTrace();
                return "配置文件读取失败，请联系管理员.";
            } finally {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            LoggerUtils.error(getClass(),"in为空，不能读取。");
            return "配置文件读取失败，请联系管理员.";
        }
        return resultBuffer.toString();
    }

}
