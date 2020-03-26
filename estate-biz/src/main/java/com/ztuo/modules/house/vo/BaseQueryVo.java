package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @description: BaseQueryVo
 * @author: MrGao
 * @create: 2020/02/14 10:34
 */
@Data
public class BaseQueryVo {

    private Integer pageNum =1;

    private Integer pageSize =10;

    private Long userId ;

}
