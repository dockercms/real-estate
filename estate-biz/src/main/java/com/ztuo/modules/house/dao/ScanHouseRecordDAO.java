package com.ztuo.modules.house.dao;


import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.ScanHouseRecord;
import com.ztuo.modules.house.entity.ScanHouseRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ScanHouseRecordDAO {

	List<ScanHouseRecord> getByExample(ScanHouseRecordExample example);
	
	ScanHouseRecord getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(ScanHouseRecordExample example);
	
	int save(ScanHouseRecord record);
	
	int saveSelective(ScanHouseRecord record);
	
	int countByExample(ScanHouseRecordExample example);
	
	int updateByExampleSelective(@Param("record") ScanHouseRecord record, @Param("example") ScanHouseRecordExample example);
	
	int updateByExample(@Param("record") ScanHouseRecord record, @Param("example") ScanHouseRecordExample example);
	
	int updateByPrimaryKeySelective(ScanHouseRecord record);
	
	int updateByPrimaryKey(ScanHouseRecord record);


	List<ScanHouseRecord> pageQueryByExample(Page<ScanHouseRecord> page, @Param("example") ScanHouseRecordExample example);

	int deleteRecordByHouseId(@Param("houseId") Long houseId);
}
