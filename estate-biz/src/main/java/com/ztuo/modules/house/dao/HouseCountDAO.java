package com.ztuo.modules.house.dao;

import com.ztuo.modules.house.entity.HouseCount;
import com.ztuo.modules.house.entity.HouseCountExample;
import java.util.List;

import com.ztuo.modules.house.entity.HouseCountNews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HouseCountDAO {

	List<HouseCount> getByExample(HouseCountExample example);
	
	HouseCount getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(HouseCountExample example);
	
	int save(HouseCount record);
	
	int saveSelective(HouseCount record);
	
	int countByExample(HouseCountExample example);
	
	int updateByExampleSelective(@Param("record") HouseCount record, @Param("example") HouseCountExample example);
	
	int updateByExample(@Param("record") HouseCount record, @Param("example") HouseCountExample example);
	
	int updateByPrimaryKeySelective(HouseCount record);
	
	int updateByPrimaryKey(HouseCount record);

	List<HouseCountNews> getByExampleNews(HouseCountExample example);

	List<HouseCountNews> getByExampleRent(HouseCountExample example);

	List<HouseCountNews> getByExampleSecond(HouseCountExample example);


    Integer addAccount(@Param("estateType")String estateType,@Param("areaCode")String areaCode);

	Integer subNewAccount(@Param("areaCode")String areaCode);

	Integer subRentAccount(String areaCode);

	Integer subSecondAccount(String areaCode);

	Integer subNewAccountMore(@Param("areaCode")String areaCode,@Param("account")Integer account);

	Integer subRentAccountMore(@Param("areaCode")String areaCode,@Param("account")Integer account);

	Integer subSecondAccountMore(@Param("areaCode")String areaCode,@Param("account")Integer account);
}
