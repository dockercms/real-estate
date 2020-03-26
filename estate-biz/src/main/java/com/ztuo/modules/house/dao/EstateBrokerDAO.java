package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.entity.EstateBrokerExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EstateBrokerDAO {

	List<EstateBroker> getByExample(EstateBrokerExample example);
	
	EstateBroker getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(EstateBrokerExample example);
	
	int save(EstateBroker record);
	
	int saveSelective(EstateBroker record);
	
	int countByExample(EstateBrokerExample example);
	
	int updateByExampleSelective(@Param("record") EstateBroker record, @Param("example") EstateBrokerExample example);
	
	int updateByExample(@Param("record") EstateBroker record, @Param("example") EstateBrokerExample example);
	
	int updateByPrimaryKeySelective(EstateBroker record);
	
	int updateByPrimaryKey(EstateBroker record);

	/**
	 * 分页条件查询经纪人信息
	 * @param page
	 * @param brokerExample
	 * @return
	 */
    List<EstateBroker> pageQueryByExample(Page page, @Param("example") EstateBrokerExample brokerExample, @Param("params")Map<String, Object> params);

	/**
	 * 根据手机号获取经纪人
	 * 因为同一个手机号回存在被拒绝得情况，所以会存在相同得手机号
	 * @param mobilePhone
	 * @return
	 */
	List<EstateBroker> getBrokerByPhone(@Param("mobilePhone") String mobilePhone);

	/**
	 * 根据审核状态和手机号查询经纪人
	 * @param mobilePhone
	 * @param auditStatus 审核状态 0-审核中 1-审核成功 2-审核失败
	 * @return
	 */
	EstateBroker getBrokerByPhoneAndStatus(@Param("mobilePhone") String mobilePhone, @Param("auditStatus") Integer auditStatus);

	/**
	 * 获取未审核记录数量
	 * @return
	 */
	Integer getUncheckedCount();
}
