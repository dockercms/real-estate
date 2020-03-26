package com.ztuo.modules.es.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/5 5:44 下午
 */
@Data
@Document(indexName = "house",type = "info")
public class HouseDoc {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * This field corresponds to the database column house_resource.id
     *
     * @date 2020-03-03 14:46:23
     */
    @Id
    private Long id;

    /**
     * 申请人姓名
     * This field corresponds to the database column house_resource.applicant_name
     *
     * @date 2020-03-03 14:46:23
     */
    private String applicantName;

    /**
     * 申请人手机号
     * This field corresponds to the database column house_resource.applicant_phone
     *
     * @date 2020-03-03 14:46:23
     */
    private String applicantPhone;

    /**
     * 所属经纪人id
     * This field corresponds to the database column house_resource.broker_id
     *
     * @date 2020-03-03 14:46:23
     */
    private Long brokerId;

    /**
     * 经纪人姓名(顾问)
     * This field corresponds to the database column house_resource.broker_name
     *
     * @date 2020-03-19 20:32:50
     */
    private String brokerName;

    /**
     * 房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位 9-新房 10-二手房 11-租房
     * This field corresponds to the database column house_resource.estate_type
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer estateType;

    /**
     * 用途 0-出租 1-出售 2-转让
     * This field corresponds to the database column house_resource.use_way
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer useWay;

    /**
     * 0-审核中 1-审核成功 2-审核失败 3-上架 4-下架
     * This field corresponds to the database column house_resource.record_status
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer recordStatus;

    /**
     * 业主姓名
     * This field corresponds to the database column house_resource.owner_name
     *
     * @date 2020-03-03 14:46:23
     */
    private String ownerName;

    /**
     * 业主联系电话
     * This field corresponds to the database column house_resource.owner_phone
     *
     * @date 2020-03-03 14:46:23
     */
    private String ownerPhone;

    /**
     * 标题
     * This field corresponds to the database column house_resource.title
     *
     * @date 2020-03-03 14:46:23
     */
    private String title;

    /**
     * 房屋类型 0-二手房 1-新房
     * This field corresponds to the database column house_resource.house_detail_type
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer houseDetailType;

    /**
     * 租房类型 0-整租 1-合租
     * This field corresponds to the database column house_resource.rental_type
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer rentalType;

    /**
     * 区域-省
     * This field corresponds to the database column house_resource.house_region_province
     *
     * @date 2020-03-03 14:46:23
     */
    private String houseRegionProvince;

    /**
     * 省code
     * This field corresponds to the database column house_resource.province_code
     *
     * @date 2020-03-03 14:46:23
     */
    private String provinceCode;

    /**
     * 区域-市
     * This field corresponds to the database column house_resource.house_region_city
     *
     * @date 2020-03-03 14:46:23
     */
    private String houseRegionCity;

    /**
     * 市code
     * This field corresponds to the database column house_resource.city_code
     *
     * @date 2020-03-03 14:46:23
     */
    private String cityCode;

    /**
     * 区域-区
     * This field corresponds to the database column house_resource.house_region_area
     *
     * @date 2020-03-03 14:46:23
     */
    private String houseRegionArea;

    /**
     * 区code
     * This field corresponds to the database column house_resource.area_code
     *
     * @date 2020-03-03 14:46:23
     */
    private String areaCode;

    /**
     * 小区名称
     * This field corresponds to the database column house_resource.plot_name
     *
     * @date 2020-03-03 14:46:23
     */
    private String plotName;

    /**
     * 详细地址
     * This field corresponds to the database column house_resource.address
     *
     * @date 2020-03-03 14:46:23
     */
    private String address;

    /**
     * 门牌号
     * This field corresponds to the database column house_resource.house_number
     *
     * @date 2020-03-03 14:46:23
     */
    private String houseNumber;

    /**
     * 楼层信息
     * This field corresponds to the database column house_resource.floor_information
     *
     * @date 2020-03-03 14:46:23
     */
    private String floorInformation;

    /**
     * 建房年代
     * This field corresponds to the database column house_resource.build_year
     *
     * @date 2020-03-03 14:46:23
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy")
    private Date buildYear;

    /**
     * 资产期限
     * This field corresponds to the database column house_resource.maturity_assets
     *
     * @date 2020-03-03 14:46:23
     */
    private String maturityAssets;

