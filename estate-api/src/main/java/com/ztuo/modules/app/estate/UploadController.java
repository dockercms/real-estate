package com.ztuo.modules.app.estate;

import com.ztuo.common.exception.BusinessException;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.app.oss.UploadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/2/25 1:06 下午
 */
@Slf4j
@RestController
@RequestMapping("upload")
public class UploadController  {


    /**
     * 上传文件
     *
     * @param file file
     * @return RestResponse
     */
    @IgnoreAuth
    @RequestMapping(value = "file",method = RequestMethod.POST)
    public RestResponse upload(@RequestParam(value = "file") MultipartFile file) throws Exception {

        if (null == file || file.isEmpty()) {
            throw new BusinessException("上传文件不能为空");
        }

        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = UploadFactory.build().uploadSuffix(file.getBytes(), suffix);

        return RestResponse.success().putData(url);
    }


    /**
     * 上传多个图片
     * @param files
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "files",method = RequestMethod.POST)
    public RestResponse uploadFiles(@RequestParam(value = "file")MultipartFile[] files) throws IOException {
        if (files != null && files.length > 0) {
            StringBuilder result = new StringBuilder();
            String picUrl;
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                picUrl = UploadFactory.build().uploadSuffix(file.getBytes(), suffix);
                result.append(picUrl);
                result.append(",");
            }
            String res = result.toString();
            String allUrl = res.substring(0,res.length()-1);
            log.info("-----返回URL: "+allUrl);
            return RestResponse.success().putData(allUrl);
        }else {
            return RestResponse.error("上传失败");
        }

    }

}
