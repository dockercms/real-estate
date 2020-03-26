package com.ztuo.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Author: dupinyan
 * @Description: 手机号校验工具类
 * @Date: 2020/2/11 19:17
 * @Version: 1.0
 */
public class ValidateUtil {


    /**
     * 验证手机号格式是否正确
     * @param phone
     * @return
     */
    public static boolean isMobilePhone(String phone){
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        if (isChinaPhoneLegal(phone)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+任意数
     * 17+任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
//		String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$";
        String regExp = "^((13[0-9])|(15[^4])|(14[0-9])|(16[0-9])|(19[0-9])|(18[0-9])|(17[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
