package com.ztuo.modules.house;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.service.IFeedbackSV;
import com.ztuo.modules.house.vo.FeedBackQueryVO;
import com.ztuo.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dupinyan
 * @Description: 意见反馈
 * @Date: 2020/3/16 19:21
 * @Version: 1.0
 */
@RestController
@RequestMapping("feedBack")
@Slf4j
public class FeedBackController extends AbstractController {

    @Autowired
    private IFeedbackSV iFeedbackSV;


    @RequestMapping(value = "pageQuery", method = RequestMethod.POST)
    public RestResponse pageQuery(@RequestBody FeedBackQueryVO feedBackQueryVO) {
        log.info("---->分页查询---->feedBackQueryVO={}", feedBackQueryVO);
        try {
            return iFeedbackSV.pageQuery(feedBackQueryVO);
        } catch (Exception e) {
            log.info("----->分页查询---->", e);
            return RestResponse.error("查询失败");
        }
    }

}
