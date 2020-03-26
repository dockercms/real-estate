package com.ztuo.modules.house.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: dupinyan
 * @Description: 经纪人查询
 * @Date: 2020/2/19 15:46
 * @Version: 1.0
 */
@Data
public class BrokerQuery extends BaseQueryVo {

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 审核状态 0-审核中 1-审核成功 2-审核失败
     */
    private Integer auditStatus;

    /**
     * 经纪人姓名
     */
    private String brokerName;

    /**
     * 工作区域
     */
    private String workArea;

    /**
     * 工作店铺
     */
    private String workShop;

    /**
     * 区域code
     */
    private String areaCode;

    /**
     * 经纪人id
     */
    private Long brokerId;

    /**
     * 经纪人级别 0-初级 1-中级 2-高级
     */
    private Integer brokerLevel;

    /**
     * 经纪人ids
     */
    private List<Long> brokerIds;
}
