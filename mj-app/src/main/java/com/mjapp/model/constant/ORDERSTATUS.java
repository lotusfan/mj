package com.mjapp.model.constant;

/**
 * @title: ORDERSTATUS
 * @description: 订单状态
 * @author: zhangfan
 * @data: 2016年12月04日 15:16
 */
public enum ORDERSTATUS {

    CREATE(1, "订单创建"),
    WAITUSE(2, "订单支付完成,待使用"),
    FINISHED(3, "订单已消费"),
    ;
    private Integer value;
    private String message;

    ORDERSTATUS(Integer value, String message) {
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
