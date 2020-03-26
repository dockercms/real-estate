/*
 * 项目名称:my-museum
 * 类名称:SysLogAspect.java
 * 包名称:com.platform.common.aspect
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.common.aspect;

import com.google.gson.Gson;
import com.ztuo.common.annotation.SysLog;
import com.ztuo.common.utils.HttpContextUtils;
import com.ztuo.common.utils.IpUtils;
import com.ztuo.modules.sys.entity.SysLogEntity;
import com.ztuo.modules.sys.entity.SysUserEntity;
import com.ztuo.modules.sys.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志，切面处理类
 *
 * @author gs
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.ztuo.common.annotation.SysLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogEntity sysLog = new SysLogEntity();
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            //注解上的描述
            sysLog.setOperation(syslog.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params ;
            if(methodName.equalsIgnoreCase("addUserProfessor")){
                params="文件上传";
            }else {
                params = new Gson().toJson(args);
            }
            sysLog.setParams(params);

            //获取request
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            //设置IP地址
            sysLog.setIp(IpUtils.getIpAddress(request));

            //用户名
            String userName = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUserName();
            if (StringUtils.isEmpty(userName)){
                log.info("获取用户名为空");
                return;
            }
            sysLog.setUserName(userName);

            sysLog.setTime(time);
            sysLog.setCreateTime(new Date());
            //保存系统日志
            sysLogService.save(sysLog);
        } catch (Exception ignored) {
            log.info("异常信息={}",ignored);
        }
    }
}
