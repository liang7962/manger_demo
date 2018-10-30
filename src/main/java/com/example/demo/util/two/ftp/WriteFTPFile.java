package com.example.demo.util.two.ftp;

import com.example.demo.util.LoggerUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * Created by gavin on 2017/9/15.
 */
public class WriteFTPFile {


    /**
     * 本地上传文件到FTP服务器
     *
     * @param ftpPath 远程文件路径FTP
     * @throws IOException
     */
    public void upload(String ftpPath, String ftpUserName, String ftpPassword,
                       String ftpHost, int ftpPort, String fileContent,
                       String writeTempFielPath) {
        FTPClient ftpClient = null;
        LoggerUtils.info(getClass(), "开始上传文件到FTP.");
        try {
            ftpClient = FTPUtil.getFTPClient(ftpHost, ftpPassword,
                    ftpUserName, ftpPort);
            // 设置PassiveMode传输
            ftpClient.enterLocalPassiveMode();
            // 设置以二进制流的方式传输
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 对远程目录的处理
            String remoteFileName = ftpPath;
            if (ftpPath.contains("/")) {
                remoteFileName = ftpPath
                        .substring(ftpPath.lastIndexOf("/") + 1);
            }
            // FTPFile[] files = ftpClient.listFiles(new
            // String(remoteFileName));
            // 先把文件写在本地。在上传到FTP上最后在删除
            boolean writeResult = write(remoteFileName, fileContent,
                    writeTempFielPath);
            if (writeResult) {
                File f = new File(writeTempFielPath + "/" + remoteFileName);
                InputStream in = new FileInputStream(f);
                ftpClient.storeFile(ftpPath, in);
                in.close();
                LoggerUtils.info(getClass(), "上传文件" + ftpPath + "到FTP成功!");
                f.delete();
            } else {
                LoggerUtils.info(getClass(), "写文件失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void upload(String ftpPath, String ftpFileName, String ftpUserName, String ftpPassword,
                       String ftpHost, int ftpPort, File f) {
        FTPClient ftpClient = null;
        LoggerUtils.info(getClass(), "开始上传文件到FTP.");
        try {
            ftpClient = FTPUtil.getFTPClient(ftpHost, ftpPassword,
                    ftpUserName, ftpPort);
            // 设置PassiveMode传输
            ftpClient.enterLocalPassiveMode();
            // 设置以二进制流的方式传输
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //设置编码方式
            ftpClient.setControlEncoding("UTF-8");
            // 对远程目录的处理
            InputStream in = new FileInputStream(f);

            //判断远端目录是否存在，不存在则创建
            if (ftpClient.makeDirectory(ftpPath)) {
                LoggerUtils.info(getClass(), "目录不存在，创建目录成功");
            } else {
                LoggerUtils.info(getClass(), "目录已存在");
            }

            if (ftpClient.storeFile(ftpPath + ftpFileName, in)) {
                LoggerUtils.info(getClass(), "上传文件" + f.getName() + "到FTP成功!");
            } else {
                LoggerUtils.info(getClass(), "上传文件" + f.getName() + "到FTP失败!");
            }
            in.close();

//                f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 把配置文件先写到本地的一个文件中取
     *
     * @param ftpPath
     * @param str
     * @return
     */
    public boolean write(String fileName, String fileContext,
                         String writeTempFielPath) {
        try {
            LoggerUtils.info(getClass(), "开始写配置文件");
            File f = new File(writeTempFielPath + "/" + fileName);
            if (!f.exists()) {
                if (!f.createNewFile()) {
                    LoggerUtils.info(getClass(), "文件不存在，创建失败!");
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.write(fileContext.replaceAll("\n", "\r\n"));
            bw.flush();
            bw.close();
            return true;
        } catch (Exception e) {
            LoggerUtils.error(getClass(), "写文件没有成功");
            e.printStackTrace();
            return false;
        }
    }

}
