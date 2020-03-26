package com.ztuo.modules.house.vo;

import com.ztuo.modules.house.entity.EstateBroker;
import lombok.Data;

/**
 * @Author: dupinyan
 * @Description: 经纪人注册
 * @Date: 2020/2/20 16:59
 * @Version: 1.0
 */
@Data
public class BrokerRegister {

    /**
     * 经纪人
     */
    private EstateBroker broker;

    /**
     * 短信验证码
     */
    private String msgCode;

}
