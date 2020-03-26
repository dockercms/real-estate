package com.ztuo.modules.es.dao;

import com.ztuo.modules.es.entity.UyHouseDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/5 3:11 下午
 */
public interface UyHouseDocRepository extends ElasticsearchRepository<UyHouseDoc,Long>,
        PagingAndSortingRepository<UyHouseDoc,Long> {

}
