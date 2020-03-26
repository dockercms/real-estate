package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.BrokerGuest;
import com.ztuo.modules.house.entity.BrokerGuestExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrokerGuestDAO {

	List<BrokerGuest> getByExample(BrokerGuestExample example);
	
	BrokerGuest getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(BrokerGuestExample example);
	
	int save(BrokerGuest record);
	
	int saveSelective(BrokerGuest record);
	
	int countByExample(BrokerGuestExample example);
	
	int updateByExampleSelective(@Param("record") BrokerGuest record, @Param("example") BrokerGuestExample example);
	
	int updateByExample(@Param("record") BrokerGuest record, @Param("example") BrokerGuestExample example);
	
	int updateByPrimaryKeySelective(BrokerGuest record);
	
	int updateByPrimaryKey(BrokerGuest record);

    List<BrokerGuest> pageQueryByExample(Page<BrokerGuest> page, @Param("example") BrokerGuestExample example,@Param("params")  Map<String, Object> params);
}
