package com.mjapp.model.constant;

/**
 * @title: SESSIONTYPE
 * @description: 存放Session种类
 * @author: zhangfan
 * @data: 2016年10月03日 15:33
 */
public enum SESSIONTYPE {

    USER("001", "userTb"),
    CODESMS("002", "codeSMS"),

    ;

    private String code;
    private String type;


    SESSIONTYPE(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
