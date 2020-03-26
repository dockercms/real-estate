package com.ztuo.modules.app.estate;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.vo.TransferVO;
import com.ztuo.modules.utils.WebOTS;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/19 3:33 下午
 */
@Slf4j
@RestController
@RequestMapping("transfer")
public class TransferController extends RestResponse {

    /**
     * 经纪人端上传房源翻译
     * @param transferVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "info",method = RequestMethod.POST)
    public RestResponse transfer(@RequestBody TransferVO transferVO) throws Exception{
        if (StringUtils.isEmpty(transferVO.getContent())){
            return error("翻译内容不能为空");
        }
        log.info("--------info"+transferVO.getContent());
        String[] str = transferVO.getContent().split("&");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            stringBuilder.append(str[i]).append("\n");
        }
        log.info("---transfer----result:"+stringBuilder.toString());
        String result = WebOTS.transferUy(stringBuilder.toString());
        if (StringUtils.isEmpty(result)){
            return error("翻译失败,请稍后重试");
        }else {
            return success().putData(result);
        }

    }
}
