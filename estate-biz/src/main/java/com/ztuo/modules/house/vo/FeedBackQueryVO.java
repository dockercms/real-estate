package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/3/16 19:24
 * @Version: 1.0
 */
@Data
public class FeedBackQueryVO extends BaseQueryVo {

    private String startTime;

    private String endTime;

    private String mobile;

}
