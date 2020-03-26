package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.entity.EstateUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EstateUserDAO {

	List<EstateUser> getByExample(EstateUserExample example);
	
	EstateUser getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(EstateUserExample example);
	
	int save(EstateUser record);
	
	int saveSelective(EstateUser record);
	
	int countByExample(EstateUserExample example);
	
	int updateByExampleSelective(@Param("record") EstateUser record, @Param("example") EstateUserExample example);
	
	int updateByExample(@Param("record") EstateUser record, @Param("example") EstateUserExample example);
	
	int updateByPrimaryKeySelective(EstateUser record);
	
	int updateByPrimaryKey(EstateUser record);

	/**
	 * 根据手机号获取用户
	 * @param mobilePhone
	 * @return
	 */
	EstateUser getUserByPhone(@Param("mobilePhone") String mobilePhone);

	EstateUser findByOpenId(@Param("openId") String openId);

    List<EstateUser> pageQueryByExample(Page page, @Param("example")EstateUserExample example);
}