    /**
     * 装修类型 0-毛坯房 1-简装 2-精装修 3-豪装
     * This field corresponds to the database column house_resource.decoration_type
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer decorationType;

    /**
     * 配备电梯 0-无 1-有
     * This field corresponds to the database column house_resource.elevator
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer elevator;

    /**
     * 户型 室
     * This field corresponds to the database column house_resource.house_type_room
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer houseTypeRoom;

    /**
     * 户型 厅
     * This field corresponds to the database column house_resource.house_type_hall
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer houseTypeHall;

    /**
     * 户型 卫
     * This field corresponds to the database column house_resource.house_type_toilet
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer houseTypeToilet;

    /**
     * 面积
     * This field corresponds to the database column house_resource.house_area
     *
     * @date 2020-03-03 14:46:23
     */
    private BigDecimal houseArea;

    /**
     * 房屋朝向 0-东 1-西 2-南 3-北 4-南北 5-东西 6-东南 7-西南 8-东北 9-西北
     * This field corresponds to the database column house_resource.towards
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer towards;

    /**
     * 月租金
     * This field corresponds to the database column house_resource.monthly_rent
     *
     * @date 2020-03-03 14:46:23
     */
    private BigDecimal monthlyRent;

    /**
     * 年租金
     * This field corresponds to the database column house_resource.annual_rent
     *
     * @date 2020-03-03 14:46:23
     */
    private BigDecimal annualRent;

    /**
     * 支付方式 0-压三付一 1-三月一付 2-半年一付 3-一年一付 4-全额 5-按揭 6-分期
     * This field corresponds to the database column house_resource.payment_method
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer paymentMethod;

    /**
     * 房源描述
     * This field corresponds to the database column house_resource.listing_description
     *
     * @date 2020-03-03 14:46:23
     */
    private String listingDescription;

    /**
     * 房源图片链接(最多九张)
     * This field corresponds to the database column house_resource.listing_pictures
     *
     * @date 2020-03-03 14:46:23
     */
    private String listingPictures;

    /**
     * 房源特色表id(最多五个)
     * This field corresponds to the database column house_resource.listing_features_ids
     *
     * @date 2020-03-03 14:46:23
     */
    private String listingFeaturesIds;

    /**
     * 物业类型表id
     * This field corresponds to the database column house_resource.property_type
     *
     * @date 2020-03-03 14:46:23
     */
    private String propertyType;

    /**
     * 开盘日期
     * This field corresponds to the database column house_resource.open_date
     *
     * @date 2020-03-03 14:46:23
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date openDate;

    /**
     * 置顶 0-否 1-是
     * This field corresponds to the database column house_resource.sticky
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer sticky;

    /**
     * 配套表id
     * This field corresponds to the database column house_resource.supporting_ids
     *
     * @date 2020-03-03 14:46:23
     */
    private String supportingIds;

    /**
     * 租赁期限
     * This field corresponds to the database column house_resource.lease_term
     *
     * @date 2020-03-03 14:46:23
     */
    private String leaseTerm;

    /**
     * 规格宽度
     * This field corresponds to the database column house_resource.specification_width
     *
     * @date 2020-03-03 14:46:23
     */
    private String specificationWidth;

    /**
     * 规格高度(厂房楼高)
     * This field corresponds to the database column house_resource.specification_height
     *
     * @date 2020-03-03 14:46:23
     */
    private String specificationHeight;

    /**
     * 经营状态 0-营业 1-非营业
     * This field corresponds to the database column house_resource.operating_status
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer operatingStatus;

    /**
     * 经营项目
     * This field corresponds to the database column house_resource.operating_item
     *
     * @date 2020-03-03 14:46:23
     */
    private String operatingItem;

    /**
     * 相关费用
     * This field corresponds to the database column house_resource.related_cost
     *
     * @date 2020-03-03 14:46:23
     */
    private String relatedCost;

    /**
     * 转让价格
     * This field corresponds to the database column house_resource.transfer_price
     *
     * @date 2020-03-03 14:46:23
     */
    private String transferPrice;

