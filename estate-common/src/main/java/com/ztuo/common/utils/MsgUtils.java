package com.ztuo.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Description: 短信工具类
 * @Author: GuoShuai
 * @Date: 2018/11/30 11:18 AM
 */
@Slf4j
@Configuration
public class MsgUtils {

    private static String apiKey;

    private static String apiSecret;

    private static String apiSign;

    @Value("${msg.api.sign}")
    public void setApiSign(String apiSign) {
        MsgUtils.apiSign = apiSign;
    }

    @Value("${msg.api.key}")
    public void setApiKey(String apiKey) {
        MsgUtils.apiKey = apiKey;
    }

    @Value("${msg.api.secret}")
    public void setApiSecret(String apiSecret) {
        MsgUtils.apiSecret = apiSecret;
    }


    public static boolean sendMessageCode(String mobile, String code) throws Exception {
        String content = "您的验证码为:%s，十分钟内有效，如非本人操作，请忽略。";
        content = String.format(content, code);
        return sendMessage5C(mobile, content);
    }

    /**
     * 短信发送，内容为短信所有内容（必须包含签名【ZTUO】）
     * <p>
     * 号码数控制在500个以内。多个号码的分隔符为英文”,”。短信内容不能超过1000字符
     *
     * @param mobile
     * @param content
     * @return
     * @throws Exception
     */
    public static boolean sendMessage(String mobile, String content) throws Exception {
        log.info("============sms content==========={}", content);

        HttpClient httpClient = new HttpClient();
        //组装请求参数
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("method", "send");
        JSONObject params = new JSONObject();
        params.put("userid", apiKey);
        params.put("password", apiSecret);
        JSONObject[] phoneSend = new JSONObject[1];
        JSONObject submit = new JSONObject();
        submit.put("content", content+"【郑州枫华云服务】");
        submit.put("phone", mobile);

        phoneSend[0] = submit;
        params.put("submit", phoneSend);
        json.put("params", params);
        log.info("==============请求参数：==========" + json);
        String url = "http://112.74.139.4:8002/sms3_api/jsonapi/jsonrpc2.jsp?" + URLEncoder.encode(json.toJSONString
                (), "UTF-8");
        //发送get请求
        GetMethod getMethod = new GetMethod(url);
        log.info("==============url==========" + url);
        int code = httpClient.executeMethod(getMethod);
        log.info("==============短信请求返回体：==========" + getMethod.getResponseBodyAsString());

        String httpResult = getMethod.getResponseBodyAsString();
        JSONObject jsonObject = JSONObject.parseObject(httpResult);
        List<JSONObject> jsonResult = (List<JSONObject>) jsonObject.get("result");
        JSONObject mess = jsonResult.get(0);
        if ("0".equals(mess.getString("return"))) {
            return true;
        }
        return false;
    }


    public static boolean sendMessage5C(String mobile, String content) throws Exception {
        log.info("============sms content==========={}", content);

        HttpClient httpClient = new HttpClient();

        //新建一个StringBuffer链接
        StringBuffer buffer = new StringBuffer();


        //String encode = "GBK"; //页面编码和短信内容编码为GBK。重要说明：如提交短信后收到乱码，请将GBK改为UTF-8测试。如本程序页面为编码格式为：ASCII/GB2312/GBK
        // 则该处为GBK。如本页面编码为UTF-8或需要支持繁体，阿拉伯文等Unicode，请将此处写为：UTF-8
        String encode = "UTF-8";
        //用户名
        String username = apiKey;
        //密码
        String password_md5 = Md5.generalMD5(apiSecret).toUpperCase();

        //apikey秘钥（请登录 http://m.5c.com.cn 短信平台-->账号管理-->我的信息 中复制apikey）
        String apikey = apiSign;
        try {
            //对短信内容做Urlencode编码操作。注意：如
            String contentUrlEncode = URLEncoder.encode(content+"【郑州枫华云服务】", encode);
            //把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
            buffer.append("http://m.5c.com.cn/api/send/index.php?username=" + username + "&password_md5=" + password_md5 + "&mobile=" + mobile + "&apikey=" + apikey + "&content=" + contentUrlEncode + "&encode=" + encode);
            //把buffer链接存入新建的URL中
            //发送get请求
            PostMethod postMethod = new PostMethod(buffer.toString());
            log.info("==============url==========" + buffer.toString());
            int code = httpClient.executeMethod(postMethod);
            log.info("==============短信请求返回体：==========" + postMethod.getResponseBodyAsString());

            String httpResult = postMethod.getResponseBodyAsString();
            String[] resultStr = httpResult.split(":");
            if ("success".equals(resultStr[0])) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.info("---发送短信异常--e={}",e);
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        String content = "您的验证码为:123456，十分钟内有效，如非本人操作，请忽略。";
        sendMessage5C("15738776414",content);
    }


}
