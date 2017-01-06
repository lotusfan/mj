package com.mjapp.model.view;

/**
 * @title: PicView
 * @description: 图片存储view
 * @author: zhangfan
 * @data: 2016年10月22日 17:42
 */
public class PicView {


    private String name;
    private String picBase64Str;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicBase64Str() {
        return picBase64Str;
    }

    public void setPicBase64Str(String picBase64Str) {
        this.picBase64Str = picBase64Str;
    }
}
