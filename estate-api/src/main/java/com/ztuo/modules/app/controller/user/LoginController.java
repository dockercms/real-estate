package com.ztuo.modules.app.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.HttpRequestUtil;
import com.ztuo.common.utils.JwtUtils;
import com.ztuo.common.utils.RedisUtil;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.handler.MessageSourceHandler;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.entity.TbAppVersion;
import com.ztuo.modules.house.service.BrokerService;
import com.ztuo.modules.house.service.EstateUserService;
import com.ztuo.modules.house.service.ITbAppVersionSV;
import com.ztuo.modules.house.service.SmsService;
import com.ztuo.modules.house.vo.BaseQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: dupinyan
 * @Description: 用户/经纪人 登录模块
 * @Date: 2020/2/11 15:02
 * @Version: 1.0
 */
@RestController
@RequestMapping("login")
@Slf4j
public class LoginController extends RestResponse{

    @Autowired
    private SmsService smsService;

    @Autowired
    private EstateUserService userService;

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private ITbAppVersionSV appVersionSV ;

    @Autowired
    private MessageSourceHandler messageSourceHandler;

    @Autowired
    private RedisUtil redisUtil ;

    @Autowired
    private JwtUtils jwtUtils ;


    /**
     * 用户端 手机密码登录
     * @param mobilePhone   手机号
     * @param password      登录密码
     * @return  token
     */
    @IgnoreAuth
    @RequestMapping(value = "user/phone", method = RequestMethod.POST)
    public RestResponse userLogin(@RequestParam("mobilePhone") String mobilePhone,
                                  @RequestParam("password") String password) {
        log.info("---->用户手机登录---->mobilePhone={}, password={}", mobilePhone, password);
        Assert.hasText(mobilePhone, messageSourceHandler.getMessage("MOBILE_NOT_NULL"));
        Assert.hasText(password, messageSourceHandler.getMessage("PASSWORD_NOT_NULL"));
        try {
            return userService.login(mobilePhone, password);
        } catch (Exception e) {
            log.info("---->用户端账号密码登录异常---->", e);
            return error(messageSourceHandler.getMessage("SIGN_IN_ERROR"));
        }
    }


    /**
     * 经纪人端 手机密码登录
     * @param mobilePhone   手机号
     * @param password      登录密码
     * @return  token
     */
    @IgnoreAuth
    @RequestMapping(value = "broker/phone", method = RequestMethod.POST)
    public RestResponse brokerLogin(@RequestParam("mobilePhone") String mobilePhone,
                                    @RequestParam("password") String password) {
        log.info("---->经纪人手机登录---->mobilePhone={}, password={}", mobilePhone, password);
        Assert.hasText(mobilePhone, "手机号不得为空");
        Assert.hasText(password, "密码不得为空");
        try {
            return brokerService.login(mobilePhone, password);
        } catch (Exception e) {
            log.info("---->经纪人端账号密码登录异常---->", e);
            return error("登录失败");
        }
    }

