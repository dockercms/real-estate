package com.ztuo.modules.app.controller.house;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.service.HouseResourceService;
import com.ztuo.modules.house.vo.HouseDetailVO;
import com.ztuo.modules.house.vo.HouseKindQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dupinyan
 * @Description: 房源分类查询
 * @Date: 2020/2/22 16:05
 * @Version: 1.0
 */
@RestController
@RequestMapping("resource")
@Slf4j
public class HouseResourceController extends RestResponse {

    @Autowired
    private HouseResourceService houseResourceService;


    /**
     * 房源分页条件分类查询 移动端
     *
     * @param queryVO
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "pageQuery", method = RequestMethod.POST)
    public RestResponse pageQueryByCondition(HttpServletRequest request, @RequestBody HouseKindQueryVO queryVO) {
        log.info("---->房源分类查询---->queryVO={}", queryVO);
        return houseResourceService.pageQuery(request, queryVO);
    }


    /**
     * 房源分页条件查询
     * @param request
     * @param queryVO
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "pageQuery/language", method = RequestMethod.POST)
    public RestResponse pageQueryByLanguage(HttpServletRequest request, @RequestBody HouseKindQueryVO queryVO) {
        log.info("---->房源分类分页条件查询---->queryVO={}", queryVO);
        return houseResourceService.pageQueryByLanguage(request, queryVO);
    }


    /**
     * pc房源分页条件查询
     * @param request
     * @param queryVO
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "pc/pageQuery", method = RequestMethod.POST)
    public RestResponse pageQueryByConditionPc(HttpServletRequest request, @RequestBody HouseKindQueryVO queryVO) {
        log.info("---->pc房源分页条件查询---->queryVO={}", queryVO);
        return houseResourceService.pageQueryPc(request, queryVO);
    }


    /**
     * 获取单个房源详细信息
     * @param request
     *  0-新房 1-二手房 2-租房 3-别墅 4-商铺 5-写字楼 6-酒店 7-厂房 8-仓库 9-土地转让 10-车位
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "getHouse", method = RequestMethod.POST)
    public RestResponse getHouse(HttpServletRequest request, @RequestBody HouseDetailVO detailVO) {
        log.info("---->获取单个---->detailVO={}", detailVO);
        return houseResourceService.getOneHouse(request, detailVO.getId(), detailVO.getEstateType(), detailVO.getUseWay());
    }

    /**
     * 经纪人端查询店铺
     * @param request
     * @param queryVO
     * @return
     */
    @RequestMapping(value = "myShop", method = RequestMethod.POST)
    public RestResponse getMyShop(HttpServletRequest request, @RequestBody HouseKindQueryVO queryVO) {
        log.info("----->查询我的店铺----->queryVO={}", queryVO);
        return houseResourceService.getMyShop(request, queryVO);
    }

}
