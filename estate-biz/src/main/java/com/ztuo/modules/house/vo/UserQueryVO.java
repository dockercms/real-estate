package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description: 用户房源数量
 * @Date: 2020/3/13 17:38
 * @Version: 1.0
 */
@Data
public class UserQueryVO extends BaseQueryVo {

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 姓名
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobilePhone;

}
