package com.ztuo.modules.house.service.impl;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.es.dao.HouseDocRepository;
import com.ztuo.modules.es.dao.UyHouseDocRepository;
import com.ztuo.modules.es.entity.HouseDoc;
import com.ztuo.modules.es.entity.UyHouseDoc;
import com.ztuo.modules.house.dao.FavoriteHouseDAO;
import com.ztuo.modules.house.dao.HouseResourceDAO;
import com.ztuo.modules.house.dao.ScanHouseRecordDAO;
import com.ztuo.modules.house.dao.UygurHouseResourceDAO;
import com.ztuo.modules.house.entity.HouseResource;
import com.ztuo.modules.house.entity.UygurHouseResource;
import com.ztuo.modules.house.service.HouseService;
import com.ztuo.modules.house.service.IHouseCountSV;
import com.ztuo.modules.house.vo.HouseResourceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/2/18 17:27
 * @Version: 1.0
 */
@Service
public class HouseServiceImpl implements HouseService {


    @Autowired
    private HouseResourceDAO houseResourceDAO;

    @Autowired
    private UygurHouseResourceDAO uygurHouseResourceDAO;

    @Autowired
    private HouseDocRepository repository;

    @Autowired
    private UyHouseDocRepository uyHouseDocRepository;

    @Autowired
    private IHouseCountSV houseCountSV;

    @Autowired
    private ScanHouseRecordDAO scanHouseRecordDAO ;

    @Autowired
    private FavoriteHouseDAO favoriteHouseDAO ;

    @Autowired
    private HouseResourceServiceImpl houseResourceService;


    @Override
    public RestResponse updateHouse(HouseResource houseResource) {
        HouseResource oldHouseResource = houseResourceDAO.getByPrimaryKey(houseResource.getId());
        String signLabel = oldHouseResource.getSignLabel();
//        UygurHouseResource uyHouse = uygurHouseResourceDAO.getBySignLabel(signLabel);
        houseResource.setUpdateTime(new Date());
//        uyHouse.setUpdateTime(new Date());
        houseResourceDAO.updateByPrimaryKeySelective(houseResource);
//        uygurHouseResourceDAO.updateBySignLabelSelective(houseResource);
        return RestResponse.success("修改成功");
    }


    @Override
    public RestResponse deleteHouse(Long id) {
        HouseResource houseResource = houseResourceDAO.getByPrimaryKey(id);
        UygurHouseResource uygurHouseResource = uygurHouseResourceDAO.getBySignLabel(houseResource.getSignLabel());
        scanHouseRecordDAO.deleteRecordByHouseId(id);
        houseResourceDAO.deleteByPrimaryKey(id);
        favoriteHouseDAO.deleteRecordByHouseIdAndLanguage(id,"0");
        if(uygurHouseResource!=null) {
            scanHouseRecordDAO.deleteRecordByHouseId(uygurHouseResource.getId());
            favoriteHouseDAO.deleteRecordByHouseIdAndLanguage(uygurHouseResource.getId(),"1");
            uygurHouseResourceDAO.deleteByPrimaryKey(uygurHouseResource.getId());
        }
        //删除ES中的房源
        repository.deleteById(houseResource.getId());
        uyHouseDocRepository.deleteById(uygurHouseResource.getId());
        //house数量减1
        houseCountSV.subAccountByType(houseResource.getEstateType()+"",houseResource.getRegionCode());

        return RestResponse.success("删除成功");
    }
    private List<Integer> estateTypes = new ArrayList<>();
    private List<Integer> esTypes = new ArrayList<>();

    {
        estateTypes.add(2);
        estateTypes.add(9);
        estateTypes.add(10);
        estateTypes.add(11);
        esTypes.add(9);
        esTypes.add(10);
        esTypes.add(11);
    }
    @Override
    public RestResponse audit(HouseResourceVO houseResourceVO) {
        HouseResource houseResource = houseResourceDAO.getByPrimaryKey(houseResourceVO.getHouseResourceId());
        if (houseResource == null) {
            return RestResponse.error("房源不存在");
        }
        houseResource.setUpdateTime(new Date());
        if (houseResourceVO.getRecordStatus() == 1) {
            houseResource.setSellStatus(0);
        }
        if (houseResource.getRecordStatus() == 1 || houseResource.getRecordStatus() == 2) {
            return RestResponse.error("请勿重复审核");
        }
        houseResource.setRecordStatus(houseResourceVO.getRecordStatus());
        houseResourceDAO.updateByPrimaryKeySelective(houseResource);
        Integer estateType = houseResource.getEstateType();
        //审核成功后插入ES
        if (houseResourceVO.getRecordStatus().equals(1) && estateTypes.contains(estateType) ){
            HouseDoc houseDoc = new HouseDoc();
            BeanUtils.copyProperties(houseResource,houseDoc);
            repository.save(houseDoc);
            //增加house数量
            if(esTypes.contains(estateType)) {
                houseCountSV.addAccount(estateType + "", houseResource.getRegionCode());
            }
        }

        UygurHouseResource uygurHouseResource = uygurHouseResourceDAO.getBySignLabel(houseResource.getSignLabel());
        if (uygurHouseResource != null) {
            uygurHouseResource.setUpdateTime(new Date());
            if ((houseResourceVO.getRecordStatus() == 1)) {
                uygurHouseResource.setSellStatus(0);
            }
            uygurHouseResource.setRecordStatus(houseResourceVO.getRecordStatus());
            uygurHouseResourceDAO.updateByPrimaryKeySelective(uygurHouseResource);
            Integer type = uygurHouseResource.getEstateType();
            //审核成功后插入ES
            if (houseResourceVO.getRecordStatus().equals(1) && estateTypes.contains(type)){
                UyHouseDoc uyHouseDoc = new UyHouseDoc();
                BeanUtils.copyProperties(uygurHouseResource,uyHouseDoc);
                uyHouseDocRepository.save(uyHouseDoc);
            }
            // 新增首页房源数据
            if (houseResource.getEstateType() == 10 || houseResource.getEstateType() == 11 || houseResource.getEstateType() == 2) {
                if (houseResource.getSticky() != null && houseResource.getSticky() == 1) {
                    houseResourceService.deleteRedisHomePageHouse(houseResource.getEstateType());
                    houseResourceService.addHomePageMysql(houseResource.getEstateType());
                }
            }
        } else {
            return RestResponse.error("维语房源不存在");
        }
        return RestResponse.success("审核成功");
    }
}
