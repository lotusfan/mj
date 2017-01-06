package com.mjapp.payment.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @title: WeiXingCBResponse
 * @description:
 * @author: zhangfan
 * @data: 2016年11月20日 12:46
 */
@XmlRootElement(name = "xml")
public class WeiXingCBResponse {
    private String return_code;
    private String return_msg;


    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    @Override
    public String toString() {
        return "WeiXingCBResponse{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                '}';
    }
}
