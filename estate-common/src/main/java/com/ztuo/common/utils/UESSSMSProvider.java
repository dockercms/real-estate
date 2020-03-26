package com.ztuo.common.utils;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URLEncoder;


/**
 * UESS短信接口实现类
 */
@Slf4j
@Configuration
public class UESSSMSProvider {

    private static String gateway;
    private static String username;
    private static String password;

    @Value("${sms.gateway:0}")
    public void setGateway(String gateway) {
        UESSSMSProvider.gateway = gateway;
    }

    @Value("${sms.username:0}")
    public void setUsername(String username) {
        UESSSMSProvider.username = username;
    }

    @Value("${sms.password:0}")
    public void setPassword(String password) {
        UESSSMSProvider.password = password;
    }

    private static final String product = "Dysmsapi";
    private static final String domain = "dysmsapi.aliyuncs.com";
    //替换成你的AK
    private static String accessKeyId;

    private static String accessKeySecret;


    @Value("${aliyun.access.key.id:0}")
    public void setAccessKeyId(String accessKeyId) {
        UESSSMSProvider.accessKeyId = accessKeyId;
    }

    @Value("${aliyun.access.key.secret:0}")
    public void setAccessKeySecret(String accessKeySecret) {
        UESSSMSProvider.accessKeySecret = accessKeySecret;
    }

    /**
     * UESS
     * @param mobile
     * @param content
     * @return
     * @throws Exception
     */
    public static RestResponse sendSingleMessage(String mobile, String content) throws Exception {
        log.info("============sms content==========={}", content);


//        String content = "http://47.96.136.50:8001/sms/interface/sendmess" +
//                ".htm?username=15738776414&userpwd=asd1230&mobiles=%s&content=%s&mobilecount=1";


        String sms = URLEncoder.encode("【BTCUSA】" + content, "UTF-8");
        StringBuilder req = new StringBuilder(gateway);
        req.append("username=%s&userpwd=%s&mobiles=%s&content=%s&mobilecount=1");

        String URL = String.format(req.toString(), username, password, mobile, sms);
        log.info("UESS URL=" + URL);

        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(URL);

        int code = httpClient.executeMethod(getMethod);

        log.info("UESS code=" + code);

        return parse2Result(getMethod.getResponseBodyAsString());


    }


    /**
     * 阿里云短信
     * @param mobile  手机号
     * @param code 六位随机码
     * @return
     * @throws Exception
     */
    public static boolean aliyunMessage(String mobile, String code) throws Exception {
        log.info("============aliyun-sms-content==========={}", code);

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysAction("SendSms");
        request.setSysVersion("2017-05-25");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "迪亚尔房产网");
        request.putQueryParameter("TemplateCode", "SMS_115385945");
        JSONObject param = new JSONObject();
        param.put("code",code);
        request.putQueryParameter("TemplateParam", param.toJSONString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("------aliyun-sms-result:"+response.toString());
            if (response.getData() != null){
                JSONObject result = JSONObject.parseObject(response.getData());
                if ("OK".equalsIgnoreCase(result.getString("Code"))){
                    return true;
                }
            }
        } catch (Exception e) {
            log.info("-------aliyun-sms-e={}",e);
            return false;
        }
        return false;


    }

    private static RestResponse parse2Result(String result) {
//        <?xml version="1.0" encoding="utf-8"?><sendresult><errorcode>1</errorcode><message>提交成功</message><SMSID
        // >29998</SMSID></sendresult>
        log.info("UESS result=" + result);
        RestResponse mr = new RestResponse();

        try {
            Document doc = DocumentHelper.parseText(result);

            Element rootElt = doc.getRootElement();
            String errorcode = rootElt.elementText("errorcode").trim();
            String message = rootElt.elementText("message").trim();
            String SMSID = rootElt.elementText("SMSID").trim();

            if ("1".equals(errorcode)) {
                mr.put("code", 0);
                mr.put("msg", "成功");
                mr.putData(SMSID);

            }
            return mr;
        } catch (DocumentException e) {
            log.info("UESS 发送短信异常e={}", e);
            return mr;
        }
    }

//    public static void main(String[] args) throws Exception{
//        String content = "http://47.96.136.50:8001/sms/interface/sendmess" +
//                ".htm?username=13783694877&userpwd=iZs27fTSg1A6&mobiles=15738776414&content=%s&mobilecount=1";
//        String ss = "【BTCUSA】尊敬的用户您好,您的验证码为:123456，十分钟内有效，如非本人操作，请忽略";
//        String sms = URLEncoder.encode( ss, "UTF-8");
//
//        String URL = String.format(content,sms);
//
//        HttpClient httpClient = new HttpClient();
//        GetMethod getMethod = new GetMethod(URL);
//
//        int code = httpClient.executeMethod(getMethod);
//
//        log.info("UESS code=" + code);
//
//        System.out.println(getMethod.getResponseBodyAsString());
//
//
//
//    }

    public static void main(String[] args) {
        log.info("============aliyun-sms-content==========={}");


        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fbr3zgeQ9Lz43otXF1u", "W6xL7wVcYycXSoDhJFOVexPO75VI1t");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysAction("SendSms");
        request.setSysVersion("2017-05-25");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15194607793");
        request.putQueryParameter("SignName", "迪亚尔房产网");
        request.putQueryParameter("TemplateCode", "SMS_115385945");
        JSONObject param = new JSONObject();
        param.put("code","123456");
        request.putQueryParameter("TemplateParam", param.toJSONString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            if (response.getData() != null){
                JSONObject result = JSONObject.parseObject(response.getData());
                if ("OK".equalsIgnoreCase(result.getString("Code"))){
                    System.out.println("1");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
