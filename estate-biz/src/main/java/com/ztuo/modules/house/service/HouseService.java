package com.ztuo.modules.house.service;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.HouseResource;
import com.ztuo.modules.house.vo.HouseResourceVO;

/**
 * @Author: dupinyan
 * @Description: 房源后台操作
 * @Date: 2020/2/18 17:27
 * @Version: 1.0
 */
public interface HouseService {

    /**
     * 修改经纪人上传房源信息
     * @param houseResource 汉语房源
     * @return
     */
    RestResponse updateHouse(HouseResource houseResource);


    /**
     * 删除房源信息 同时删除维语房源
     * @param id
     * @return
     */
    RestResponse deleteHouse(Long id);


    /**
     * 审核房源信息 同时修改维语房源审核状态
     * @param houseResourceVO
     * @return
     */
    RestResponse audit(HouseResourceVO houseResourceVO);

}
