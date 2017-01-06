package com.mjapp.model.constant;

/**
 * @title: PAYTYPE
 * @description: 支付方式 类型
 * @author: zhangfan
 * @data: 2016年12月04日 15:38
 */
public enum PAYTYPE {

    ZHIFUBAO(1, "支付宝"),
    WEIXIN(2, "微信"),
    ;

    private Integer value;
    private String name;

    PAYTYPE(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
