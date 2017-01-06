package com.mjapp.util;

import com.alibaba.fastjson.JSONObject;
import com.mjapp.payment.model.ApplyForPayOrderParameterZFBModel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @title: ModelToMapTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年12月04日 12:20
 */
public class ModelToMapTest {

    @Test
    public void testTransform() throws Exception {

        ApplyForPayOrderParameterZFBModel am = new ApplyForPayOrderParameterZFBModel();
        am.setBiz_content(JSONObject.toJSONString(am));
        System.out.println(am.getApp_id());
        System.out.println(PROPERTIESUTIL.get("app_id_zfb"));

        System.out.println(ModelTransformUtil.toMap(am));
        System.out.println(ModelTransformUtil.toUrlParameterStr(am));


    }
}