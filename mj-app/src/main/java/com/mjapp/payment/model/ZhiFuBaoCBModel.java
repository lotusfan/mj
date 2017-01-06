package com.mjapp.payment.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @title: ZhiFuBaoCB
 * @description: 支付宝返回参数model
 * @author: zhangfan
 * @data: 2016年11月13日 17:26
 */
public class ZhiFuBaoCBModel {

    private Integer id; //
    private Timestamp notify_time; //通知时间
    private String notify_type; //通知的类型。
    private String notify_id; //通知校验ID
    private String app_id; //支付宝分配给开发者的应用Id
    private String charset; // 编码格式
    private String version; //接口版本
    private String sign_type; //固定取值为RSA。签名方式
    private String sign; //签名
    private String out_trade_no; //商户网站唯一订单号
    private String out_biz_no; //商户业务号
    private String subject; //商品名称
    private String payment_type; //支付类型
    private String trade_no; //支付宝交易号
    private String trade_status; //交易状态
    private String seller_id; //卖家支付宝用户号
    private String seller_email; //卖家支付宝账号
    private String buyer_id; //买家支付宝用户号
    private String buyer_logon_id; //买家支付宝账号
    private BigDecimal total_amout; //订单金额
    private BigDecimal receipt_amount; //实收金额
    private BigDecimal total_fee; //交易金额
    private Integer quantity; //购买数量
    private BigDecimal price; //商品单价
    private String body; //商品描述
    private Timestamp gmt_create; //交易创建时间
    private Timestamp gmt_payment; //交易付款时间
    private String is_total_fee_adjust; //是否调整总价
    private String use_coupon; //是否使用红包买家
    private BigDecimal discount; //折扣
    private String refund_status; //退款状态
    private Timestamp gmt_refund; //退款时间
    private Timestamp create_time; //
    private String msg; //


}
