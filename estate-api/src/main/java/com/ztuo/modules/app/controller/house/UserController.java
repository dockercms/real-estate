package com.ztuo.modules.app.controller.house;

import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.service.IEstateBrokerSV;
import com.ztuo.modules.house.service.IEstateUserSV;
import com.ztuo.modules.house.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dupinyan
 * @Description: 经纪人/用户相关
 * @Date: 2020/3/2 10:12
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController extends RestResponse {

    @Autowired
    private IEstateUserSV userSV;

    @Autowired
    private IEstateBrokerSV estateBrokerSV;


    /**
     * 获取用户信息
     * @param type
     * @return
     */
    @RequestMapping(value = "getMessage/{type}", method = RequestMethod.GET)
    public RestResponse getMessage(HttpServletRequest request, @PathVariable("type") Integer type) {
        String userId = request.getHeader("User-Id");
        log.info("---->获取经纪人或用户端信息---->type={}, userId={}", type, userId);
        try {
            if (StringUtils.isNotBlank(userId)) {
                if (type == 0) {
                    EstateUser user = userSV.getByPrimaryKey(Long.valueOf(userId));
                    log.info("---->获取用户端信息---->user={}", user);
                    return success(user);
                }
                if (type == 1) {
                    EstateBroker broker = estateBrokerSV.getByPrimaryKey(Long.valueOf(userId));
                    log.info("---->获取经纪人端信息---->broker={}", broker);
                    return success(broker);
                }
            }
        } catch (Exception e) {
            log.info("---->获取用户信息异常---->", e);
        }
        return error("获取用户信息失败");
    }

    /**
     * 修改用户头像及昵称
     * @param userInfoVO
     * @return
     */
    @RequestMapping(value = "info/update", method = RequestMethod.POST)
    public RestResponse getMessage(HttpServletRequest request, @RequestBody UserInfoVO userInfoVO) throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        log.info("---->修改用户头像及昵称---->userInfoVO={}, userId={}", userInfoVO.toString(), userId);
        if (StringUtils.isNotBlank(userId)) {
            EstateUser user = userSV.getByPrimaryKey(Long.valueOf(userId));
            if (user !=null){
                if (StringUtils.isNotEmpty(userInfoVO.getNickname())){
                    user.setNickname(userInfoVO.getNickname());
                }
                if (StringUtils.isNotEmpty(userInfoVO.getAvatarUrl())){
                    user.setAvatarUrl(userInfoVO.getAvatarUrl());
                }
                int result = userSV.updateByPrimaryKeySelective(user);
                if (result == 1){
                    return success("修改成功");
                }else {
                    return error("修改失败,请稍候重试");
                }
            }
        }
        return error("用户不存在");
    }

}
