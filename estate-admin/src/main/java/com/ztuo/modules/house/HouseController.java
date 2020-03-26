package com.ztuo.modules.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.entity.UserHouse;
import com.ztuo.modules.house.entity.UygurUserHouse;
import com.ztuo.modules.house.service.*;
import com.ztuo.modules.house.vo.UserHouseQuery;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: HouseController
 * @author: MrGao
 * @create: 2020/02/15 10:51
 */
@Slf4j
@RestController
@RequestMapping("house")
public class HouseController extends AbstractController {


    @Autowired
    private IUserHouseSV userHouseSV;

    @Autowired
    private IUygurUserHouseSV uygurUserHouseSV ;

    @Autowired
    private IEstateUserSV userSV ;



    /**
     * 分页查询 用户上传房源信息
     * @param houseQuery
     * @return
     */
    @RequiresPermissions("house:page:query")
    @RequestMapping(value = "page_query",method = RequestMethod.POST)
    public RestResponse pageQueryHouse(@RequestBody UserHouseQuery houseQuery)throws Exception{
        log.info("分页查询房源信息={}",houseQuery);
        Page<UserHouse> page = userHouseSV.pageQuery(houseQuery,null);
        return RestResponse.success(page);
    }

    @RequiresPermissions("house:button:review")
    @RequestMapping(value = "review",method = RequestMethod.POST)
    public RestResponse reviewUserHouse(@RequestBody UserHouseQuery houseQuery)throws Exception{
        log.info("审核房源信息={}",houseQuery);
        UserHouse userHouse = userHouseSV.getByPrimaryKey(houseQuery.getHouseId());
        if(userHouse ==null){
            return RestResponse.error("记录不存在");
        }
        if(!"0".equalsIgnoreCase(userHouse.getStatus())){
            return RestResponse.error("该条记录已审核,请刷新");
        }
        String status = houseQuery.getStatus();
        if("1".equalsIgnoreCase(status)){
            userHouse.setStatus("1");
        }else {
            userHouse.setStatus("2");
        }
        String loadType = userHouse.getLoadType();
        List<String> loadTypes = new ArrayList<>();
        loadTypes.add("1");
        loadTypes.add("3");
        if(loadTypes.contains(loadType)){
            log.info("用户卖房或者出租 添加用户房子数量={}",loadType);
            EstateUser estateUser = userSV.getByPrimaryKey(Long.parseLong(userHouse.getUserId()));
            Integer houseResourseNum = estateUser.getHouseResourseNum();
            if(houseResourseNum == null){
                estateUser.setHouseResourseNum(1);
            }else {
                estateUser.setHouseResourseNum(houseResourseNum+1);
            }
            userSV.updateByPrimaryKeySelective(estateUser);
        }
        userHouseSV.updateByPrimaryKeySelective(userHouse);
        String signLabel = userHouse.getSignLabel();
        UygurUserHouse uygurUserHouse = uygurUserHouseSV.findBySingLabel(signLabel);
        if(uygurUserHouse !=null){
            uygurUserHouse.setStatus(status);
            uygurUserHouseSV.updateByPrimaryKeySelective(uygurUserHouse);
        }
        return RestResponse.success("审核成功");
    }













}
