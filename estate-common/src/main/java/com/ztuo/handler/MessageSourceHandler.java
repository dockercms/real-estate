package com.ztuo.handler;

import com.ztuo.common.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/2/13 6:24 下午
 */
@Component
public class MessageSourceHandler {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String messageKey) {
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        String[] zh = {"zh","CN"};
        String[] wy = {"zh","WY"};
        Locale defaultLocal = new Locale(zh[0],zh[1]);
        Locale WyLocal = new Locale(wy[0],wy[1]);
        String message;
        if (header != null && "wy".equals(header)){
            message = messageSource.getMessage(messageKey, null, WyLocal);
        }else {
            message = messageSource.getMessage(messageKey, null, defaultLocal);
        }
        return message;
    }
}