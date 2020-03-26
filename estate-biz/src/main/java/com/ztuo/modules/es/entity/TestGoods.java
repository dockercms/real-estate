package com.ztuo.modules.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/5 3:08 下午
 */
@Data
@Document(indexName = "goods",type = "goods")
public class TestGoods {

    @Id
    private Long id;

    private String name;

    @Version
    private Long version;
}
