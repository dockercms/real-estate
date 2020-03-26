package com.ztuo.modules.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.UserAgreement;
import com.ztuo.modules.house.service.IUserAgreementSV;
import com.ztuo.modules.house.vo.UserAgreementVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description: UserAgreementController
 * @author: MrGao
 * @create: 2020/03/12 17:46
 */
@Slf4j
@RestController
@RequestMapping("agreement")
public class UserAgreementController {

    @Autowired
    private IUserAgreementSV userAgreementSV ;

    /**
     * 分页查询用户协议
     * @param agreementVo
     * @return
     */
    @RequiresPermissions("user:agreement:page")
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public RestResponse pageQueryUserAgreement(@RequestBody UserAgreementVo agreementVo) throws Exception{
        log.info("分页查询用户协议={}",agreementVo);
        Page<UserAgreement> page = userAgreementSV.pageQuery(agreementVo);
        return RestResponse.success(page);
    }

    /**
     * 保存用户协议
     * @param userAgreement
     * @return
     * @throws Exception
     */
    @RequiresPermissions("user:agreement:save")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public RestResponse addUserAgreement(@RequestBody UserAgreement userAgreement) throws Exception{
        log.info("用户协议新增={}",userAgreement);
        userAgreement.setCreateTime(new Date());
        int i = userAgreementSV.abandonHistoryAgreement(userAgreement.getAgreementType());
        log.info("废除协议个数={}",i);
        userAgreement.setStatus("0");
        userAgreementSV.save(userAgreement);
        return RestResponse.success("添加成功");
    }




}
