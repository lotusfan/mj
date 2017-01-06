package com.mjapp.payment.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @title: ReceiveWeiXingAppDataReq
 * @description:
 * @author: zhangfan
 * @data: 2016年11月20日 12:15
 */
@XmlRootElement(name="xml")
public class ReceiveWeiXingAppDataReq {

    private String appid;
    private String mch_id;
    private String nonce_str;
    private String transaction_id;
    private String sign;
    private String out_trade_no;



    public String getOut_trade_no() {
        return out_trade_no;
    }
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getAppid() {
        return appid;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
    public String getMch_id() {
        return mch_id;
    }
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }
    public String getNonce_str() {
        return nonce_str;
    }
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getTransaction_id() {
        return transaction_id;
    }
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    @Override
    public String toString() {
        return "ReceiveWeiXingAppDataReq [appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str
                + ", transaction=" + transaction_id + ", sign=" + sign + "]";
    }




}

