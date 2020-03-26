package com.ztuo.modules.app.estate;

import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.es.dao.HouseDocRepository;
import com.ztuo.modules.es.dao.UyHouseDocRepository;
import com.ztuo.modules.es.entity.HouseDoc;
import com.ztuo.modules.es.entity.UyHouseDoc;
import com.ztuo.modules.es.vo.HouseDocVo;
import com.ztuo.modules.house.service.IHouseResourceSV;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/5 3:14 下午
 */
@Slf4j
@RestController
@RequestMapping("house/search")
public class HouseDocController extends RestResponse {

    @Autowired
    private HouseDocRepository repository;

    @Autowired
    private UyHouseDocRepository uyHouseDocRepository;

    @Autowired
    private IHouseResourceSV houseResourceSV;

//    /**
//     */
//    @IgnoreAuth
//    @RequestMapping(value = "/insert",method = RequestMethod.GET)
//    public RestResponse search() throws Exception{
//        HouseResource house = houseResourceSV.getByPrimaryKey(56L);
//        HouseResource houseT = houseResourceSV.getByPrimaryKey(57L);
//
//        HouseDoc houseDoc = new HouseDoc();
//        HouseDoc houseDocT = new HouseDoc();
//        UyHouseDoc uyHouseDoc = new UyHouseDoc();
//        UyHouseDoc uyHouseDocT = new UyHouseDoc();
//        BeanUtils.copyProperties(house,houseDoc);
//        BeanUtils.copyProperties(houseT,houseDocT);
//        BeanUtils.copyProperties(house,uyHouseDoc);
//        BeanUtils.copyProperties(houseT,uyHouseDocT);
//        log.info("------copy完成---");
//        repository.save(houseDoc);
//        repository.save(houseDocT);
//        uyHouseDocRepository.save(uyHouseDoc);
//        uyHouseDocRepository.save(uyHouseDocT);
//        return success();
//    }
    /**
     * 模糊查询房源(市,区域,小区名称)
     * @param houseDocVo
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public RestResponse search(HttpServletRequest request, @Valid @RequestBody HouseDocVo houseDocVo) {
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        String content = "*"+houseDocVo.getName()+"*";
        queryBuilder.must(QueryBuilders.boolQuery().should(QueryBuilders.wildcardQuery("houseRegionCity",content))
        .should(QueryBuilders.wildcardQuery("houseRegionArea",content))
        .should(QueryBuilders.wildcardQuery("plotName",content)));

        queryBuilder.must(QueryBuilders.termQuery("estateType",houseDocVo.getEstateType()));

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(queryBuilder);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(houseDocVo.getPageNum()-1,houseDocVo.getPageSize(),sort);
        nativeSearchQueryBuilder.withPageable(pageable);
        NativeSearchQuery query = nativeSearchQueryBuilder.build();
        if (header != null && "wy".equals(header)){
            Page<UyHouseDoc> page = uyHouseDocRepository.search(query);
            com.baomidou.mybatisplus.extension.plugins.pagination.Page result =
                    new com.baomidou.mybatisplus.extension.plugins.pagination.Page();
            result.setTotal(page.getTotalElements());
            result.setRecords(page.getContent());
            return success(result);
        }else {
            Page<HouseDoc> page = repository.search(query);
            com.baomidou.mybatisplus.extension.plugins.pagination.Page result =
                    new com.baomidou.mybatisplus.extension.plugins.pagination.Page();
            result.setTotal(page.getTotalElements());
            result.setRecords(page.getContent());
            return success(result);
        }
    }


    @IgnoreAuth
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public RestResponse search(@RequestParam("id")Long id) {
        repository.deleteById(id);
        uyHouseDocRepository.deleteById(id);
        return success();
    }
}
