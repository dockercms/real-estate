package com.ztuo.modules.house.service;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.vo.HouseKindQueryVO;
import com.ztuo.modules.house.vo.UploadHouse;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/2/22 16:06
 * @Version: 1.0
 */
public interface HouseResourceService {

    /**
     * 房源条件查询
     * @param queryVO
     * @return
     */
    RestResponse pageQuery(HttpServletRequest request, HouseKindQueryVO queryVO);

    /**
     * 获取我的店铺
     * @param request
     * @param queryVO
     * @return
     */
    RestResponse getMyShop(HttpServletRequest request, HouseKindQueryVO queryVO);

    /**
     * 获取单个房源
     * @param request
     * @param id    当前记录id
     * @param estateType  0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位 9-新房 10-二手房 11-租房
     * @param useWay 用途 0-出租 1-出售 2-转让
     * @return
     */
    RestResponse getOneHouse(HttpServletRequest request, Long id, Integer estateType, Integer useWay);

    /**
     * pc端查询
     * @param request
     * @param queryVO
     * @return
     */
    RestResponse pageQueryPc(HttpServletRequest request, HouseKindQueryVO queryVO);


    /**
     * 删除房源 修改为下架状态
     * @param signLabel
     * @return
     */
    RestResponse deleteHouse(String signLabel);

    /**
     * 首页查询 pc显示5条 app3条
     * @return
     */
    RestResponse homePage(HttpServletRequest request);

    /**
     * 计算审核未通过数量
     * @return
     */
    RestResponse getCount();

    /**
     * 分页条件查询 根据请求头
     * @param request
     * @param queryVO
     * @return
     */
    RestResponse pageQueryByLanguage(HttpServletRequest request, HouseKindQueryVO queryVO);

    /**
     * 上传房源
     * @param house
     * @return
     */
    RestResponse uploadHouse(UploadHouse house);
}
