### 我要估价,我要卖房,我要求购,委托出租
DROP TABLE IF EXISTS `user_house`;
CREATE TABLE `user_house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '当前登录人id',
  `user_name` varchar(20) NOT NULL COMMENT '会员名',
  `mobile_phone` varchar(20) NOT NULL COMMENT '手机号',
  `housing_zone` varchar(255) DEFAULT NULL COMMENT '小区具体区域',
  `city_zone` varchar(255) DEFAULT NULL COMMENT '城市区域',
  `area_code` varchar(255) DEFAULT NULL COMMENT '城市编码',
  `address` varchar(2048) DEFAULT NULL COMMENT '详细地址',
  `floor_info` varchar(255) DEFAULT NULL COMMENT '楼层信息 具体信息 中间 其他字段 ,隔开 例 3,13,23',
  `area` varchar(255) DEFAULT NULL COMMENT '面积',
  `decorate_type` varchar(255) DEFAULT NULL COMMENT '装修类型 0-毛坯房 1-简装 2-精装修 3-豪装',
  `attachment_info_id` varchar(255) DEFAULT NULL COMMENT '配套信息id ,隔开',
  `load_type` varchar(255) DEFAULT NULL COMMENT '上传类型 0我要估价 1我要卖房 2我要求购 3委托出租',
  `status` varchar(11) DEFAULT NULL COMMENT '审核状态 0待审核 1审核通过 2审核拒绝',
  `sign_label` varchar(255) DEFAULT NULL COMMENT '维语汉语标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户上传房子信息';

##维语
DROP TABLE IF EXISTS `uygur_user_house`;
CREATE TABLE `uygur_user_house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '当前登录人id',
  `user_name` varchar(20) NOT NULL COMMENT '会员名',
  `mobile_phone` varchar(20) NOT NULL COMMENT '手机号',
  `housing_zone` varchar(255) DEFAULT NULL COMMENT '小区具体区域',
  `city_zone` varchar(255) DEFAULT NULL COMMENT '城市区域',
  `area_code` varchar(255) DEFAULT NULL COMMENT '城市编码',
  `address` varchar(2048) DEFAULT NULL COMMENT '详细地址',
  `floor_info` varchar(255) DEFAULT NULL COMMENT '楼层信息 具体信息 中间 其他字段 ,隔开 例 3,13,23',
  `area` varchar(255) DEFAULT NULL COMMENT '面积',
  `decorate_type` varchar(255) DEFAULT NULL COMMENT '装修类型 0-毛坯房 1-简装 2-精装修 3-豪装',
  `attachment_info_id` varchar(255) DEFAULT NULL COMMENT '配套信息id ,隔开',
  `load_type` varchar(255) DEFAULT NULL COMMENT '上传类型 0我要估价 1我要卖房 2我要求购 3委托出租',
  `status` varchar(11) DEFAULT NULL COMMENT '审核状态 0待审核 1审核通过 2审核拒绝',
  `sign_label` varchar(255) DEFAULT NULL COMMENT '维语汉语标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户上传房子信息';

####我的关注
DROP TABLE IF EXISTS `favorite_house`;
CREATE TABLE `favorite_house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NOT NULL COMMENT '房源id',
  `user_id` bigint(20) NOT NULL COMMENT '会员id',
  `house_type` varchar(20) NOT NULL COMMENT '房源类型 0-新房 1-二手房 2-租房 3-别墅 4-商铺 5-写字楼 6-酒店 7-厂房 8-仓库 9-土地 10-车位',
  `language_type` varchar(20) NOT NULL COMMENT '房源类型 0-汉语 1-维语',
  `remark` varchar(255) default NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='我的 关注';


####最近联系经纪人
DROP TABLE IF EXISTS `last_contact`;
CREATE TABLE `last_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '会员id',
  `broker_id` bigint(20) NOT NULL COMMENT '经纪人id',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  `contract_time` datetime DEFAULT NULL COMMENT '联系时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='最近联系经纪人';

####意见反馈
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `feedback` varchar(1024) DEFAULT NULL  COMMENT '反馈内容',
  `contract` varchar(255) DEFAULT NULL  COMMENT '联系方式',
  `img_url` varchar(1024) DEFAULT NULL  COMMENT '图片地址',
  `remark` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `uygur_feedback`;
