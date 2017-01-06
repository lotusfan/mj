package com.mjapp.service;

import com.alibaba.fastjson.JSON;
import com.mjapp.model.RecommendUserTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @title: MJAdvancedQueryServiceTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年10月30日 15:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MJAdvancedQueryServiceTest {

    @Autowired
    private MJAdvancedQueryService mjAdvancedQueryService;

    @Test
    public void testHomeRecommendS() throws Exception {

        System.out.println(JSON.toJSONString(mjAdvancedQueryService.homeRecommendS(new RecommendUserTb())));
    }

    @Test
    public void testHome() throws Exception {

        System.out.println(mjAdvancedQueryService.homeQueryS("帆", null));
    }
}