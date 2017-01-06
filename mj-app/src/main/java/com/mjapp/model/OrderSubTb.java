package com.mjapp.model;

import java.sql.Timestamp;

public class OrderSubTb extends ParentModel{

	private Integer id; //
	private Integer payTypeCode; //支付类型code
	private String payTypeName; //支付类型名称（微信支付，支付宝支付）
	private Integer orderId; //
	private String orderSn; //
	private String activityName; //
	private Integer activityId; //
	private String storeJson; //
	private String goodsJson; //
	private Integer billFlag; //结算标记
	private Timestamp createTime; //
	private Timestamp updateTime; //
	private String tradeno; //交易流水号

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getPayTypeCode() {
		return payTypeCode;
	}
	public void setPayTypeCode (Integer payTypeCode) {
		this.payTypeCode = payTypeCode;
	}
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName (String payTypeName) {
		this.payTypeName = payTypeName;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId (Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn (String orderSn) {
		this.orderSn = orderSn;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName (String activityName) {
		this.activityName = activityName;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId (Integer activityId) {
		this.activityId = activityId;
	}
	public String getStoreJson() {
		return storeJson;
	}
	public void setStoreJson (String storeJson) {
		this.storeJson = storeJson;
	}
	public String getGoodsJson() {
		return goodsJson;
	}
	public void setGoodsJson (String goodsJson) {
		this.goodsJson = goodsJson;
	}
	public Integer getBillFlag() {
		return billFlag;
	}
	public void setBillFlag (Integer billFlag) {
		this.billFlag = billFlag;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime (Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno (String tradeno) {
		this.tradeno = tradeno;
	}

    @Override
    public String toString() {
        return "OrderSubTb{" +
            "\nid=" + id +
            "\npayTypeCode=" + payTypeCode +
            "\npayTypeName=" + payTypeName +
            "\norderId=" + orderId +
            "\norderSn=" + orderSn +
            "\nactivityName=" + activityName +
            "\nactivityId=" + activityId +
            "\nstoreJson=" + storeJson +
            "\ngoodsJson=" + goodsJson +
            "\nbillFlag=" + billFlag +
            "\ncreateTime=" + createTime +
            "\nupdateTime=" + updateTime +
            "\ntradeno=" + tradeno +
            '}';
    }
}