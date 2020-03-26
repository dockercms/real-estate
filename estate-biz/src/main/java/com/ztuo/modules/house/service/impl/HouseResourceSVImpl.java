package com.ztuo.modules.house.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.dao.HouseResourceDAO;
import com.ztuo.modules.house.entity.HouseResource;
import com.ztuo.modules.house.entity.HouseResourceExample;
import com.ztuo.modules.house.service.IHouseResourceSV;
import com.ztuo.modules.house.vo.HouseCountVO;
import com.ztuo.modules.house.vo.HouseLocationVO;
import com.ztuo.modules.house.vo.HouseResourceVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HouseResourceSVImpl implements IHouseResourceSV {
    
    @Autowired
    private HouseResourceDAO dao;
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int countByExample(HouseResourceExample example) throws Exception {
    		return dao.countByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int deleteByExample(HouseResourceExample example) throws Exception {
    		return dao.deleteByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int deleteByPrimaryKey(Long parameterId) throws Exception {
    		return dao.deleteByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int save(HouseResource record) throws Exception {
    		return dao.save(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int saveSelective(HouseResource record) throws Exception {
    		return dao.saveSelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public List<HouseResource> getByExample(HouseResourceExample example) throws Exception {
    		return dao.getByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public HouseResource getByPrimaryKey(Long parameterId) throws Exception {
    		return dao.getByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByExampleSelective(HouseResource record, HouseResourceExample example) throws Exception {
    		return dao.updateByExampleSelective(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByExample(HouseResource record, HouseResourceExample example) throws Exception {
    		return dao.updateByExample(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByPrimaryKeySelective(HouseResource record) throws Exception {
    		return dao.updateByPrimaryKeySelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table house_resource
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByPrimaryKey(HouseResource record) throws Exception {
    		return dao.updateByPrimaryKey(record);
    }

    @Override
    public Page<HouseResource> criteriaQuery(HouseResourceVO houseResourceVO, Map<String, Object> params) throws Exception {
        // 创建分页
        Page page = new Page(houseResourceVO.getPageNum(),houseResourceVO.getPageSize());
        HouseResourceExample example = new HouseResourceExample();
        HouseResourceExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(houseResourceVO.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtils.parseDate(houseResourceVO.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotEmpty(houseResourceVO.getEndTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtils.parseDate(houseResourceVO.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(houseResourceVO.getApplicantName())) {
            criteria.andApplicantNameEqualTo(houseResourceVO.getApplicantName());
        }
        if (houseResourceVO.getEstateType() != null) {
            if (houseResourceVO.getEstateType() == 0) {
                List<Integer> types = new ArrayList<>();
                types.add(9);
                types.add(10);
                types.add(11);
                criteria.andEstateTypeIn(types);
            } else {
                criteria.andEstateTypeEqualTo(houseResourceVO.getEstateType());
            }
        }
        if (houseResourceVO.getUseWay() != null) {
            criteria.andUseWayEqualTo(houseResourceVO.getUseWay());
        }
        if (StringUtils.isNotBlank(houseResourceVO.getRegion())) {
            criteria.andHouseRegionAreaLike(houseResourceVO.getRegion());
        }
        // 审核状态
        if (houseResourceVO.getRecordStatus() != null) {
            criteria.andRecordStatusEqualTo(houseResourceVO.getRecordStatus());
        }
        example.setOrderByClause("create_time desc");
        List<HouseResource> houseResources = dao.pageQueryByExample(page, example,params);
        return page.setRecords(houseResources);
    }

    @Override
    public HouseResource findBySignLabel(String signLabel) {
        return dao.getBySignLabel(signLabel);
    }

    @Override
    public List<HouseLocationVO> getMapLocation(HouseCountVO houseCountVO) {
        List<HouseLocationVO> result = new ArrayList<>();
        HouseResourceExample example = new HouseResourceExample();
        HouseResourceExample.Criteria criteria = example.createCriteria();
        criteria.andAreaCodeEqualTo(houseCountVO.getCityCode());
        if ("0".equals(houseCountVO.getEstateType())){
            criteria.andEstateTypeEqualTo(9);
        }else if ("1".equals(houseCountVO.getEstateType())){
            criteria.andEstateTypeEqualTo(11);
        }else if ("2".equals(houseCountVO.getEstateType())){
            criteria.andEstateTypeEqualTo(10);
        }else {
            return result;
        }
        result = dao.getMapLocation(example);
        return result;
    }
}
