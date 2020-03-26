package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @description: BrokerGuestVo
 * @author: MrGao
 * @create: 2020/02/15 12:55
 */
@Data
public class BrokerGuestVo extends BaseQueryVo {

    private String status ;

    private String clientName ;

    private String clientPhone ;

    private String createStartTime ;

    private String createEndTime ;

    private String houseRegion ;

    private String brokerId ;

}
