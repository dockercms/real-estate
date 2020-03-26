package com.ztuo.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztuo.modules.sys.dao.SysUserRoleDao;
import com.ztuo.modules.sys.entity.SysUserRoleEntity;
import com.ztuo.modules.sys.service.SysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gs
 */
@Service("sysUserRoleService")
@Slf4j
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public void saveOrUpdate(String userId, List<String> roleIdList) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("user_id", userId);
        //先删除用户与角色关系
        this.removeByMap(map);

        if (roleIdList == null || roleIdList.size() == 0) {
            return;
        }

        //保存用户与角色关系
        List<SysUserRoleEntity> list = new ArrayList<>(roleIdList.size());
        for (String roleId : roleIdList) {
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setUserId(userId);
            sysUserRoleEntity.setRoleId(roleId);

            list.add(sysUserRoleEntity);
        }
        log.info("----保存用户与角色关系--");
        this.saveBatch(list);
    }

    @Override
    public List<String> queryRoleIdList(String userId) {
        return baseMapper.queryRoleIdList(userId);
    }

    @Override
    public int deleteBatch(String[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}
