package com.ztuo.modules.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.BrokerGuest;
import com.ztuo.modules.house.service.IBrokerGuestSV;
import com.ztuo.modules.house.vo.BrokerGuestVo;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: BrokerGuestController
 * @author: MrGao
 * @create: 2020/02/15 13:16
 */
@Slf4j
@RestController
@RequestMapping("guest")
public class BrokerGuestController extends AbstractController {


    @Autowired
    private IBrokerGuestSV brokerGuestSV ;

    @RequiresPermissions("guest:page:query")
    @RequestMapping(value = "page_query",method = RequestMethod.POST)
    public RestResponse pageQueryBrokerGuest(@RequestBody BrokerGuestVo guestVo) throws Exception{
        log.info("分页查询我的客源guestVo={}",guestVo);
        Map<String, Object> params = new HashMap<>();
        params.put("dataScope", getDataScope());
        Page<BrokerGuest> page = brokerGuestSV.pageQuery(guestVo,params);
        return RestResponse.success(page);
    }
    @RequiresPermissions("guest:broker:delete")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public RestResponse deleteBrokerGuest(@PathVariable("id")Long id)throws Exception{
        log.info("删除信息={}",id);
        brokerGuestSV.deleteByPrimaryKey(id);
        return RestResponse.success("删除成功");
    }
}