CREATE TABLE `uygur_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `feedback` varchar(1024) DEFAULT NULL  COMMENT '反馈内容',
  `contract` varchar(255) DEFAULT NULL  COMMENT '联系方式',
  `img_url` varchar(1024) DEFAULT NULL  COMMENT '图片地址',
  `remark` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE estate_user (
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	mobile_phone VARCHAR(50) NOT NULL COMMENT '手机号',
	open_id VARCHAR(255) DEFAULT NULL COMMENT '微信openId',
	device_type INT(1) DEFAULT NULL COMMENT '设备类型 0-ios 1-Android',
	device_token VARCHAR(255) DEFAULT NULL COMMENT '设备标识',
	area_code VARCHAR(16) DEFAULT NULL COMMENT '区域标识',
	nickname VARCHAR(255) DEFAULT NULL COMMENT '昵称',
	avatar_url VARCHAR(1024) DEFAULT NULL COMMENT '头像地址',
	sign_password VARCHAR(255) NOT NULL COMMENT '登陆密码',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	house_resourse_num INT(5) DEFAULT NULL COMMENT '房源数量',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';


CREATE TABLE estate_broker (
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	mobile_phone VARCHAR(50) NOT NULL COMMENT '手机号',
	sign_password VARCHAR(255) NOT NULL COMMENT '登陆密码',
	open_id VARCHAR(255) DEFAULT NULL COMMENT '微信openId',
	device_type INT(1) DEFAULT NULL COMMENT '设备类型 0-ios 1-Android',
	device_token VARCHAR(255) DEFAULT NULL COMMENT '设备标识',
	area_code VARCHAR(16) DEFAULT NULL COMMENT '区域标识',
	broker_name VARCHAR(255) NOT NULL COMMENT '经纪人姓名',
	work_area VARCHAR(255) DEFAULT NULL COMMENT '工作区域',
	work_shop VARCHAR(255) DEFAULT NULL COMMENT '工作店铺',
	broker_level INT(1) DEFAULT NULL COMMENT '经纪人级别 0-初级 1-中级 2-高级',
	birth_date DATETIME DEFAULT NULL COMMENT '出生年月',
	identity_number VARCHAR(255) DEFAULT NULL COMMENT '身份证号',
	home_address VARCHAR(255) DEFAULT NULL COMMENT '家庭住址',
	photo_url VARCHAR(1024) NOT NULL COMMENT '证件照URL',
	guest_number INT(2) DEFAULT NULL COMMENT '客源数量',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='经纪人表';

CREATE TABLE broker_guest (
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	client_name VARCHAR(50) NOT NULL COMMENT '客户姓名',
	client_phone VARCHAR(50) NOT NULL COMMENT '客户手机号',
	house_region VARCHAR(255) NOT NULL COMMENT '区域',
	area_code varchar(255) DEFAULT NULL COMMENT '城市编码',
	province_code varchar(255) DEFAULT NULL COMMENT '省编码',
	city_code varchar(255) DEFAULT NULL COMMENT '市编码',
	street_code varchar(255) DEFAULT NULL COMMENT '街道编码',
	price VARCHAR(30) NOT NULL COMMENT '金额',
	house_area VARCHAR(20) NOT NULL COMMENT '面积',
	house_type VARCHAR(20) NOT NULL COMMENT '户型',
	house_floor VARCHAR(20) NOT NULL COMMENT '楼层',
	towards INT(1) NOT NULL COMMENT '房屋朝向 0-东 1-西 2-南 3-北 4-南北 5-东西 6-东南 7-西南 8-东北 9-西北',
	decoration_type INT(1) NOT NULL COMMENT '装修类型 0-毛坯房 1-简装 2-精装修 3-豪装',
	reason_demand VARCHAR(1024) DEFAULT NULL COMMENT '需求原因',
	remark VARCHAR(1024) DEFAULT NULL COMMENT '备注',
	record_status INT(1) NOT NULL COMMENT '0-正常 1-前端删除',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	update_time DATETIME DEFAULT NULL COMMENT '更新时间',
	broker_id BIGINT(20) NOT NULL COMMENT '所属经纪人id',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='经纪人客源信息表';

DROP TABLE IF EXISTS house_resource;
CREATE TABLE `house_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `applicant_name` varchar(50) NOT NULL COMMENT '申请人姓名',
  `applicant_phone` varchar(50) NOT NULL COMMENT '申请人手机号',
  `broker_id` bigint(20) NOT NULL COMMENT '所属经纪人id',
  `estate_type` int(1) NOT NULL COMMENT '房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位',
  `use_way` int(1) NOT NULL COMMENT '用途 0-出租 1-出售 2-转让',
  `record_status` int(1) NOT NULL COMMENT '0-审核中 1-审核成功 2-审核失败 3-上架 4-下架',
  `area_code` varchar(16) NOT NULL COMMENT '区域标识',
  `owner_name` varchar(20) NOT NULL COMMENT '业主姓名',
  `owner_phone` varchar(50) NOT NULL COMMENT '业主联系电话',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `house_detail_type` int(1) DEFAULT NULL COMMENT '房屋类型 0-二手房 1-新房',
  `rental_type` int(1) DEFAULT NULL COMMENT '租房类型 0-整租 1-合租',
  `house_region` varchar(255) DEFAULT NULL COMMENT '区域',
  `plot_name` varchar(255) DEFAULT NULL COMMENT '小区名称',
  `address` varchar(1024) DEFAULT NULL COMMENT '详细地址',
  `house_number` varchar(30) DEFAULT NULL COMMENT '门牌号',
  `floor_information` varchar(30) DEFAULT NULL COMMENT '楼层信息',
  `build_year` datetime DEFAULT NULL COMMENT '建房年代',
  `maturity_assets` varchar(10) DEFAULT NULL COMMENT '资产期限',
  `decoration_type` int(1) DEFAULT NULL COMMENT '装修类型 0-毛坯房 1-简装 2-精装修 3-豪装',
  `elevator` int(1) DEFAULT NULL COMMENT '配备电梯 0-无 1-有',
  `house_type_room` int(20) DEFAULT NULL COMMENT '户型 室',
  `house_type_hall` int(20) DEFAULT NULL COMMENT '户型 厅',
  `house_type_toilet` int(20) DEFAULT NULL COMMENT '户型 卫',
  `house_area` decimal(14,3) DEFAULT NULL COMMENT '面积(平方米)',
  `towards` int(1) DEFAULT NULL COMMENT '房屋朝向 0-东 1-西 2-南 3-北 4-南北 5-东西 6-东南 7-西南 8-东北 9-西北',
  `monthly_rent` decimal(12,2) DEFAULT NULL COMMENT '月租金',
  `annual_rent` decimal(12,2) DEFAULT NULL COMMENT '年租金',
  `payment_method` int(1) DEFAULT NULL COMMENT '支付方式 0-压三付一 1-三月一付 2-半年一付 3-一年一付 4-全额 5-按揭 6-分期',
  `listing_description` varchar(1024) DEFAULT NULL COMMENT '房源描述',
  `listing_pictures` varchar(1024) NOT NULL COMMENT '房源图片链接(最多九张)',
  `listing_features_ids` varchar(50) NOT NULL COMMENT '房源特色表id(最多五个)',
  `property_type` varchar(50) NOT NULL COMMENT '物业类型表id',
  `open_date` datetime DEFAULT NULL COMMENT '开盘日期',
  `sticky` int(1) NOT NULL COMMENT '置顶 0-否 1-是',
  `supporting_ids` varchar(50) NOT NULL COMMENT '配套表id',
  `lease_term` varchar(20) DEFAULT NULL COMMENT '租赁期限',
  `specification_width` varchar(30) DEFAULT NULL COMMENT '规格宽度',
  `specification_height` varchar(30) DEFAULT NULL COMMENT '规格高度(厂房楼高)',
  `operating_status` int(1) DEFAULT NULL COMMENT '经营状态 0-营业 1-非营业',
  `operating_item` varchar(30) DEFAULT NULL COMMENT '经营项目',
  `related_cost` varchar(30) DEFAULT NULL COMMENT '相关费用',
  `transfer_price` varchar(30) DEFAULT NULL COMMENT '转让价格',
  `price` int(60) DEFAULT NULL COMMENT '售价(万)',
  `day_rent` varchar(30) DEFAULT NULL COMMENT '日价格',
  `leasing_method` varchar(100) DEFAULT NULL COMMENT '租赁方式',
  `build_time` datetime DEFAULT NULL COMMENT '建造时间',
  `floorNum` varchar(20) DEFAULT NULL COMMENT '层数',
  `valuation` varchar(30) DEFAULT NULL COMMENT '估值',
  `property_name` varchar(50) DEFAULT NULL COMMENT '楼盘名称',
  `property_cost` varchar(50) DEFAULT NULL COMMENT '物业费',
  `building_grade` varchar(30) DEFAULT NULL COMMENT '建筑等级',
  `usage_rate` varchar(50) DEFAULT NULL COMMENT '使用率',
  `room_num` varchar(30) DEFAULT NULL COMMENT '住宿数量',
  `decoration_floor` varchar(20) DEFAULT NULL COMMENT '装修层数',
  `parking_space` varchar(20) DEFAULT NULL COMMENT '停车位',
  `down_payment` varchar(50) DEFAULT NULL COMMENT '首付',
  `land_sovereignty` varchar(100) DEFAULT NULL COMMENT '土地主权',
  `use_plan` varchar(255) DEFAULT NULL COMMENT '使用计划',
  `remaining_lease` varchar(30) DEFAULT NULL COMMENT '剩余租期',
  `parking_category` varchar(255) DEFAULT NULL COMMENT '车位类别',
  `square_price` varchar(60) DEFAULT NULL COMMENT '每平方价格',
  `truck_space_type` varchar(30) DEFAULT NULL COMMENT '预付车位类型',
  `sell_status` int(1) NOT NULL COMMENT '出售状态是否上下架 0-上架 1-下架',
  `longitude` decimal(18,4) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(18,4) DEFAULT NULL COMMENT '纬度',
  `sign_label` varchar(255) NOT NULL COMMENT '维语汉语标记',
  `create_time` datetime NOT NULL COMMENT '创建时间(申请时间)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房源信息表'


