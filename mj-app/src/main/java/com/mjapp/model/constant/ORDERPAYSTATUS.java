package com.mjapp.model.constant;

/**
 * @title: ORDERPAYSTATUS
 * @description: 订单支付状态
 * @author: zhangfan
 * @data: 2016年12月04日 15:17
 */
public enum ORDERPAYSTATUS {

    WAITPAY(1, "等待支付"),
    SUCCESS(2, "支付成功"),
    FAILED(3, "支付失败"),
    ;


    private Integer value;
    private String message;

    ORDERPAYSTATUS(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
