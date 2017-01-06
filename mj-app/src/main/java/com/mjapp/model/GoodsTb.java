package com.mjapp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class GoodsTb extends ParentModel{

	private Integer id; //
	private Integer storeId; //店铺Id
	private BigDecimal commission; //返现力度
	private BigDecimal minimumcharge; //最低消费
	private Timestamp createTime; //
	private Timestamp updateTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId (Integer storeId) {
		this.storeId = storeId;
	}
	public BigDecimal getCommission() {
		return commission;
	}
	public void setCommission (BigDecimal commission) {
		this.commission = commission;
	}
	public BigDecimal getMinimumcharge() {
		return minimumcharge;
	}
	public void setMinimumcharge (BigDecimal minimumcharge) {
		this.minimumcharge = minimumcharge;
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
        return "GoodsTb{" +
            "\nid=" + id +
            "\nstoreId=" + storeId +
            "\ncommission=" + commission +
            "\nminimumcharge=" + minimumcharge +
            "\ncreateTime=" + createTime +
            "\nupdateTime=" + updateTime +
            '}';
    }
}