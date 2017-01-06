package com.mjapp.payment.action;

import com.alibaba.fastjson.JSONObject;
import com.jcabi.aspects.Loggable;
import com.mjapp.payment.model.WeiXinCBModel;
import com.mjapp.payment.model.WeiXingCBResponse;
import com.mjapp.payment.model.ZhiFuBaoCBModel;
import com.mjapp.payment.model.constant.CALLBACKRETURNCODE;
import com.mjapp.payment.service.CallBackService;
import com.mjapp.payment.service.WeiXinService;
import com.mjapp.payment.service.ZhiFuBaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @title: CallBackAction
 * @description: 支付回调入口
 * @author: zhangfan
 * @data: 2016年11月13日 17:35
 */
@Loggable(trim = false)
@Controller
public class CallBackAction {

    @Autowired
    private WeiXinService weiXinService;
    @Autowired
    private ZhiFuBaoService zhiFuBaoService;



    /**
     * 微信回调函数处理
     *
     * @param weiXinCBModel
     * @return
     */
    @RequestMapping(value = "/wx/cb", method = RequestMethod.POST)
    @ResponseBody
    public WeiXingCBResponse handleWeiXingCallBack(@RequestBody WeiXinCBModel weiXinCBModel) {

        System.out.println(weiXinCBModel);

        CALLBACKRETURNCODE e = weiXinService.handleWeiXingCallBack(weiXinCBModel);

        WeiXingCBResponse weiXingCBResponse = new WeiXingCBResponse();
        weiXingCBResponse.setReturn_code(e.getCode());

        return weiXingCBResponse;
    }

    /**
     * 支付宝回调函数处理
     *
     * @param zhiFuBaoCBModel
     * @return
     */
    @RequestMapping(value = "/zfb/cb", method = RequestMethod.POST)
    @ResponseBody
    public String handleZhiFuBaoCallBack(ZhiFuBaoCBModel zhiFuBaoCBModel) {

        CALLBACKRETURNCODE e = zhiFuBaoService.handleZhiFuBaoCallBack(zhiFuBaoCBModel);

//        ZhiFuBaoCBResponse zhiFuBaoCBResponse = new ZhiFuBaoCBResponse();

        return e.getCode();

    }

    @RequestMapping(value = "/zfb/cbm", method = RequestMethod.POST)
    @ResponseBody
    public String handleZhiFuBaoCallBack(@RequestParam Map<String, String> map) {


        System.out.println(JSONObject.toJSONString(map));
        zhiFuBaoService.handleZhiFuBaoCallBack(map);
//        ZhiFuBaoCBResponse zhiFuBaoCBResponse = new ZhiFuBaoCBResponse();

        return JSONObject.toJSONString(map);
    }


//    /**
//     * App 开发接口转换
//     *
//     * @param receiveAppData
//     * @return
//     */
//    @RequestMapping(value = "/app/interface", method = RequestMethod.POST)
//    @ResponseBody
//    public ReturnAppData ReceiveAppData(@RequestBody ReceiveAppData receiveAppData) {
//
//        String rs = "";
//        ReturnAppData returnAppData = new ReturnAppData();
//        returnAppData.setStatus(CALLBACKRETURNCODE.FAILSTATUS.getCode());
//        if ("wxsyn".equals(receiveAppData.getAction())) {
//            rs = receiveWeiXingAppData(receiveAppData.getOrderNum());
//        }
//
//        if ("zfbsyn".equals(receiveAppData.getAction())) {
//            rs = receiveZhiFuBaoAppData(receiveAppData.getOrderNum());
//        }
//
//        if ("SUCCESS".equals(rs.toUpperCase())) {
//            returnAppData.setStatus(CALLBACKRETURNCODE.SUCCESSSTATUS.getCode());
//        }
//        return returnAppData;
//    }
//
//
//    /**
//     * 微信前端返回信息
//     *
//     * @return
//     */
//    public String receiveWeiXingAppData(String transaction_id) {
//
//        CALLBACKRETURNCODE e = callBackService.receiveWeiXingAppData(transaction_id);
//
//        return e.getCode();
//    }
//
//    /**
//     * 支付宝前端返回信息
//     *
//     * @return
//     */
//    public String receiveZhiFuBaoAppData(String orderNum) {
//
//        CALLBACKRETURNCODE e = callBackService.receiveZhiFuBaoAppData(orderNum);
//
//        return e.getCode();
//    }


}
