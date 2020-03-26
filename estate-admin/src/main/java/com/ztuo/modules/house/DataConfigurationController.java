package com.ztuo.modules.house;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.DataConfiguration;
import com.ztuo.modules.house.service.IDataConfigurationSV;
import com.ztuo.modules.house.vo.DataConfigurationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/3 3:17 下午
 */
@Slf4j
@RestController
@RequestMapping("data/con")
public class DataConfigurationController {

    @Autowired
    private IDataConfigurationSV dataConfigurationSV;

    /**
     * 根据父级Id查询配置项
     * @param configurationVO
     * @return
     */
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public RestResponse queryConfiguration(@RequestBody DataConfigurationVO configurationVO) {
        log.info("---->查询全部配置---->");
        List<DataConfiguration> dataConfiguration = dataConfigurationSV.findAll(configurationVO.getParentId());
        return RestResponse.success(dataConfiguration);
    }
}
