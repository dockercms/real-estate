package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.Feedback;
import com.ztuo.modules.house.entity.FeedbackExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedbackDAO {

	List<Feedback> getByExample(FeedbackExample example);
	
	Feedback getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(FeedbackExample example);
	
	int save(Feedback record);
	
	int saveSelective(Feedback record);
	
	int countByExample(FeedbackExample example);
	
	int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);
	
	int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);
	
	int updateByPrimaryKeySelective(Feedback record);
	
	int updateByPrimaryKey(Feedback record);

	/**
	 * 意见反馈查询
	 * @param page
	 * @param example
	 * @return
	 */
    List<Feedback> pageQuery(Page page, @Param("example") FeedbackExample example);
}
