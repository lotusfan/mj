package com.mjapp.model.constant;

/**
 * @title: ORDERBILLFLAG
 * @description: 订单结算标记
 * @author: zhangfan
 * @data: 2016年12月04日 15:44
 */
public enum ORDERBILLFLAG {

    NO(1, "未结算"),
    YES(2, "已结算"),
    ;

    private Integer value;
    private String message;

    ORDERBILLFLAG(Integer value, String message) {
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
