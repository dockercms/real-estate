package com.ztuo.modules.house.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RedisUtil;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.es.dao.HouseDocRepository;
import com.ztuo.modules.es.dao.UyHouseDocRepository;
import com.ztuo.modules.house.dao.*;
import com.ztuo.modules.house.dto.*;
import com.ztuo.modules.house.entity.*;
import com.ztuo.modules.house.service.HouseResourceService;
import com.ztuo.modules.house.service.IHouseCountSV;
import com.ztuo.modules.house.vo.HomePageUyVO;
import com.ztuo.modules.house.vo.HomePageVO;
import com.ztuo.modules.house.vo.HouseKindQueryVO;
import com.ztuo.modules.house.vo.UploadHouse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * @Author: dupinyan
 * @Description: House
 * @Date: 2020/2/22 16:07
 * @Version: 1.0
 */
@Service
@Slf4j
public class HouseResourceServiceImpl implements HouseResourceService {

    @Autowired
    private HouseResourceDAO houseResourceDAO;

    @Autowired
    private EstateBrokerDAO brokerDAO;

    @Autowired
    private UygurHouseResourceDAO uygurHouseResourceDAO;

    @Autowired
    private UserHouseDAO userHouseDAO;

    @Autowired
    private FavoriteHouseDAO favoriteHouseDAO ;

    @Autowired
    private IHouseCountSV houseCountSV;

    @Autowired
    private HouseDocRepository houseDocRepository;