    /**
     * 用户端手机验证码登录
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "user/msg", method = RequestMethod.POST)
    public RestResponse userMsgLogin(@RequestParam("mobilePhone") String mobilePhone,
                                     @RequestParam("msgCode") String msgCode,
                                     HttpServletRequest request) {
        log.info("---->用户验证码登录---->mobilePhone={}, msgCode={}", mobilePhone, msgCode);
        Assert.hasText(mobilePhone, messageSourceHandler.getMessage("MOBILE_NOT_NULL"));
        Assert.hasText(msgCode, messageSourceHandler.getMessage("MESSAGE_CODE_NOT_NULL"));
        try {
            return userService.msgLogin(mobilePhone, msgCode, request);
        } catch (Exception e) {
            log.info("----->用户验证码登录或快捷登录异常---->", e);
        }
        return error(messageSourceHandler.getMessage("SIGN_IN_ERROR"));
    }


    /**
     * 经纪人验证码登录
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "broker/msg", method = RequestMethod.POST)
    public RestResponse brokerMsgLogin(@RequestParam("mobilePhone") String mobilePhone,
                                       @RequestParam("msgCode") String msgCode) {
        log.info("---->经纪人验证码登录---->mobilePhone={}, msgCode={}", mobilePhone, msgCode);
        Assert.hasText(mobilePhone, "手机号不得为空");
        Assert.hasText(msgCode, "验证码不得为空");
        return brokerService.msgLogin(mobilePhone, msgCode);
    }

    /**
     * 忘记重置密码
     * @param mobilePhone 手机号
     * @param msgCode   验证码
     * @param type  用户类型 0-用户端/pc端 1-经纪人端
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "forget", method = RequestMethod.POST)
    public RestResponse forgetPassword(@RequestParam("mobilePhone") String mobilePhone,
                                       @RequestParam("msgCode") String msgCode,
                                       @RequestParam("newPassword") String newPassword,
                                       @RequestParam("userType") Integer type) {
        log.info("---->忘记重置密码---->mobilePhone={}, msgCode={}, newPassword={}, type={}", mobilePhone, msgCode, newPassword, type);
        Assert.hasText(mobilePhone, messageSourceHandler.getMessage("MOBILE_NOT_NULL"));
        Assert.hasText(msgCode, messageSourceHandler.getMessage("MESSAGE_CODE_NOT_NULL"));
        try {
            if (type != null) {
                if (type == 0) {
                    return userService.forget(mobilePhone, msgCode, newPassword);
                }
                if (type == 1) {
                    return brokerService.forget(mobilePhone, msgCode, newPassword);
                }
            }
        } catch (Exception e) {
            log.info("---->忘记重置密码异常---->", e);
        }
        return error(messageSourceHandler.getMessage("ILLEGAL_PARAM"));
    }

    /**
     * 查询当前更新版本信息
     * @param appCate
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "app/version/{cate}",method = RequestMethod.GET)
    public RestResponse getAppVersion(@PathVariable("cate")String appCate){
        log.info("查询当前更新版本信息={}",appCate);
        BaseQueryVo queryVO = new BaseQueryVo();
        queryVO.setPageNum(1);
        queryVO.setPageSize(1);
        Page<TbAppVersion> page =  appVersionSV.pageQueryByVO(queryVO,appCate);
        return RestResponse.success().putData(page.getRecords().get(0));

    }

    private String appId = "wxc70bef0b5b1fdad1";

    private String secret = "";

    private String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    private String refreshTokenUrl = " https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";

    private String getUserInfoUrl=" https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    private String REFRESH_TOKEN ="REFRESH_TOKEN_";

    private String TOKEN="TOKEN_";

    private String OPEN_ID="OPEN_ID_";
    /**
     * 微信登录
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "we/chat/login",method = RequestMethod.POST)
    public RestResponse weChatLogin(String code ){
        log.info("code={},state={}",code);
        if(StringUtils.isNotEmpty(code)){
            return RestResponse.error("信息不符合,请重新授权");
        }
        String accessToken = redisUtil.getString(TOKEN+code);
        String refreshToken = redisUtil.getString(REFRESH_TOKEN+code);
        String openId =redisUtil.getString(OPEN_ID+code);
        if(StringUtils.isEmpty(accessToken) && StringUtils.isEmpty(refreshToken)){
            // 根据 code 获取 token
            String url = String.format(getAccessTokenUrl,appId,secret,code);
            log.info("获取AccessToken={}",url);
            String tokenJson = HttpRequestUtil.URLGet(url, null);
            log.info("tokenJson={}",tokenJson);
            JSONObject jsonObject = JSONObject.parseObject(tokenJson);
            accessToken= jsonObject.getString("access_token");
            refreshToken = jsonObject.getString("refresh_token");
            openId = jsonObject.getString("openid");
            log.info("accessToken={},refresh_token={},openid={}",accessToken,refreshToken,openId);
            redisUtil.set(TOKEN+code,accessToken,7200,TimeUnit.SECONDS);
            redisUtil.set(REFRESH_TOKEN+code,refreshToken,30,TimeUnit.DAYS);
            redisUtil.set(OPEN_ID+code,openId);
        }else if(StringUtils.isNotEmpty(refreshToken) && StringUtils.isEmpty(accessToken)){
            //刷新token
            String url = String.format(refreshTokenUrl,appId,refreshToken);
            String tokenJson = HttpRequestUtil.URLGet(url, null);
            log.info("tokenJson={},url={}",tokenJson,url);
            JSONObject jsonObject = JSONObject.parseObject(tokenJson);
            accessToken= jsonObject.getString("access_token");
            refreshToken = jsonObject.getString("refresh_token");
            openId = jsonObject.getString("openid");
            redisUtil.set(TOKEN+code,accessToken,7200,TimeUnit.SECONDS);
            redisUtil.set(OPEN_ID+code,openId);
            log.info("accessToken={},refresh_token={},openid={}",accessToken,refreshToken,openId);
        }
        //根据 token 获取 用户信息
        String url = String.format(getUserInfoUrl,accessToken,openId);
        //拉取用户信息
        String result = HttpRequestUtil.URLGet(url, null);
        log.info("result={},url={}",result,url);
        JSONObject  userInfo= JSONObject.parseObject(result);
        String nickname = userInfo.getString("nickname");
        String headImgUrl = userInfo.getString("headimgurl");
        EstateUser estateUser = userService.findByOpenId(openId);
        if(estateUser ==null){
            //新注册用户
            estateUser = new EstateUser();
            estateUser.setAvatarUrl(headImgUrl);
            estateUser.setCreateTime(new Date());
            estateUser.setNickname(nickname);
            estateUser.setOpenId(openId);
            estateUser.setHouseResourseNum(0);
            userService.saveEstateUser(estateUser);
        }else {
            //登录用户
            EstateUser update = new EstateUser();
            update.setId(estateUser.getId());
            update.setAvatarUrl(headImgUrl);
            update.setNickname(nickname);
            userService.updateUser(update);
        }
        log.info("user info ={}",estateUser);
        String token = jwtUtils.generateToken(estateUser.getId().toString());
        redisUtil.set(token,estateUser.getId(),jwtUtils.getExpire(),TimeUnit.SECONDS);
        Map<String, Object> map = new HashMap<>(4);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("user", estateUser);
        return RestResponse.success(map);
    }


}
