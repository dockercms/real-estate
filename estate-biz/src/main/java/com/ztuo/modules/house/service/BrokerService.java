package com.ztuo.modules.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.vo.BrokerQuery;
import com.ztuo.modules.house.vo.BrokerRegister;

import java.util.Map;

/**
 * @Author: dupinyan
 * @Description: 经纪人接口
 * @Date: 2020/2/19 16:17
 * @Version: 1.0
 */
public interface BrokerService {

    /**
     * 分页条件查询经纪人信息
     *
     * @param brokerQuery
     * @return
     */
    Page<EstateBroker> criteriaQuery(BrokerQuery brokerQuery, Map<String, Object> params) throws Exception;

    /**
     * 审核经纪人
     *
     * @param brokerQuery
     * @return
     */
    RestResponse auditBroker(BrokerQuery brokerQuery);

    /**
     * 经纪人注册
     *
     * @param brokerRegister
     * @return
     */
    RestResponse registerByPhone(BrokerRegister brokerRegister) throws Exception;

    /**
     * 经纪人手机号密码登录
     *
     * @param mobilePhone
     * @param password
     * @return
     */
    RestResponse login(String mobilePhone, String password) throws Exception;

    /**
     * 经纪人验证码登录
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    RestResponse msgLogin(String mobilePhone, String msgCode);

    /**
     * 经纪人端忘记密码
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    RestResponse forget(String mobilePhone, String msgCode, String newPassword) throws Exception;

    /**
     * 后台管理新增经纪人
     * @param broker
     * @return
     */
    RestResponse add(EstateBroker broker) throws Exception;

    /**
     * 删除经纪人
     * @param id
     * @return
     */
    RestResponse delete(Long id);

    /**
     * 校验验证码
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    RestResponse checkBrokerMsg(String mobilePhone, String msgCode);
}
