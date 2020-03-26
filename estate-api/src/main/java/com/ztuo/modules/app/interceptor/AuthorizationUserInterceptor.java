package com.ztuo.modules.app.interceptor;


import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.JwtUtils;
import com.ztuo.common.utils.RedisUtil;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @description: AuthorizationUserInterceptor
 * @author: MrGao
 * @create: 2019/07/10 15:19
 */
@Component
@Slf4j
public class AuthorizationUserInterceptor implements HandlerInterceptor {


    @Autowired
    private RedisUtil redisUtil ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info(request.getRequestURL().toString());
        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }
        //如果有@IgnoreAuth注解，则不验证token
        if (annotation != null) {
            return true;
        }
        //获取用户凭证
        String token = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String identity = request.getHeader(Constant.IDENTAITY_HERADER);
        log.info("token:{},userId={},object={}", token,userId,userId);
        //凭证为空
        if(StringUtils.isBlank(token)){
            ajaxReturn(response, 4000, "当前登录状态过期，请您重新登录！");
            return false;
        }
        Object object = redisUtil.get(identity+userId);
        log.info("object:{},", object);
        //token 过期失效
        if(object ==null){
            ajaxReturn(response, 4000, "当前登录状态过期，请您重新登录！");
            return false;
        }
        String redisToken = object.toString();
        if(!token.equalsIgnoreCase(redisToken)){
            //信息不一致 失效
            ajaxReturn(response, 4000, "当前登录信息有误，请您重新登录！");
            return false;
        }
        //信息一致 刷新token
        redisUtil.set(identity+userId,token,Constant.ACCESS_TOKEN_TIME_OUT,TimeUnit.SECONDS);
        return true;

    }

    public void ajaxReturn(HttpServletResponse response, int code, String msg) throws IOException, JSONException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        out.print(json.toString());
        out.flush();
        out.close();
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
