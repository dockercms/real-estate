package com.ztuo.modules.app.controller.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.entity.Advertising;
import com.ztuo.modules.house.service.IAdvertisingSV;
import com.ztuo.modules.house.vo.AdvertisingQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description: AdvertisingController
 * @author: MrGao
 * @create: 2020/03/04 10:40
 */
@Slf4j
@RestController
@RequestMapping("advertising")
public class AdvertisingController {

    @Autowired
    private IAdvertisingSV advertisingSV ;

    /**
     * 分页查询不同位置广告
     * @param queryVO
     * @return
     * @throws Exception
     */
    @IgnoreAuth
    @RequestMapping(value = "page_query",method = RequestMethod.POST)
    public RestResponse pageQueryAdvertising(@RequestBody AdvertisingQueryVO queryVO)throws Exception{
        log.info("分页查询广告={}",queryVO);
        queryVO.setEffectTime(new Date());
        Page<Advertising> page = advertisingSV.pageQuery(queryVO);
        return RestResponse.success(page);
    }

}
