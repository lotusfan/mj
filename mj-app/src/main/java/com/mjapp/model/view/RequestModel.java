package com.mjapp.model.view;

/**
 * Created by zhangfan on 2015/3/10.
 * <p/>
 * 结构化 请求体
 */
public class RequestModel {

    private String version;

    private String userName;

    private String tokenId;

    private String clientType;

    private Integer userId;

    private Object o;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "version='" + version + '\'' +
                ", userName='" + userName + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", clientType='" + clientType + '\'' +
                ", userId='" + userId + '\'' +
                ", o=" + o +
                '}';
    }
}
