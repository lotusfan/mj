package com.mjapp.model.constant;

/**
 * Created by zhangfan on 2015/3/10.
 */
public enum HTTPCODE {
    HTTPSUCCESS(200),
    HTTPERROR(500);

    HTTPCODE(Integer code) {
        this.code = code;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }
}
