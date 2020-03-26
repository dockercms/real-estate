package com.ztuo.modules.house.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.dto.*;
import com.ztuo.modules.house.entity.HouseResource;
import com.ztuo.modules.house.entity.UygurHouseResource;
import com.ztuo.modules.house.entity.UygurHouseResourceExample;
import com.ztuo.modules.house.vo.HouseLocationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UygurHouseResourceDAO {

	List<UygurHouseResource> getByExample(UygurHouseResourceExample example);
	
	UygurHouseResource getByPrimaryKey(Long id);
	
	int deleteByPrimaryKey(Long id);
	
	int deleteByExample(UygurHouseResourceExample example);
	
	int save(UygurHouseResource record);
	
	int saveSelective(UygurHouseResource record);
	
	int countByExample(UygurHouseResourceExample example);
	
	int updateByExampleSelective(@Param("record") UygurHouseResource record, @Param("example") UygurHouseResourceExample example);
	
	int updateByExample(@Param("record") UygurHouseResource record, @Param("example") UygurHouseResourceExample example);
	
	int updateByPrimaryKeySelective(UygurHouseResource record);
	
	int updateByPrimaryKey(UygurHouseResource record);

	UygurHouseResource getBySignLabel(@Param("signLabel") String signLabel);

	/**
	 * 根据维语中文表关联更新中文表的同时更新维语表
	 * @param houseResource
	 * @return
	 */
	int updateBySignLabelSelective(HouseResource houseResource);

	/**
	 * 新房
	 * @param page
	 * @param example
	 * @return
	 */
	List<NewHouseDTO> newHouseQuery(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 二手房
	 * @param page
	 * @param example
	 * @return
	 */
	List<SecondHandHouseDTO> secondHouse(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 租房
	 * @param page
	 * @param example
	 * @return
	 */
	List<RentHouseDTO> rentHouse(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 别墅出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<VillaRentDTO> villaRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 别墅出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<VillaSellDTO> villaSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 商铺出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<ShopSellHouseDTO> shopSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 商铺转让
	 * @param page
	 * @param example
	 * @return
	 */
	List<ShopTransferHouseDTO> shopTransfer(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 商铺出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<ShopRentHouseDTO> shopRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 写字楼出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<OfficeRentHouseDTO> officeRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 写字楼出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<OfficeSellHouseDTO> officeSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 酒店出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<HotelRentDTO> hotelRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 酒店出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<HotelSellDTO> hotelSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 厂房出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<WorkShopRentDTO> workShopRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 厂房出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<WorkShopSellDTO> workShopSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 厂房转让
	 * @param page
	 * @param example
	 * @return
	 */
	List<WorkShopTransferDTO> workShopTransfer(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 仓库出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<WareHouseRentDTO> wareHouseRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 仓库出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<WareHouseSellDTO> wareHouseSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 仓库转让
	 * @param page
	 * @param example
	 * @return
	 */
	List<WareHouseTransferDTO> wareHouseTransfer(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 土地转让
	 * @param page
	 * @param example
	 * @return
	 */
	List<LandTransferDTO> landTransfer(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 车位出租
	 * @param page
	 * @param example
	 * @return
	 */
	List<ParkingSpaceRentDTO> parkingSpaceRent(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 车位出售
	 * @param page
	 * @param example
	 * @return
	 */
	List<ParkingSpaceSellDTO> parkingSpaceSell(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 车位转让
	 * @param page
	 * @param example
	 * @return
	 */
	List<ParkingSpaceTransferDTO> parkingSpaceTransfer(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 别墅大类
	 * @param page
	 * @param example
	 * @return
	 */
    List<VillaDTO> queryVilla(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 商铺大类
	 * @param page
	 * @param example
	 * @return
	 */
	List<ShopDTO> queryShop(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 写字楼大类
	 * @param page
	 * @param example
	 * @return
	 */
	List<OfficeHouseDTO> queryOffice(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 旅馆大类
	 * @param page
	 * @param example
	 * @return
	 */
	List<HotelDTO> queryHotel(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 厂房大类
	 * @param page
	 * @param example
	 * @return
	 */
	List<WorkShopDTO> queryWorkShop(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 仓库大类
	 * @param page
	 * @param example
	 * @return
	 */
	List<WareHouseDTO> queryWareHouse(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 车位大类
	 * @param page
	 * @param example
	 * @return
	 */
	List<ParkingSpaceDTO> queryParkingSpace(Page page, @Param("example") UygurHouseResourceExample example);

	/**
	 * 首页二手房
	 * @return
	 */
	List<SecondHandHouseDTO> getHomePageForSecondHouse(@Param("cityCode") String cityCode);

	/**
	 * 首页商铺
	 * @return
	 */
	List<ShopDTO> getHomePageForShop(@Param("cityCode") String cityCode);

	/**
	 * 首页租房
	 * @return
	 */
	List<RentHouseDTO> getHomePageForRentHouse(@Param("cityCode") String cityCode);

	/**
	 * 获取单个新房
	 * @param id
	 * @return
	 */
	NewHouseDTO getNewHouseById(@Param("id")Long id);

	/**
	 * 获取单个二手房
	 * @param id
	 * @return
	 */
	SecondHandHouseDTO getSecondHouseById(@Param("id")Long id);

	/**
	 * 获取单个租房
	 * @param id
	 * @return
	 */
	RentHouseDTO getRentHouseById(@Param("id")Long id);

	/**
	 * 别墅出售
	 * @param id
	 * @return
	 */
	VillaSellDTO getVillaSellById(@Param("id")Long id);

	/**
	 * 别墅出租
	 * @param id
	 * @return
	 */
	VillaRentDTO getVillaRentById(@Param("id")Long id);

	/**
	 * 商铺出售
	 * @param id
	 * @return
	 */
	ShopSellHouseDTO getShopSellHouseById(@Param("id")Long id);

	/**
	 * 商铺转让
	 * @param id
	 * @return
	 */
	ShopTransferHouseDTO getShopTransferHouseById(@Param("id")Long id);

	/**
	 * 商铺出租
	 * @param id
	 * @return
	 */
	ShopRentHouseDTO getShopRentHouseById(@Param("id")Long id);

	/**
	 * 写字楼出售
	 * @param id
	 * @return
	 */
	OfficeSellHouseDTO getOfficeSellById(@Param("id")Long id);

	/**
	 * 写字楼出租
	 * @param id
	 * @return
	 */
	OfficeRentHouseDTO getOfficeRentById(@Param("id")Long id);

	/**
	 * 酒店出售
	 * @param id
	 * @return
	 */
	HotelSellDTO getHotelSellById(@Param("id")Long id);

	/**
	 * 酒店出租
	 * @param id
	 * @return
	 */
	HotelRentDTO getHotelRentById(@Param("id")Long id);

	/**
	 * 厂房出售
	 * @param id
	 * @return
	 */
	WorkShopSellDTO getWorkShopSellById(@Param("id")Long id);

	/**
	 * 厂房转让
	 * @param id
	 * @return
	 */
	WorkShopTransferDTO getWorkShopTransferById(@Param("id")Long id);

	/**
	 * 厂房出租
	 * @param id
	 * @return
	 */
	WorkShopRentDTO getWorkShopRentById(@Param("id")Long id);

	/**
	 * 仓库出售
	 * @param id
	 * @return
	 */
	WareHouseSellDTO getWareHouseSellById(@Param("id")Long id);

	/**
	 * 仓库转让
	 * @param id
	 * @return
	 */
	WareHouseTransferDTO getWareHouseTransferById(@Param("id")Long id);

	/**
	 * 仓库出租
	 * @param id
	 * @return
	 */
	WareHouseRentDTO getWareHouseRentById(@Param("id")Long id);

	/**
	 * 土地转让
	 * @param id
	 * @return
	 */
	LandTransferDTO getLandTransferById(@Param("id")Long id);

	/**
	 * 车位出售
	 * @param id
	 * @return
	 */
	ParkingSpaceSellDTO getParkingSpaceSellById(@Param("id")Long id);

	/**
	 * 车位转让
	 * @param id
	 * @return
	 */
	ParkingSpaceTransferDTO getParkingSpaceTransferById(@Param("id")Long id);

	/**
	 * 车位出租
	 * @param id
	 * @return
	 */
	ParkingSpaceRentDTO getParkingSpaceRentById(@Param("id")Long id);

	Integer getStickyCount(@Param("estateType")Integer estateTye);

	UygurHouseResource getFirstSticky();

	List<UygurHouseResource> getByBrokerId(@Param("brokerId") Long brokerId);

	/**
	 * app首页3
	 * @param estateType
	 * @return
	 */
	List<UygurHouseResource> getHomePageAppInRedis(@Param("estateType") Integer estateType);

	/**
	 * pc首页5
	 * @param estateType
	 * @return
	 */
	List<UygurHouseResource> getHomePagePcInRedis(@Param("estateType") Integer estateType);

    List<HouseLocationVO> getMapLocation(UygurHouseResourceExample example);
}
