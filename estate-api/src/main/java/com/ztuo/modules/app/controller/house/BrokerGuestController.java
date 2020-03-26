package com.ztuo.modules.app.controller.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.BrokerGuest;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.service.IBrokerGuestSV;
import com.ztuo.modules.house.service.IEstateBrokerSV;
import com.ztuo.modules.house.vo.BrokerGuestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @description: BrokerGuestController
 * @author: MrGao
 * @create: 2020/02/15 12:02
 */
@Slf4j
@RestController
@RequestMapping("broker")
public class BrokerGuestController {

    @Autowired
    private IBrokerGuestSV brokerGuestSV ;

    @Autowired
    private IEstateBrokerSV estateBrokerSV ;

    /**
     * 分页查询 我的客源
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "page_query",method = RequestMethod.POST)
    public RestResponse pageQueryBrokerGuest(HttpServletRequest request, @RequestBody BrokerGuestVo queryVo) throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        log.info("分页查询我的客源={},userId={}",queryVo,userId);
        queryVo.setUserId(Long.parseLong(userId));
        queryVo.setStatus("0");
        Page<BrokerGuest> page = brokerGuestSV.pageQuery(queryVo,null);
        return RestResponse.success(page);
    }

    /**
     * 新增我的客源
     * @param request
     * @param guest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public RestResponse addBrokerGuest(HttpServletRequest request,@RequestBody BrokerGuest guest)throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        guest.setBrokerId(Long.parseLong(userId));
        EstateBroker broker = estateBrokerSV.getByPrimaryKey(guest.getBrokerId());
        if(broker!=null){
            Integer guestNumber = broker.getGuestNumber();
            guestNumber = guestNumber==null?1:guestNumber+1;
            log.info("新增我的客源,添加经纪人客源信息={}",guestNumber);
            broker.setGuestNumber(guestNumber);
            estateBrokerSV.updateByPrimaryKeySelective(broker);
        }
        guest.setCreateTime(new Date());
        guest.setRecordStatus(0);
        log.info("新增我的客源={}",guest);
        brokerGuestSV.save(guest);
        return RestResponse.success("新增成功");
    }

    /**
     * 修改客源信息
     * @param request
     * @param guest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RestResponse updateBrokerGuest(HttpServletRequest request,@RequestBody BrokerGuest guest)throws Exception{
        log.info("修改我的客源={}",guest);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        BrokerGuest dataGuest = brokerGuestSV.getByPrimaryKey(guest.getId());
        Long brokerId = dataGuest.getBrokerId();
        if(!userId.equalsIgnoreCase(brokerId.toString())){
            return RestResponse.error("信息不符合,请核查信息");
        }
        guest.setBrokerId(Long.parseLong(userId));
        guest.setUpdateTime(new Date());
        guest.setRecordStatus(0);
        brokerGuestSV.updateByPrimaryKeySelective(guest);
        return RestResponse.success("修改成功");
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public RestResponse deleteBrokerGuest(HttpServletRequest request, @PathVariable("id")Long id)throws Exception{
        log.info("删除我的客源={}",id);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        BrokerGuest dataGuest = brokerGuestSV.getByPrimaryKey(id);
        Long brokerId = dataGuest.getBrokerId();
        if(!userId.equalsIgnoreCase(brokerId.toString())){
            return RestResponse.error("信息不符合,请核查信息");
        }
        if(dataGuest ==null){
            return RestResponse.error("信息不存在");
        }
        BrokerGuest guest = new BrokerGuest();
        guest.setId(id);
        guest.setRecordStatus(1);
        guest.setUpdateTime(new Date());
        brokerGuestSV.updateByPrimaryKeySelective(guest);
        return RestResponse.success("删除成功");
    }


}
