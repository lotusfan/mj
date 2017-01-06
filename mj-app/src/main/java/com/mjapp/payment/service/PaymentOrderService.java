package com.mjapp.payment.service;

import com.mjapp.model.OrderTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: PaymentOrderService
 * @description: 订单业务相关处理
 * @author: zhangfan
 * @data: 2016年11月13日 17:51
 */
@Service
public class PaymentOrderService {


    @Autowired
    private ZhiFuBaoService zhiFuBaoService;
    @Autowired
    private WeiXinService weiXinService;


    /**
     *
     * 支付宝下单
     *
     * @return
     */
    public String createOrderByZhiFuBao() {

        return zhiFuBaoService.payOrderStr(createOrder(), "活动名称????");
    }


    public String createOrderByWeiXin() {

        return null;
    }





    public OrderTb createOrder() {


        return null;
    }



    public void validateOrder() {

        //订单是否存在


        //订单金额是否正确


    }

    public void updateOrder() {

    }

}
