package com.ztuo.modules.house.dao;

import com.ztuo.modules.house.entity.UygurFeedback;
import com.ztuo.modules.house.entity.UygurFeedbackExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UygurFeedbackDAO {

	List<UygurFeedback> getByExample(UygurFeedbackExample example);
	
	UygurFeedback getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(UygurFeedbackExample example);
	
	int save(UygurFeedback record);
	
	int saveSelective(UygurFeedback record);
	
	int countByExample(UygurFeedbackExample example);
	
	int updateByExampleSelective(@Param("record") UygurFeedback record, @Param("example") UygurFeedbackExample example);
	
	int updateByExample(@Param("record") UygurFeedback record, @Param("example") UygurFeedbackExample example);
	
	int updateByPrimaryKeySelective(UygurFeedback record);
	
	int updateByPrimaryKey(UygurFeedback record);
	

}
