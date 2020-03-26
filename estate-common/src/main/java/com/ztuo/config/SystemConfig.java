package com.ztuo.config;

import com.ztuo.common.utils.IdWorkByTwitter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuoShuai
 * @date 2017年12月22日
 */
@Configuration
public class SystemConfig {

    @Bean
    public IdWorkByTwitter idWorkByTwitter(@Value("${bdtop.system.work-id:0}")long workId, @Value("${bdtop.system.data-center-id:0}")long dataCenterId){
        return new IdWorkByTwitter(workId, dataCenterId);
    }


}
