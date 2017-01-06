package com.mjapp.model.constant;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * Action层返回前台参数编码
 */
public enum SERVICECODE {
    REQUESTSUCCESS("0200", "请求成功"),
    REQUESTFAIL("-1", "请求失败"),

    NOAUTHORITY("1003", "没有权限"),
    TIMEOUT("1004", "时间超时"),
    SERVERERROR("1005", "服务器错误"),
    REQUESTLEGAL("1006", "非法请求"),
    VERSIONINCOMPLETE("1007", "版本信息不完整"), //
    VERSIONNEEDUPDATE("1008", "版本需要更新"),//
    SESSIONINVALID("1010", "Session过期超时"),//
    DATANOTCOMPLETE("1011", "上传数据不完整"),//
    USEREXIST("1012", "用户已存在"), //
    LOGINNAMEEMPTY("1013", "登录用户名不存在"),//
    LOGINPASSWORDEMPTY("1014", "登录用户密码不存在"),
    LOGINUSERERROR("1015", "用户名和密码不匹配"), //
    SMSNUMEXCEED("1017", "发送短信超出限制次数"),
    SMSCODEERROR("1018", "短信验证码错误"),
    USERNOTEXIST("1019", "用户不存在"),
    NOID("1053", "没有用户ID"), //
    UPDATEERROR("1054", "更新错误"),//
    SELECTERROR("1056", "查询错误"),//
    INSERTERROR("1059", "数据添加错误"),//
    UPLOADPICERROR("1060", "图片存储出错"),//
    AUTHENTICODEERROR("1061", "验证码发送失败"),//
    SELECTEMPTY("1063", "查询结果为空"),




    VERSIONNOTNEEDUPDATE("0009", "版本不需要更新"),//
    LOGINUSERSUCCESS("0016", "用户登录成功"), //
    UPDATESUCCESS("0055", "更新成功"),//
    SELECTSUCCESS("0057", "查询成功"),//
    INSERTSUCCESS("0058", "数据添加正确"),//
    UPLOADPICSUCCESS("0059", "图片存储成功"),//
    AUTHENTICODESUCCESS("0062", "验证码发送成功"),//


    ;

    private String code;
    private String message;

    SERVICECODE(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
