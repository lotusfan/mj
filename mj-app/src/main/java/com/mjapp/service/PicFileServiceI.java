package com.mjapp.service;

import com.mjapp.model.view.PicView;

import java.util.List;

/**
 * @title: PicFileServiceI
 * @description: base64图片异步处理
 * @author: zhangfan
 * @data: 2016年10月22日 17:38
 */
public interface PicFileServiceI {

    void savePic(List<PicView> list);
}
