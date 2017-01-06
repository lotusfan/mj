package com.mjapp.payment.model.constant;

/**
 * @title: CALLBACKRETURNCODE
 * @description: 处理回调状态集
 * @author: zhangfan
 * @data: 2016年11月13日 18:02
 */
public enum CALLBACKRETURNCODE {


    SUCCESS("success", "统一成功"),
    FAIL("fail", "统一失败"),
    SUCCESSSTATUS("0", "成功状态"),
    FAILSTATUS("1", "失败状态"),

    WEIXINSUCCESS("SUCCESS", "成功"),
    WEIXINFAIL("FAIL", "微信返回状态码失败"),
    WEIXINFAILRESULTCODE("FAIL", "微信返回业务支付结果失败"),
    WEIXINFAILSIGN("FAIL", "微信返回验证sign不一至"),
    WEIXINFAILORDERCOUNT("FAIL", "微信返回业务订单库中无记录"),
    WEIXINFAILORDERFEE("FAIL", "微信返回业务订单金额与库中不符"),
    WEIXINFAILUPDATE("FAIL", "订单状态更新有误符"),
    WEIXNGFAILEXCEPTION("EXCEPTION", "业务出现异常"),

    ZHIFUBAOSUCCESS("success", "成功"),
    ZHIFUBAOFAIL("fail", "失败"),
    ZHIFUBAOTRADESUCCESS("TRADE_SUCCESS", "交易成功"),
    ZHIFUBAOTRADEFINISHED("TRADE_FINISHED", "交易成功"),
    ZHIFUBAOWAITBUYERPAY("WAIT_BUYER_PAY", "交易创建"),
    ZHIFUBAOTRADECLOSED("TRADE_CLOSED", "交易关闭"),
    ZHIFUBAOFAILEXCEPTION("EXCEPTION", "业务出现异常"),
    ;

    private String code;
    private String msg;

    CALLBACKRETURNCODE(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