    @Autowired
    private UyHouseDocRepository uyHouseDocRepository;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public RestResponse pageQuery(HttpServletRequest request, HouseKindQueryVO queryVO) {
        Page zhPage = new Page(queryVO.getPageNum(), queryVO.getPageSize());
        Page uyPage = new Page(queryVO.getPageNum(), queryVO.getPageSize());

        Map<String, Page> map = new HashMap<>();

        HouseResourceExample zhExample = new HouseResourceExample();
        HouseResourceExample.Criteria zhCriteria = zhExample.createCriteria();

        UygurHouseResourceExample uygurExample = new UygurHouseResourceExample();
        UygurHouseResourceExample.Criteria uygurCriteria = uygurExample.createCriteria();

        // 市code和区code
        if (StringUtils.isNotBlank(queryVO.getRegionCode()) && StringUtils.isNotBlank(queryVO.getCityCode())) {
            zhCriteria.andCityCodeEqualTo(queryVO.getCityCode());
            zhCriteria.andRegionCodeEqualTo(queryVO.getRegionCode());
            uygurCriteria.andCityCodeEqualTo(queryVO.getCityCode());
            uygurCriteria.andRegionCodeEqualTo(queryVO.getRegionCode());
        }

        // 房屋x室
        if (queryVO.getHouseType() != null) {
            if (queryVO.getHouseType() != 5) {
                zhCriteria.andHouseTypeRoomEqualTo(queryVO.getHouseType());
                uygurCriteria.andHouseTypeRoomEqualTo(queryVO.getHouseType());
            } else {
                zhCriteria.andHouseTypeRoomGreaterThanOrEqualTo(queryVO.getHouseType());
                uygurCriteria.andHouseTypeRoomGreaterThanOrEqualTo(queryVO.getHouseType());
            }
        }
        // 面积
        if (StringUtils.isNotBlank(queryVO.getMinArea())) {
            zhCriteria.andHouseAreaGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinArea()));
            uygurCriteria.andHouseAreaGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinArea()));
        }
        if (StringUtils.isNotBlank(queryVO.getMaxArea())) {
            zhCriteria.andHouseAreaLessThanOrEqualTo(new BigDecimal(queryVO.getMaxArea()));
            uygurCriteria.andHouseAreaLessThanOrEqualTo(new BigDecimal(queryVO.getMaxArea()));
        }
        // 上架状态并且通过审核
        zhCriteria.andRecordStatusEqualTo(1);
        uygurCriteria.andRecordStatusEqualTo(1);
        zhCriteria.andSellStatusEqualTo(0);
        uygurCriteria.andSellStatusEqualTo(0);

        Integer sortType = queryVO.getSortType();

        // 房源分类
        Integer propertyType = queryVO.getPropertyType();
        if (propertyType != null) {
            // 住宅 + 出售 + 新房 = 新房
            if (propertyType == 0) {
                // 最小售价
                if (queryVO.getMinPrice() != null) {
                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                }
                // 最大售价
                if (queryVO.getMaxPrice() != null) {
                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                }
                // 即将开盘 在售楼盘
                if (queryVO.getQueryType() != null) {
                    if (queryVO.getQueryType() == 0) {
                        zhCriteria.andOpenDateGreaterThanOrEqualTo(new Date());
                        uygurCriteria.andOpenDateGreaterThanOrEqualTo(new Date());
                    } else {
                        zhCriteria.andOpenDateLessThanOrEqualTo(new Date());
                        uygurCriteria.andOpenDateLessThanOrEqualTo(new Date());
                    }
                }
                if (sortType != null) {
                    if (sortType == 1) {
                        zhExample.setOrderByClause("price asc");
                        uygurExample.setOrderByClause("price asc");
                    }
                    if (sortType == 2) {
                        zhExample.setOrderByClause("price desc");
                        uygurExample.setOrderByClause("price desc");
                    }
                    if (sortType == 3) {
                        zhExample.setOrderByClause("open_date asc");
                        uygurExample.setOrderByClause("open_date asc");
                    }
                    if (sortType == 4) {
                        zhExample.setOrderByClause("open_date desc");
                        uygurExample.setOrderByClause("open_date desc");
                    }
                } else {
                    zhExample.setOrderByClause("create_time desc");
                    uygurExample.setOrderByClause("create_time desc");
                }
                zhCriteria.andEstateTypeEqualTo(9);
                uygurCriteria.andEstateTypeEqualTo(9);

                List<NewHouseDTO> newHouseDTOList = houseResourceDAO.newHouseQuery(zhPage, zhExample);
                List<NewHouseDTO> uyNewHouseDTOList = uygurHouseResourceDAO.newHouseQuery(uyPage, uygurExample);

                zhPage = zhPage.setRecords(newHouseDTOList);
                uyPage = uyPage.setRecords(uyNewHouseDTOList);

                map.put("zhPage", zhPage);
                map.put("uyPage", uyPage);

                return RestResponse.success(map);
            }
            // 住宅 + 出售 + 二手房 = 二手房
            if (propertyType == 1) {
                zhCriteria.andEstateTypeEqualTo(10);
                uygurCriteria.andEstateTypeEqualTo(10);
                List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                // 最小售价
                if (queryVO.getMinPrice() != null) {
                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                }
                // 最大售价
                if (queryVO.getMaxPrice() != null) {
                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                }
                // 房源特色
                if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                    zhCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                    uygurCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                }
                // 装修类型
                if (queryVO.getDecorationType() != null) {
                    zhCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                    uygurCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                }
                // 楼层
                if (queryVO.getFloorType() != null) {
                    zhCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                    uygurCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                }

                if (queryVO.getTowards() != null) {
                    zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                    uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                }

                if (queryVO.getElevator() != null) {
                    zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                    uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                }

                if (sortType != null) {
                    if (sortType == 1) {
                        zhExample.setOrderByClause("average_price asc");
                        uygurExample.setOrderByClause("average_price asc");
                    }
                    if (sortType == 2) {
                        zhExample.setOrderByClause("average_price desc");
                        uygurExample.setOrderByClause("average_price desc");
                    }
                    if (sortType == 3) {
                        zhExample.setOrderByClause("open_date asc");
                        uygurExample.setOrderByClause("open_date asc");
                    }
                    if (sortType == 4) {
                        zhExample.setOrderByClause("open_date desc");
                        uygurExample.setOrderByClause("open_date desc");
                    }
                } else {
                    zhExample.setOrderByClause("create_time desc");
                    uygurExample.setOrderByClause("create_time desc");
                }

                List<SecondHandHouseDTO> zhSecondHandHouseDTOList = houseResourceDAO.secondHouse(zhPage, zhExample);
                List<SecondHandHouseDTO> uySecondHandHouseDTOList = uygurHouseResourceDAO.secondHouse(uyPage, uygurExample);

                zhPage = zhPage.setRecords(zhSecondHandHouseDTOList);
                uyPage = uyPage.setRecords(uySecondHandHouseDTOList);

                map.put("zhPage", zhPage);
                map.put("uyPage", uyPage);

                return RestResponse.success(map);
            }
            // 住宅 + 出租 = 租房
            if (propertyType == 2) {
                if (queryVO.getRentalType() != null) {
                    zhCriteria.andRentalTypeEqualTo(queryVO.getRentalType());
                    uygurCriteria.andRentalTypeEqualTo(queryVO.getRentalType());
                }
                zhCriteria.andEstateTypeEqualTo(11);
                uygurCriteria.andEstateTypeEqualTo(11);

                // 最小租金
                if (queryVO.getMinPrice() != null) {
                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                }
                // 最大租金
                if (queryVO.getMaxPrice() != null) {
                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                }
                // 装修类型
                if (queryVO.getDecorationType() != null) {
                    zhCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                    uygurCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                }
                // 楼层
                if (queryVO.getFloorType() != null) {
                    zhCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                    uygurCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                }
                // 朝向
                if (queryVO.getTowards() != null) {
                    zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                    uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                }
                // 配备电梯
                if (queryVO.getElevator() != null) {
                    zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                    uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                }

                if (sortType != null) {
                    if (sortType == 1) {
                        zhExample.setOrderByClause("monthly_rent asc");
                        uygurExample.setOrderByClause("monthly_rent asc");
                    }
                    if (sortType == 2) {
                        zhExample.setOrderByClause("monthly_rent desc");
                        uygurExample.setOrderByClause("monthly_rent desc");
                    }
                    if (sortType == 3) {
                        zhExample.setOrderByClause("open_date asc");
                        uygurExample.setOrderByClause("open_date asc");
                    }
                    if (sortType == 4) {
                        zhExample.setOrderByClause("open_date desc");
                        uygurExample.setOrderByClause("open_date desc");
                    }
                } else {
                    zhExample.setOrderByClause("create_time desc");
                    uygurExample.setOrderByClause("create_time desc");
                }

                List<RentHouseDTO> zhRentHouseDTOList = houseResourceDAO.rentHouse(zhPage, zhExample);
                List<RentHouseDTO> uyRentHouseDTOList = uygurHouseResourceDAO.rentHouse(uyPage, uygurExample);

                zhPage = zhPage.setRecords(zhRentHouseDTOList);
                uyPage = uyPage.setRecords(uyRentHouseDTOList);

                map.put("zhPage", zhPage);
                map.put("uyPage", uyPage);

                return RestResponse.success(map);
            }
            // 别墅
            if (propertyType == 3) {

                if (queryVO.getUseWay() != null) {
                    // 装修类型
                    if (queryVO.getDecorationType() != null) {
                        zhCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                        uygurCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                    }
                    // 楼层
                    if (queryVO.getFloorType() != null) {
                        zhCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                        uygurCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                    }
                    // 朝向
                    if (queryVO.getTowards() != null) {
                        zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                        uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                    }
                    // 配备电梯
                    if (queryVO.getElevator() != null) {
                        zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                        uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                    }
                    List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                    // 房源特色
                    if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                        zhCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        uygurCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                    }

                    zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    zhCriteria.andEstateTypeEqualTo(1);
                    uygurCriteria.andEstateTypeEqualTo(1);
                    // 别墅出租
                    if (queryVO.getUseWay() == 0) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                            if (sortType == 3) {
                                zhExample.setOrderByClause("open_date asc");
                                uygurExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                zhExample.setOrderByClause("open_date desc");
                                uygurExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<VillaRentDTO> zhVillaRentDTOList = houseResourceDAO.villaRent(zhPage, zhExample);
                        List<VillaRentDTO> uyVillaRentDTOList = uygurHouseResourceDAO.villaRent(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhVillaRentDTOList);
                        uyPage = uyPage.setRecords(uyVillaRentDTOList);

                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 别墅出售
                    if (queryVO.getUseWay() == 1) {

                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                            if (sortType == 3) {
                                zhExample.setOrderByClause("open_date asc");
                                uygurExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                zhExample.setOrderByClause("open_date desc");
                                uygurExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<VillaSellDTO> zhVillaSellDTOList = houseResourceDAO.villaSell(zhPage, zhExample);
                        List<VillaSellDTO> uyVillaSellDTOList = uygurHouseResourceDAO.villaSell(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhVillaSellDTOList);
                        uyPage = uyPage.setRecords(uyVillaSellDTOList);

                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                }

            }
            // 商铺
            if (propertyType == 4) {
                if (queryVO.getUseWay() != null) {
                    zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    zhCriteria.andEstateTypeEqualTo(2);
                    uygurCriteria.andEstateTypeEqualTo(2);
                    // 商铺出售
                    if (queryVO.getUseWay() == 1) {

                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<ShopSellHouseDTO> zhShopSellHouseDTOList = houseResourceDAO.shopSell(zhPage, zhExample);
                        List<ShopSellHouseDTO> uyShopSellHouseDTOList = uygurHouseResourceDAO.shopSell(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhShopSellHouseDTOList);
                        uyPage = uyPage.setRecords(uyShopSellHouseDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 商铺转让
                    if (queryVO.getUseWay() == 2) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<ShopTransferHouseDTO> zhShopTransferHouseDTOList = houseResourceDAO.shopTransfer(zhPage, zhExample);
                        List<ShopTransferHouseDTO> uyShopTransferHouseDTOList = uygurHouseResourceDAO.shopTransfer(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhShopTransferHouseDTOList);
                        uyPage = uyPage.setRecords(uyShopTransferHouseDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 商铺出租
                    if (queryVO.getUseWay() == 0) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<ShopRentHouseDTO> zhShopRentHouseDTOList = houseResourceDAO.shopRent(zhPage, zhExample);
                        List<ShopRentHouseDTO> uyShopRentHouseDTOList = uygurHouseResourceDAO.shopRent(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhShopRentHouseDTOList);
                        uyPage = uyPage.setRecords(uyShopRentHouseDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                }
            }
            // 写字楼
            if (propertyType == 5) {
                if (queryVO.getUseWay() != null) {
                    zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    zhCriteria.andEstateTypeEqualTo(3);
                    uygurCriteria.andEstateTypeEqualTo(3);
                    // 写字楼出租
                    if (queryVO.getUseWay() == 0) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<OfficeRentHouseDTO> zhOfficeRentHouseDTOList = houseResourceDAO.officeRent(zhPage, zhExample);
                        List<OfficeRentHouseDTO> uyOfficeRentHouseDTOList = uygurHouseResourceDAO.officeRent(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhOfficeRentHouseDTOList);
                        uyPage = uyPage.setRecords(uyOfficeRentHouseDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 写字楼出售
                    if (queryVO.getUseWay() == 1) {

                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<OfficeSellHouseDTO> zhOfficeSellHouseDTOList = houseResourceDAO.officeSell(zhPage, zhExample);
                        List<OfficeSellHouseDTO> uyOfficeSellHouseDTOList = uygurHouseResourceDAO.officeSell(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhOfficeSellHouseDTOList);
                        uyPage = uyPage.setRecords(uyOfficeSellHouseDTOList);

                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                }
            }
            // 酒店
            if (propertyType == 6) {
                if (queryVO.getUseWay() != null) {
                    zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    zhCriteria.andEstateTypeEqualTo(4);
                    uygurCriteria.andEstateTypeEqualTo(4);
                    // 酒店出租
                    if (queryVO.getUseWay() == 0) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        List<HotelRentDTO> zhHotelRentDTOList = houseResourceDAO.hotelRent(zhPage, zhExample);
                        List<HotelRentDTO> uyHotelRentDTOList = uygurHouseResourceDAO.hotelRent(uyPage, uygurExample);


                        zhPage = zhPage.setRecords(zhHotelRentDTOList);
                        uyPage = uyPage.setRecords(uyHotelRentDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 酒店出售
                    if (queryVO.getUseWay() == 1) {

                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        List<HotelSellDTO> zhHotelSellDTOList = houseResourceDAO.hotelSell(zhPage, zhExample);
                        List<HotelSellDTO> uyHotelSellDTOList = uygurHouseResourceDAO.hotelSell(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhHotelSellDTOList);
                        uyPage = uyPage.setRecords(uyHotelSellDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                }
            }
            // 厂房
            if (propertyType == 7) {
                if (queryVO.getUseWay() != null) {
                    zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    zhCriteria.andEstateTypeEqualTo(5);
                    uygurCriteria.andEstateTypeEqualTo(5);
                    // 厂房出租
                    if (queryVO.getUseWay() == 0) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<WorkShopRentDTO> zhWorkShopRentDTOList = houseResourceDAO.workShopRent(zhPage, zhExample);
                        List<WorkShopRentDTO> uyWorkShopRentDTOList = uygurHouseResourceDAO.workShopRent(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhWorkShopRentDTOList);
                        uyPage = uyPage.setRecords(uyWorkShopRentDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 厂房出售
                    if (queryVO.getUseWay() == 1) {

                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        List<WorkShopSellDTO> zhWorkShopSellDTOList = houseResourceDAO.workShopSell(zhPage, zhExample);
                        List<WorkShopSellDTO> uyWorkShopSellDTOList = uygurHouseResourceDAO.workShopSell(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhWorkShopSellDTOList);
                        uyPage = uyPage.setRecords(uyWorkShopSellDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 厂房转让
                    if (queryVO.getUseWay() == 2) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        List<WorkShopTransferDTO> zhWorkShopTransferDTOList = houseResourceDAO.workShopTransfer(zhPage, zhExample);
                        List<WorkShopTransferDTO> uyWorkShopTransferDTOList = uygurHouseResourceDAO.workShopTransfer(uyPage, uygurExample);

                        zhPage = zhPage.setRecords(zhWorkShopTransferDTOList);
                        uyPage = uyPage.setRecords(uyWorkShopTransferDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                }
            }
            // 仓库
            if (propertyType == 8) {
                if (queryVO.getUseWay() != null) {
                    zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                    zhCriteria.andEstateTypeEqualTo(6);
                    uygurCriteria.andEstateTypeEqualTo(6);
                    // 仓库出租
                    if (queryVO.getUseWay() == 0) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        List<WareHouseRentDTO> zhWareHouseRentDTOList = houseResourceDAO.wareHouseRent(zhPage, zhExample);
                        List<WareHouseRentDTO> uyWareHouseRentDTOList = uygurHouseResourceDAO.wareHouseRent(uyPage, uygurExample);
                        zhPage = zhPage.setRecords(zhWareHouseRentDTOList);
                        uyPage = uyPage.setRecords(uyWareHouseRentDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 仓库出售
                    if (queryVO.getUseWay() == 1) {

                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                                uygurExample.setOrderByClause("price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        List<WareHouseSellDTO> zhWareHouseSellDTOList = houseResourceDAO.wareHouseSell(zhPage, zhExample);
                        List<WareHouseSellDTO> uyWareHouseSellDTOList = uygurHouseResourceDAO.wareHouseSell(uyPage, uygurExample);
                        zhPage = zhPage.setRecords(zhWareHouseSellDTOList);
                        uyPage = uyPage.setRecords(uyWareHouseSellDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                    // 仓库转让
                    if (queryVO.getUseWay() == 2) {

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<WareHouseTransferDTO> zhWareHouseTransferDTOList = houseResourceDAO.wareHouseTransfer(zhPage, zhExample);
                        List<WareHouseTransferDTO> uyWareHouseTransferDTOList = uygurHouseResourceDAO.wareHouseTransfer(uyPage, uygurExample);
                        zhPage = zhPage.setRecords(zhWareHouseTransferDTOList);
                        uyPage = uyPage.setRecords(uyWareHouseTransferDTOList);
                        map.put("zhPage", zhPage);
                        map.put("uyPage", uyPage);

                        return RestResponse.success(map);
                    }
                }
            }
            // 土地转让
            if (propertyType == 9) {
                zhCriteria.andEstateTypeEqualTo(7);
                uygurCriteria.andEstateTypeEqualTo(7);

                if (sortType != null) {
                    if (sortType == 1) {
                        zhExample.setOrderByClause("transfer_price asc");
                        uygurExample.setOrderByClause("transfer_price asc");
                    }
                    if (sortType == 2) {
                        zhExample.setOrderByClause("transfer_price desc");
                        uygurExample.setOrderByClause("transfer_price desc");
                    }
                } else {
                    zhExample.setOrderByClause("create_time desc");
                    uygurExample.setOrderByClause("create_time desc");
                }


                if (queryVO.getMinPrice() != null) {
                    zhCriteria.andTransferPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                    uygurCriteria.andTransferPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                }

                if (queryVO.getMaxPrice() != null) {
                    zhCriteria.andTransferPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                    uygurCriteria.andTransferPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                }


                List<LandTransferDTO> zhLandTransferDTOList = houseResourceDAO.landTransfer(zhPage, zhExample);
                List<LandTransferDTO> uyLandTransferDTOList = uygurHouseResourceDAO.landTransfer(uyPage, uygurExample);

                zhPage = zhPage.setRecords(zhLandTransferDTOList);
                uyPage = uyPage.setRecords(uyLandTransferDTOList);

                map.put("zhPage", zhPage);
                map.put("uyPage", uyPage);

                return RestResponse.success(map);
            }
            // 车位
            if (propertyType == 10) {
                zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                zhCriteria.andEstateTypeEqualTo(8);
                uygurCriteria.andEstateTypeEqualTo(8);
                // 出租
                if (queryVO.getUseWay() == 0) {
                    if (queryVO.getMinPrice() != null) {
                        zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                    }
                    if (queryVO.getMaxPrice() != null) {
                        zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                    }
                    if (sortType != null) {
                        if (sortType == 1) {
                            zhExample.setOrderByClause("monthly_rent asc");
                            uygurExample.setOrderByClause("monthly_rent asc");
                        }
                        if (sortType == 2) {
                            zhExample.setOrderByClause("monthly_rent desc");
                            uygurExample.setOrderByClause("monthly_rent desc");
                        }
                    } else {
                        zhExample.setOrderByClause("create_time desc");
                        uygurExample.setOrderByClause("create_time desc");
                    }

                    List<ParkingSpaceRentDTO> zhParkingSpaceRentDTOList = houseResourceDAO.parkingSpaceRent(zhPage, zhExample);
                    List<ParkingSpaceRentDTO> uyParkingSpaceRentDTOList = uygurHouseResourceDAO.parkingSpaceRent(uyPage, uygurExample);

                    zhPage = zhPage.setRecords(zhParkingSpaceRentDTOList);
                    uyPage = uyPage.setRecords(uyParkingSpaceRentDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 出售
                if (queryVO.getUseWay() == 1) {

                    if (queryVO.getMinPrice() != null) {
                        zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                    }
                    if (queryVO.getMaxPrice() != null) {
                        zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                    }
                    if (sortType != null) {
                        if (sortType == 1) {
                            zhExample.setOrderByClause("price asc");
                            uygurExample.setOrderByClause("price asc");
                        }
                        if (sortType == 2) {
                            zhExample.setOrderByClause("price desc");
                            uygurExample.setOrderByClause("price desc");
                        }
                    } else {
                        zhExample.setOrderByClause("create_time desc");
                        uygurExample.setOrderByClause("create_time desc");
                    }

                    List<ParkingSpaceSellDTO> zhParkingSpaceSellDTOList = houseResourceDAO.parkingSpaceSell(zhPage, zhExample);
                    List<ParkingSpaceSellDTO> uyParkingSpaceSellDTOList = uygurHouseResourceDAO.parkingSpaceSell(uyPage, uygurExample);

                    zhPage = zhPage.setRecords(zhParkingSpaceSellDTOList);
                    uyPage = uyPage.setRecords(uyParkingSpaceSellDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 转让
                if (queryVO.getUseWay() == 2) {
                    if (queryVO.getMinPrice() != null) {
                        zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                    }
                    if (queryVO.getMaxPrice() != null) {
                        zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                    }
                    if (sortType != null) {
                        if (sortType == 1) {
                            zhExample.setOrderByClause("price asc");
                            uygurExample.setOrderByClause("price asc");
                        }
                        if (sortType == 2) {
                            zhExample.setOrderByClause("price desc");
                            uygurExample.setOrderByClause("price desc");
                        }
                    } else {
                        zhExample.setOrderByClause("create_time desc");
                        uygurExample.setOrderByClause("create_time desc");
                    }

                    List<ParkingSpaceTransferDTO> zhParkingSpaceTransferDTOList = houseResourceDAO.parkingSpaceTransfer(zhPage, zhExample);
                    List<ParkingSpaceTransferDTO> uyParkingSpaceTransferDTOList = uygurHouseResourceDAO.parkingSpaceTransfer(uyPage, uygurExample);

                    zhPage = zhPage.setRecords(zhParkingSpaceTransferDTOList);
                    uyPage = uyPage.setRecords(uyParkingSpaceTransferDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
            }

        }
        return RestResponse.error();
    }


    @Override
    public RestResponse getMyShop(HttpServletRequest request, HouseKindQueryVO queryVO) {
        String userId = request.getHeader("User-Id");
        if (StringUtils.isNotBlank(userId)) {
            Page zhPage = new Page(queryVO.getPageNum(), queryVO.getPageSize());
            Page uyPage = new Page(queryVO.getPageNum(), queryVO.getPageSize());

            Map<String, Page> map = new HashMap<>();

            HouseResourceExample zhExample = new HouseResourceExample();
            HouseResourceExample.Criteria zhCriteria = zhExample.createCriteria();

            UygurHouseResourceExample uygurExample = new UygurHouseResourceExample();
            UygurHouseResourceExample.Criteria uygurCriteria = uygurExample.createCriteria();

            zhExample.setOrderByClause("create_time desc");
            uygurExample.setOrderByClause("create_time desc");
            zhCriteria.andBrokerIdEqualTo(Long.valueOf(userId));
            uygurCriteria.andBrokerIdEqualTo(Long.valueOf(userId));
            zhCriteria.andRecordStatusEqualTo(1);
            uygurCriteria.andRecordStatusEqualTo(1);
            zhCriteria.andSellStatusEqualTo(0);
            uygurCriteria.andSellStatusEqualTo(0);

            Integer propertyType = queryVO.getPropertyType();
            if (propertyType != null) {
                // 住宅 + 出售 + 新房 = 新房
                if (propertyType == 0) {
                    zhCriteria.andEstateTypeEqualTo(9);
                    uygurCriteria.andEstateTypeEqualTo(9);
                    List<NewHouseDTO> zhNewHouseDTOList = houseResourceDAO.newHouseQuery(zhPage, zhExample);
                    List<NewHouseDTO> uyNewHouseDTOList = uygurHouseResourceDAO.newHouseQuery(uyPage, uygurExample);

                    zhPage = zhPage.setRecords(zhNewHouseDTOList);
                    uyPage = uyPage.setRecords(uyNewHouseDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 住宅 + 出售 + 二手房 = 二手房
                if (propertyType == 1) {
                    zhCriteria.andEstateTypeEqualTo(10);
                    uygurCriteria.andEstateTypeEqualTo(10);
                    List<SecondHandHouseDTO> zhHecondHandHouseDTOList = houseResourceDAO.secondHouse(zhPage, zhExample);
                    List<SecondHandHouseDTO> uyHecondHandHouseDTOList = uygurHouseResourceDAO.secondHouse(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhHecondHandHouseDTOList);
                    uyPage = uyPage.setRecords(uyHecondHandHouseDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 住宅 + 出租 = 租房
                if (propertyType == 2) {
                    zhCriteria.andEstateTypeEqualTo(11);
                    uygurCriteria.andEstateTypeEqualTo(11);
                    List<RentHouseDTO> zhRentHouseDTOList = houseResourceDAO.rentHouse(zhPage, zhExample);
                    List<RentHouseDTO> uyRentHouseDTOList = uygurHouseResourceDAO.rentHouse(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhRentHouseDTOList);
                    uyPage = uyPage.setRecords(uyRentHouseDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 别墅
                if (propertyType == 3) {
                    zhCriteria.andEstateTypeEqualTo(1);
                    uygurCriteria.andEstateTypeEqualTo(1);
                    List<VillaDTO> zhVillaDTOList = houseResourceDAO.queryVilla(zhPage, zhExample);
                    List<VillaDTO> uyVillaDTOList = uygurHouseResourceDAO.queryVilla(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhVillaDTOList);
                    uyPage = uyPage.setRecords(uyVillaDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 商铺
                if (propertyType == 4) {
                    zhCriteria.andEstateTypeEqualTo(2);
                    uygurCriteria.andEstateTypeEqualTo(2);
                    List<ShopDTO> zhShopDTOList = houseResourceDAO.queryShop(zhPage, zhExample);
                    List<ShopDTO> uyShopDTOList = uygurHouseResourceDAO.queryShop(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhShopDTOList);
                    uyPage = uyPage.setRecords(uyShopDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 写字楼
                if (propertyType == 5) {
                    zhCriteria.andEstateTypeEqualTo(3);
                    uygurCriteria.andEstateTypeEqualTo(3);
                    List<OfficeHouseDTO> zhOfficeHouseDTOList = houseResourceDAO.queryOffice(zhPage, zhExample);
                    List<OfficeHouseDTO> uyOfficeHouseDTOList = uygurHouseResourceDAO.queryOffice(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhOfficeHouseDTOList);
                    uyPage = uyPage.setRecords(uyOfficeHouseDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 酒店
                if (propertyType == 6) {
                    zhCriteria.andEstateTypeEqualTo(4);
                    uygurCriteria.andEstateTypeEqualTo(4);
                    List<HotelDTO> zhHotelDTOList = houseResourceDAO.queryHotel(zhPage, zhExample);
                    List<HotelDTO> uyHotelDTOList = uygurHouseResourceDAO.queryHotel(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhHotelDTOList);
                    uyPage = uyPage.setRecords(uyHotelDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 厂房
                if (propertyType == 7) {
                    zhCriteria.andEstateTypeEqualTo(5);
                    uygurCriteria.andEstateTypeEqualTo(5);
                    List<WorkShopDTO> zhWorkShopDTOList = houseResourceDAO.queryWorkShop(zhPage, zhExample);
                    List<WorkShopDTO> uyWorkShopDTOList = uygurHouseResourceDAO.queryWorkShop(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhWorkShopDTOList);
                    uyPage = uyPage.setRecords(uyWorkShopDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 仓库
                if (propertyType == 8) {
                    zhCriteria.andEstateTypeEqualTo(6);
                    uygurCriteria.andEstateTypeEqualTo(6);
                    List<WareHouseDTO> zhWareHouseDTOList = houseResourceDAO.queryWareHouse(zhPage, zhExample);
                    List<WareHouseDTO> uyWareHouseDTOList = uygurHouseResourceDAO.queryWareHouse(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhWareHouseDTOList);
                    uyPage = uyPage.setRecords(uyWareHouseDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 土地转让
                if (propertyType == 9) {
                    zhCriteria.andEstateTypeEqualTo(7);
                    uygurCriteria.andEstateTypeEqualTo(7);
                    List<LandTransferDTO> zhLandTransferDTOList = houseResourceDAO.landTransfer(zhPage, zhExample);
                    List<LandTransferDTO> uyLandTransferDTOList = uygurHouseResourceDAO.landTransfer(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhLandTransferDTOList);
                    uyPage = uyPage.setRecords(uyLandTransferDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }
                // 车位
                if (propertyType == 10) {
                    zhCriteria.andEstateTypeEqualTo(8);
                    uygurCriteria.andEstateTypeEqualTo(8);
                    List<ParkingSpaceDTO> zhParkingSpaceDTOList = houseResourceDAO.queryParkingSpace(zhPage, zhExample);
                    List<ParkingSpaceDTO> uyParkingSpaceDTOList = uygurHouseResourceDAO.queryParkingSpace(uyPage, uygurExample);
                    zhPage = zhPage.setRecords(zhParkingSpaceDTOList);
                    uyPage = uyPage.setRecords(uyParkingSpaceDTOList);
                    map.put("zhPage", zhPage);
                    map.put("uyPage", uyPage);

                    return RestResponse.success(map);
                }

            }
        }
        return RestResponse.error();
    }

    /**
     *
     * @param request
     * @param id    当前记录id
     * @param estateType  0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位 9-新房 10-二手房 11-租房
     * @param useWay 用途 0-出租 1-出售 2-转让
     * @return
     */
    @Override
    public RestResponse getOneHouse(HttpServletRequest request, Long id, Integer estateType, Integer useWay) {
        String language = request.getHeader("Header-Language");
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        boolean favoriteStatus =false ;
        if (StringUtils.isNotEmpty(language) && id != null && estateType != null) {
            if ("wy".equals(language)) {
                // 新房
                if(StringUtils.isNotEmpty(userId)) {
                    FavoriteHouse favoriteHouse = favoriteHouseDAO.findByHouseIdAndUserIdLanguage(id, userId,"1");
                    favoriteStatus = favoriteHouse == null ? false : true;
                }
                if (estateType == 9) {
                    NewHouseDTO dto = uygurHouseResourceDAO.getNewHouseById(id);
                    dto.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(dto);
                }
                // 二手房
                if (estateType == 10) {
                    SecondHandHouseDTO dto = uygurHouseResourceDAO.getSecondHouseById(id);
                    dto.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(dto);
                }
                // 租房
                if (estateType == 11) {
                    RentHouseDTO rentHouseById = uygurHouseResourceDAO.getRentHouseById(id);
                    rentHouseById.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(rentHouseById);
                }
                // 别墅
//                0- 出租 1- 出售  2-转让
                if (estateType == 1) {
                    if (useWay == 0) {
                        VillaRentDTO villaRentById = uygurHouseResourceDAO.getVillaRentById(id);
                        villaRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(villaRentById);
                    }
                    if (useWay == 1) {
                        VillaSellDTO villaSellById = uygurHouseResourceDAO.getVillaSellById(id);
                        villaSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(villaSellById);
                    }
                }
                // 商铺
                if (estateType == 2) {
                    if (useWay == 0) {
                        ShopRentHouseDTO shopRentHouseById = uygurHouseResourceDAO.getShopRentHouseById(id);
                        shopRentHouseById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(shopRentHouseById);
                    }
                    if (useWay == 1) {
                        ShopSellHouseDTO shopSellHouseById = uygurHouseResourceDAO.getShopSellHouseById(id);
                        shopSellHouseById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(shopSellHouseById);
                    }
                    if (useWay == 2) {
                        ShopTransferHouseDTO shopTransferHouseById = uygurHouseResourceDAO.getShopTransferHouseById(id);
                        shopTransferHouseById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(shopTransferHouseById);
                    }
                }
                // 写字楼
                if (estateType == 3) {
                    if (useWay == 0) {
                        OfficeRentHouseDTO officeRentById = uygurHouseResourceDAO.getOfficeRentById(id);
                        officeRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(officeRentById);
                    }
                    if (useWay == 1) {
                        OfficeSellHouseDTO officeSellById = uygurHouseResourceDAO.getOfficeSellById(id);
                        officeSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(officeSellById);
                    }
                }
                // 酒店
                if (estateType == 4) {
                    if (useWay == 0) {
                        HotelRentDTO hotelRentById = uygurHouseResourceDAO.getHotelRentById(id);
                        hotelRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(hotelRentById);
                    }
                    if (useWay == 1) {
                        HotelSellDTO hotelSellById = uygurHouseResourceDAO.getHotelSellById(id);
                        hotelSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(hotelSellById);
                    }
                }
                // 厂房
                if (estateType == 5) {
                    if (useWay == 0) {
                        WorkShopRentDTO workShopRentById = uygurHouseResourceDAO.getWorkShopRentById(id);
                        workShopRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(workShopRentById);
                    }
                    if (useWay == 1) {
                        WorkShopSellDTO workShopSellById = uygurHouseResourceDAO.getWorkShopSellById(id);
                        workShopSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(workShopSellById);
                    }
                    if (useWay == 2) {
                        WorkShopTransferDTO workShopTransferById = uygurHouseResourceDAO.getWorkShopTransferById(id);
                        workShopTransferById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(workShopTransferById);
                    }
                }
                // 仓库
                if (estateType == 6) {
                    if (useWay == 0) {
                        WareHouseRentDTO wareHouseRentById = uygurHouseResourceDAO.getWareHouseRentById(id);
                        wareHouseRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(wareHouseRentById);
                    }
                    if (useWay == 1) {
                        WareHouseSellDTO wareHouseSellById = uygurHouseResourceDAO.getWareHouseSellById(id);
                        wareHouseSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(wareHouseSellById);
                    }
                    if (useWay == 2) {
                        WareHouseTransferDTO wareHouseTransferById = uygurHouseResourceDAO.getWareHouseTransferById(id);
                        wareHouseTransferById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(wareHouseTransferById);
                    }
                }
                // 土地转让
                if (estateType == 7) {
                    LandTransferDTO landTransferById = uygurHouseResourceDAO.getLandTransferById(id);
                    landTransferById.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(landTransferById);
                }
                // 车位
                if (estateType == 8) {
                    if (useWay == 0) {
                        ParkingSpaceRentDTO parkingSpaceRentById = uygurHouseResourceDAO.getParkingSpaceRentById(id);
                        parkingSpaceRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(parkingSpaceRentById);
                    }
                    if (useWay == 1) {
                        ParkingSpaceSellDTO parkingSpaceSellById = uygurHouseResourceDAO.getParkingSpaceSellById(id);
                        parkingSpaceSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(parkingSpaceSellById);
                    }
                    if (useWay == 2) {
                        ParkingSpaceTransferDTO parkingSpaceTransferById = uygurHouseResourceDAO.getParkingSpaceTransferById(id);
                        parkingSpaceTransferById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(parkingSpaceTransferById);
                    }
                }
            }
            if ("zh".equals(language)) {
                // 新房
                if(StringUtils.isNotEmpty(userId)) {
                    FavoriteHouse favoriteHouse = favoriteHouseDAO.findByHouseIdAndUserIdLanguage(id, userId,"1");
                    favoriteStatus = favoriteHouse == null ? false : true;
                }
                if (estateType == 9) {
                    NewHouseDTO newHouseById = houseResourceDAO.getNewHouseById(id);
                    newHouseById.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(newHouseById);
                }
                // 二手房
                if (estateType == 10) {
                    SecondHandHouseDTO secondHouseById = houseResourceDAO.getSecondHouseById(id);
                    secondHouseById.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(secondHouseById);
                }
                // 租房
                if (estateType == 11) {
                    RentHouseDTO rentHouseById = houseResourceDAO.getRentHouseById(id);
                    rentHouseById.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(rentHouseById);
                }
                // 别墅
//                0- 出租 1- 出售  2-转让
                if (estateType == 1) {
                    if (useWay == 0) {
                        VillaRentDTO villaRentById = houseResourceDAO.getVillaRentById(id);
                        villaRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(villaRentById);
                    }
                    if (useWay == 1) {
                        VillaSellDTO villaSellById = houseResourceDAO.getVillaSellById(id);
                        villaSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(villaSellById);
                    }
                }
                // 商铺
                if (estateType == 2) {
                    if (useWay == 0) {
                        ShopRentHouseDTO shopRentHouseById = houseResourceDAO.getShopRentHouseById(id);
                        shopRentHouseById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(shopRentHouseById);
                    }
                    if (useWay == 1) {
                        ShopSellHouseDTO shopSellHouseById = houseResourceDAO.getShopSellHouseById(id);
                        shopSellHouseById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(shopSellHouseById);
                    }
                    if (useWay == 2) {
                        ShopTransferHouseDTO shopTransferHouseById = houseResourceDAO.getShopTransferHouseById(id);
                        shopTransferHouseById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(shopTransferHouseById);
                    }
                }
                // 写字楼
                if (estateType == 3) {
                    if (useWay == 0) {
                        OfficeRentHouseDTO officeRentById = houseResourceDAO.getOfficeRentById(id);
                        officeRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(officeRentById);
                    }
                    if (useWay == 1) {
                        OfficeSellHouseDTO officeSellById = houseResourceDAO.getOfficeSellById(id);
                        officeSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(officeSellById);
                    }
                }
                // 酒店
                if (estateType == 4) {
                    if (useWay == 0) {
                        HotelRentDTO hotelRentById = houseResourceDAO.getHotelRentById(id);
                        hotelRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(hotelRentById);
                    }
                    if (useWay == 1) {
                        HotelSellDTO hotelSellById = houseResourceDAO.getHotelSellById(id);
                        hotelSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(hotelSellById);
                    }
                }
                // 厂房
                if (estateType == 5) {
                    if (useWay == 0) {
                        WorkShopRentDTO workShopRentById = houseResourceDAO.getWorkShopRentById(id);
                        workShopRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(workShopRentById);
                    }
                    if (useWay == 1) {
                        WorkShopSellDTO workShopSellById = houseResourceDAO.getWorkShopSellById(id);
                        workShopSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(workShopSellById);
                    }
                    if (useWay == 2) {
                        WorkShopTransferDTO workShopTransferById = houseResourceDAO.getWorkShopTransferById(id);
                        workShopTransferById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(workShopTransferById);
                    }
                }
                // 仓库
                if (estateType == 6) {
                    if (useWay == 0) {
                        WareHouseRentDTO wareHouseRentById = houseResourceDAO.getWareHouseRentById(id);
                        wareHouseRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(wareHouseRentById);
                    }
                    if (useWay == 1) {
                        WareHouseSellDTO wareHouseSellById = houseResourceDAO.getWareHouseSellById(id);
                        wareHouseSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(wareHouseSellById);
                    }
                    if (useWay == 2) {
                        WareHouseTransferDTO wareHouseTransferById = houseResourceDAO.getWareHouseTransferById(id);
                        wareHouseTransferById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(wareHouseTransferById);
                    }
                }
                // 土地转让
                if (estateType == 7) {
                    LandTransferDTO landTransferById = houseResourceDAO.getLandTransferById(id);
                    landTransferById.setFavoriteHouseStatus(favoriteStatus);
                    return RestResponse.success(landTransferById);
                }
                // 车位
                if (estateType == 8) {
                    if (useWay == 0) {
                        ParkingSpaceRentDTO parkingSpaceRentById = houseResourceDAO.getParkingSpaceRentById(id);
                        parkingSpaceRentById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(parkingSpaceRentById);
                    }
                    if (useWay == 1) {
                        ParkingSpaceSellDTO parkingSpaceSellById = houseResourceDAO.getParkingSpaceSellById(id);
                        parkingSpaceSellById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(parkingSpaceSellById);
                    }
                    if (useWay == 2) {
                        ParkingSpaceTransferDTO parkingSpaceTransferById = houseResourceDAO.getParkingSpaceTransferById(id);
                        parkingSpaceTransferById.setFavoriteHouseStatus(favoriteStatus);
                        return RestResponse.success(parkingSpaceTransferById);
                    }
                }
            }
        }
        return RestResponse.error();
    }

    /**
     * pc查询
     *
     * @param request
     * @param queryVO
     * @return
     */
    @Override
    public RestResponse pageQueryPc(HttpServletRequest request, HouseKindQueryVO queryVO) {
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("---->房源查询---->header={}", header);
        Page page = new Page(queryVO.getPageNum(), queryVO.getPageSize());

        HouseResourceExample zhExample = new HouseResourceExample();
        HouseResourceExample.Criteria zhCriteria = zhExample.createCriteria();

        UygurHouseResourceExample uygurExample = new UygurHouseResourceExample();
        UygurHouseResourceExample.Criteria uygurCriteria = uygurExample.createCriteria();

        // 市code和区code
        if (StringUtils.isNotBlank(queryVO.getRegionCode()) && StringUtils.isNotBlank(queryVO.getCityCode())) {
            zhCriteria.andCityCodeEqualTo(queryVO.getCityCode());
            zhCriteria.andRegionCodeEqualTo(queryVO.getRegionCode());
            uygurCriteria.andCityCodeEqualTo(queryVO.getCityCode());
            uygurCriteria.andAreaCodeEqualTo(queryVO.getRegionCode());
        }

        // 房屋x室
        if (queryVO.getHouseType() != null) {
            if (queryVO.getHouseType() != 5) {
                zhCriteria.andHouseTypeRoomEqualTo(queryVO.getHouseType());
                uygurCriteria.andHouseTypeRoomEqualTo(queryVO.getHouseType());
            } else {
                zhCriteria.andHouseTypeRoomGreaterThanOrEqualTo(queryVO.getHouseType());
                uygurCriteria.andHouseTypeRoomGreaterThanOrEqualTo(queryVO.getHouseType());
            }
        }
        // 面积
        if (StringUtils.isNotBlank(queryVO.getMinArea())) {
            zhCriteria.andHouseAreaGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinArea()));
            uygurCriteria.andHouseAreaGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinArea()));
        }
        if (StringUtils.isNotBlank(queryVO.getMaxArea())) {
            zhCriteria.andHouseAreaLessThanOrEqualTo(new BigDecimal(queryVO.getMaxArea()));
            uygurCriteria.andHouseAreaLessThanOrEqualTo(new BigDecimal(queryVO.getMaxArea()));
        }
        // 上架状态并且通过审核
        zhCriteria.andRecordStatusEqualTo(1);
        uygurCriteria.andRecordStatusEqualTo(1);
        zhCriteria.andSellStatusEqualTo(0);
        uygurCriteria.andSellStatusEqualTo(0);


        Integer sortType = queryVO.getSortType();
        // 排序方式
        if (sortType != null) {
            if (sortType == 1) {
                zhExample.setOrderByClause("price asc");
                uygurExample.setOrderByClause("price asc");
            }
            if (sortType == 2) {
                zhExample.setOrderByClause("price desc");
                uygurExample.setOrderByClause("price desc");
            }
            if (sortType == 3) {
                zhExample.setOrderByClause("open_date asc");
                uygurExample.setOrderByClause("open_date asc");
            }
            if (sortType == 4) {
                zhExample.setOrderByClause("open_date desc");
                uygurExample.setOrderByClause("open_date desc");
            }
            if (sortType == 5) {
                zhExample.setOrderByClause("average_price asc");
                uygurExample.setOrderByClause("average_price asc");
            }
            if (sortType == 6) {
                zhExample.setOrderByClause("average_price desc");
                uygurExample.setOrderByClause("average_price desc");
            }
            if (sortType == 7) {
                zhExample.setOrderByClause("house_area asc");
                uygurExample.setOrderByClause("house_area asc");
            }
            if (sortType == 8) {
                zhExample.setOrderByClause("house_area desc");
                uygurExample.setOrderByClause("house_area desc");
            }
            if (sortType == 9) {
                zhExample.setOrderByClause("monthly_rent asc");
                uygurExample.setOrderByClause("monthly_rent asc");
            }
            if (sortType == 10) {
                zhExample.setOrderByClause("monthly_rent desc");
                uygurExample.setOrderByClause("monthly_rent desc");
            }
        } else {
            zhExample.setOrderByClause("create_time desc");
            uygurExample.setOrderByClause("create_time desc");
        }

        Integer propertyType = queryVO.getPropertyType();

        // 如果是维语查询维语表
        if (StringUtils.isNotBlank(header)) {
            if ("wy".equals(header)) {
                // 房源分类

                if (propertyType != null) {
                    // 住宅 + 出售 + 新房 = 新房
                    if (propertyType == 0) {
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 即将开盘 在售楼盘
                        if (queryVO.getQueryType() != null) {
                            if (queryVO.getQueryType() == 0) {
                                uygurCriteria.andOpenDateGreaterThanOrEqualTo(new Date());
                            } else {
                                uygurCriteria.andOpenDateLessThanOrEqualTo(new Date());
                            }
                        }
                        zhCriteria.andEstateTypeEqualTo(9);
                        uygurCriteria.andEstateTypeEqualTo(9);

                        List<NewHouseDTO> uyNewHouseDTOList = uygurHouseResourceDAO.newHouseQuery(page, uygurExample);

                        page = page.setRecords(uyNewHouseDTOList);
                        return RestResponse.success(page);
                    }
                    // 住宅 + 出售 + 二手房 = 二手房
                    if (propertyType == 1) {
                        uygurCriteria.andEstateTypeEqualTo(10);
                        List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 房源特色
                        if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                            uygurCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        }

                        if (queryVO.getTowards() != null) {
                            uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                        }

                        if (queryVO.getElevator() != null) {
                            uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                        }
                        List<SecondHandHouseDTO> uySecondHandHouseDTOList = uygurHouseResourceDAO.secondHouse(page, uygurExample);

                        page = page.setRecords(uySecondHandHouseDTOList);

                        return RestResponse.success(page);
                    }
                    // 住宅 + 出租 = 租房
                    if (propertyType == 2) {
                        if (queryVO.getRentalType() != null) {
                            uygurCriteria.andRentalTypeEqualTo(queryVO.getRentalType());
                        }
                        uygurCriteria.andEstateTypeEqualTo(11);

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        List<RentHouseDTO> uyRentHouseDTOList = uygurHouseResourceDAO.rentHouse(page, uygurExample);

                        page = page.setRecords(uyRentHouseDTOList);


                        return RestResponse.success(page);
                    }
                    // 别墅
                    if (propertyType == 3) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(1);
                            // 别墅出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<VillaRentDTO> uyVillaRentDTOList = uygurHouseResourceDAO.villaRent(page, uygurExample);

                                page = page.setRecords(uyVillaRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 别墅出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<VillaSellDTO> uyVillaSellDTOList = uygurHouseResourceDAO.villaSell(page, uygurExample);

                                page = page.setRecords(uyVillaSellDTOList);

                                return RestResponse.success(page);
                            }
                        }

                    }
                    // 商铺
                    if (propertyType == 4) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(2);
                            // 商铺出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                List<ShopSellHouseDTO> uyShopSellHouseDTOList = uygurHouseResourceDAO.shopSell(page, uygurExample);

                                page = page.setRecords(uyShopSellHouseDTOList);

                                return RestResponse.success(page);
                            }
                            // 商铺转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<ShopTransferHouseDTO> uyShopTransferHouseDTOList = uygurHouseResourceDAO.shopTransfer(page, uygurExample);

                                page = page.setRecords(uyShopTransferHouseDTOList);

                                return RestResponse.success(page);
                            }
                            // 商铺出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<ShopRentHouseDTO> uyShopRentHouseDTOList = uygurHouseResourceDAO.shopRent(page, uygurExample);

                                page = page.setRecords(uyShopRentHouseDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 写字楼
                    if (propertyType == 5) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(3);
                            // 写字楼出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<OfficeRentHouseDTO> uyOfficeRentHouseDTOList = uygurHouseResourceDAO.officeRent(page, uygurExample);

                                page = page.setRecords(uyOfficeRentHouseDTOList);


                                return RestResponse.success(page);
                            }
                            // 写字楼出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<OfficeSellHouseDTO> uyOfficeSellHouseDTOList = uygurHouseResourceDAO.officeSell(page, uygurExample);

                                page = page.setRecords(uyOfficeSellHouseDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 酒店
                    if (propertyType == 6) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(4);
                            // 酒店出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<HotelRentDTO> uyHotelRentDTOList = uygurHouseResourceDAO.hotelRent(page, uygurExample);

                                page = page.setRecords(uyHotelRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 酒店出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                List<HotelSellDTO> uyHotelSellDTOList = uygurHouseResourceDAO.hotelSell(page, uygurExample);

                                page = page.setRecords(uyHotelSellDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 厂房
                    if (propertyType == 7) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(5);
                            // 厂房出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<WorkShopRentDTO> uyWorkShopRentDTOList = uygurHouseResourceDAO.workShopRent(page, uygurExample);
                                page = page.setRecords(uyWorkShopRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 厂房出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<WorkShopSellDTO> uyWorkShopSellDTOList = uygurHouseResourceDAO.workShopSell(page, uygurExample);

                                page = page.setRecords(uyWorkShopSellDTOList);

                                return RestResponse.success(page);
                            }
                            // 厂房转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WorkShopTransferDTO> uyWorkShopTransferDTOList = uygurHouseResourceDAO.workShopTransfer(page, uygurExample);

                                page = page.setRecords(uyWorkShopTransferDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 仓库
                    if (propertyType == 8) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andEstateTypeEqualTo(6);
                            // 仓库出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WareHouseRentDTO> uyWareHouseRentDTOList = uygurHouseResourceDAO.wareHouseRent(page, uygurExample);

                                page = page.setRecords(uyWareHouseRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 仓库出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<WareHouseSellDTO> uyWareHouseSellDTOList = uygurHouseResourceDAO.wareHouseSell(page, uygurExample);

                                page = page.setRecords(uyWareHouseSellDTOList);

                                return RestResponse.success(page);
                            }
                            // 仓库转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WareHouseTransferDTO> uyWareHouseTransferDTOList = uygurHouseResourceDAO.wareHouseTransfer(page, uygurExample);

                                page = page.setRecords(uyWareHouseTransferDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 土地转让
                    if (propertyType == 9) {
                        uygurCriteria.andEstateTypeEqualTo(7);

                        List<LandTransferDTO> uyLandTransferDTOList = uygurHouseResourceDAO.landTransfer(page, uygurExample);

                        page = page.setRecords(uyLandTransferDTOList);

                        return RestResponse.success(page);
                    }
                    // 车位
                    if (propertyType == 10) {
                        uygurCriteria.andEstateTypeEqualTo(8);
                        // 出租
                        if (queryVO.getUseWay() == 0) {
                            List<ParkingSpaceRentDTO> uyParkingSpaceRentDTOList = uygurHouseResourceDAO.parkingSpaceRent(page, uygurExample);

                            page = page.setRecords(uyParkingSpaceRentDTOList);

                            return RestResponse.success(page);
                        }
                        // 出售
                        if (queryVO.getUseWay() == 1) {
                            List<ParkingSpaceSellDTO> uyParkingSpaceSellDTOList = uygurHouseResourceDAO.parkingSpaceSell(page, uygurExample);
                            page = page.setRecords(uyParkingSpaceSellDTOList);
                            return RestResponse.success(page);
                        }
                        // 转让
                        if (queryVO.getUseWay() == 2) {
                            if (queryVO.getMinPrice() != null) {
                                uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                            }
                            if (queryVO.getMaxPrice() != null) {
                                uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                            }
                            List<ParkingSpaceTransferDTO> uyParkingSpaceTransferDTOList = uygurHouseResourceDAO.parkingSpaceTransfer(page, uygurExample);
                            page = page.setRecords(uyParkingSpaceTransferDTOList);
                            return RestResponse.success(page);
                        }
                    }
                }
            }
            if ("zh".equals(header)) {

                if (propertyType != null) {
                    // 住宅 + 出售 + 新房 = 新房
                    if (propertyType == 0) {
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 即将开盘 在售楼盘
                        if (queryVO.getQueryType() != null) {
                            if (queryVO.getQueryType() == 0) {
                                zhCriteria.andOpenDateGreaterThanOrEqualTo(new Date());
                            } else {
                                zhCriteria.andOpenDateLessThanOrEqualTo(new Date());
                            }
                        }
                        zhCriteria.andEstateTypeEqualTo(9);

                        List<NewHouseDTO> newHouseDTOList = houseResourceDAO.newHouseQuery(page, zhExample);

                        page = page.setRecords(newHouseDTOList);

                        return RestResponse.success(page);
                    }
                    // 住宅 + 出售 + 二手房 = 二手房
                    if (propertyType == 1) {
                        zhCriteria.andEstateTypeEqualTo(10);
                        List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 房源特色
                        if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                            zhCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        }

                        if (queryVO.getTowards() != null) {
                            zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                        }

                        if (queryVO.getElevator() != null) {
                            zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                        }
                        List<SecondHandHouseDTO> zhSecondHandHouseDTOList = houseResourceDAO.secondHouse(page, zhExample);

                        page = page.setRecords(zhSecondHandHouseDTOList);

                        return RestResponse.success(page);
                    }
                    // 住宅 + 出租 = 租房
                    if (propertyType == 2) {
                        if (queryVO.getRentalType() != null) {
                            zhCriteria.andRentalTypeEqualTo(queryVO.getRentalType());
                        }
                        zhCriteria.andEstateTypeEqualTo(11);

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        List<RentHouseDTO> zhRentHouseDTOList = houseResourceDAO.rentHouse(page, zhExample);

                        page = page.setRecords(zhRentHouseDTOList);


                        return RestResponse.success(page);
                    }
                    // 别墅
                    if (propertyType == 3) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(1);
                            // 别墅出租
                            if (queryVO.getUseWay() == 0) {
                                List<VillaRentDTO> zhVillaRentDTOList = houseResourceDAO.villaRent(page, zhExample);

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                page = page.setRecords(zhVillaRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 别墅出售
                            if (queryVO.getUseWay() == 1) {
                                List<VillaSellDTO> zhVillaSellDTOList = houseResourceDAO.villaSell(page, zhExample);

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                page = page.setRecords(zhVillaSellDTOList);

                                return RestResponse.success(page);
                            }
                        }

                    }
                    // 商铺
                    if (propertyType == 4) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(2);
                            // 商铺出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<ShopSellHouseDTO> zhShopSellHouseDTOList = houseResourceDAO.shopSell(page, zhExample);

                                page = page.setRecords(zhShopSellHouseDTOList);

                                return RestResponse.success(page);
                            }
                            // 商铺转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<ShopTransferHouseDTO> zhShopTransferHouseDTOList = houseResourceDAO.shopTransfer(page, zhExample);

                                page = page.setRecords(zhShopTransferHouseDTOList);

                                return RestResponse.success(page);
                            }
                            // 商铺出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<ShopRentHouseDTO> zhShopRentHouseDTOList = houseResourceDAO.shopRent(page, zhExample);

                                page = page.setRecords(zhShopRentHouseDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 写字楼
                    if (propertyType == 5) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(3);
                            // 写字楼出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<OfficeRentHouseDTO> zhOfficeRentHouseDTOList = houseResourceDAO.officeRent(page, zhExample);

                                page = page.setRecords(zhOfficeRentHouseDTOList);

                                return RestResponse.success(page);
                            }
                            // 写字楼出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<OfficeSellHouseDTO> zhOfficeSellHouseDTOList = houseResourceDAO.officeSell(page, zhExample);

                                page = page.setRecords(zhOfficeSellHouseDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 酒店
                    if (propertyType == 6) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(4);
                            // 酒店出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<HotelRentDTO> zhHotelRentDTOList = houseResourceDAO.hotelRent(page, zhExample);

                                page = page.setRecords(zhHotelRentDTOList);


                                return RestResponse.success(page);
                            }
                            // 酒店出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<HotelSellDTO> zhHotelSellDTOList = houseResourceDAO.hotelSell(page, zhExample);

                                page = page.setRecords(zhHotelSellDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 厂房
                    if (propertyType == 7) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(5);
                            // 厂房出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WorkShopRentDTO> zhWorkShopRentDTOList = houseResourceDAO.workShopRent(page, zhExample);

                                page = page.setRecords(zhWorkShopRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 厂房出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<WorkShopSellDTO> zhWorkShopSellDTOList = houseResourceDAO.workShopSell(page, zhExample);

                                page = page.setRecords(zhWorkShopSellDTOList);

                                return RestResponse.success(page);
                            }
                            // 厂房转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WorkShopTransferDTO> zhWorkShopTransferDTOList = houseResourceDAO.workShopTransfer(page, zhExample);

                                page = page.setRecords(zhWorkShopTransferDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 仓库
                    if (propertyType == 8) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andEstateTypeEqualTo(6);
                            // 仓库出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WareHouseRentDTO> zhWareHouseRentDTOList = houseResourceDAO.wareHouseRent(page, zhExample);
                                page = page.setRecords(zhWareHouseRentDTOList);

                                return RestResponse.success(page);
                            }
                            // 仓库出售
                            if (queryVO.getUseWay() == 1) {


                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                List<WareHouseSellDTO> zhWareHouseSellDTOList = houseResourceDAO.wareHouseSell(page, zhExample);
                                page = page.setRecords(zhWareHouseSellDTOList);

                                return RestResponse.success(page);
                            }
                            // 仓库转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                List<WareHouseTransferDTO> zhWareHouseTransferDTOList = houseResourceDAO.wareHouseTransfer(page, zhExample);

                                page = page.setRecords(zhWareHouseTransferDTOList);

                                return RestResponse.success(page);
                            }
                        }
                    }
                    // 土地转让
                    if (propertyType == 9) {
                        zhCriteria.andEstateTypeEqualTo(7);

                        List<LandTransferDTO> zhLandTransferDTOList = houseResourceDAO.landTransfer(page, zhExample);

                        page = page.setRecords(zhLandTransferDTOList);

                        return RestResponse.success(page);
                    }
                    // 车位
                    if (propertyType == 10) {
                        zhCriteria.andEstateTypeEqualTo(8);
                        // 出租
                        if (queryVO.getUseWay() == 0) {
                            List<ParkingSpaceRentDTO> zhParkingSpaceRentDTOList = houseResourceDAO.parkingSpaceRent(page, zhExample);

                            page = page.setRecords(zhParkingSpaceRentDTOList);
                            return RestResponse.success(page);
                        }
                        // 出售
                        if (queryVO.getUseWay() == 1) {
                            List<ParkingSpaceSellDTO> zhParkingSpaceSellDTOList = houseResourceDAO.parkingSpaceSell(page, zhExample);

                            page = page.setRecords(zhParkingSpaceSellDTOList);

                            return RestResponse.success(page);
                        }
                        // 转让
                        if (queryVO.getUseWay() == 2) {
                            List<ParkingSpaceTransferDTO> zhParkingSpaceTransferDTOList = houseResourceDAO.parkingSpaceTransfer(page, zhExample);

                            page = page.setRecords(zhParkingSpaceTransferDTOList);

                            return RestResponse.success(page);
                        }
                    }

                }
            }
        }
        return RestResponse.error();
    }

    /**
     * 删除房源修改为
     *
     * @param signLabel
     * @return
     */
    @Override
    public RestResponse deleteHouse(String signLabel) {
        HouseResource houseResource = houseResourceDAO.getBySignLabel(signLabel);
        UygurHouseResource uygurHouseResource = uygurHouseResourceDAO.getBySignLabel(signLabel);
        if (houseResource == null || uygurHouseResource == null) {
            return RestResponse.error("信息不存在");
        }
        houseResource.setSellStatus(1);
        uygurHouseResource.setSellStatus(1);
        houseResourceDAO.updateByPrimaryKeySelective(houseResource);
        uygurHouseResourceDAO.updateByPrimaryKeySelective(uygurHouseResource);
        //删除ES中的房源
        houseDocRepository.deleteById(houseResource.getId());
        uyHouseDocRepository.deleteById(uygurHouseResource.getId());
        //house数量减1
        houseCountSV.subAccountByType(houseResource.getEstateType()+"",houseResource.getRegionCode());
        // 清空redis
        deleteRedisHomePageHouse(10);
        deleteRedisHomePageHouse(2);
        deleteRedisHomePageHouse(11);

        return RestResponse.success("删除成功");
    }


    /**
     * 10-二手房 2-商铺 11-租房
     * @param request
     * @return
     */
    @Override
    public RestResponse homePage(HttpServletRequest request) {
        String language = request.getHeader("Header-Language");
        String device = request.getHeader("Device-Header");
        if (StringUtils.isNotBlank(language) && StringUtils.isNotBlank(device)) {
            HomePageVO homePage = new HomePageVO();
            HomePageUyVO homePageUyVO = new HomePageUyVO();
            // pc || app 维语
            if ("wy".equals(language)) {
                if ("pc".equals(device)) {
                    List<UygurHouseResource> uygurHouseResourceSecondPC = homePageWy("pc", 10);
                    List<UygurHouseResource> uygurHouseResourceShopPC = homePageWy("pc", 2);
                    List<UygurHouseResource> uygurHouseResourceRentPC = homePageWy("pc", 11);

                    homePageUyVO.setHomePageForSecondHouse(uygurHouseResourceSecondPC);
                    homePageUyVO.setHomePageForShop(uygurHouseResourceShopPC);
                    homePageUyVO.setHomePageForRentHouse(uygurHouseResourceRentPC);
                    return RestResponse.success(homePageUyVO);
                }
                if ("app".equals(device)) {
                    List<UygurHouseResource> uygurHouseResourceSecondAPP = homePageWy("app", 10);
                    List<UygurHouseResource> uygurHouseResourceShopAPP = homePageWy("app", 2);
                    List<UygurHouseResource> uygurHouseResourceRentAPP = homePageWy("app", 11);

                    homePageUyVO.setHomePageForSecondHouse(uygurHouseResourceSecondAPP);
                    homePageUyVO.setHomePageForShop(uygurHouseResourceShopAPP);
                    homePageUyVO.setHomePageForRentHouse(uygurHouseResourceRentAPP);
                    return RestResponse.success(homePageUyVO);
                }
            }
            // pc || app 中文
            if ("zh".equals(language)) {
                if ("pc".equals(device)) {
                    List<HouseResource> houseResourceSecondPC = homePageZh("pc", 10);
                    List<HouseResource> houseResourceShopPC = homePageZh("pc", 2);
                    List<HouseResource> houseResourceRentPC = homePageZh("pc", 11);

                    homePage.setHomePageForSecondHouse(houseResourceSecondPC);
                    homePage.setHomePageForShop(houseResourceShopPC);
                    homePage.setHomePageForRentHouse(houseResourceRentPC);
                    return RestResponse.success(homePage);
                }
                if ("app".equals(device)) {
                    List<HouseResource> houseResourceSecondAPP = homePageZh("app", 10);
                    List<HouseResource> houseResourceShopAPP = homePageZh("app", 2);
                    List<HouseResource> houseResourceRentAPP = homePageZh("app", 11);
                    homePage.setHomePageForSecondHouse(houseResourceSecondAPP);
                    homePage.setHomePageForShop(houseResourceShopAPP);
                    homePage.setHomePageForRentHouse(houseResourceRentAPP);
                    return RestResponse.success(homePage);
                }
            }
        }
        return RestResponse.error("未指定类型");
    }

    @Override
    public RestResponse getCount() {
        Integer uncheckedCountHouseResource = houseResourceDAO.getUncheckedCount();
        Integer uncheckedCountUserHouse = userHouseDAO.getUncheckedCount();
        Integer uncheckedCountBroker = brokerDAO.getUncheckedCount();
        Integer[] unchecked = new Integer[]{uncheckedCountUserHouse, uncheckedCountBroker, uncheckedCountHouseResource};
        return RestResponse.success(unchecked);
    }

    @Override
    public RestResponse pageQueryByLanguage(HttpServletRequest request, HouseKindQueryVO queryVO) {
        String language = request.getHeader("Header-Language");
        if (StringUtils.isNotBlank(language)) {

            if ("zh".equals(language)) {
                Page zhPage = new Page(queryVO.getPageNum(), queryVO.getPageSize());
                HouseResourceExample zhExample = new HouseResourceExample();
                HouseResourceExample.Criteria zhCriteria = zhExample.createCriteria();

                // 市code和区code
                if (StringUtils.isNotBlank(queryVO.getRegionCode()) && StringUtils.isNotBlank(queryVO.getCityCode())) {
                    zhCriteria.andCityCodeEqualTo(queryVO.getCityCode());
                    zhCriteria.andRegionCodeEqualTo(queryVO.getRegionCode());
                }

                // 房屋x室
                if (queryVO.getHouseType() != null) {
                    if (queryVO.getHouseType() != 5) {
                        zhCriteria.andHouseTypeRoomEqualTo(queryVO.getHouseType());
                    } else {
                        zhCriteria.andHouseTypeRoomGreaterThanOrEqualTo(queryVO.getHouseType());
                    }
                }
                // 面积
                if (StringUtils.isNotBlank(queryVO.getMinArea())) {
                    zhCriteria.andHouseAreaGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinArea()));
                }
                if (StringUtils.isNotBlank(queryVO.getMaxArea())) {
                    zhCriteria.andHouseAreaLessThanOrEqualTo(new BigDecimal(queryVO.getMaxArea()));
                }
                // 上架状态并且通过审核
                zhCriteria.andRecordStatusEqualTo(1);
                zhCriteria.andSellStatusEqualTo(0);

                Integer sortType = queryVO.getSortType();

                // 房源分类
                Integer propertyType = queryVO.getPropertyType();
                if (propertyType != null) {
                    // 住宅 + 出售 + 新房 = 新房
                    if (propertyType == 0) {
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 即将开盘 在售楼盘
                        if (queryVO.getQueryType() != null) {
                            if (queryVO.getQueryType() == 0) {
                                zhCriteria.andOpenDateGreaterThanOrEqualTo(new Date());
                            } else {
                                zhCriteria.andOpenDateLessThanOrEqualTo(new Date());
                            }
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("price desc");
                            }
                            if (sortType == 3) {
                                zhExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                zhExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                        }
                        zhCriteria.andEstateTypeEqualTo(9);

                        List<NewHouseDTO> newHouseDTOList = houseResourceDAO.newHouseQuery(zhPage, zhExample);

                        zhPage = zhPage.setRecords(newHouseDTOList);

                        return RestResponse.success(zhPage);
                    }
                    // 住宅 + 出售 + 二手房 = 二手房
                    if (propertyType == 1) {
                        zhCriteria.andEstateTypeEqualTo(10);
                        List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }

                        // 房源特色
                        if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                            zhCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        }

                        // 装修类型
                        if (queryVO.getDecorationType() != null) {
                            zhCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                        }
                        // 楼层
                        if (queryVO.getFloorType() != null) {
                            zhCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                        }
                        // 朝向
                        if (queryVO.getTowards() != null) {
                            zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                        }
                        // 配备电梯
                        if (queryVO.getElevator() != null) {
                            zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("average_price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("average_price desc");
                            }
                            if (sortType == 3) {
                                zhExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                zhExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                        }

                        List<SecondHandHouseDTO> zhSecondHandHouseDTOList = houseResourceDAO.secondHouse(zhPage, zhExample);

                        zhPage = zhPage.setRecords(zhSecondHandHouseDTOList);

                        return RestResponse.success(zhPage);
                    }
                    // 住宅 + 出租 = 租房
                    if (propertyType == 2) {
                        if (queryVO.getRentalType() != null) {
                            zhCriteria.andRentalTypeEqualTo(queryVO.getRentalType());
                        }
                        zhCriteria.andEstateTypeEqualTo(11);

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }

                        // 装修类型
                        if (queryVO.getDecorationType() != null) {
                            zhCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                        }
                        // 楼层
                        if (queryVO.getFloorType() != null) {
                            zhCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                        }
                        // 朝向
                        if (queryVO.getTowards() != null) {
                            zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                        }
                        // 配备电梯
                        if (queryVO.getElevator() != null) {
                            zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                        }
                        List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                        // 房源特色
                        if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                            zhCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("monthly_rent desc");
                            }
                            if (sortType == 3) {
                                zhExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                zhExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                        }

                        List<RentHouseDTO> zhRentHouseDTOList = houseResourceDAO.rentHouse(zhPage, zhExample);

                        zhPage = zhPage.setRecords(zhRentHouseDTOList);

                        return RestResponse.success(zhPage);
                    }
                    // 别墅
                    if (propertyType == 3) {
                        if (queryVO.getUseWay() != null) {
                            // 装修类型
                            if (queryVO.getDecorationType() != null) {
                                zhCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                            }
                            // 楼层
                            if (queryVO.getFloorType() != null) {
                                zhCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                            }
                            // 朝向
                            if (queryVO.getTowards() != null) {
                                zhCriteria.andTowardsEqualTo(queryVO.getTowards());
                            }
                            // 配备电梯
                            if (queryVO.getElevator() != null) {
                                zhCriteria.andElevatorEqualTo(queryVO.getElevator());
                            }
                            List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                            // 房源特色
                            if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                                zhCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                            }

                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(1);
                            // 别墅出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                    if (sortType == 3) {
                                        zhExample.setOrderByClause("open_date asc");
                                    }
                                    if (sortType == 4) {
                                        zhExample.setOrderByClause("open_date desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<VillaRentDTO> zhVillaRentDTOList = houseResourceDAO.villaRent(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhVillaRentDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 别墅出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                    if (sortType == 3) {
                                        zhExample.setOrderByClause("open_date asc");
                                    }
                                    if (sortType == 4) {
                                        zhExample.setOrderByClause("open_date desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<VillaSellDTO> zhVillaSellDTOList = houseResourceDAO.villaSell(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhVillaSellDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }

                    }
                    // 商铺
                    if (propertyType == 4) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(2);
                            // 商铺出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<ShopSellHouseDTO> zhShopSellHouseDTOList = houseResourceDAO.shopSell(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhShopSellHouseDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 商铺转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<ShopTransferHouseDTO> zhShopTransferHouseDTOList = houseResourceDAO.shopTransfer(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhShopTransferHouseDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 商铺出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<ShopRentHouseDTO> zhShopRentHouseDTOList = houseResourceDAO.shopRent(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhShopRentHouseDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }
                    }
                    // 写字楼
                    if (propertyType == 5) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(3);
                            // 写字楼出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<OfficeRentHouseDTO> zhOfficeRentHouseDTOList = houseResourceDAO.officeRent(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhOfficeRentHouseDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 写字楼出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<OfficeSellHouseDTO> zhOfficeSellHouseDTOList = houseResourceDAO.officeSell(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhOfficeSellHouseDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }
                    }
                    // 酒店
                    if (propertyType == 6) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(4);
                            // 酒店出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }
                                List<HotelRentDTO> zhHotelRentDTOList = houseResourceDAO.hotelRent(zhPage, zhExample);


                                zhPage = zhPage.setRecords(zhHotelRentDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 酒店出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }
                                List<HotelSellDTO> zhHotelSellDTOList = houseResourceDAO.hotelSell(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhHotelSellDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }
                    }
                    // 厂房
                    if (propertyType == 7) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(5);
                            // 厂房出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<WorkShopRentDTO> zhWorkShopRentDTOList = houseResourceDAO.workShopRent(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhWorkShopRentDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 厂房出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }
                                List<WorkShopSellDTO> zhWorkShopSellDTOList = houseResourceDAO.workShopSell(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhWorkShopSellDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 厂房转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }
                                List<WorkShopTransferDTO> zhWorkShopTransferDTOList = houseResourceDAO.workShopTransfer(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhWorkShopTransferDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }
                    }
                    // 仓库
                    if (propertyType == 8) {
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            zhCriteria.andEstateTypeEqualTo(6);
                            // 仓库出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }
                                List<WareHouseRentDTO> zhWareHouseRentDTOList = houseResourceDAO.wareHouseRent(zhPage, zhExample);
                                zhPage = zhPage.setRecords(zhWareHouseRentDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 仓库出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }
                                List<WareHouseSellDTO> zhWareHouseSellDTOList = houseResourceDAO.wareHouseSell(zhPage, zhExample);
                                zhPage = zhPage.setRecords(zhWareHouseSellDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 仓库转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<WareHouseTransferDTO> zhWareHouseTransferDTOList = houseResourceDAO.wareHouseTransfer(zhPage, zhExample);
                                zhPage = zhPage.setRecords(zhWareHouseTransferDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }
                    }
                    // 土地转让
                    if (propertyType == 9) {
                        zhCriteria.andEstateTypeEqualTo(7);

                        if (queryVO.getMinPrice() != null) {
                            zhCriteria.andTransferPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }

                        if (queryVO.getMaxPrice() != null) {
                            zhCriteria.andTransferPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                zhExample.setOrderByClause("transfer_price asc");
                            }
                            if (sortType == 2) {
                                zhExample.setOrderByClause("transfer_price desc");
                            }
                        } else {
                            zhExample.setOrderByClause("create_time desc");
                        }


                        List<LandTransferDTO> zhLandTransferDTOList = houseResourceDAO.landTransfer(zhPage, zhExample);

                        zhPage = zhPage.setRecords(zhLandTransferDTOList);

                        return RestResponse.success(zhPage);
                    }
                    // 车位
                    if (propertyType == 10) {
                        zhCriteria.andEstateTypeEqualTo(8);
                        if (queryVO.getUseWay() != null) {
                            zhCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            // 出租
                            if (queryVO.getUseWay() == 0) {
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<ParkingSpaceRentDTO> zhParkingSpaceRentDTOList = houseResourceDAO.parkingSpaceRent(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhParkingSpaceRentDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 出售
                            if (queryVO.getUseWay() == 1) {

                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<ParkingSpaceSellDTO> zhParkingSpaceSellDTOList = houseResourceDAO.parkingSpaceSell(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhParkingSpaceSellDTOList);

                                return RestResponse.success(zhPage);
                            }
                            // 转让
                            if (queryVO.getUseWay() == 2) {
                                if (queryVO.getMinPrice() != null) {
                                    zhCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                if (queryVO.getMaxPrice() != null) {
                                    zhCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        zhExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        zhExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    zhExample.setOrderByClause("create_time desc");
                                }

                                List<ParkingSpaceTransferDTO> zhParkingSpaceTransferDTOList = houseResourceDAO.parkingSpaceTransfer(zhPage, zhExample);

                                zhPage = zhPage.setRecords(zhParkingSpaceTransferDTOList);

                                return RestResponse.success(zhPage);
                            }
                        }
                    }

                }
            }

            if ("wy".equals(language)) {
                Page uyPage = new Page(queryVO.getPageNum(), queryVO.getPageSize());
                UygurHouseResourceExample uygurExample = new UygurHouseResourceExample();
                UygurHouseResourceExample.Criteria uygurCriteria = uygurExample.createCriteria();

                // 市code和区code
                if (StringUtils.isNotBlank(queryVO.getRegionCode()) && StringUtils.isNotBlank(queryVO.getCityCode())) {
                    uygurCriteria.andCityCodeEqualTo(queryVO.getCityCode());
                    uygurCriteria.andRegionCodeEqualTo(queryVO.getRegionCode());
                }

                // 房屋x室
                if (queryVO.getHouseType() != null) {
                    if (queryVO.getHouseType() != 5) {
                        uygurCriteria.andHouseTypeRoomEqualTo(queryVO.getHouseType());
                    } else {
                        uygurCriteria.andHouseTypeRoomGreaterThanOrEqualTo(queryVO.getHouseType());
                    }
                }
                // 面积
                if (StringUtils.isNotBlank(queryVO.getMinArea())) {
                    uygurCriteria.andHouseAreaGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinArea()));
                }
                if (StringUtils.isNotBlank(queryVO.getMaxArea())) {
                    uygurCriteria.andHouseAreaLessThanOrEqualTo(new BigDecimal(queryVO.getMaxArea()));
                }
                // 上架状态并且通过审核
                uygurCriteria.andRecordStatusEqualTo(1);
                uygurCriteria.andSellStatusEqualTo(0);

                Integer sortType = queryVO.getSortType();

                // 房源分类
                Integer propertyType = queryVO.getPropertyType();
                if (propertyType != null) {
                    // 住宅 + 出售 + 新房 = 新房
                    if (propertyType == 0) {
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 即将开盘 在售楼盘
                        if (queryVO.getQueryType() != null) {
                            if (queryVO.getQueryType() == 0) {
                                uygurCriteria.andOpenDateGreaterThanOrEqualTo(new Date());
                            } else {
                                uygurCriteria.andOpenDateLessThanOrEqualTo(new Date());
                            }
                        }
                        if (sortType != null) {
                            if (sortType == 1) {
                                uygurExample.setOrderByClause("price asc");
                            }
                            if (sortType == 2) {
                                uygurExample.setOrderByClause("price desc");
                            }
                            if (sortType == 3) {
                                uygurExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                uygurExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            uygurExample.setOrderByClause("create_time desc");
                        }
                        uygurCriteria.andEstateTypeEqualTo(9);

                        List<NewHouseDTO> uyNewHouseDTOList = uygurHouseResourceDAO.newHouseQuery(uyPage, uygurExample);

                        uyPage = uyPage.setRecords(uyNewHouseDTOList);

                        return RestResponse.success(uyPage);
                    }
                    // 住宅 + 出售 + 二手房 = 二手房
                    if (propertyType == 1) {
                        uygurCriteria.andEstateTypeEqualTo(10);
                        List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                        // 最小售价
                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }
                        // 最大售价
                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }
                        // 房源特色
                        if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                            uygurCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        }

                        // 装修类型
                        if (queryVO.getDecorationType() != null) {
                            uygurCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                        }
                        // 楼层
                        if (queryVO.getFloorType() != null) {
                            uygurCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                        }
                        // 朝向
                        if (queryVO.getTowards() != null) {
                            uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                        }
                        // 配备电梯
                        if (queryVO.getElevator() != null) {
                            uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                uygurExample.setOrderByClause("average_price asc");
                            }
                            if (sortType == 2) {
                                uygurExample.setOrderByClause("average_price desc");
                            }
                            if (sortType == 3) {
                                uygurExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                uygurExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<SecondHandHouseDTO> uySecondHandHouseDTOList = uygurHouseResourceDAO.secondHouse(uyPage, uygurExample);

                        uyPage = uyPage.setRecords(uySecondHandHouseDTOList);

                        return RestResponse.success(uyPage);
                    }
                    // 住宅 + 出租 = 租房
                    if (propertyType == 2) {
                        if (queryVO.getRentalType() != null) {
                            uygurCriteria.andRentalTypeEqualTo(queryVO.getRentalType());
                        }
                        uygurCriteria.andEstateTypeEqualTo(11);

                        // 最小租金
                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                        }
                        // 最大租金
                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                        }
                        // 装修类型
                        if (queryVO.getDecorationType() != null) {
                            uygurCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                        }
                        // 楼层
                        if (queryVO.getFloorType() != null) {
                            uygurCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                        }
                        // 朝向
                        if (queryVO.getTowards() != null) {
                            uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                        }
                        // 配备电梯
                        if (queryVO.getElevator() != null) {
                            uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                        }

                        List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                        // 房源特色
                        if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                            uygurCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                uygurExample.setOrderByClause("monthly_rent asc");
                            }
                            if (sortType == 2) {
                                uygurExample.setOrderByClause("monthly_rent desc");
                            }
                            if (sortType == 3) {
                                uygurExample.setOrderByClause("open_date asc");
                            }
                            if (sortType == 4) {
                                uygurExample.setOrderByClause("open_date desc");
                            }
                        } else {
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<RentHouseDTO> uyRentHouseDTOList = uygurHouseResourceDAO.rentHouse(uyPage, uygurExample);

                        uyPage = uyPage.setRecords(uyRentHouseDTOList);

                        return RestResponse.success(uyPage);
                    }
                    // 别墅
                    if (propertyType == 3) {
                        if (queryVO.getUseWay() != null) {
                            // 装修类型
                            if (queryVO.getDecorationType() != null) {
                                uygurCriteria.andDecorationTypeEqualTo(queryVO.getDecorationType());
                            }
                            // 楼层
                            if (queryVO.getFloorType() != null) {
                                uygurCriteria.andFloorTypeEqualTo(queryVO.getFloorType());
                            }
                            // 朝向
                            if (queryVO.getTowards() != null) {
                                uygurCriteria.andTowardsEqualTo(queryVO.getTowards());
                            }
                            // 配备电梯
                            if (queryVO.getElevator() != null) {
                                uygurCriteria.andElevatorEqualTo(queryVO.getElevator());
                            }
                            List<String> listingFeaturesIds = queryVO.getListingFeaturesIds();
                            // 房源特色
                            if (listingFeaturesIds != null && listingFeaturesIds.size() > 0) {
                                uygurCriteria.orListingFeaturesIdsLike(listingFeaturesIds);
                            }

                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(1);
                            // 别墅出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                    if (sortType == 3) {
                                        uygurExample.setOrderByClause("open_date asc");
                                    }
                                    if (sortType == 4) {
                                        uygurExample.setOrderByClause("open_date desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<VillaRentDTO> uyVillaRentDTOList = uygurHouseResourceDAO.villaRent(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyVillaRentDTOList);

                                return RestResponse.success(uyPage);
                            }
                            // 别墅出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                    if (sortType == 3) {
                                        uygurExample.setOrderByClause("open_date asc");
                                    }
                                    if (sortType == 4) {
                                        uygurExample.setOrderByClause("open_date desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<VillaSellDTO> uyVillaSellDTOList = uygurHouseResourceDAO.villaSell(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyVillaSellDTOList);

                                return RestResponse.success(uyPage);
                            }
                        }

                    }
                    // 商铺
                    if (propertyType == 4) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(2);
                            // 商铺出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<ShopSellHouseDTO> uyShopSellHouseDTOList = uygurHouseResourceDAO.shopSell(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyShopSellHouseDTOList);
                                return RestResponse.success(uyPage);
                            }
                            // 商铺转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<ShopTransferHouseDTO> uyShopTransferHouseDTOList = uygurHouseResourceDAO.shopTransfer(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyShopTransferHouseDTOList);

                                return RestResponse.success(uyPage);
                            }
                            // 商铺出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<ShopRentHouseDTO> uyShopRentHouseDTOList = uygurHouseResourceDAO.shopRent(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyShopRentHouseDTOList);
                                return RestResponse.success(uyPage);
                            }
                        }
                    }
                    // 写字楼
                    if (propertyType == 5) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(3);
                            // 写字楼出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<OfficeRentHouseDTO> uyOfficeRentHouseDTOList = uygurHouseResourceDAO.officeRent(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyOfficeRentHouseDTOList);
                                return RestResponse.success(uyPage);
                            }
                            // 写字楼出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<OfficeSellHouseDTO> uyOfficeSellHouseDTOList = uygurHouseResourceDAO.officeSell(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyOfficeSellHouseDTOList);

                                return RestResponse.success(uyPage);
                            }
                        }
                    }
                    // 酒店
                    if (propertyType == 6) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(4);
                            // 酒店出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }
                                List<HotelRentDTO> uyHotelRentDTOList = uygurHouseResourceDAO.hotelRent(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyHotelRentDTOList);

                                return RestResponse.success(uyPage);
                            }
                            // 酒店出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }
                                List<HotelSellDTO> uyHotelSellDTOList = uygurHouseResourceDAO.hotelSell(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyHotelSellDTOList);
                                return RestResponse.success(uyPage);
                            }
                        }
                    }
                    // 厂房
                    if (propertyType == 7) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(5);
                            // 厂房出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<WorkShopRentDTO> uyWorkShopRentDTOList = uygurHouseResourceDAO.workShopRent(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyWorkShopRentDTOList);

                                return RestResponse.success(uyPage);
                            }
                            // 厂房出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }

                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }
                                List<WorkShopSellDTO> uyWorkShopSellDTOList = uygurHouseResourceDAO.workShopSell(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyWorkShopSellDTOList);
                                return RestResponse.success(uyPage);
                            }
                            // 厂房转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }
                                List<WorkShopTransferDTO> uyWorkShopTransferDTOList = uygurHouseResourceDAO.workShopTransfer(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyWorkShopTransferDTOList);
                                return RestResponse.success(uyPage);
                            }
                        }
                    }
                    // 仓库
                    if (propertyType == 8) {
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            uygurCriteria.andEstateTypeEqualTo(6);
                            // 仓库出租
                            if (queryVO.getUseWay() == 0) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }
                                List<WareHouseRentDTO> uyWareHouseRentDTOList = uygurHouseResourceDAO.wareHouseRent(uyPage, uygurExample);
                                uyPage = uyPage.setRecords(uyWareHouseRentDTOList);
                                return RestResponse.success(uyPage);
                            }
                            // 仓库出售
                            if (queryVO.getUseWay() == 1) {

                                // 最小售价
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                // 最大售价
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }
                                List<WareHouseSellDTO> uyWareHouseSellDTOList = uygurHouseResourceDAO.wareHouseSell(uyPage, uygurExample);
                                uyPage = uyPage.setRecords(uyWareHouseSellDTOList);

                                return RestResponse.success(uyPage);
                            }
                            // 仓库转让
                            if (queryVO.getUseWay() == 2) {

                                // 最小租金
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                // 最大租金
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<WareHouseTransferDTO> uyWareHouseTransferDTOList = uygurHouseResourceDAO.wareHouseTransfer(uyPage, uygurExample);
                                uyPage = uyPage.setRecords(uyWareHouseTransferDTOList);

                                return RestResponse.success(uyPage);
                            }
                        }
                    }
                    // 土地转让
                    if (propertyType == 9) {
                        uygurCriteria.andEstateTypeEqualTo(7);

                        if (queryVO.getMinPrice() != null) {
                            uygurCriteria.andTransferPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                        }

                        if (queryVO.getMaxPrice() != null) {
                            uygurCriteria.andTransferPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                        }

                        if (sortType != null) {
                            if (sortType == 1) {
                                uygurExample.setOrderByClause("transfer_price asc");
                            }
                            if (sortType == 2) {
                                uygurExample.setOrderByClause("transfer_price desc");
                            }
                        } else {
                            uygurExample.setOrderByClause("create_time desc");
                        }

                        List<LandTransferDTO> uyLandTransferDTOList = uygurHouseResourceDAO.landTransfer(uyPage, uygurExample);

                        uyPage = uyPage.setRecords(uyLandTransferDTOList);

                        return RestResponse.success(uyPage);
                    }
                    // 车位
                    if (propertyType == 10) {
                        uygurCriteria.andEstateTypeEqualTo(8);
                        if (queryVO.getUseWay() != null) {
                            uygurCriteria.andUseWayEqualTo(queryVO.getUseWay());
                            // 出租
                            if (queryVO.getUseWay() == 0) {
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("monthly_rent asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("monthly_rent desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<ParkingSpaceRentDTO> uyParkingSpaceRentDTOList = uygurHouseResourceDAO.parkingSpaceRent(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyParkingSpaceRentDTOList);
                                return RestResponse.success(uyPage);
                            }
                            // 出售
                            if (queryVO.getUseWay() == 1) {

                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andPriceGreaterThanOrEqualTo(queryVO.getMinPrice());
                                }
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andPriceLessThanOrEqualTo(queryVO.getMaxPrice());
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<ParkingSpaceSellDTO> uyParkingSpaceSellDTOList = uygurHouseResourceDAO.parkingSpaceSell(uyPage, uygurExample);

                                uyPage = uyPage.setRecords(uyParkingSpaceSellDTOList);

                                return RestResponse.success(uyPage);
                            }
                            // 转让
                            if (queryVO.getUseWay() == 2) {
                                if (queryVO.getMinPrice() != null) {
                                    uygurCriteria.andMonthlyRentGreaterThanOrEqualTo(new BigDecimal(queryVO.getMinPrice()));
                                }
                                if (queryVO.getMaxPrice() != null) {
                                    uygurCriteria.andMonthlyRentLessThanOrEqualTo(new BigDecimal(queryVO.getMaxPrice()));
                                }
                                if (sortType != null) {
                                    if (sortType == 1) {
                                        uygurExample.setOrderByClause("price asc");
                                    }
                                    if (sortType == 2) {
                                        uygurExample.setOrderByClause("price desc");
                                    }
                                } else {
                                    uygurExample.setOrderByClause("create_time desc");
                                }

                                List<ParkingSpaceTransferDTO> uyParkingSpaceTransferDTOList = uygurHouseResourceDAO.parkingSpaceTransfer(uyPage, uygurExample);
                                uyPage = uyPage.setRecords(uyParkingSpaceTransferDTOList);
                                return RestResponse.success(uyPage);
                            }
                        }
                    }

                }
            }
        }
        return RestResponse.error("缺少参数");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RestResponse uploadHouse(UploadHouse uploadHouse) {
        HouseResource houseResource = uploadHouse.getHouseResource();
        UygurHouseResource uygurHouseResource = uploadHouse.getUygurHouseResource();
        String sign = UUID.randomUUID().toString().replace("-", "");
        // 更换areaCode(市code)和为regionCode(区域code)，把市code添加到areaCode中

        if (StringUtils.isBlank(houseResource.getBrokerName()) || StringUtils.isBlank(uygurHouseResource.getBrokerName())) {
            return RestResponse.error("上传失败");
        }

        houseResource.setAreaCode(houseResource.getRegionCode());
        uygurHouseResource.setAreaCode(uygurHouseResource.getRegionCode());

        // 住宅+出售+新房=新房
        if (houseResource.getEstateType() == 0 && houseResource.getUseWay() == 1 && houseResource.getHouseDetailType() != null
                && houseResource.getHouseDetailType() == 1) {
            houseResource.setEstateType(9);
            uygurHouseResource.setEstateType(9);
            // 添加均价
            if (houseResource.getPrice() != null && houseResource.getHouseArea() != null) {
                BigDecimal averagePrice = getAveragePrice(houseResource.getPrice(), houseResource.getHouseArea());
                houseResource.setAveragePrice(averagePrice);
                uygurHouseResource.setAveragePrice(averagePrice);
            } else {
                return RestResponse.error("缺少售价和面积");
            }
        }
        // 住宅+出售+二手房=二手房
        if (houseResource.getEstateType() == 0 && houseResource.getUseWay() == 1 && houseResource.getHouseDetailType() != null
                && houseResource.getHouseDetailType() == 0) {
            // 添加均价
            if (houseResource.getPrice() != null && houseResource.getHouseArea() != null) {
                BigDecimal averagePrice = getAveragePrice(houseResource.getPrice(), houseResource.getHouseArea());
                houseResource.setAveragePrice(averagePrice);
                uygurHouseResource.setAveragePrice(averagePrice);
            } else {
                return RestResponse.error("缺少售价和面积");
            }
            houseResource.setEstateType(10);
            uygurHouseResource.setEstateType(10);
        }
        // 住宅+出租=租房
        if (houseResource.getEstateType() == 0 && houseResource.getUseWay() == 0) {
            houseResource.setEstateType(11);
            uygurHouseResource.setEstateType(11);
        }

        // 计算楼层低中高层
        if (houseResource.getEstateType() != 3 || houseResource.getEstateType() != 7 || houseResource.getEstateType() != 8) {
            if (houseResource.getId() == null && uygurHouseResource.getId() == null) {
                if (StringUtils.isNotBlank(houseResource.getFloorInformation()) && StringUtils.isNotBlank(houseResource.getFloorInformation())) {
                    int floor = getFloor(houseResource.getFloorInformation());
                    if (floor != 3) {
                        houseResource.setFloorType(floor);
                        uygurHouseResource.setFloorType(floor);
                    } else {
                        // 如果其他情况默认添加成低层
                        houseResource.setFloorType(0);
                        uygurHouseResource.setFloorType(floor);
                    }
                }
            }
        }

        houseResource.setSellStatus(1);
        houseResource.setCreateTime(new Date());
        houseResource.setRecordStatus(0);
        houseResource.setSignLabel(sign);


        // 测试or正式上线时打开
        uygurHouseResource.setSellStatus(1);
        uygurHouseResource.setCreateTime(new Date());
        uygurHouseResource.setRecordStatus(0);
        uygurHouseResource.setSignLabel(sign);


        if (houseResource.getId() != null && uygurHouseResource.getId() != null) {
            houseResource.setSellStatus(1);
            houseResource.setRecordStatus(0);
            uygurHouseResource.setSellStatus(1);
            uygurHouseResource.setRecordStatus(0);

            // 更新记录
            houseResourceDAO.updateByPrimaryKeySelective(houseResource);
            uygurHouseResourceDAO.updateByPrimaryKeySelective(uygurHouseResource);
            //删除ES中的数据,审核通过后会再次插入
            houseDocRepository.deleteById(houseResource.getId());
            uyHouseDocRepository.deleteById(uygurHouseResource.getId());
            //house数量减1
            houseCountSV.subAccountByType(houseResource.getEstateType() + "", houseResource.getRegionCode());

        } else {
            // 上传房源时如果传递的置顶不为空并且要置顶，指定置顶时间
            if (houseResource.getSticky() != null && houseResource.getSticky() == 1 && uygurHouseResource.getSticky() != null && uygurHouseResource.getSticky() == 1) {
                houseResource.setStickyTime(new Date());
                uygurHouseResource.setStickyTime(new Date());
            }
            houseResourceDAO.save(houseResource);
            if (houseResource.getId() == null) {
                throw new RuntimeException("上传异常");
            }
            uygurHouseResource.setId(houseResource.getId());
            uygurHouseResourceDAO.save(uygurHouseResource);

        }

        return RestResponse.success("上传成功");
    }

    /**
     * 清除redis数据
     * @param estateType
     */
    public void deleteRedisHomePageHouse(Integer estateType) {
        // 二手房 首页数据
        if (estateType == 10) {
            redisUtil.delete("houseResourceSecondPC", "houseResourceSecondAPP", "uygurHouseResourceSecondPC", "uygurHouseResourceSecondAPP");
        }

        // 商铺
        if (estateType == 2) {
            redisUtil.delete("houseResourceShopPC", "houseResourceShopAPP", "uygurHouseResourceShopPC", "uygurHouseResourceShopAPP");
        }

        // 租房
        if (estateType == 11) {
            redisUtil.delete("houseResourceRentPC", "houseResourceRentAPP", "uygurHouseResourceRentPC", "uygurHouseResourceRentAPP");
        }
    }


    /**
     * 计算均价
     * @param price     总价(售价)
     * @param houseArea 面积(平方米)
     */
    public BigDecimal getAveragePrice(int price, BigDecimal houseArea) {
        BigDecimal totalPrice = new BigDecimal(price);
        BigDecimal averagePrice = totalPrice.divide(houseArea, 2, ROUND_HALF_UP);
        return averagePrice;
    }


    /**
     * 计算楼层信息
     * @param floor
     * @return
     */
    public int getFloor(String floor) {
        log.info("---->楼层信息---->floor={}", floor);
        String[] floorMessage = floor.split(",");
        int currentFloor ;
        int floorNum ;
        try {
            currentFloor = Integer.parseInt(floorMessage[0]);
            floorNum = Integer.parseInt(floorMessage[1]);
        } catch (NumberFormatException e) {
            log.info("---->楼层转换异常---->", e);
            return 3;
        }
        int num = floorNum % 3;
        // 可以被三整除
        if (num == 0) {
            int n = floorNum / 3;
            // 底层
            if (1 <= currentFloor) {
                return 0;
            }
            // 中层
            if (n + 1 <= currentFloor && currentFloor <= 2 * n) {
                return 1;
            }
            // 高层
            if (2 * n + 1 <= currentFloor && currentFloor <= floorNum) {
                return 2;
            }
        }
        // 不可被三整除
        if (num != 0) {
            int n = floorNum / 3;
            // 底层
            if (1 <= currentFloor && currentFloor <= n + 1) {
                return 0;
            }
            if (n + 2 <= currentFloor && currentFloor <= 2 * (n + 1)) {
                return 1;
            }
            if (2 * (n + 1) <= currentFloor && currentFloor <= floorNum) {
                return 2;
            }
        }
        return 3;
    }


    /**
     * 修改redis置顶房源
     * @param houseResource 房源
     * @param uygurHouseResource 维语房源
     * @param type 类型 10-二手房  2-商铺  11-租房
     */
    public void addHomePageRedis(HouseResource houseResource, UygurHouseResource uygurHouseResource, Integer type) {
        // 二手房 首页数据
        if (type == 10) {
            redisUtil.lSet("houseResourceSecondPC", houseResource);
            redisUtil.lSet("houseResourceSecondAPP", houseResource);
            redisUtil.lSet("uygurHouseResourceSecondPC", uygurHouseResource);
            redisUtil.lSet("uygurHouseResourceSecondAPP", uygurHouseResource);
            long pcZhSize = redisUtil.lGetListSize("houseResourceSecondPC");
            long appZhSize = redisUtil.lGetListSize("houseResourceSecondAPP");
            long pcUySize = redisUtil.lGetListSize("uygurHouseResourceSecondPC");
            long appUySize = redisUtil.lGetListSize("uygurHouseResourceSecondAPP");
            if (pcUySize > 5 && pcZhSize > 5) {
                redisUtil.trim("houseResourceSecondPC", 1, 5);
                redisUtil.trim("uygurHouseResourceSecondPC", 1, 5);
                List<Object> houseResourceSecondPC = redisUtil.lGet("houseResourceSecondPC", 0, -1);
                List<Object> uygurHouseResourceSecondPC = redisUtil.lGet("uygurHouseResourceSecondPC", 0, -1);
                log.info("修改后pc首页二手房数据" + houseResourceSecondPC);
                log.info("修改后pc首页二手房数据" + uygurHouseResourceSecondPC);
            }
            if (appZhSize > 3 && appUySize > 3) {
                redisUtil.trim("houseResourceSecondAPP", 1, 3);
                redisUtil.trim("uygurHouseResourceSecondAPP", 1, 3);
                List<Object> houseResourceSecondAPP = redisUtil.lGet("houseResourceSecondAPP", 0, -1);
                List<Object> uygurHouseResourceSecondAPP = redisUtil.lGet("uygurHouseResourceSecondAPP", 0, -1);
                log.info("修改后app首页二手房数据" + houseResourceSecondAPP);
                log.info("修改后app首页二手房数据" + uygurHouseResourceSecondAPP);
            }
        }

        // 商铺
        if (type == 2) {
            redisUtil.lSet("houseResourceShopPC", houseResource);
            redisUtil.lSet("houseResourceShopAPP", houseResource);
            redisUtil.lSet("uygurHouseResourceShopPC", uygurHouseResource);
            redisUtil.lSet("uygurHouseResourceShopAPP", uygurHouseResource);
            long pcZhSize = redisUtil.lGetListSize("houseResourceShopPC");
            long appZhSize = redisUtil.lGetListSize("houseResourceShopAPP");
            long pcUySize = redisUtil.lGetListSize("uygurHouseResourceShopPC");
            long appUySize = redisUtil.lGetListSize("uygurHouseResourceShopAPP");
            if (pcUySize > 5 && pcZhSize > 5) {
                redisUtil.trim("houseResourceShopPC", 1, 5);
                redisUtil.trim("uygurHouseResourceShopPC", 1, 5);
                List<Object> houseResourceShopPC = redisUtil.lGet("houseResourceShopPC", 0, -1);
                List<Object> uygurHouseResourceShopPC = redisUtil.lGet("uygurHouseResourceShopPC", 0, -1);
                log.info("修改后pc首页商铺数据" + houseResourceShopPC);
                log.info("修改后pc首页商铺数据" + uygurHouseResourceShopPC);
            }

            if (appZhSize > 3 && appUySize > 3) {
                redisUtil.trim("houseResourceShopAPP", 1, 3);
                redisUtil.trim("uygurHouseResourceShopAPP", 1, 3);
                List<Object> houseResourceShopAPP = redisUtil.lGet("houseResourceShopAPP", 0, -1);
                List<Object> uygurHouseResourceShopAPP = redisUtil.lGet("uygurHouseResourceShopAPP", 0, -1);
                log.info("修改后app首页商铺数据" + houseResourceShopAPP);
                log.info("修改后app首页商铺数据" + uygurHouseResourceShopAPP);
            }
        }

        // 租房
        if (type == 11) {
            redisUtil.lSet("houseResourceRentPC", houseResource);
            redisUtil.lSet("houseResourceRentAPP", houseResource);
            redisUtil.lSet("uygurHouseResourceRentPC", uygurHouseResource);
            redisUtil.lSet("uygurHouseResourceRentAPP", uygurHouseResource);
            long pcZhSize = redisUtil.lGetListSize("houseResourceRentPC");
            long appZhSize = redisUtil.lGetListSize("houseResourceRentAPP");
            long pcUySize = redisUtil.lGetListSize("uygurHouseResourceRentPC");
            long appUySize = redisUtil.lGetListSize("uygurHouseResourceRentAPP");
            if (pcUySize > 5 && pcZhSize > 5) {
                redisUtil.trim("houseResourceRentPC", 1, 5);
                redisUtil.trim("uygurHouseResourceRentPC", 1, 5);
                List<Object> houseResourceRentPC = redisUtil.lGet("houseResourceRentPC", 0, -1);
                List<Object> uygurHouseResourceRentPC = redisUtil.lGet("uygurHouseResourceRentPC", 0, -1);
                log.info("修改后pc首页租房数据" + houseResourceRentPC);
                log.info("修改后pc首页租房数据" + uygurHouseResourceRentPC);
            }

            if (appZhSize > 3 && appUySize > 3) {
                redisUtil.trim("houseResourceRentAPP", 1, 3);
                redisUtil.trim("uygurHouseResourceRentAPP", 1, 3);
                List<Object> houseResourceRentAPP = redisUtil.lGet("houseResourceRentAPP", 0, -1);
                List<Object> uygurHouseResourceRentAPP = redisUtil.lGet("uygurHouseResourceRentAPP", 0, -1);
                log.info("修改后app首页租房数据" + houseResourceRentAPP);
                log.info("修改后app首页租房数据" + uygurHouseResourceRentAPP);
            }
        }

    }


    /**
     * 修改mysql置顶房源
     * @param type
     */
    public void addHomePageMysql(Integer type) {
        // 二手房 首页数据
        Integer stickyCount = houseResourceDAO.getStickyCount(type);
        Integer uyStickyCount = uygurHouseResourceDAO.getStickyCount(type);
        if (stickyCount > 5 && uyStickyCount > 5) {
            // 最先置顶得去除置顶
            HouseResource firstSticky = houseResourceDAO.getFirstSticky();
            firstSticky.setSticky(0);
            UygurHouseResource uygurFirstSticky = uygurHouseResourceDAO.getFirstSticky();
            uygurFirstSticky.setSticky(0);
            houseResourceDAO.updateByPrimaryKeySelective(firstSticky);
            uygurHouseResourceDAO.updateByPrimaryKeySelective(uygurFirstSticky);
        }
    }

    /**
     * 获取中文首页数据
     * 10-二手房 2-商铺 11-租房
     * @param estateType
     * @return
     */
    public List<HouseResource> homePageZh(String device, Integer estateType) {
        List<HouseResource> houseResourceList = new ArrayList<>();
        if (estateType == 10) {
            if ("pc".equals(device)) {
                List<Object> houseResourceSecondPC = redisUtil.lGet("houseResourceSecondPC", 0, -1);
                if (houseResourceSecondPC != null && houseResourceSecondPC.size() > 0) {
                    for (int i = 0; i < houseResourceSecondPC.size(); i++) {
                        houseResourceList.add((HouseResource) houseResourceSecondPC.get(i));
                    }
                } else {
                    // 读取redis存储
                    houseResourceList = getStickyHouseZh("pc", estateType);
                }
            }
            if ("app".equals(device)) {
                List<Object> houseResourceSecondAPP = redisUtil.lGet("houseResourceSecondAPP", 0, -1);
                if (houseResourceSecondAPP != null && houseResourceSecondAPP.size() > 0) {
                    for (int i = 0; i < houseResourceSecondAPP.size(); i++) {
                        houseResourceList.add((HouseResource) houseResourceSecondAPP.get(i));
                    }
                } else {
                    // 读取redis存储
                    houseResourceList = getStickyHouseZh("app", estateType);
                }
            }

        }
        if (estateType == 11) {
            if ("pc".equals(device)) {
                List<Object> houseResourceSecondPC = redisUtil.lGet("houseResourceRentPC", 0, -1);
                if (houseResourceSecondPC != null && houseResourceSecondPC.size() > 0) {
                    for (int i = 0; i < houseResourceSecondPC.size(); i++) {
                        houseResourceList.add((HouseResource) houseResourceSecondPC.get(i));
                    }
                } else {
                    // 读取redis存储
                    houseResourceList = getStickyHouseZh("pc", estateType);
                }
            }
            if ("app".equals(device)) {
                List<Object> houseResourceSecondAPP = redisUtil.lGet("houseResourceRentAPP", 0, -1);
                if (houseResourceSecondAPP != null && houseResourceSecondAPP.size() > 0) {
                    for (int i = 0; i < houseResourceSecondAPP.size(); i++) {
                        houseResourceList.add((HouseResource) houseResourceSecondAPP.get(i));
                    }
                } else {
                    // 读取redis存储
                    houseResourceList = getStickyHouseZh("app", estateType);
                }
            }
        }
        if (estateType == 2) {
            if ("pc".equals(device)) {
                List<Object> houseResourceSecondPC = redisUtil.lGet("houseResourceShopPC", 0, -1);
                if (houseResourceSecondPC != null && houseResourceSecondPC.size() > 0) {
                    for (int i = 0; i < houseResourceSecondPC.size(); i++) {
                        houseResourceList.add((HouseResource) houseResourceSecondPC.get(i));
                    }
                } else {
                    // 读取redis存储
                    houseResourceList = getStickyHouseZh("pc", estateType);
                }
            }
            if ("app".equals(device)) {
                List<Object> houseResourceShopAPP = redisUtil.lGet("houseResourceShopAPP", 0, -1);
                if (houseResourceShopAPP != null && houseResourceShopAPP.size() > 0) {
                    for (int i = 0; i < houseResourceShopAPP.size(); i++) {
                        houseResourceList.add((HouseResource) houseResourceShopAPP.get(i));
                    }
                } else {
                    houseResourceList = getStickyHouseZh("app", estateType);
                }
            }

        }
        return houseResourceList;
    }

    /**
     * 获取维语首页数据
     * 10-二手房 2-商铺 11-租房
     * @param estateType
     * @return
     */
    public List<UygurHouseResource> homePageWy(String device, Integer estateType) {
        List<UygurHouseResource> uygurHouseResourceList = new ArrayList<>();
        if (estateType == 10) {
            if ("pc".equals(device)) {
                List<Object> uygurHouseResourceSecondPC = redisUtil.lGet("uygurHouseResourceSecondPC", 0, -1);
                if (uygurHouseResourceSecondPC != null && uygurHouseResourceSecondPC.size() > 0) {
                    for (int i = 0; i < uygurHouseResourceSecondPC.size(); i++) {
                        uygurHouseResourceList.add((UygurHouseResource) uygurHouseResourceSecondPC.get(i));
                    }
                } else {
                    // 读取redis存储
                    uygurHouseResourceList = getStickyHouseWy("pc", estateType);
                }
            }
            if ("app".equals(device)) {
                List<Object> uygurHouseResourceSecondAPP = redisUtil.lGet("uygurHouseResourceSecondAPP", 0, -1);
                if (uygurHouseResourceSecondAPP != null && uygurHouseResourceSecondAPP.size() > 0) {
                    for (int i = 0; i < uygurHouseResourceSecondAPP.size(); i++) {
                        uygurHouseResourceList.add((UygurHouseResource) uygurHouseResourceSecondAPP.get(i));
                    }
                } else {
                    // 读取redis存储
                    uygurHouseResourceList = getStickyHouseWy("app", estateType);
                }
            }

        }
        if (estateType == 11) {
            if ("pc".equals(device)) {
                List<Object> uygurHouseResourceRentPC = redisUtil.lGet("uygurHouseResourceRentPC", 0, -1);
                if (uygurHouseResourceRentPC != null && uygurHouseResourceRentPC.size() > 0) {
                    for (int i = 0; i < uygurHouseResourceRentPC.size(); i++) {
                        uygurHouseResourceList.add((UygurHouseResource) uygurHouseResourceRentPC.get(i));
                    }
                } else {
                    // 读取redis存储
                    uygurHouseResourceList = getStickyHouseWy("pc", estateType);
                }
            }
            if ("app".equals(device)) {
                List<Object> uygurHouseResourceRentAPP = redisUtil.lGet("uygurHouseResourceRentAPP", 0, -1);
                if (uygurHouseResourceRentAPP != null && uygurHouseResourceRentAPP.size() > 0) {
                    for (int i = 0; i < uygurHouseResourceRentAPP.size(); i++) {
                        uygurHouseResourceList.add((UygurHouseResource) uygurHouseResourceRentAPP.get(i));
                    }
                } else {
                    // 读取redis存储
                    uygurHouseResourceList = getStickyHouseWy("app", estateType);
                }
            }
        }
        if (estateType == 2) {
            if ("pc".equals(device)) {
                List<Object> uygurHouseResourceShopPC = redisUtil.lGet("uygurHouseResourceShopPC", 0, -1);
                if (uygurHouseResourceShopPC != null && uygurHouseResourceShopPC.size() > 0) {
                    for (int i = 0; i < uygurHouseResourceShopPC.size(); i++) {
                        uygurHouseResourceList.add((UygurHouseResource) uygurHouseResourceShopPC.get(i));
                    }
                } else {
                    // 读取redis存储
                    uygurHouseResourceList = getStickyHouseWy("pc", estateType);
                }
            }
            if ("app".equals(device)) {
                List<Object> uygurHouseResourceShopAPP = redisUtil.lGet("uygurHouseResourceShopAPP", 0, -1);
                if (uygurHouseResourceShopAPP != null && uygurHouseResourceShopAPP.size() > 0) {
                    for (int i = 0; i < uygurHouseResourceShopAPP.size(); i++) {
                        uygurHouseResourceList.add((UygurHouseResource) uygurHouseResourceShopAPP.get(i));
                    }
                } else {
                    uygurHouseResourceList = getStickyHouseWy("app", estateType);
                }
            }

        }
        return uygurHouseResourceList;
    }

    /**
     * 从数据库中读取存入redis 维语
     * @param device
     * @param estateType
     * @return
     */
    public List<UygurHouseResource> getStickyHouseWy(String device, Integer estateType) {
        List<UygurHouseResource> uygurHouseResourceList = new ArrayList<>();
        if ("app".equals(device)) {
            if (estateType == 10) {
                uygurHouseResourceList = uygurHouseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                    redisUtil.lSet("uygurHouseResourceSecondAPP", uygurHouseResourceList.get(i));
                }
            }
            if (estateType == 2) {
                uygurHouseResourceList = uygurHouseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                    redisUtil.lSet("uygurHouseResourceShopAPP", uygurHouseResourceList.get(i));
                }
            }
            if (estateType == 11) {
                uygurHouseResourceList = uygurHouseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                    redisUtil.lSet("uygurHouseResourceRentAPP", uygurHouseResourceList.get(i));
                }
            }
        }
        if ("pc".equals(device)) {
            if (estateType == 10) {
                uygurHouseResourceList = uygurHouseResourceDAO.getHomePagePcInRedis(estateType);
                for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                    redisUtil.lSet("uygurHouseResourceSecondPC", uygurHouseResourceList.get(i));
                }
            }
            if (estateType == 2) {
                uygurHouseResourceList = uygurHouseResourceDAO.getHomePagePcInRedis(estateType);
                for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                    redisUtil.lSet("uygurHouseResourceShopPC", uygurHouseResourceList.get(i));
                }
            }
            if (estateType == 11) {
                uygurHouseResourceList = uygurHouseResourceDAO.getHomePagePcInRedis(estateType);
                for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                    redisUtil.lSet("uygurHouseResourceRentPC", uygurHouseResourceList.get(i));
                }
            }
        }
        return uygurHouseResourceList;
    }


    /**
     * 从数据库中读取存入redis 中文
     * @param device pc app
     * @param estateType 10-二手房 2-商铺 11-租房
     * @return
     */
    public List<HouseResource> getStickyHouseZh(String device, Integer estateType) {
        List<HouseResource> houseResourceList = new ArrayList<>();
        if ("app".equals(device)) {
            if (estateType == 10) {
                houseResourceList = houseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < houseResourceList.size(); i++) {
                    redisUtil.lSet("houseResourceSecondAPP", houseResourceList.get(i));
                }
            }
            if (estateType == 2) {
                houseResourceList = houseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < houseResourceList.size(); i++) {
                    redisUtil.lSet("houseResourceShopAPP", houseResourceList.get(i));
                }
            }
            if (estateType == 11) {
                houseResourceList = houseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < houseResourceList.size(); i++) {
                    redisUtil.lSet("houseResourceRentAPP", houseResourceList.get(i));
                }
            }
        }
        if ("pc".equals(device)) {
            if (estateType == 10) {
                houseResourceList = houseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < houseResourceList.size(); i++) {
                    redisUtil.lSet("houseResourceSecondPC", houseResourceList.get(i));
                }
            }
            if (estateType == 2) {
                houseResourceList = houseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < houseResourceList.size(); i++) {
                    redisUtil.lSet("houseResourceShopPC", houseResourceList.get(i));
                }
            }
            if (estateType == 11) {
                houseResourceList = houseResourceDAO.getHomePageAppInRedis(estateType);
                for (int i = 0; i < houseResourceList.size(); i++) {
                    redisUtil.lSet("houseResourceRentPC", houseResourceList.get(i));
                }
            }
        }
        return houseResourceList;
    }


}
