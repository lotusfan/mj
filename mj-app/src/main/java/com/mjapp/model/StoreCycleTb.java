package com.mjapp.model;

import java.sql.Timestamp;

public class StoreCycleTb extends ParentModel{

	private Integer id; //
	private String name; //商圈名称
	private Timestamp createTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}

    @Override
    public String toString() {
        return "StoreCycleTb{" +
            "\nid=" + id +
            "\nname=" + name +
            "\ncreateTime=" + createTime +
            '}';
    }
}