package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.UserHouse;
import com.ztuo.modules.house.entity.UserHouseExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserHouseDAO {

	List<UserHouse> getByExample(UserHouseExample example);
	
	UserHouse getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(UserHouseExample example);
	
	int save(UserHouse record);
	
	int saveSelective(UserHouse record);
	
	int countByExample(UserHouseExample example);
	
	int updateByExampleSelective(@Param("record") UserHouse record, @Param("example") UserHouseExample example);
	
	int updateByExample(@Param("record") UserHouse record, @Param("example") UserHouseExample example);
	
	int updateByPrimaryKeySelective(UserHouse record);
	
	int updateByPrimaryKey(UserHouse record);

    List<UserHouse> pageQueryByExample(Page page, @Param("example")  UserHouseExample example,@Param("params") Map<String, Object> params);

	/**
	 * 获取未审核记录数量
	 * @return
	 */
	Integer getUncheckedCount();
}
