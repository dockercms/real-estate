package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.TbAppVersion;
import com.ztuo.modules.house.entity.TbAppVersionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbAppVersionDAO {

	List<TbAppVersion> getByExample(TbAppVersionExample example);
	
	TbAppVersion getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(TbAppVersionExample example);
	
	int save(TbAppVersion record);
	
	int saveSelective(TbAppVersion record);
	
	int countByExample(TbAppVersionExample example);
	
	int updateByExampleSelective(@Param("record") TbAppVersion record, @Param("example") TbAppVersionExample example);
	
	int updateByExample(@Param("record") TbAppVersion record, @Param("example") TbAppVersionExample example);
	
	int updateByPrimaryKeySelective(TbAppVersion record);
	
	int updateByPrimaryKey(TbAppVersion record);


    List<TbAppVersion> getPageByExample(Page page, @Param("example") TbAppVersionExample example);
}
