/*
 * 项目名称:my-museum
 * 类名称:DataSource.java
 * 包名称:com.platform.datasources.annotation
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author gs
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
