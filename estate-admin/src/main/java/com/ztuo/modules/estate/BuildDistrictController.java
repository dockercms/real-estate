package com.ztuo.modules.estate;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.annotation.SysLog;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.BuildDistrict;
import com.ztuo.modules.house.service.IBuildDistrictSV;
import com.ztuo.modules.house.vo.BuildDistrictVO;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/2 6:09 下午
 */
@Slf4j
@RestController
@RequestMapping("build")
public class BuildDistrictController extends AbstractController {

    @Autowired
    private IBuildDistrictSV buildDistrictSV;

    /**
     * 分页查询
     * @param districtVO
     * @return
     * @throws Exception
     */
    @SysLog("分页查询小区信息")
    @RequiresPermissions("build:page")
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public RestResponse queryPage(@RequestBody BuildDistrictVO districtVO) throws Exception{
        log.info("-----小区管理分页查询---"+districtVO.toString());
        Map<String, Object> params = new HashMap<>();
        params.put("dataScope", getDataScope());
        Page<BuildDistrict> result = buildDistrictSV.pageQuery(districtVO,params);
        return RestResponse.success(result);
    }


    /**
     * 新增
     * @param district
     * @return
     * @throws Exception
     */
    @SysLog("新增小区信息")
    @RequiresPermissions("build:add")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public RestResponse save(@Valid @RequestBody BuildDistrict district) throws Exception{
        log.info("-----小区管理新增---"+district.toString());
        district.setCreateTime(new Date());
        district.setBuildStatus("0");
        district.setAreaCode(district.getParentNo());
        int save = buildDistrictSV.save(district);
        if (save == 1){
            return RestResponse.success("保存成功");
        }else {
            return RestResponse.error("保存失败,请稍后再试");
        }
    }

    /**
     * 修改
     * @param district
     * @return
     * @throws Exception
     */
    @SysLog("修改小区信息")
    @RequiresPermissions("build:update")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RestResponse update(@Valid @RequestBody BuildDistrict district) throws Exception{
        log.info("-----小区管理修改---"+district.toString());
        if (district.getId() == null){
            return RestResponse.error("请选择要修改的记录");
        }
        district.setUpdateTime(new Date());
        int save = buildDistrictSV.updateByPrimaryKeySelective(district);
        if (save == 1){
            return RestResponse.success("修改成功");
        }else {
            return RestResponse.error("修改失败,请稍后再试");
        }
    }

    /**
     * 删除
     * @param districtVO
     * @return
     * @throws Exception
     */
    @SysLog("删除小区信息")
    @RequiresPermissions("build:del")
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public RestResponse del(@RequestBody BuildDistrictVO districtVO ) throws Exception{
        BuildDistrict district = buildDistrictSV.getByPrimaryKey(districtVO.getId());
        if (district == null){
            return RestResponse.error("记录不存在");
        }
        district.setBuildStatus("1");
        district.setUpdateTime(new Date());
        int result = buildDistrictSV.updateByPrimaryKeySelective(district);
        if (result == 1){
            return RestResponse.success("删除成功");
        }else {
            return RestResponse.error("删除失败");
        }
    }



}
