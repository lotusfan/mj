package com.mjapp.model;

import java.sql.Timestamp;

public class HomePicTb extends ParentModel{

	private Integer id; //
	private String homePic; //首页加载图
	private Integer deleteFlag; //
	private Timestamp createTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getHomePic() {
		return homePic;
	}
	public void setHomePic (String homePic) {
		this.homePic = homePic;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag (Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}

    @Override
    public String toString() {
        return "HomePicTb{" +
            "\nid=" + id +
            "\nhomePic=" + homePic +
            "\ndeleteFlag=" + deleteFlag +
            "\ncreateTime=" + createTime +
            '}';
    }
}