package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @description: UserAgreementVo
 * @author: MrGao
 * @create: 2020/03/12 17:48
 */
@Data
public class UserAgreementVo extends BaseQueryVo {


    private String createStartTime ;

    private String createEndTime ;

    private String agreementName ;

}
