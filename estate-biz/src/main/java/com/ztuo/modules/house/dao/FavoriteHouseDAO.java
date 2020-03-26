package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.FavoriteHouse;
import com.ztuo.modules.house.entity.FavoriteHouseExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteHouseDAO {

	List<FavoriteHouse> getByExample(FavoriteHouseExample example);
	
	FavoriteHouse getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(FavoriteHouseExample example);
	
	int save(FavoriteHouse record);
	
	int saveSelective(FavoriteHouse record);
	
	int countByExample(FavoriteHouseExample example);
	
	int updateByExampleSelective(@Param("record") FavoriteHouse record, @Param("example") FavoriteHouseExample example);
	
	int updateByExample(@Param("record") FavoriteHouse record, @Param("example") FavoriteHouseExample example);
	
	int updateByPrimaryKeySelective(FavoriteHouse record);
	
	int updateByPrimaryKey(FavoriteHouse record);

    List<FavoriteHouse> pageQueryByExample(Page page,@Param("example") FavoriteHouseExample example);

    int deleteByConditions(@Param("userId") Long userId, @Param("houseId") Long houseId);

	int deleteRecordByHouseIdAndLanguage(@Param("houseId") Long houseId,@Param("language") String language);

    FavoriteHouse findByHouseIdAndUserIdLanguage(@Param("houseId") Long houseId,@Param("userId")String userId , @Param("language") String language);
}
