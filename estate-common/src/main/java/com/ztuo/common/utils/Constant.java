/*
 * 项目名称:my-museum
 * 类名称:Constant.java
 * 包名称:com.platform.common.utils
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.common.utils;

/**
 * 常量
 *
 * @author gs
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final String SUPER_ADMIN = "1";
    /**
     * 超级管理员所属机构
     */
    public static final String SUPER_ADMIN_ORG = "01";

    public static final String DEFAULT_PW = "Tgy1225";

    /**
     * 6小时后过期
     */
    public static final int EXPIRE = 3600 * 6;

    /**
     * 云存储配置KEY
     */
    public final static String CLOUD_STORAGE_CONFIG_KEY = "CLOUD_STORAGE_CONFIG_KEY";

    /**
     * 短信配置KEY
     */
    public final static String SMS_CONFIG_KEY = "SMS_CONFIG_KEY";

    /**
     * 权限前缀
     */
    public static final String SESSION = "SESSION:";

    /**
     * 系统缓存前缀
     */
    public static final String SYS_CACHE = "SYS_CACHE:";

    /**
     * 业务系统缓存前缀
     */
    public static final String MTM_CACHE = "MTM_CACHE:";

    public static final String STR_ZERO = "0";
    public static final String STR_ONE = "1";
    public static final String STR_TWO = "2";
    public static final String STR_THREE = "3";
    public static final String STR_FOUR = "4";

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    /**
     * 未关注
     */
    public static final int UNSUBSCRIBE = 0;
    /**
     * 关注
     */
    public static final int SUBSCRIBE = 1;
    /**
     * 空字符串
     */
    public static final String BLANK = "";
    /**
     * 斜杠
     */
    public static final String SLASH = "/";
    /**
     * 逗号
     */
    public static final String COMMA = ",";
    /**
     * 句号
     */
    public static final String DOT = ".";
    /**
     * 冒号
     */
    public static final String COLON = ":";
    /**
     * 下划线
     */
    public static final String UNDERSCORE = "_";
    /**
     * 换行符
     */
    public static final String LINE_BREAK = "\\r\\n";

    public static final String ACCESS_TOKEN = "ACCESS-TOKEN";

    public static final int ACCESS_TOKEN_TIME_OUT = 604800 ;

    public static final String BPMN20 = ".bpmn20.xml";

    public static final String IMAGE = "image";

    public static final String XML = "xml";
    public static final String PNG = "png";
    public static final String BAR = "bar";
    public static final String ZIP = "zip";
    public static final String BPMN = "bpmn";

    /**
     * 系统邮件签名
     */
    public static final String SIGNATURE_STR = "<br><font color='red'>-------------------------------------------------------------------<br>以上内容为邮件系统自动发送，请勿直接回复。</font>";

    /**
     * 系统自动邮件
     */
    public static final int SYS_SEND = 0;
    /**
     * 操作人主动邮件
     */
    public static final int USER_SEND = 1;

    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3),
        /**
         * 服务器存储
         */
        DISCK(4),
        /**
         * FastDFS
         */
        FAST_DFS(5);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static  String EASEMOB_ACCESS_TOKEN="EASEMOB_ACCESS_TOKEN";
    /**
     * 单位id
     */


    /**
     * 加密
     */
    public static final String KEY = "29roeyufuqphribl";
    public static final String ALGORITHMSTR_CBC = "AES/CBC/PKCS5Padding";
    public static final String ALGORITHMSTR_ECB = "AES/ECB/PKCS5Padding";
    public static final String VI = "0102030405060708";


    /**
     * 注册相关信息 短信验证码
     */
    public static final String REGISTER_CUSTOMER_MOBILE_PHONE="REGISTER_CUSTOMER_MOBILE_PHONE_";
    public static final int REGISTER_CUSTOMER_MOBILE_PHONE_ERPIRE_OUT=600;
    /**
     * 发送间隔
     */
    public static final String REGISTER_PHONE_VERIFY_CODE_TIME = "REGISTER_PHONE_VERIFY_CODE_TIME_";
    public static final int REGISTER_PHONE_VERIFY_CODE_TIME_TIME_OUT = 60;
    /**
     * 安全时长 保证一天只加一次
     */
    public static final String WORK_UNIT_INCREASE_SAFETY_DURATION="WORK_UNIT_INCREASE_SAFETY_DURATION_";


    public static String ORDER_REMIND="接单提醒,工单:%s已分配请及时登录预约处理";

    /**工单下过之后5个小时做出响应，未响应了系统默认售后放弃(单位:小时)
     *
     */
    public static final String SUB_TIME = "sub_time";

    /**最大预约时间(单位:天)
     *
     */
    public static final String SUB_MAX_TIME = "sub_max_time";

    public static final String MESSAGE_REMIND = "MESSAGE_REMIND_";

    public static final String PROMOTION_CODE = "PROMOTION_CODE_";

    public static final String NEW_MARKET_PRICE="NEW_MARKET_PRICE_";

    /**
     * 手机注册发送验证码
     */
    public static final String REGISTER_PHONE_CODE="REGISTER_PHONE_CODE_";

    /**
     * 注册验证码有效时长
     */
    public static final int REGISTER_PHONE_CODE_VALID_TIME = 5;

    /**
     * 登录验证码
     */
    public static final String LOGIN_PHONE_CODE_ = "LOGIN_PHONE_CODE_";
    public static final int LOGIN_PHONE_CODE_VALID_TIME = 5;
    public static final String LOGIN_PHONE_CODE_TIME_OUT = "LOGIN_PHONE_CODE_TIME_OUT";
    public static final int LOGIN_PHONE_CODE_TIME_OUT_NUM = 60;
    /**
     * 忘记密码
     */
    public static final String FORGET_PHONE_CODE_ = "FORGET_PHONE_CODE_";
    public static final int FORGET_PHONE_CODE_VALID_TIME = 5;
    public static final String FORGET_PHONE_CODE_TIME_OUT = "FORGET_PHONE_CODE_TIME_OUT";
    public static final int FORGET_PHONE_CODE_TIME_OUT_NUM = 60;

    /**
     * MD5加密字符串
     */
    public static final String MD5KEY = "XehGyeyrVgOV4P8Uf70REVpIw3iVNwNs";

    /**
     * zh-中文，en-英文，wy-维语（不传默认为中文）
     */
    public static final String HEADER_LANGUAGE="Header-Language";
    /**
     * 当前登录人id
     */
    public static final String HEADER_USER_ID = "User-Id" ;


    /**
     * 审核状态 0-审核中 1-审核成功 2-审核失败
     */
    public static final Integer AUDIT_ING = 0;
    public static final Integer AUDIT_SUCCESS = 1;
    public static final Integer AUDIT_ERROR = 2;

    public static final String DATA_CONFIGURATION="DATA_CONFIGURATION:";

    public static final String CUSTOMER = "c";
    public static final String BROKER = "b";

    public static final String IDENTAITY_HERADER="Identity-Header";


    public static final String INFO_DATA_CONFIGURATION="INFO_DATA_CONFIGURATION:";

    public static final String WY_DATA_CONFIGURATION="WY_DATA_CONFIGURATION:";

    /**
     * 设备标识头，值：app  pc
     */
    public static final String DEVICE_HEADER = "Device-Header";


}
