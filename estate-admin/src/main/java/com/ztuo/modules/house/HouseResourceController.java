package com.ztuo.modules.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.dto.DataConfigurationDTO;
import com.ztuo.modules.house.entity.DataConfiguration;
import com.ztuo.modules.house.entity.HouseResource;
import com.ztuo.modules.house.service.HouseService;
import com.ztuo.modules.house.service.IDataConfigurationSV;
import com.ztuo.modules.house.service.IHouseResourceSV;
import com.ztuo.modules.house.vo.HouseResourceVO;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dupinyan
 * @Description: 上传房源管理
 * @Date: 2020/2/17 15:25
 * @Version: 1.0
 */
@RestController
@RequestMapping("houseResource")
@Slf4j
public class HouseResourceController extends AbstractController {

    @Autowired
    private IHouseResourceSV houseResourceSV;

    @Autowired
    private HouseService houseService;

    @Autowired
    private IDataConfigurationSV dataConfigurationSV;


    /**
     * 分页条件查询经纪人上传房源
     * @param houseResourceVO
     * @return
     */
    @RequestMapping(value = "pageQuery", method = RequestMethod.POST)
    public RestResponse queryHouseResource(@RequestBody HouseResourceVO houseResourceVO) {
        log.info("---->分页条件查询经纪人上传房源---->houseResourceVO={}", houseResourceVO);
        Page<HouseResource> page = null;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("dataScope", getDataScope());
            page = houseResourceSV.criteriaQuery(houseResourceVO,params);
        } catch (Exception e) {
            log.info("---->分页条件查询异常---->", e);
            return RestResponse.error("查询失败");
        }
        return RestResponse.success(page);
    }


    /**
     * 查询单个
     * @param id
     * @return
     */
    @RequestMapping(value = "queryOne/{id}", method = RequestMethod.GET)
    public RestResponse queryOne(@PathVariable("id") Long id) {
        log.info("---->查询单个房源信息---->id={}", id);
        HouseResource houseResource = null;
        try {
            houseResource = houseResourceSV.getByPrimaryKey(id);
        } catch (Exception e) {
            log.info("---->查询单个房源信息异常---->", e);
            return RestResponse.error("查询失败");
        }
        return RestResponse.success(houseResource);
    }


    /**
     * 删除信息
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public RestResponse delete(@PathVariable("id") Long id) {
        log.info("---->删除单个信息---->id={}", id);
        return houseService.deleteHouse(id);
    }


    /**
     * 修改单个房源
     * @param houseResource
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public RestResponse update(@RequestBody HouseResource houseResource) {
        log.info("---->修改单个房源---->houseResource={}", houseResource);
        return houseService.updateHouse(houseResource);
    }


    /**
     * 审核房源
     * @param houseResourceVO
     * @return
     */
    @RequestMapping(value = "audit", method = RequestMethod.POST)
    public RestResponse auditHouse(@RequestBody HouseResourceVO houseResourceVO) {
        log.info("---->审核房源---->houseResourceVO={}", houseResourceVO);
        return houseService.audit(houseResourceVO);
    }


    @RequestMapping(value = "configuration", method = RequestMethod.GET)
    public RestResponse queryConfiguration() {
        log.info("---->查询全部配置---->");
        List<DataConfiguration> dataConfiguration = dataConfigurationSV.findAll(0L);
        Map<Long, Object> map = new HashMap<>();
        for (int i = 0; i < dataConfiguration.size(); i++) {
            List<DataConfiguration> all = dataConfigurationSV.findAll(dataConfiguration.get(i).getId());
            map.put(dataConfiguration.get(i).getId(), all);
        }
        DataConfigurationDTO dataConfigurationDTO = new DataConfigurationDTO();
        map.put(1001L, dataConfigurationDTO.getCategories());
        map.put(1002L, dataConfigurationDTO.getRentalType());
        map.put(1003L, dataConfigurationDTO.getDecorationType());
        map.put(1004L, dataConfigurationDTO.getElevator());
        map.put(1005L, dataConfigurationDTO.getTowards());
        map.put(1006L, dataConfigurationDTO.getPaymentMethod());
        map.put(1007L, dataConfigurationDTO.getSticky());
        map.put(1008L, dataConfigurationDTO.getOperatingStatus());
        map.put(1009L, dataConfigurationDTO.getHouseDetailType());
        return RestResponse.success(map);
    }


}
