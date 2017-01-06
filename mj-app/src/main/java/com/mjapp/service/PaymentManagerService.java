package com.mjapp.service;

import com.alibaba.fastjson.JSONObject;
import com.mjapp.dao.ActivityTbMapper;
import com.mjapp.dao.GoodsTbMapper;
import com.mjapp.dao.OrderSubTbMapper;
import com.mjapp.dao.OrderTbMapper;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.GoodsTb;
import com.mjapp.model.OrderSubTb;
import com.mjapp.model.OrderTb;
import com.mjapp.model.constant.ORDERBILLFLAG;
import com.mjapp.model.constant.ORDERPAYSTATUS;
import com.mjapp.model.constant.ORDERSTATUS;
import com.mjapp.model.constant.PAYTYPE;
import com.mjapp.util.OrderSnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: PaymentManagerService
 * @description: 支付, 下单相关Service
 * @author: zhangfan
 * @data: 2016年12月04日 14:39
 */
@Service
public class PaymentManagerService {


    @Autowired
    private ActivityTbMapper activityTbMapper;
    @Autowired
    private GoodsTbMapper goodsTbMapper;
    @Autowired
    private OrderTbMapper orderTbMapper;
    @Autowired
    private OrderSubTbMapper orderSubTbMapper;


    /**
     * 创建 订单
     *
     * @param activityId
     * @param userId
     * @param paytype
     * @return
     */
    public OrderTb createOrderS(Integer activityId, Integer userId, PAYTYPE paytype) {

        OrderTb orderTb = new OrderTb();
        OrderSubTb orderSubTb = new OrderSubTb();

        ActivityTb activityTb = new ActivityTb();
        activityTb.setId(activityId);
        activityTb = activityTbMapper.getUniqueBy(activityTb);
        orderTb.setActivityId(activityTb.getId());
        orderTb.setUserId(userId);
        orderTb.setPayStatus(ORDERPAYSTATUS.WAITPAY.getValue());
        orderTb.setStatus(ORDERSTATUS.CREATE.getValue());
        orderTb.setSn(OrderSnUtil.get());
        orderTb.setPayPrice(new BigDecimal(0));

        orderSubTb.setPayTypeCode(paytype.getValue());
        orderSubTb.setPayTypeName(paytype.getName());
        orderSubTb.setOrderSn(orderTb.getSn());
        orderSubTb.setActivityName(activityTb.getName());
        orderSubTb.setStoreJson(activityTb.getStoreJson());
        orderSubTb.setBillFlag(ORDERBILLFLAG.NO.getValue());
        orderSubTb.setActivityId(activityId);

        List<Integer> storeIdList = JSONObject.parseArray(activityTb.getStoreJson(), Integer.class);

        List<GoodsTb> goodsTbList = new ArrayList<>();
        for (Integer storeId : storeIdList) {

            GoodsTb goodsTb = new GoodsTb();
            goodsTb.setStoreId(storeId);
            goodsTb = goodsTbMapper.getUniqueBy(goodsTb);
            goodsTbList.add(goodsTb);

            orderTb.setPayPrice(orderTb.getPayPrice().add(goodsTb.getMinimumcharge()));
        }
        orderSubTb.setGoodsJson(JSONObject.toJSONString(goodsTbList));

        orderTb.setPrice(orderTb.getPayPrice());

        orderTbMapper.save(orderTb);
        orderSubTb.setOrderId(orderTb.getId());
        orderSubTbMapper.save(orderSubTb);

        return orderTb;
    }

}
