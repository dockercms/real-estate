package com.ztuo.modules.house.dao;


import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.UserAgreement;
import com.ztuo.modules.house.entity.UserAgreementExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface UserAgreementDAO {

	List<UserAgreement> getByExample(UserAgreementExample example);
	
	UserAgreement getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(UserAgreementExample example);
	
	int save(UserAgreement record);
	
	int saveSelective(UserAgreement record);
	
	int countByExample(UserAgreementExample example);
	
	int updateByExampleSelective(@Param("record") UserAgreement record, @Param("example") UserAgreementExample example);
	
	int updateByExample(@Param("record") UserAgreement record, @Param("example") UserAgreementExample example);
	
	int updateByPrimaryKeySelective(UserAgreement record);
	
	int updateByPrimaryKey(UserAgreement record);

	List<UserAgreement> pageQueryByExample(Page page, @Param("example") UserAgreementExample example);

	int abandonHistoryAgreement(@Param("agreementType") String agreementType);

	UserAgreement findShelvesAgreement(@Param("type") String type);
}
