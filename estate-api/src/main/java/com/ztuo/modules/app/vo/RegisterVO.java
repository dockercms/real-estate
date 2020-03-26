package com.ztuo.modules.app.vo;

import lombok.Data;

/**
 * @description: RegisterVO
 * @author: MrGao
 * @create: 2019/07/11 09:40
 */
@Data
public class RegisterVO {

    private String mobilePhone ;

    private String verifyCode ;

    private String userName ;

    private String workPosition ;

    private Long workUnitId ;

    private String workUnitName ;

    private String loginEquipment;

    private String equipmentToken;

    private String password ;
    private String oldPassword ;

}
