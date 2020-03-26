package com.ztuo.modules.house.dao;

import com.ztuo.modules.house.entity.DataConfiguration;
import com.ztuo.modules.house.entity.DataConfigurationExample;
import com.ztuo.modules.house.entity.DataConfigurationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DataConfigurationDAO {

	List<DataConfiguration> getByExample(DataConfigurationExample example);
	
	DataConfiguration getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(DataConfigurationExample example);
	
	int save(DataConfiguration record);
	
	int saveSelective(DataConfiguration record);
	
	int countByExample(DataConfigurationExample example);
	
	int updateByExampleSelective(@Param("record") DataConfiguration record, @Param("example") DataConfigurationExample example);
	
	int updateByExample(@Param("record") DataConfiguration record, @Param("example") DataConfigurationExample example);
	
	int updateByPrimaryKeySelective(DataConfiguration record);
	
	int updateByPrimaryKey(DataConfiguration record);

	List<DataConfiguration> findAll();

	List<DataConfigurationInfo> getByExampleInfo(DataConfigurationExample example);

	List<DataConfigurationInfo> getByExampleInfoWy(DataConfigurationExample example);

}
