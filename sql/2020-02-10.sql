

CREATE TABLE `SYS_ORG_TRAN` (
  `ORG_NO` varchar(10) NOT NULL COMMENT '机构编码',
  `ORG_NAME` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `PARENT_NO` varchar(10) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  `ORG_TYPE` int(11) DEFAULT NULL COMMENT '级别',
  `STATUS` int(11) DEFAULT '1' COMMENT '状态  0：无效   1：有效',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建者ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ORG_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构';

CREATE TABLE `tb_app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_cate` char(1) NOT NULL COMMENT '0安卓.1IOS',
  `app_version` varchar(255) NOT NULL COMMENT 'app版本',
  `app_down_url` varchar(255) NOT NULL COMMENT '下载地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `app_upgrade_content` text COMMENT '升级内容',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `tb_app_version` VALUES (1,'0','1.0.0','http://39.98.36.167/app/museum_user_1.0.0.apk','2019-07-18 12:50:22','本次更新',NULL),(2,'1','1.0.0','http://39.98.36.167/app/museum_master_1.0.0.apk','2019-07-18 12:50:30','本次更新',NULL),(3,'2','1.0.0','奥迪','2019-07-22 04:01:06','阿萨德',NULL),(4,'3','1.0.0','http://39.98.36.167/vic/default.png','2019-07-31 06:51:58','本次更新内容：暗示国家大事骄傲干啥',NULL);



ALTER TABLE `SYS_ORG` ADD COLUMN `ORG_NAME_WY` varchar(100) NULL COMMENT '维语名称' AFTER `CREATE_TIME`;




CREATE TABLE `build_district` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `super_parent_no` varchar(10) DEFAULT NULL COMMENT '上级机构ID',
  `parent_no` varchar(10) DEFAULT NULL COMMENT '上级机构ID',
  `build_cate` char(1) NOT NULL COMMENT '0砖混1钢筋混凝土2钢结构',
  `area_code` char(1) NOT NULL COMMENT '所属市',
  `apply_name` varchar(256) NOT NULL COMMENT '申请人',
  `build_name` varchar(256) NOT NULL COMMENT '小区名称',
  `build_name_wy` varchar(256) NOT NULL COMMENT '小区名称',
  `detail_address` varchar(1024) NOT NULL COMMENT '详细地址',
  `detail_address_wy` varchar(1024) NOT NULL COMMENT '详细地址维语',
  `build_years` int(2) NOT NULL COMMENT '年限',
  `build_status` char(1) default '0' COMMENT '0可用1不可用',
  `create_years` int(4) NOT NULL COMMENT '建成年代',
  `developer` varchar (512) default NULL COMMENT '物业类型',
  `development` varchar (512) default NULL COMMENT '开发商',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小区管理';

DROP TABLE IF EXISTS `user_agreement`;
CREATE TABLE `user_agreement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` varchar(10) DEFAULT NULL COMMENT '0有效 1无效',
  `agreement_type` varchar(1) DEFAULT NULL COMMENT '0用户端 1客户端',
  `agreement_name` varchar(256) DEFAULT NULL COMMENT '协议名称',
  `agreement_desc` varchar(256) NOT NULL COMMENT '协议描述',
  `agreement_address` varchar(1024) default NULL COMMENT '协议地址',
  `agreement_content` text default NULL COMMENT '协议内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='协议管理';



ALTER TABLE `estate`.`build_district` ADD COLUMN `area_code` varchar(10) default NULL COMMENT '所属市' ;
ALTER TABLE `estate`.`build_district` ADD COLUMN `development` varchar(512) default NULL COMMENT '开发商';
