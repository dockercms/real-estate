package com.ztuo.modules.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.service.BrokerService;
import com.ztuo.modules.house.service.HouseResourceService;
import com.ztuo.modules.house.vo.BrokerQuery;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dupinyan
 * @Description: 经纪人管理
 * @Date: 2020/2/18 19:23
 * @Version: 1.0
 */
@RestController
@RequestMapping("broker")
@Slf4j
public class BrokerController extends AbstractController {

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private HouseResourceService houseResourceService;

    /**
     * 分页条件查询经纪人信息
     * @param brokerQuery
     * @return
     */
    @RequestMapping(value = "pageQuery", method = RequestMethod.POST)
    public RestResponse queryBroker(@RequestBody BrokerQuery brokerQuery) {
        log.info("---->分页条件查询经纪人信息---->brokerQuery={}", brokerQuery);
        Page<EstateBroker> page = null;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("dataScope", getDataScope());
            page = brokerService.criteriaQuery(brokerQuery,params);
        } catch (Exception e) {
            log.info("---->分页条件查询经纪人信息失败---->", e);
            return RestResponse.error("查询失败");
        }
        return RestResponse.success(page);
    }


    /**
     * 审核经纪人
     * @param brokerQuery
     * @return
     */
    @RequestMapping(value = "audit", method = RequestMethod.POST)
    public RestResponse auditBroker(@RequestBody BrokerQuery brokerQuery) {
        log.info("---->审核经纪人信息---->brokerQuery={}", brokerQuery);
        return brokerService.auditBroker(brokerQuery);
    }


    /**
     * 获取首页未审核数量
     * @return
     */
    @RequestMapping(value = "getCount", method = RequestMethod.GET)
    public RestResponse getCount() {
        log.info("---->获取首页未审核数量---->");
        return houseResourceService.getCount();
    }


    /**
     * 后台管理添加新增经纪人
     * @param broker
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestResponse addBroker(@Valid @RequestBody EstateBroker broker) {
        log.info("---->后台管理新增经纪人---->broker={}", broker);
        try {
            return brokerService.add(broker);
        } catch (Exception e) {
            log.info("----->后台添加经纪人异常---->", e);
            return RestResponse.error("添加失败");
        }
    }


    /**
     * 删除经纪人
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public RestResponse deleteBroker(@PathVariable("id") Long id) {
        log.info("---->删除经纪人并下架房源----->id={}", id);
        return brokerService.delete(id);
    }



}