    /**
     * 售价(万)
     * This field corresponds to the database column house_resource.price
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer price;

    /**
     * 日价格
     * This field corresponds to the database column house_resource.day_rent
     *
     * @date 2020-03-03 14:46:23
     */
    private String dayRent;

    /**
     * 租赁方式
     * This field corresponds to the database column house_resource.leasing_method
     *
     * @date 2020-03-03 14:46:23
     */
    private String leasingMethod;

    /**
     * 建造时间
     * This field corresponds to the database column house_resource.build_time
     *
     * @date 2020-03-03 14:46:23
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date buildTime;

    /**
     * 层数
     * This field corresponds to the database column house_resource.floorNum
     *
     * @date 2020-03-03 14:46:23
     */
    private String floornum;

    /**
     * 估值
     * This field corresponds to the database column house_resource.valuation
     *
     * @date 2020-03-03 14:46:23
     */
    private String valuation;

    /**
     * 楼盘名称
     * This field corresponds to the database column house_resource.property_name
     *
     * @date 2020-03-03 14:46:23
     */
    private String propertyName;

    /**
     * 物业费
     * This field corresponds to the database column house_resource.property_cost
     *
     * @date 2020-03-03 14:46:23
     */
    private String propertyCost;

    /**
     * 建筑等级
     * This field corresponds to the database column house_resource.building_grade
     *
     * @date 2020-03-03 14:46:23
     */
    private String buildingGrade;

    /**
     * 使用率
     * This field corresponds to the database column house_resource.usage_rate
     *
     * @date 2020-03-03 14:46:23
     */
    private String usageRate;

    /**
     * 住宿数量
     * This field corresponds to the database column house_resource.room_num
     *
     * @date 2020-03-03 14:46:23
     */
    private String roomNum;

    /**
     * 装修层数
     * This field corresponds to the database column house_resource.decoration_floor
     *
     * @date 2020-03-03 14:46:23
     */
    private String decorationFloor;

    /**
     * 停车位
     * This field corresponds to the database column house_resource.parking_space
     *
     * @date 2020-03-03 14:46:23
     */
    private String parkingSpace;

    /**
     * 首付
     * This field corresponds to the database column house_resource.down_payment
     *
     * @date 2020-03-03 14:46:23
     */
    private String downPayment;

    /**
     * 土地主权
     * This field corresponds to the database column house_resource.land_sovereignty
     *
     * @date 2020-03-03 14:46:23
     */
    private String landSovereignty;

    /**
     * 使用计划
     * This field corresponds to the database column house_resource.use_plan
     *
     * @date 2020-03-03 14:46:23
     */
    private String usePlan;

    /**
     * 剩余租期
     * This field corresponds to the database column house_resource.remaining_lease
     *
     * @date 2020-03-03 14:46:23
     */
    private String remainingLease;

    /**
     * 车位类别
     * This field corresponds to the database column house_resource.parking_category
     *
     * @date 2020-03-03 14:46:23
     */
    private String parkingCategory;

    /**
     * 每平方价格
     * This field corresponds to the database column house_resource.square_price
     *
     * @date 2020-03-03 14:46:23
     */
    private String squarePrice;

    /**
     * 预付车位类型
     * This field corresponds to the database column house_resource.truck_space_type
     *
     * @date 2020-03-03 14:46:23
     */
    private String truckSpaceType;

    /**
     * 出售状态是否上下架 0-上架 1-下架
     * This field corresponds to the database column house_resource.sell_status
     *
     * @date 2020-03-03 14:46:23
     */
    private Integer sellStatus;

    /**
     * 经度
     * This field corresponds to the database column house_resource.longitude
     *
     * @date 2020-03-03 14:46:23
     */
    private BigDecimal longitude;

    /**
     * 纬度
     * This field corresponds to the database column house_resource.latitude
     *
     * @date 2020-03-03 14:46:23
     */
    private BigDecimal latitude;

    /**
     * 维语汉语标记
     * This field corresponds to the database column house_resource.sign_label
     *
     * @date 2020-03-03 14:46:23
     */
    private String signLabel;

    /**
     * 创建时间(申请时间)
     * This field corresponds to the database column house_resource.create_time
     *
     * @date 2020-03-03 14:46:23
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     * This field corresponds to the database column getidhouse_resource.update_time
     *
     * @date 2020-03-03 14:46:23
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date updateTime;

}
