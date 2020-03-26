package com.ztuo.modules.house.dao;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.Advertising;
import com.ztuo.modules.house.entity.AdvertisingExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvertisingDAO {

	List<Advertising> getByExample(AdvertisingExample example);
	
	Advertising getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(AdvertisingExample example);
	
	int save(Advertising record);
	
	int saveSelective(Advertising record);
	
	int countByExample(AdvertisingExample example);
	
	int updateByExampleSelective(@Param("record") Advertising record, @Param("example") AdvertisingExample example);
	
	int updateByExample(@Param("record") Advertising record, @Param("example") AdvertisingExample example);
	
	int updateByPrimaryKeySelective(Advertising record);
	
	int updateByPrimaryKey(Advertising record);

	List<Advertising> pageQueryByExample(Page<Advertising> page ,@Param("example") AdvertisingExample example);
	

}
