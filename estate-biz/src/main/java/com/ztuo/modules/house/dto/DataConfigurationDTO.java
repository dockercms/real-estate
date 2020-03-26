package com.ztuo.modules.house.dto;

import com.ztuo.modules.house.entity.DataConfiguration;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dupinyan
 * @Description: 配置DTO
 * @Date: 2020/3/7 11:17
 * @Version: 1.0
 */
@Data
public class DataConfigurationDTO {

    /**
     *
     * 1-物业类型
     * 2-房源特色
     * 3-资产期限
     * 4-配套
     * 1001-房源分类
     * 1002-租房分类
     * 1003-装修类型
     * 1004-配备电梯
     * 1005-朝向
     * 1006-支付方式
     * 1007-置顶
     * 1008-营业状态
     * 1009-房屋类型
     */

    public List<DataConfiguration> getCategories() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(5L, 0L, "房源分类", "房源分类维语");
        //房源分类(房屋类型 ئۆي تىپى)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1001L, "住宅", "تۇرالغۇ");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1001L, "别墅", "داچا");
        DataConfiguration dataConfiguration3 = new DataConfiguration(2L, 1001L, "商铺", "دۇكان");
        DataConfiguration dataConfiguration4 = new DataConfiguration(3L, 1001L, "写字楼", "ئىشخانا");
        DataConfiguration dataConfiguration5 = new DataConfiguration(4L, 1001L, "酒店", "مېھمانخانا");
        DataConfiguration dataConfiguration6 = new DataConfiguration(5L, 1001L, "厂房", "زاۋۇت");
        DataConfiguration dataConfiguration7 = new DataConfiguration(6L, 1001L, "仓库", "ئامبار");
        DataConfiguration dataConfiguration8 = new DataConfiguration(7L, 1001L, "土地", "يەر-زېمىن");
        DataConfiguration dataConfiguration9 = new DataConfiguration(8L, 1001L, "车位", "ماشىنا توختىتىش ئورنى");
        DataConfiguration dataConfiguration10 = new DataConfiguration(9L, 1001L, "新房", "يېڭى ئۆي");
        DataConfiguration dataConfiguration11 = new DataConfiguration(10L, 1001L, "二手房", "نىمكەش ئۆي");
        DataConfiguration dataConfiguration12 = new DataConfiguration(11L, 1001L, "租房", "ئىجارە ئۆي");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        list.add(dataConfiguration3);
        list.add(dataConfiguration4);
        list.add(dataConfiguration5);
        list.add(dataConfiguration6);
        list.add(dataConfiguration7);
        list.add(dataConfiguration8);
        list.add(dataConfiguration9);
        list.add(dataConfiguration10);
        list.add(dataConfiguration11);
        list.add(dataConfiguration12);
        return list;
    }

    public List<DataConfiguration> getRentalType() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(6L, 0L, "租房类型", "租房分类维语");
        //租房类型 (ئىجارە شەكلى)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1002L, "整租", "پۈتۈن ئىجارە");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1002L, "合租", "شىرىك ئىجارە");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        return list;
    }


    public List<DataConfiguration> getDecorationType() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(7L, 0L, "装修类型", "装修类型维语");
        //装修类型装修类型 بىزىلىشى
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1003L, "毛坯房", "بىزەلمىگەن");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1003L, "简装", "ئاددىي بېزەلگەن");
        DataConfiguration dataConfiguration3 = new DataConfiguration(2L, 1003L, "精装修", "نەپىس بىزەلگەن");
        DataConfiguration dataConfiguration4 = new DataConfiguration(3L, 1003L, "豪装", "ھەشەمەت بىزەلگەن");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        list.add(dataConfiguration3);
        list.add(dataConfiguration4);
        return list;
    }

    public List<DataConfiguration> getElevator() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(8L, 0L, "配备电梯", "配备电梯");
        //配备电梯(لىفىت سەپلىنشى)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1004L, "无", "سەپلەنمىگەن");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1004L, "有", "سەپلەنگەن");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        return list;
    }


    public List<DataConfiguration> getTowards() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(9L, 0L, "朝向", "朝向");
        //朝向(يۆنىلىش)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1005L, "东", "دوڭ");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1005L, "西", "غەرىب");
        DataConfiguration dataConfiguration3 = new DataConfiguration(2L, 1005L, "南", "جەنۇب");
        DataConfiguration dataConfiguration4 = new DataConfiguration(3L, 1005L, "北", "شىمال");
        DataConfiguration dataConfiguration5 = new DataConfiguration(4L, 1005L, "南北", "نامباك");
        DataConfiguration dataConfiguration6 = new DataConfiguration(5L, 1005L, "东西", "نەرسىلىرىنى");
        DataConfiguration dataConfiguration7 = new DataConfiguration(6L, 1005L, "东南", "شەرقىي جەنۇب");
        DataConfiguration dataConfiguration8 = new DataConfiguration(7L, 1005L, "西南", "غەربىي جەنۇب");
        DataConfiguration dataConfiguration9 = new DataConfiguration(8L, 1005L, "东北", "شەرقىي شىمال");
        DataConfiguration dataConfiguration10 = new DataConfiguration(9L, 1005L, "西北", "غەربىي شىمال");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        list.add(dataConfiguration3);
        list.add(dataConfiguration4);
        list.add(dataConfiguration5);
        list.add(dataConfiguration6);
        list.add(dataConfiguration7);
        list.add(dataConfiguration8);
        list.add(dataConfiguration9);
        list.add(dataConfiguration10);

        return list;
    }

    public List<DataConfiguration> getPaymentMethod() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(10L, 0L, "支付方式", "支付方式");
        //支付方式(تۆلەش ئۇسۇلى)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1006L, "押一付三", "بىر ئايلىق");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1006L, "一月一付", "ئايلىق ئىجارىسى");
        DataConfiguration dataConfiguration3 = new DataConfiguration(2L, 1006L, "三月一付", "ئۈچ ئايلىق");
        DataConfiguration dataConfiguration4 = new DataConfiguration(3L, 1006L, "半年一付", "يېرىم يىللىق");
        DataConfiguration dataConfiguration5 = new DataConfiguration(4L, 1006L, "一年一付", "يىللىق ئىجارىسى");
        DataConfiguration dataConfiguration6 = new DataConfiguration(5L, 1006L, "全额", "پۈتۈن سومما");
        DataConfiguration dataConfiguration7 = new DataConfiguration(6L, 1006L, "按揭", "قەرزى قىلىش");
        DataConfiguration dataConfiguration8 = new DataConfiguration(7L, 1006L, "分期", "مۇددەتكە بۈلۈش");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        list.add(dataConfiguration3);
        list.add(dataConfiguration4);
        list.add(dataConfiguration5);
        list.add(dataConfiguration6);
        list.add(dataConfiguration7);
        list.add(dataConfiguration8);

        return list;
    }


    public List<DataConfiguration> getSticky() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(11L, 0L, "置顶", "置顶");
        //置顶(چۇقلاش)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1007L, "否", "ياق");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1007L, "是", "شۇنداق");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        return list;
    }

    public List<DataConfiguration> getOperatingStatus() {
        List<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration(12L, 0L, "营业状态", "营业状态");
        //营业状态(تىجارەت ھالىتى)
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1008L, "营业", "تىجارەتلىك");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1008L, "非营业", "تىجارەتسىز");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        return list;
    }


    public List<DataConfiguration> getHouseDetailType() {
        List<DataConfiguration> list = new ArrayList<>();
        DataConfiguration dataConfiguration1 = new DataConfiguration(0L, 1009L, "二手房", "نىمكەش ئۆي");
        DataConfiguration dataConfiguration2 = new DataConfiguration(1L, 1009L, "新房", "يېڭى ئۆي");
        list.add(dataConfiguration1);
        list.add(dataConfiguration2);
        return list;
    }
    

}
