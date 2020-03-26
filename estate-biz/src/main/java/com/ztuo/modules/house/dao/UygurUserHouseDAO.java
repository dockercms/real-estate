package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.UygurUserHouse;
import com.ztuo.modules.house.entity.UygurUserHouseExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UygurUserHouseDAO {

	List<UygurUserHouse> getByExample(UygurUserHouseExample example);
	
	UygurUserHouse getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(UygurUserHouseExample example);
	
	int save(UygurUserHouse record);
	
	int saveSelective(UygurUserHouse record);
	
	int countByExample(UygurUserHouseExample example);
	
	int updateByExampleSelective(@Param("record") UygurUserHouse record, @Param("example") UygurUserHouseExample example);
	
	int updateByExample(@Param("record") UygurUserHouse record, @Param("example") UygurUserHouseExample example);
	
	int updateByPrimaryKeySelective(UygurUserHouse record);
	
	int updateByPrimaryKey(UygurUserHouse record);

	List<UygurUserHouse> pageQueryByExample(Page page, @Param("example") UygurUserHouseExample example);
}
