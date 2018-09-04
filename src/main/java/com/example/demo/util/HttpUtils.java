package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dto.httpDemo.AcctLotteryMerchant;
import com.example.demo.dto.httpDemo.AcctLotteryMerchantDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.HttpEntity;
import java.io.IOException;
import java.util.Map;

public class HttpUtils {

    private static final int TIMEOUT = 30000;
    /**
     * post请求传输json参数
     *
     * @param url  url地址
     * @param jsonParam 参数
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        LoggerUtils.info(HttpUtils.class,"*************发送httpPost请求（begin）****************");
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(TIMEOUT).setConnectTimeout(TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        try {
            if (null != jsonParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    LoggerUtils.error(HttpUtils.class,"post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            LoggerUtils.error(HttpUtils.class,"post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        LoggerUtils.info(HttpUtils.class,"*************发送httpPost请求（end）****************");
        return jsonResult;
    }

    /**
     * @author: jinliang
     * @create: 2018/9/4 11:31
     * @desc:   上传文件
     * @param
     **/
    public static JSONObject uploadMultipartFile(AcctLotteryMerchant acctLotteryMerchant , String url){

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        JSONObject jsonResult = null;
        try {
            httpClient = HttpClients.createDefault();
            // 把一个普通参数和文件上传给下面这个地址 是一个servlet
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addBinaryBody("bankCard", acctLotteryMerchant.getBankCard().getInputStream(), ContentType.DEFAULT_BINARY,acctLotteryMerchant.getBankCard().getOriginalFilename())
                    // 相当于<input type="text" name="userName" value=userName>
                    .addBinaryBody("idCardZ", acctLotteryMerchant.getIdCardZ().getInputStream(),ContentType.DEFAULT_BINARY,acctLotteryMerchant.getIdCardZ().getOriginalFilename())
                    .addBinaryBody("idCardF", acctLotteryMerchant.getIdCardF().getInputStream(),ContentType.DEFAULT_BINARY,acctLotteryMerchant.getIdCardF().getOriginalFilename())
                    .addBinaryBody("hardIdCardZ", acctLotteryMerchant.getHardIdCardZ().getInputStream(),ContentType.DEFAULT_BINARY,acctLotteryMerchant.getHardIdCardZ().getOriginalFilename());
            AcctLotteryMerchantDto acctLotteryMerchantDto=new AcctLotteryMerchantDto();
            BeanCopyUtil.copyUseCglib(acctLotteryMerchant,acctLotteryMerchantDto);
            Map<String, String> map = BeanToMap.transBean2Map(acctLotteryMerchantDto);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotBlank(entry.getKey())){
                    multipartEntityBuilder.addPart(entry.getKey(),new StringBody(entry.getValue(), ContentType.create("text/plain", Consts.UTF_8)));
                }
            }
            HttpEntity reqEntity = multipartEntityBuilder.build();
            httpPost.setEntity(reqEntity);
            response = httpClient.execute(httpPost);
            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(resEntity, "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    LoggerUtils.error(HttpUtils.class,"post请求提交失败:" + url, e);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(httpClient != null){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonResult;
    }

}
