package com.mjapp.model.thirdparty;

/**
 * @title: Sms
 * @description: 短信发送时Model
 * @author: zhangfan
 * @data: 2016年10月20日 13:20
 */
public class SmsModel {

    private final String corp_id = "sc3636"; //访问接口账户Id
    private final String corp_pwd = "523v2v"; //访问接口账户密码
    private final String corp_service = "1069003256636"; //业务代码
    private String mobile; //下发目的手机号
    private String msg_content; //知信内容
    private String corp_msg_id; //用户发送短信时自己定义的短信id，用于区分状态报告。参数名必须填写，参数值可为空。
    private String ext; //用户自行分配扩展号。参数名必须填写，参数值可为空。
                        // 该参数是显示在接收手机上的主叫尾号，可用于上行信息匹配，例：我方给合作方开通特服号为：10657532521924，
                        //合作方在发送信息时可随意填写扩展号（需为0-9数字）ext=8888，那么用户收到信息时显示的下发号码就是106575325219248888。


    public String getCorp_id() {
        return corp_id;
    }

    public String getCorp_pwd() {
        return corp_pwd;
    }

    public String getCorp_service() {
        return corp_service;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    public String getCorp_msg_id() {
        return corp_msg_id;
    }

    public void setCorp_msg_id(String corp_msg_id) {
        this.corp_msg_id = corp_msg_id;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "corp_id='" + corp_id + '\'' +
                ", corp_pwd='" + corp_pwd + '\'' +
                ", corp_service='" + corp_service + '\'' +
                ", mobile='" + mobile + '\'' +
                ", msg_content='" + msg_content + '\'' +
                ", corp_msg_id='" + corp_msg_id + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}

