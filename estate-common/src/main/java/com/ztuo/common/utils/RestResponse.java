/*
 * 项目名称:my-museum
 * 类名称:R.java
 * 包名称:com.platform.common.utils
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.common.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author gs
 */
public class RestResponse extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public RestResponse() {
        put("code", 0);
        put("msg", "成功");
    }

    public static RestResponse error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static RestResponse error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static RestResponse error(int code, String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.put("code", code);
        restResponse.put("msg", msg);
        return restResponse;
    }

    public static RestResponse success(String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.put("msg", msg);
        return restResponse;
    }

    public static RestResponse success(Map<String, Object> map) {
        RestResponse restResponse = new RestResponse();
        restResponse.putAll(map);
        return restResponse;
    }

    public static RestResponse success() {
        return new RestResponse();
    }

    @Override
    public RestResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public RestResponse putData(Object value) {
        super.put("data", value);
        return this;
    }

    public static RestResponse success(Object value) {
        RestResponse response = new RestResponse();
        response.put("code", 0);
        response.put("msg", "SUCCESS");
        response.putData(value);
        return response;
    }
}
