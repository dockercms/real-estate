package com.ztuo.modules.utils;

import com.alibaba.fastjson.JSONObject;
import com.ztuo.common.utils.RedisUtil;
import com.ztuo.push.AndroidNotification;
import com.ztuo.push.PushClient;
import com.ztuo.push.android.AndroidUnicast;
import com.ztuo.push.ios.IOSUnicast;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2019/7/13 9:53 AM
 */
@Slf4j
@Component
public class UPushUtils {


    /**
     * 1.早上8点半,6点各一次服务运行正常
     * 发送逻辑
     * 1>获取消息配置
     * 2>获取发送对象
     * 3>判断发送方式,是否需要app推送,是否需要发送站内信
     * 4>判断是否生成工单
     * 2.
     */

    @Value("${android.push.app.key}")
    private String androidAppkey;

    @Value("${android.push.app.Secret}")
    private String androidAppSecret;

    @Value("${android.server.push.app.key}")
    private String androidServerAppkey;

    @Value("${android.server.push.app.Secret}")
    private String androidServerAppSecret;


    @Value("${ios.push.app.key}")
    private String IOSAppkey;

    @Value("${ios.push.app.Secret}")
    private String IOSAppSecret;

    @Value("${ios.server.push.app.key}")
    private String IOSServerAppkey;

    @Value("${ios.server.push.app.Secret}")
    private String IOSServerAppSecret;


    @Autowired
    private RedisUtil redisUtil;


    private ExecutorService executor = Executors.newFixedThreadPool(20);


    /**
     * app单播消息推送(向指定设备发送消息)
     *
     * @param loginEquipment 0-安卓,1-ios
     * @param deviceToken    设备token
     * @param title          通知标题
     * @param titleContent   通知副标题
     * @param content        通知内容
     * @param userType       0客户1销售2客服3专家4售后
     * @throws Exception
     */
    public void pushSend(String loginEquipment, String deviceToken, String userType, String title, String titleContent,
                         String content) throws Exception {

        if (StringUtils.isNotEmpty(deviceToken)) {
            if ("0".equals(userType)) {
                if ("0".equals(loginEquipment)) {
                    //安卓推送
                    sendAndroidUnicast(deviceToken, title, titleContent, content);
                } else if ("1".equals(loginEquipment)) {
                    //IOS推送
                    sendIOSUnicast(deviceToken, title, titleContent, content);
                }
            } else {
                if ("0".equals(loginEquipment)) {
                    //安卓推送
                    sendAndroidUnicastServer(deviceToken, title, titleContent, content);
                } else if ("1".equals(loginEquipment)) {
                    //IOS推送
                    sendIOSUnicastServer(deviceToken, title, titleContent, content);
                }
            }
        }
    }

    /**
     * 客户端ios推送
     *
     * @param deviceToken
     * @param title
     * @param titleContent
     * @param content
     * @throws Exception
     */
    public void sendIOSUnicast(String deviceToken, String title, String titleContent, String content) throws Exception {
        PushClient client = new PushClient();
        IOSUnicast unicast = new IOSUnicast(IOSAppkey, IOSAppSecret);
        unicast.setDeviceToken(deviceToken);
        JSONObject alert = new JSONObject();
        alert.put("title", title);
//        alert.put("subtitle",titleContent);
        alert.put("body", content);
        unicast.setAlert(alert);
        unicast.setBadge(0);
        unicast.setSound("default");
        unicast.setContentAvailable(0);
        unicast.setTestMode();
        log.info("-----IOS用户端推送----");
        // Set customized fields
//        unicast.setCustomizedField("test", "helloworld");
        client.send(unicast);
    }

    /**
     * 售后端IOS推送
     *
     * @param deviceToken
     * @param title
     * @param titleContent
     * @param content
     * @throws Exception
     */
    public void sendIOSUnicastServer(String deviceToken, String title, String titleContent, String content) throws
            Exception {
        PushClient client = new PushClient();
        IOSUnicast unicast = new IOSUnicast(IOSServerAppkey, IOSServerAppSecret);
        unicast.setDeviceToken(deviceToken);
        JSONObject alert = new JSONObject();
        alert.put("title", title);
//        alert.put("subtitle",titleContent);
        alert.put("body", content);
        unicast.setAlert(alert);
        unicast.setBadge(0);
        unicast.setSound("default");
        unicast.setContentAvailable(0);
        unicast.setTestMode();
        // Set customized fields
//        unicast.setCustomizedField("test", "helloworld");
        client.send(unicast);
    }


    /**
     * 安卓客户端推送
     *
     * @param deviceToken
     * @param title
     * @param titleContent
     * @param content
     * @throws Exception
     */
    public void sendAndroidUnicast(String deviceToken, String title, String titleContent, String content) throws
            Exception {
        PushClient client = new PushClient();
        AndroidUnicast unicast = new AndroidUnicast(androidAppkey, androidAppSecret);
        unicast.setDeviceToken(deviceToken);
//        unicast.setTicker(titleContent);
        unicast.setTitle(title);
        unicast.setText(content);
        unicast.goAppAfterOpen();
        unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        unicast.setTestMode();
        // Set customized fields
//        unicast.setExtraField();
        client.send(unicast);
    }


    /**
     * 安卓售后端推送
     *
     * @param deviceToken
     * @param title
     * @param titleContent
     * @param content
     * @throws Exception
     */
    public void sendAndroidUnicastServer(String deviceToken, String title, String titleContent, String content) throws
            Exception {
        PushClient client = new PushClient();
        AndroidUnicast unicast = new AndroidUnicast(androidServerAppkey, androidServerAppSecret);
        unicast.setDeviceToken(deviceToken);
//        unicast.setTicker(titleContent);
        unicast.setTitle(title);
        unicast.setText(content);
        unicast.goAppAfterOpen();
        unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        unicast.setTestMode();
        // Set customized fields
//        unicast.setExtraField();
        client.send(unicast);
    }


    public void sendIOSTest(String deviceToken, String title, String titleContent, String content) throws Exception {
        PushClient client = new PushClient();
        IOSUnicast unicast = new IOSUnicast(IOSAppkey, IOSAppSecret);
        unicast.setDeviceToken(deviceToken);

        JSONObject alert = new JSONObject();
        alert.put("title", title);
//        alert.put("subtitle",titleContent);
        alert.put("body", content);

        unicast.setAlert(alert);
        unicast.setBadge(0);
        unicast.setSound("default");
        unicast.setTestMode();
        // Set customized fields
        unicast.setCustomizedField("test", "helloworld");
        client.send(unicast);
    }

}
