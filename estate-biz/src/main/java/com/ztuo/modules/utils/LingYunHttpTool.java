package com.ztuo.modules.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 * 
 * @author
 *
 */

public class LingYunHttpTool {
	//指定访问灵云平台�??求的Appkey，Devkey，ClourUrl密钥
	private final static String appkey="b95d5446";
	private final static String developerkey= "90ff428742b3facd6c190c3ab3e72250";
	private final static String cloudurl="http://api.hcicloud.com:8880/mt/Translate";
	
	//指定使用的MT能力
	private final static String capkey="mt.cloud.translate";
	private final static String property="cn2uy";
	//指定访问平台的SdkVersion版本、UDID设备�??
	private final static String sdkversion="8.1";
	private final static String udid="101:1234567890";
	
	//意图识别使用的参数配�?
	private final static String splitsentence="yes";
	private final static String taskconfig="capkey="+ capkey +",splitsentence"+splitsentence+",property="+ property;

	//指定MT请求数据
	private final static String transText="乌鲁木齐,新疆";
//	byte[] bytes = strToByteArray();
//	ByteArrayInputStream bInputStream = new ByteArrayInputStream(bytes);
	
	//获取当前的时间并格式
	private String getNowDate() {
    	Date currentTime = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return dateFormat.format(currentTime);
    }
	
	//字符串转二进制数
	public static byte[] strToByteArray(String str) {
	    if (str == null) {
	        return null;
	    }
	    byte[] byteArray = str.getBytes();
	    return byteArray;
	}

	//发�?�HTTP POST请求
	public byte[] sendPost(String cloudurl) throws IOException{
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(cloudurl);
		postMethod.setRequestHeader("x-app-key",appkey);
		postMethod.setRequestHeader("x-sdk-version", sdkversion);
		postMethod.setRequestHeader("x-request-date", getNowDate());
		postMethod.setRequestHeader("x-task-config",taskconfig);
		postMethod.setRequestHeader("x-session-key",getXsessionkey(getNowDate(), developerkey));
		postMethod.setRequestHeader("x-result-format", "json");
		postMethod.setRequestEntity(new StringRequestEntity(transText, null, "UTF-8"));
		httpClient.executeMethod(postMethod);
		byte[] responseBody=postMethod.getResponseBody();
		return responseBody;
	}
	
	//生成灵云平台求的SessionKey密钥
	private String getXsessionkey(String currentTime,String developerkey) {
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] messageByte = (currentTime+developerkey).getBytes("UTF-8");
			byte[] md5Byte = md.digest(messageByte);
			return byteToHex(md5Byte);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return developerkey;
				
	}
	
	//Byte2Hex
	private String byteToHex(byte[] bytes) {
		StringBuffer hexStr = new StringBuffer();
		int num;
		for (int count = 0; count < bytes.length; count++) {
            num = bytes[count];  
            if(num < 0) {  
                num += 256;  
           }  
           if(num < 16){  
               hexStr.append("0");  
           }  
           hexStr.append(Integer.toHexString(num));  
        }  
        return hexStr.toString().toUpperCase();  
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LingYunHttpTool httptool = new LingYunHttpTool();
    	byte[] byteResult = httptool.sendPost(cloudurl);
    	String result = new String(byteResult, "utf-8");
    	System.out.println(result.toString());
    		
	}
	
	

}
	

		