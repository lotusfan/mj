package com.mjapp.payment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: CallBackService
 * @description: 支付回调
 * @author: zhangfan
 * @data: 2016年11月13日 17:36
 */
public class CallBackService {


    /**
     * 订单支付成功  减少活动可购买数（NO）
     *
     * @param count
     * @param guid
     */
    public void updateBuyPeopleCount(Integer count, String guid) {
        try {

            Map<String, String> map = new HashMap<>();
            map.put("count", String.valueOf(count));
            map.put("guid", guid);

//            actischeduleMapper.payFinish(map);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}
