package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: dupinyan
 * @Description: 区域中文+维语 DTO
 * @Date: 2020/3/12 11:40
 * @Version: 1.0
 */
@Data
public class SysOrgDTO {


    private String orgNo;

    private String orgName;

    private String orgNameWy;

    private List<SysOrgDTO> orgEntityList;

}
