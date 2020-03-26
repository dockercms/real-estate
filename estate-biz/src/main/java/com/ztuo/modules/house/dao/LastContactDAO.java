package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.LastContactExample;
import com.ztuo.modules.house.entity.LastContact;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LastContactDAO {

	List<LastContact> getByExample(LastContactExample example);
	
	LastContact getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(LastContactExample example);
	
	int save(LastContact record);
	
	int saveSelective(LastContact record);
	
	int countByExample(LastContactExample example);
	
	int updateByExampleSelective(@Param("record") LastContact record, @Param("example") LastContactExample example);
	
	int updateByExample(@Param("record") LastContact record, @Param("example") LastContactExample example);
	
	int updateByPrimaryKeySelective(LastContact record);
	
	int updateByPrimaryKey(LastContact record);


    List<LastContact> pageQueryByExample(Page<LastContact> page,@Param("example") LastContactExample example);
}
