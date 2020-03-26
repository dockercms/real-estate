/*
 * 项目名称:my-museum
 * 类名称:DataScopeInterceptor.java
 * 包名称:com.platform.datascope
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2019/2/14 09:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.datascope;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.ShiroUtils;
import com.ztuo.common.utils.StringUtils;
import com.ztuo.modules.sys.entity.SysUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * @author gs
 * <p>
 * mybatis 数据权限拦截器
 */
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class DataScopeInterceptor extends SqlExplainInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        this.sqlParser(metaObject);

        // 不是SELECT操作直接返回
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
            return invocation.proceed();
        }

        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        String sql = boundSql.getSql();
        StringBuilder filterSql ;
        StringBuilder endSql ;
        if(sql.contains("ORDER BY")){
            String[] split =  sql.split("ORDER BY");
            filterSql =new StringBuilder(split[0]);
            endSql =new StringBuilder(" ORDER BY "+split[1]);
        }else if (sql.contains("order by")){
            String[] split =  sql.split("order by");
            filterSql =new StringBuilder(split[0]);
            endSql =new StringBuilder(" order by "+split[1]);
        } else {
            filterSql = new StringBuilder(sql);
            endSql = new StringBuilder();
        }
        Object parameterObject = boundSql.getParameterObject();

        //参数中DataScope类型的参数
        DataScope dataScope = findDataScopeObject(parameterObject);

        if (dataScope == null) {
            return invocation.proceed();
        } else {
            SysUserEntity user = ShiroUtils.getUserEntity();
            if (null != user) {
                //如果不是超级管理员，则只能查询本机构及子机构数据
                if (!Constant.SUPER_ADMIN.equals(user.getUserId())) {
                    String userAlias = dataScope.getUserAlias();
                    String orgAlias = dataScope.getOrgAlias();
                    String alias = dataScope.getOrgNos();
                    boolean self = dataScope.getSelf();
                    String filterSqlT = filterSql.toString();

                    if (StringUtils.isNotBlank(alias)) {
                        if (filterSqlT.contains("where") || filterSqlT.contains("WHERE")){
                            filterSql.append(" and 1=1 and (").append(orgAlias).append(" in (").append(alias).append(")");
                        }else {
                            filterSql.append(" where (").append(orgAlias).append(" in (").append(alias).append(")");
                        }
                        if (self) {
                            filterSql.append(" or ").append(userAlias).append("='").append(user.getUserId()).append("' ");
                        }
                        filterSql.append(" ) ");
                    } else if (self) {
                        filterSql.append(" and ").append(userAlias).append("='").append(user.getUserId()).append("' ");
                    }
                }
                filterSql.append(endSql);
                metaObject.setValue("delegate.boundSql.sql", filterSql.toString());
            }
            return invocation.proceed();
        }
    }



    /**
     * 生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * mybatis配置的属性
     *
     * @param properties mybatis配置的属性
     */
    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 查找参数是否包括DataScope对象
     *
     * @param parameterObj 参数列表
     * @return DataScope
     */
    private DataScope findDataScopeObject(Object parameterObj) {
        if (parameterObj instanceof DataScope) {
            return (DataScope) parameterObj;
        } else if (parameterObj instanceof Map) {
            for (Object val : ((Map<?, ?>) parameterObj).values()) {
                if (val instanceof DataScope) {
                    return (DataScope) val;
                } else {
                    if (val instanceof Map) {
                        for (Object v : ((Map<?, ?>) val).values()) {
                            if (v instanceof DataScope) {
                                return (DataScope) v;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
