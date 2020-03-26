package com.ztuo.modules.estate;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.sys.entity.SysOrgVO;
import com.ztuo.modules.sys.service.SysOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     * 获取所有区域
     * @return
     */
    @RequestMapping(value = "info/all",method = RequestMethod.POST)
    public RestResponse getArea(){
        Integer level = 2;
        List<SysOrgVO> result = orgService.getArea("01",level);
        String parentNo;
        for (int i = 0; i < result.size(); i++) {
            parentNo = result.get(i).getOrgNo();
            List<SysOrgVO> item = orgService.getArea(parentNo,3);
            result.get(i).setOrgEntityList(item);
        }
        return RestResponse.success(result);
    }


}
