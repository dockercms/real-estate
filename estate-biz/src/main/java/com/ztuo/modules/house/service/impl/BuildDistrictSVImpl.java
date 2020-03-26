package com.ztuo.modules.house.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.DateUtil;
import com.ztuo.modules.house.dao.BuildDistrictDAO;
import com.ztuo.modules.house.entity.BuildDistrict;
import com.ztuo.modules.house.entity.BuildDistrictExample;
import com.ztuo.modules.house.service.IBuildDistrictSV;
import com.ztuo.modules.house.vo.BuildDistrictVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuildDistrictSVImpl implements IBuildDistrictSV {
    
    @Autowired
    private BuildDistrictDAO dao;
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int countByExample(BuildDistrictExample example) throws Exception {
    		return dao.countByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int deleteByExample(BuildDistrictExample example) throws Exception {
    		return dao.deleteByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int deleteByPrimaryKey(Long parameterId) throws Exception {
    		return dao.deleteByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int save(BuildDistrict record) throws Exception {
    		return dao.save(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int saveSelective(BuildDistrict record) throws Exception {
    		return dao.saveSelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public List<BuildDistrict> getByExample(BuildDistrictExample example) throws Exception {
    		return dao.getByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public BuildDistrict getByPrimaryKey(Long parameterId) throws Exception {
    		return dao.getByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int updateByExampleSelective(BuildDistrict record, BuildDistrictExample example) throws Exception {
    		return dao.updateByExampleSelective(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int updateByExample(BuildDistrict record, BuildDistrictExample example) throws Exception {
    		return dao.updateByExample(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int updateByPrimaryKeySelective(BuildDistrict record) throws Exception {
    		return dao.updateByPrimaryKeySelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table build_district
     *
     * @date 2020-03-02 18:04:46
     */
    public int updateByPrimaryKey(BuildDistrict record) throws Exception {
    		return dao.updateByPrimaryKey(record);
    }

    @Override
    public Page<BuildDistrict> pageQuery(BuildDistrictVO districtVO, Map<String, Object> params) {
        Page page = new Page(districtVO.getPageNum(),districtVO.getPageSize());
        BuildDistrictExample example = new BuildDistrictExample();
        BuildDistrictExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(districtVO.getBuildCate())){
            criteria.andBuildCateEqualTo(districtVO.getBuildCate());
        }
        if (StringUtils.isNotEmpty(districtVO.getStartTime())){
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.strToDate(districtVO.getStartTime()));
        }
        if (StringUtils.isNotEmpty(districtVO.getEndTime())){
            criteria.andCreateTimeLessThanOrEqualTo(DateUtil.strToDate(districtVO.getEndTime()));
        }
        if (StringUtils.isNotEmpty(districtVO.getBuildName())){
            criteria.andBuildNameLike("%"+districtVO.getBuildName()+"%");
        }
        if (districtVO.getBuildYears() != null){
            criteria.andBuildYearsEqualTo(districtVO.getBuildYears());
        }
        criteria.andBuildStatusEqualTo("0");
        example.setOrderByClause("id desc");
        List<BuildDistrict> result = dao.pageQuery(page, example,params);
        return page.setRecords(result);
    }

    @Override
    public List<BuildDistrict> getBuildInfo(String parentNo) throws Exception {
        return dao.getBuildInfo(parentNo);
    }

    @Override
    public List<BuildDistrict> getBuildInfoWy(String parentNo) throws Exception {
        return dao.getBuildInfoWy(parentNo);
    }
}
