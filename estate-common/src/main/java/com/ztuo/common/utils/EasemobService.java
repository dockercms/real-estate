package com.ztuo.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description: 环信接入工具类
 * @Author: GuoShuai
 * @Date: 2019/7/8 7:35 PM
 */
@Slf4j
@Component
public class EasemobService {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${easemob.org.name}")
    private String orgName;

    @Value("${easemob.app.name}")
    private String appName;

    @Value("${easemob.client.id}")
    private String clientId;

    @Value("${easemob.client.secret}")
    private String clientSecret;

    @Value("${easemob.lead.id}")
    private String leadId;

    private static String httpURL = "https://a1.easemob.com/";

    /**
     * 注册用户
     * @param userId
     * @param password
     * @param nickname
     * @return
     */
    public boolean registerEasemob(String userId, String password,String nickname){
        String url = httpURL+orgName+"/"+appName+"/users";
        log.info("-----创建环信用户URL"+url);
        JSONObject param = new JSONObject();
        param.put("username",userId);
        param.put("password",password);
        param.put("nickname",nickname);
        String accessToken = getToken();
        if (accessToken == null){
            return false;
        }
        Map<String, Object> headParams = new HashMap<>();
        headParams.put("Authorization","Bearer "+accessToken);
        String result = HttpRequestUtil.URLPostJSONParams(url, param.toJSONString(), headParams);
        log.info("-----创建环信用户返回"+result);
        JSONObject users = JSONObject.parseObject(result);
        String application = users.getString("application");
        if (StringUtils.isNotEmpty(application)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 创建一个群组
     * @param userId
     * @param addUserId
     * @return
     */
    public String createGroup(Long userId, Long  addUserId,String groupname){

        String url = httpURL+orgName+"/"+appName+"/chatgroups";
        log.info("-----创建环信群组URL"+url);
        JSONObject param = new JSONObject();
        //群组名称，此属性为必须的
        param.put("groupname",groupname);
        //群组描述，此属性为必须的
        param.put("desc",groupname);
        //群组最大人数
        param.put("maxusers",300);
        param.put("members_only",false);
        //是否是公开群，此属性为必须的
        param.put("public",false);
        //是否允许群成员邀请别人加入此群。 true：允许群成员邀请人加入此群，false：只有群主或者管理员才可以往群里加人
        param.put("allowinvites",true);
        //群组的管理员，此属性为必须的，默认客服
        param.put("owner",leadId+"");
        List<String> members = Arrays.asList(userId+"",addUserId+"");
        //群组成员，此属性为可选的，但是如果加了此项，数组元素至少一个（注：群主user1不需要写入到members里面）
        param.put("members",members);
        String accessToken = getToken();
        if (accessToken == null){
            return null;
        }
        Map<String, Object> headParams = new HashMap<>();
        headParams.put("Authorization","Bearer "+accessToken);
        String result = HttpRequestUtil.URLPostJSONParams(url, param.toJSONString(), headParams);
        if (StringUtils.isEmpty(result)){
            return null;
        }
        log.info("-----创建环信用户返回"+result);
        JSONObject users = JSONObject.parseObject(result);
        String application = users.getString("application");
        if (StringUtils.isNotEmpty(application)){
            JSONObject dataJson = users.getJSONObject("data");
            String groupId = dataJson.getString("groupid");
            if (StringUtils.isNotEmpty(groupId)){
                return groupId;
            }
            return null;
        }else {
            return null;
        }
    }


    /**
     * 获取群组用户
     * @param groupId
     * @return
     */
    public List<Long> getGroupUser(String groupId){
        List<Long> res= new ArrayList<>();
        String url = httpURL+orgName+"/"+appName+"/chatgroups/"+groupId+"/users";
        log.info("-----获取环信群组用户URL"+url);
        String accessToken = getToken();
        if (accessToken == null){
            return null;
        }
        Map<String, Object> headParams = new HashMap<>();
        headParams.put("Authorization","Bearer "+accessToken);
        String result = HttpRequestUtil.URLGet(url,headParams);
        log.info("-----获取环信群组用户返回"+result);
        if (StringUtils.isEmpty(result)){
            return null;
        }
        JSONObject allUser = JSONObject.parseObject(result);
        String application = allUser.getString("application");
        if (StringUtils.isNotEmpty(application)){
            JSONArray dataJson = allUser.getJSONArray("data");
            JSONObject user;
            for (int i = 0; i < dataJson.size(); i++) {
                user = dataJson.getJSONObject(i);
                if ( i > 0){
                    res.add(user.getLong("member"));
                }
            }
            return res;
        }else {
            return null;
        }
    }




    /**
     * 获取校验token
     * @return
     */
    public String getToken(){
        String accessToken = redisUtil.getString(Constant.EASEMOB_ACCESS_TOKEN);
        if ( StringUtils.isEmpty(accessToken)){
            String url = httpURL+orgName+"/"+appName+"/token";
            log.info("-----获取环信token-URL"+url);
            JSONObject param = new JSONObject();
            param.put("client_id",clientId);
            param.put("client_secret",clientSecret);
            param.put("grant_type","client_credentials");
            String result = HttpRequestUtil.URLPostJSONParams(url, param.toJSONString(), null);
            log.info("-----获取环信token返回"+result);
            JSONObject token = JSONObject.parseObject(result);
            accessToken = token.getString("access_token");
            if (StringUtils.isNotEmpty(accessToken)){
                int expiresIn = token.getInteger("expires_in")-100;
                redisUtil.set(Constant.EASEMOB_ACCESS_TOKEN,accessToken,expiresIn);
                return accessToken;
            }else {
                return null;
            }
        }else {
            return accessToken;
        }
    }

    /**
     * 检查用户是否存在
     * @param userName
     * @return
     */
    public boolean checkUserRegister(String userName){
        String url = httpURL+orgName+"/"+appName+"/users/"+userName;
        log.info("-----检查用户是否存在用户信息"+url);
        String accessToken = getToken();
        if (accessToken == null){
            return false;
        }
        Map<String, Object> headParams = new HashMap<>();
        headParams.put("Authorization","Bearer "+accessToken);
        String result = HttpRequestUtil.URLGet(url,  headParams);
        log.info("-----检查用户是否存在返回"+result);
        if(StringUtils.isEmpty(result)){
            return false;
        }else {
            JSONObject json = JSONObject.parseObject(result);
            JSONArray entities = json.getJSONArray("entities");
            log.info("entities={}",entities);
            return true;
        }
    }


}
