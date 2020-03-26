package com.ztuo.modules.app.estate;

import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.common.utils.StringUtils;
import com.ztuo.handler.MessageSourceHandler;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.dto.SysOrgDTO;
import com.ztuo.modules.house.entity.BuildDistrict;
import com.ztuo.modules.house.entity.HouseCountNews;
import com.ztuo.modules.house.service.IBuildDistrictSV;
import com.ztuo.modules.house.service.IHouseCountSV;
import com.ztuo.modules.house.service.IHouseResourceSV;
import com.ztuo.modules.house.service.IUygurHouseResourceSV;
import com.ztuo.modules.house.vo.HouseCountVO;
import com.ztuo.modules.house.vo.HouseLocationVO;
import com.ztuo.modules.sys.entity.SysOrgVO;
import com.ztuo.modules.sys.service.SysOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/2/12 5:01 下午
 */
@Slf4j
@RestController
@RequestMapping("area")
public class AreaController {


    @Autowired
    private SysOrgService orgService;

    @Autowired
    private IBuildDistrictSV buildDistrictSV;

    @Autowired
    private MessageSourceHandler messageSourceHandler;

    @Autowired
    private IHouseCountSV houseCountSV;

    @Autowired
    private IHouseResourceSV houseResourceSV;

    @Autowired
    private IUygurHouseResourceSV uygurHouseResourceSV;
    /**
     * 获取所有区域
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "info",method = RequestMethod.POST)
    public RestResponse getArea(HttpServletRequest request, @RequestParam(value = "parentNo",required = false)String parentNo){
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("----获取地区编码："+header);
        log.info("----parentNo："+parentNo);
        Integer level;
        if (StringUtils.isEmpty(parentNo)){
            parentNo = "01";
            level = 2;
        }else {
            level = 3;
        }
        List<SysOrgVO> result;
        if (header != null && "wy".equals(header)){
            result = orgService.getAreaWy(parentNo,level);
        }else {
            result = orgService.getArea(parentNo,level);
        }
        return RestResponse.success(result);
    }


    /**
     * 获取所有区域
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "info/all",method = RequestMethod.POST)
    public RestResponse getArea(HttpServletRequest request){
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("----获取地区编码："+header);
        Integer level = 2;
        List<SysOrgVO> result;
        if (header != null && "wy".equals(header)){
            result = orgService.getAreaWy("01",level);
        }else {
            result = orgService.getArea("01",level);
        }
        String parentNo;
        for (int i = 0; i < result.size(); i++) {
            List<SysOrgVO> item;
            parentNo = result.get(i).getOrgNo();
            if (header != null && "wy".equals(header)){
                item = orgService.getAreaWy(parentNo,3);
            }else {
                item = orgService.getArea(parentNo,3);
            }
            result.get(i).setOrgEntityList(item);

        }
        return RestResponse.success(result);
    }


    /**
     * 获取区域 中文+维语
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "info/all/message", method = RequestMethod.GET)
    public RestResponse getMessage() {
        Integer level = 2;
        List<SysOrgDTO> result;
        result = orgService.getAreaAll("01", level);
        String parentNo;
        for (int i = 0; i < result.size(); i++) {
            List<SysOrgDTO> item;
            parentNo = result.get(i).getOrgNo();
            item = orgService.getAreaAll(parentNo, 3);
            result.get(i).setOrgEntityList(item);
        }
        return RestResponse.success(result);
    }

    /**
     * 获取所有小区
     * @param request
     * @return
     */
    @RequestMapping(value = "build/info",method = RequestMethod.POST)
    public RestResponse getBuildInfo(HttpServletRequest request, @RequestParam(value = "parentNo")String parentNo) throws Exception{
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("-------获取所有小区:"+parentNo);
        List<BuildDistrict> result;
        if (header != null && "wy".equals(header)){
            result = buildDistrictSV.getBuildInfoWy(parentNo);
        }else {
            result = buildDistrictSV.getBuildInfo(parentNo);
        }
        return RestResponse.success(result);
    }

    /**
     * 地图找房查询某区域下所有房屋数量
     * @param houseCountVO
     * @return
     * @throws Exception
     */
    @IgnoreAuth
    @RequestMapping(value = "map/info",method = RequestMethod.POST)
    public RestResponse getBuildInfo(@Valid @RequestBody HouseCountVO houseCountVO) throws Exception{
        log.info("-------地图找房查询某区域下所有房屋:"+houseCountVO.toString());
        List<HouseCountNews> result = houseCountSV.getAll(houseCountVO);
        return RestResponse.success(result);
    }

    /**
     * 地图找房查询某区域下所有房屋信息
     * @return
     * @throws Exception
     */
    @IgnoreAuth
    @RequestMapping(value = "map/detail",method = RequestMethod.POST)
    public RestResponse getBuildLocation(@Valid @RequestBody HouseCountVO houseCountVO) throws Exception{
        log.info("-------地图找房查询某区域下所有房屋信息:"+houseCountVO.toString());
        List<HouseLocationVO> result =  uygurHouseResourceSV.getMapLocation(houseCountVO);
        return RestResponse.success(result);
    }

}
