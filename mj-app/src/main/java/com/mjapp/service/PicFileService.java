package com.mjapp.service;

import com.mjapp.model.view.PicView;
import com.mjapp.util.Base64PicUtils;
import com.mjapp.util.PROPERTIESUTIL;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: PicFileSave
 * @description: base64图片异步处理
 * @author: zhangfan
 * @data: 2016年10月22日 17:36
 */
@Service
public class PicFileService implements PicFileServiceI{

    @Async
    public void savePic(List<PicView> list) {

        for (PicView picView : list) {
            Base64PicUtils.savePicFile(picView.getPicBase64Str(), picView.getName(), PROPERTIESUTIL.get("pic_url"));

        }


    }
}
