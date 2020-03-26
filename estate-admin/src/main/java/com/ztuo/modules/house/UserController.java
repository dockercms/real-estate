package com.ztuo.modules.house;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.service.EstateUserService;
import com.ztuo.modules.house.vo.UserQueryVO;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/3/13 16:12
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController extends AbstractController {

    @Autowired
    private EstateUserService estateUserService;


    /**
     * 条件分页查询 用户
     * @return
     */
    @RequestMapping(value = "pageQuery", method = RequestMethod.POST)
    public RestResponse pageQueryUser(@RequestBody UserQueryVO userQueryVO) {
        log.info("---->分页条件查询用户---->userQueryVO={}", userQueryVO);
        try {
            return estateUserService.pageQueryByCondition(userQueryVO);
        } catch (Exception e) {
            log.info("---->查询用户异常---->", e);
            return RestResponse.error();
        }
    }
}
