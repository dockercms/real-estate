package com.ztuo.modules.estate;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.annotation.SysLog;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.TbAppVersion;
import com.ztuo.modules.house.service.ITbAppVersionSV;
import com.ztuo.modules.house.vo.BaseQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @description: TbAppVersionController
 * @author: MrGao
 * @create: 2019/07/13 10:44
 */
@Slf4j
@RestController
@RequestMapping("system")
public class TbAppVersionController {


    @Autowired
    private ITbAppVersionSV appVersionSV ;
    /**
     * 分页查询所有版本更新
     * @param queryVO
     * @return
     */
    @SysLog("分页查询所有版本更新")
    @RequiresPermissions("system:app_version:page_query")
    @RequestMapping(value = "app_version/page_query",method = RequestMethod.POST)
    public RestResponse pageQueryAppVersion(@RequestBody BaseQueryVo queryVO){
        log.info("分页查询所有版本更新={}",queryVO);
        Page<TbAppVersion> pageInfo = appVersionSV.pageQueryByVO(queryVO,null);
        return RestResponse.success().putData(pageInfo);
    }


    /**
     * 新增版本信息
     * @param appVersion
     * @return
     */
    @SysLog("新增版本信息")
    @RequiresPermissions("system:app_version:save")
    @RequestMapping(value = "app_version/save",method = RequestMethod.POST)
    public RestResponse saveAppVersion(@RequestBody TbAppVersion appVersion)throws Exception{
        log.info("分页查询所有版本更新={}",appVersion);
        List<TbAppVersion> data = appVersionSV.findAppVersionByVersionAndCate(appVersion.getAppVersion(),appVersion.getAppCate());
        if(data!=null && data.size()>0){
            return RestResponse.error("当前版本已存在,请修改版本号");
        }
        appVersion.setCreateTime(new Date());
        appVersionSV.save(appVersion);
        return RestResponse.success();
    }



}
