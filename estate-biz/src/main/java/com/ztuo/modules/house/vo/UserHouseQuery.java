package com.ztuo.modules.house.vo;


import lombok.Data;

import java.util.List;

/**
 * @description: UserHouseQuery
 * @author: MrGao
 * @create: 2020/02/14 10:35
 */
@Data
public class UserHouseQuery extends BaseQueryVo {

    /**
     * 上传类型 0我要估价 1我要卖房 2我要求购 3委托出租
     */
    private List<String> loadTypes ;

    private String status ;

    private String createStartTime ;

    private String createEndTime ;

    private String houseZone ;

    private Long houseId ;
    /**
     * 前端查询 1 其他 后台管理查询
     */
    private String webQuery ;

    /**
     * 1 查询我的委托 其他查询我的房子
     */
    private String entrustQuery ;



}
