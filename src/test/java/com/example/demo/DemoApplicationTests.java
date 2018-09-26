package com.example.demo;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void create() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("C:\\qt\\mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	@Test
	public void testFtpClient() throws IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.51.129",22);//服务器地址和端口
		ftpClient.login("dev","qwer4321");//登录的用户名和密码
		//读取本地文件，给出的是本地文件地址
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\123.png"));
		//设置上传路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/images");
		//设置文件类型
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//1.服务器端保存的文件名，2.上传文件的inputstream
		ftpClient.storeFile("test.png",inputStream);
		ftpClient.logout();
	}

}
