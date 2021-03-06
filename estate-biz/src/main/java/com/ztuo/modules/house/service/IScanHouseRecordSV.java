package com.ztuo.modules.house.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.ScanHouseRecord;
import com.ztuo.modules.house.entity.ScanHouseRecordExample;
import com.ztuo.modules.house.vo.BaseQueryVo;

import java.util.List;

public interface IScanHouseRecordSV {
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int countByExample(ScanHouseRecordExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int deleteByExample(ScanHouseRecordExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int deleteByPrimaryKey(Long parameterId) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int save(ScanHouseRecord record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int saveSelective(ScanHouseRecord record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    List<ScanHouseRecord> getByExample(ScanHouseRecordExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    ScanHouseRecord getByPrimaryKey(Long parameterId) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int updateByExampleSelective(ScanHouseRecord record, ScanHouseRecordExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int updateByExample(ScanHouseRecord record, ScanHouseRecordExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int updateByPrimaryKeySelective(ScanHouseRecord record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table scan_house_record
     *
     * @date 2020-03-02 18:25:52
     */
    int updateByPrimaryKey(ScanHouseRecord record) throws Exception;

    Page<ScanHouseRecord> pageQuery(BaseQueryVo queryVo);
}
