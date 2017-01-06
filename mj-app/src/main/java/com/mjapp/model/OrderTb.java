package com.mjapp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderTb extends ParentModel{

	private Integer id; //
	private String sn; //订单SN
	private BigDecimal price; //商品价格
	private BigDecimal payPrice; //需支付价格
	private Integer payStatus; //交易状态
	private Integer status; //订单状态
	private Integer userId; //
	private Integer activityId; //
	private Timestamp createTime; //
	private Timestamp updateTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn (String sn) {
		this.sn = sn;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice (BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPayPrice() {
		return payPrice;
	}
	public void setPayPrice (BigDecimal payPrice) {
		this.payPrice = payPrice;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus (Integer payStatus) {
		this.payStatus = payStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus (Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId (Integer userId) {
		this.userId = userId;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId (Integer activityId) {
		this.activityId = activityId;
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

    @Override
    public String toString() {
        return "OrderTb{" +
            "\nid=" + id +
            "\nsn=" + sn +
            "\nprice=" + price +
            "\npayPrice=" + payPrice +
            "\npayStatus=" + payStatus +
            "\nstatus=" + status +
            "\nuserId=" + userId +
            "\nactivityId=" + activityId +
            "\ncreateTime=" + createTime +
            "\nupdateTime=" + updateTime +
            '}';
    }
}