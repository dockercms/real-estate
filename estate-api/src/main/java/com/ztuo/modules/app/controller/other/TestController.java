package com.ztuo.modules.app.controller.other;

import com.ztuo.common.utils.EasemobService;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.sys.entity.SysOrgEntity;
import com.ztuo.modules.utils.UPushUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2019/7/8 8:26 PM
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private EasemobService easemobService;

    @Autowired
    private UPushUtils uPushUtils;

    @IgnoreAuth
    @RequestMapping(value = "register/{userType}",method = RequestMethod.GET)
    public RestResponse register(@PathVariable("userType")String userType) {
        if("0".equalsIgnoreCase(userType)){
            easemobService.registerEasemob("b1","123456","111");
        }else {
            easemobService.registerEasemob("c1","123456","111");
        }
        return RestResponse.success();

    }


    @IgnoreAuth
    @RequestMapping(value = "create",method = RequestMethod.GET)
    public RestResponse createGroup() {

        String s = easemobService.createGroup(13L,23L,"测试新增");
        return RestResponse.success().putData(s);

    }


    @IgnoreAuth
    @RequestMapping(value = "send",method = RequestMethod.POST)
    public RestResponse sendMessage(@RequestParam("deviceToken")String deviceToken,@RequestParam("cate")String
            cate) {


        try {
            if ("1".equals(cate)){
                uPushUtils.sendIOSUnicastServer(deviceToken,"测试服务端","测试新增","测试服务端");

            }else{
                uPushUtils.sendIOSTest(deviceToken,"测试客户端","测试新增","测试客户端");

            }

        } catch (Exception e) {
            log.info("------测试发送异常:e={}",e);
        }

        return RestResponse.success();
    }



}
