package com.mjapp.model.view;

/**
 * @title: BackPassWordVies
 * @description: 找回密码前端展现
 * @author: zhangfan
 * @data: 2016年10月04日 15:21
 */
public class BackPassWordVies {

    private String loginName; //电话
    private String code; // 短信验证码
    private String newWord; //新密码

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNewWord() {
        return newWord;
    }

    public void setNewWord(String newWord) {
        this.newWord = newWord;
    }

    @Override
    public String toString() {
        return "BackPassWordVies{" +
                "loginName='" + loginName + '\'' +
                ", code='" + code + '\'' +
                ", newWord='" + newWord + '\'' +
                '}';
    }
}