DROP TABLE IF EXISTS uygur_house_resource;
CREATE TABLE `uygur_house_resource` (
  CREATE TABLE `uygur_house_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `applicant_name` varchar(50) NOT NULL COMMENT '申请人姓名',
  `applicant_phone` varchar(50) NOT NULL COMMENT '申请人手机号',
  `broker_id` bigint(20) NOT NULL COMMENT '所属经纪人id',
  `estate_type` int(1) NOT NULL COMMENT '房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位',
  `use_way` int(1) NOT NULL COMMENT '用途 0-出租 1-出售 2-转让',
  `record_status` int(1) NOT NULL COMMENT '0-审核中 1-审核成功 2-审核失败 3-上架 4-下架',
  `area_code` varchar(16) NOT NULL COMMENT '区域标识',
  `owner_name` varchar(20) NOT NULL COMMENT '业主姓名',
  `owner_phone` varchar(50) NOT NULL COMMENT '业主联系电话',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `house_detail_type` int(1) DEFAULT NULL COMMENT '房屋类型 0-二手房 1-新房',
  `rental_type` int(1) DEFAULT NULL COMMENT '租房类型 0-整租 1-合租',
  `house_region` varchar(255) DEFAULT NULL COMMENT '区域',
  `plot_name` varchar(255) DEFAULT NULL COMMENT '小区名称',
  `address` varchar(1024) DEFAULT NULL COMMENT '详细地址',
  `house_number` varchar(30) DEFAULT NULL COMMENT '门牌号',
  `floor_information` varchar(30) DEFAULT NULL COMMENT '楼层信息',
  `build_year` datetime DEFAULT NULL COMMENT '建房年代',
  `maturity_assets` varchar(10) DEFAULT NULL COMMENT '资产期限',
  `decoration_type` int(1) DEFAULT NULL COMMENT '装修类型 0-毛坯房 1-简装 2-精装修 3-豪装',
  `elevator` int(1) DEFAULT NULL COMMENT '配备电梯 0-无 1-有',
  `house_type_room` int(20) DEFAULT NULL COMMENT '户型 室',
  `house_type_hall` int(20) DEFAULT NULL COMMENT '户型 厅',
  `house_type_toilet` int(20) DEFAULT NULL COMMENT '户型 卫',
  `house_area` decimal(14,3) DEFAULT NULL COMMENT '面积(平方米)',
  `towards` int(1) DEFAULT NULL COMMENT '房屋朝向 0-东 1-西 2-南 3-北 4-南北 5-东西 6-东南 7-西南 8-东北 9-西北',
  `monthly_rent` decimal(12,2) DEFAULT NULL COMMENT '月租金',
  `annual_rent` decimal(12,2) DEFAULT NULL COMMENT '年租金',
  `payment_method` int(1) DEFAULT NULL COMMENT '支付方式 0-压三付一 1-三月一付 2-半年一付 3-一年一付 4-全额 5-按揭 6-分期',
  `listing_description` varchar(1024) DEFAULT NULL COMMENT '房源描述',
  `listing_pictures` varchar(1024) NOT NULL COMMENT '房源图片链接(最多九张)',
  `listing_features_ids` varchar(50) NOT NULL COMMENT '房源特色表id(最多五个)',
  `property_type` varchar(50) NOT NULL COMMENT '物业类型表id',
  `open_date` datetime DEFAULT NULL COMMENT '开盘日期',
  `sticky` int(1) NOT NULL COMMENT '置顶 0-否 1-是',
  `supporting_ids` varchar(50) NOT NULL COMMENT '配套表id',
  `lease_term` varchar(20) DEFAULT NULL COMMENT '租赁期限',
  `specification_width` varchar(30) DEFAULT NULL COMMENT '规格宽度',
  `specification_height` varchar(30) DEFAULT NULL COMMENT '规格高度(厂房楼高)',
  `operating_status` int(1) DEFAULT NULL COMMENT '经营状态 0-营业 1-非营业',
  `operating_item` varchar(30) DEFAULT NULL COMMENT '经营项目',
  `related_cost` varchar(30) DEFAULT NULL COMMENT '相关费用',
  `transfer_price` varchar(30) DEFAULT NULL COMMENT '转让价格',
  `price` int(60) DEFAULT NULL COMMENT '售价(万)',
  `day_rent` varchar(30) DEFAULT NULL COMMENT '日价格',
  `leasing_method` varchar(100) DEFAULT NULL COMMENT '租赁方式',
  `build_time` datetime DEFAULT NULL COMMENT '建造时间',
  `floorNum` varchar(20) DEFAULT NULL COMMENT '层数',
  `valuation` varchar(30) DEFAULT NULL COMMENT '估值',
  `property_name` varchar(50) DEFAULT NULL COMMENT '楼盘名称',
  `property_cost` varchar(50) DEFAULT NULL COMMENT '物业费',
  `building_grade` varchar(30) DEFAULT NULL COMMENT '建筑等级',
  `usage_rate` varchar(50) DEFAULT NULL COMMENT '使用率',
  `room_num` varchar(30) DEFAULT NULL COMMENT '住宿数量',
  `decoration_floor` varchar(20) DEFAULT NULL COMMENT '装修层数',
  `parking_space` varchar(20) DEFAULT NULL COMMENT '停车位',
  `down_payment` varchar(50) DEFAULT NULL COMMENT '首付',
  `land_sovereignty` varchar(100) DEFAULT NULL COMMENT '土地主权',
  `use_plan` varchar(255) DEFAULT NULL COMMENT '使用计划',
  `remaining_lease` varchar(30) DEFAULT NULL COMMENT '剩余租期',
  `parking_category` varchar(255) DEFAULT NULL COMMENT '车位类别',
  `square_price` varchar(60) DEFAULT NULL COMMENT '每平方价格',
  `truck_space_type` varchar(30) DEFAULT NULL COMMENT '预付车位类型',
  `sell_status` int(1) NOT NULL COMMENT '出售状态是否上下架 0-上架 1-下架',
  `longitude` decimal(18,4) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(18,4) DEFAULT NULL COMMENT '纬度',
  `sign_label` varchar(255) NOT NULL COMMENT '维语汉语标记',
  `create_time` datetime NOT NULL COMMENT '创建时间(申请时间)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房源信息表(维语)'

CREATE TABLE data_configuration (
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	parent_id BIGINT(20) DEFAULT NULL COMMENT '父级目录配置id',
	description VARCHAR(255) DEFAULT NULL COMMENT '描述',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	update_time DATETIME DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='房产配置表';


####看房记录
DROP TABLE IF EXISTS `scan_house_record`;
CREATE TABLE `scan_house_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NOT NULL COMMENT '房源id',
  `user_id` bigint(20) NOT NULL COMMENT '会员id',
  `language_type` varchar(20) NOT NULL COMMENT '房源类型 0-汉语 1-维语',
  `remark` varchar(255) default NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='我的 看房记录';

DROP TABLE IF EXISTS `advertising`;
CREATE TABLE `advertising` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar (256) NOT NULL COMMENT '标题',
  `status` varchar (10) NOT NULL COMMENT '0 开启 1 关闭',
  `location` varchar(20) NOT NULL COMMENT '位置',
  `url_address` varchar(1024) NOT NULL COMMENT 'url地址',
  `sorts` varchar(20) NOT NULL COMMENT '排序',
  `effect_time` datetime not NULL COMMENT '生效时间',
  `failure_time` datetime not NULL COMMENT '失效时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='广告轮播';


ALTER TABLE `estate`.`last_contact`
ADD UNIQUE INDEX `INDEX_USER_ID_BROKER_ID`(`user_id`, `broker_id`) USING BTREE COMMENT '会员id联系人唯一索引';