package com.ztuo.modules.house.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: AdvertisingQueryVO
 * @author: MrGao
 * @create: 2020/03/03 19:36
 */
@Data
public class AdvertisingQueryVO extends BaseQueryVo{

    private String createStartTime ;

    private String createEndTime ;

    private String location ;

    private Date effectTime ;


}
