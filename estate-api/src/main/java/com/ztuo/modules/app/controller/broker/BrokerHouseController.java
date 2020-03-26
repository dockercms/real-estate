package com.ztuo.modules.app.controller.broker;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.dto.DataConfigurationDTO;
import com.ztuo.modules.house.entity.DataConfiguration;
import com.ztuo.modules.house.entity.DataConfigurationInfo;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.service.HouseResourceService;
import com.ztuo.modules.house.service.IDataConfigurationSV;
import com.ztuo.modules.house.service.IEstateBrokerSV;
import com.ztuo.modules.house.vo.BrokerQuery;
import com.ztuo.modules.house.vo.UploadHouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dupinyan
 * @Description: 经纪人相关
 * @Date: 2020/2/15 15:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("broker")
@Slf4j
public class BrokerHouseController extends RestResponse{


    @Autowired
    private IDataConfigurationSV dataConfigurationSV;

    @Autowired
    private IEstateBrokerSV estateBrokerSV;

    @Autowired
    private HouseResourceService houseResourceService;



    /**
     * 经纪人上传房源
     * @param uploadHouse
     * @return
     */
    @RequestMapping(value = "uploadHouse", method = RequestMethod.POST)
    public RestResponse uploadHouseResource(@RequestBody UploadHouse uploadHouse) {
        log.info("---->上传房源---->uploadHouse={}", uploadHouse);
        try {
            return houseResourceService.uploadHouse(uploadHouse);
        } catch (Exception e) {
            return RestResponse.error("上传失败");
        }
    }


    /**
     * 根据父级ID查询全部配置
     * @return
     */
    @IgnoreAuth
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
        return success(map);
    }


    /**
     * 经纪人分页条件查询
     * @param brokerQuery
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "pageQuery", method = RequestMethod.POST)
    public RestResponse pageQueryByCondition(@RequestBody BrokerQuery brokerQuery) {
        log.info("---->经纪人分页条件查询---->brokerQuery={}", brokerQuery);
        try {
            Page<EstateBroker> estateBrokerPage = estateBrokerSV.pageQueryByCondition(brokerQuery);
            return success(estateBrokerPage);
        } catch (Exception e) {
            log.info("---->分页查询异常---->", e);
            return error("查询失败");
        }
    }

    /**
     * 查询首页二手房，商铺 ，租房
     * pc 5 app 3
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "homePage", method = RequestMethod.GET)
    public RestResponse homePage(HttpServletRequest request) {
        log.info("---->查询首页数据---->");
        return houseResourceService.homePage(request);
    }

    /**
     * 根据父级ID查询全部配置
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "configuration/{parentNo}", method = RequestMethod.GET)
    public RestResponse queryConfiguration(@PathVariable("parentNo")Long parentNo) {
        log.info("---->查询全部配置---->");
        List<DataConfiguration> dataConfiguration = dataConfigurationSV.findAll(parentNo);
        return success(dataConfiguration);
    }


    @IgnoreAuth
    @RequestMapping(value = "conf/{parentNo}", method = RequestMethod.GET)
    public RestResponse queryConf(HttpServletRequest request,@PathVariable("parentNo")Long parentNo) {
        log.info("---->查询全部配置包含内存中的---->");
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("----查询全部配置包含内存中的："+header);
        log.info("----parentNo："+parentNo);
        List<DataConfigurationInfo> result;
        if (header != null && "wy".equals(header)){
            result = dataConfigurationSV.getByExampleInfoWy(parentNo);
        }else {
            result = dataConfigurationSV.getByExampleInfo(parentNo);
        }
        return success(result);
    }


    /**
     * 下架房源
     * @param signLabel
     * @return
     */
    @RequestMapping(value = "deleteHouse", method = RequestMethod.POST)
    public RestResponse deleteHouse(@RequestParam("signLabel") String signLabel) {
        log.info("----修改房源为下架状态----signLabel={}", signLabel);
        return houseResourceService.deleteHouse(signLabel);
    }



}
