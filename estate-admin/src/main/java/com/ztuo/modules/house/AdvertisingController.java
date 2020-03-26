package com.ztuo.modules.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.Advertising;
import com.ztuo.modules.house.service.IAdvertisingSV;
import com.ztuo.modules.house.vo.AdvertisingQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: AdvertisingController
 * @author: MrGao
 * @create: 2020/03/03 19:00
 */
@Slf4j
@RestController
@RequestMapping("advertising")
public class AdvertisingController {

    @Autowired
    private IAdvertisingSV advertisingSV ;

    /**
     * 分页查询我的广告
     * @param queryVO
     * @return
     * @throws Exception
     */
    @RequiresPermissions("web:advertising:page")
    @RequestMapping(value = "page_query",method = RequestMethod.POST)
    public RestResponse pageQueryAdvertising(@RequestBody AdvertisingQueryVO queryVO)throws Exception{
        log.info("分页查询当前广告={}",queryVO);
        Page<Advertising> page = advertisingSV.pageQuery(queryVO);
        List<Advertising> records = page.getRecords();
        for (Advertising advertising :records){
            String location = advertising.getLocation();
            String locationString = locationMap.get(location);
            advertising.setLocation(locationString);
        }
        return RestResponse.success(page);
    }

    /**
     * 保存广告信息
     * @param advertising
     * @return
     * @throws Exception
     */
    @RequiresPermissions("web:advertising:save")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public RestResponse saveAdvertising(@RequestBody Advertising advertising)throws Exception{
        log.info("保存广告信息={}",advertising);
        advertising.setCreateTime(new Date());
        advertisingSV.save(advertising);
        return RestResponse.success("新增成功");
    }

    /**
     * 更新
     * @param advertising
     * @return
     * @throws Exception
     */
    @RequiresPermissions("web:advertising:update")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RestResponse updateAdvertising(@RequestBody Advertising advertising)throws Exception{
        Advertising byPrimaryKey = advertisingSV.getByPrimaryKey(advertising.getId());
        if(byPrimaryKey==null){
            return RestResponse.error("信息不存在");
        }
        log.info("修改广告信息={}",advertising);
        advertising.setCreateTime(new Date());
        advertisingSV.updateByPrimaryKeySelective(advertising);
        return RestResponse.success("修改成功");
    }

    /**
     * 删除
     * @param advertising
     * @return
     * @throws Exception
     */
    @RequiresPermissions("web:advertising:delete")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public RestResponse deleteAdvertising(@RequestBody Advertising advertising)throws Exception{
        Advertising byPrimaryKey = advertisingSV.getByPrimaryKey(advertising.getId());
        if(byPrimaryKey==null){
            return RestResponse.error("信息不存在");
        }
        advertisingSV.deleteByPrimaryKey(advertising.getId());
        return RestResponse.success("删除成功");
    }


    private Map<String,String> locationMap ;

    {
        locationMap = new HashMap<>();
        //app首页、app二手房页面、app新房、app租房、app别墅、app商铺、app写字楼、app酒店、app厂房、app仓库、app土地、app车位
        locationMap.put("0","app首页");locationMap.put("1","app二手房页面");locationMap.put("2","app新房");
        locationMap.put("3","app租房");locationMap.put("4","app别墅");locationMap.put("5","app商铺");
        locationMap.put("6","app写字楼");locationMap.put("7","app酒店");locationMap.put("8","app厂房");
        locationMap.put("9","app仓库");locationMap.put("10","app土地");locationMap.put("11","app车位");
        locationMap.put("12","web首页");locationMap.put("13","web二手房页面");locationMap.put("14","web新房");
        locationMap.put("15","web租房");locationMap.put("16","web别墅");locationMap.put("17","web商铺");
        locationMap.put("18","web写字楼");locationMap.put("19","web酒店");locationMap.put("20","web厂房");
        locationMap.put("21","web仓库");locationMap.put("22","web土地");locationMap.put("23","web车位");
    }

    @RequestMapping(value = "location",method = RequestMethod.GET)
    public RestResponse findAllLocation(){
        return RestResponse.success(locationMap);
    }





}
