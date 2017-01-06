package com.mjapp.action;

import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @title: PaymentManagerAction
 * @description: 支付、下单相关Action
 * @author: zhangfan
 * @data: 2016年12月04日 13:10
 */
@Controller
@RequestMapping("/order")
public class PaymentManagerAction extends ActionParent{

    @RequestMapping(value = "co", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel createOrder(@RequestBody RequestModel requestModel) {


        return null;
    }

}
