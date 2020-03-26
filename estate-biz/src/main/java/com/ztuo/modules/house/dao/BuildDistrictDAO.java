package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.BuildDistrictExample;
import com.ztuo.modules.house.entity.BuildDistrict;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuildDistrictDAO {

	List<BuildDistrict> getByExample(BuildDistrictExample example);
	
	BuildDistrict getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(BuildDistrictExample example);
	
	int save(BuildDistrict record);
	
	int saveSelective(BuildDistrict record);
	
	int countByExample(BuildDistrictExample example);
	
	int updateByExampleSelective(@Param("record") BuildDistrict record, @Param("example") BuildDistrictExample example);
	
	int updateByExample(@Param("record") BuildDistrict record, @Param("example") BuildDistrictExample example);
	
	int updateByPrimaryKeySelective(BuildDistrict record);
	
	int updateByPrimaryKey(BuildDistrict record);

	List<BuildDistrict> pageQuery(Page page, @Param("example") BuildDistrictExample example, @Param("params")Map<String, Object> params);

    List<BuildDistrict> getBuildInfo(String parentNo);

	List<BuildDistrict> getBuildInfoWy(String parentNo);
}
