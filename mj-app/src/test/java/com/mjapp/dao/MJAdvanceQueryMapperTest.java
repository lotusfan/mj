package com.mjapp.dao;

import com.mjapp.model.UserLifeLineTb;
import com.mjapp.model.constant.UNIFYTYPE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @title: MJAdvanceQueryMapperTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年10月27日 09:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MJAdvanceQueryMapperTest {

    @Autowired
    private MJAdvanceQueryMapper mjAdvanceQueryMapper;

    @Test
    public void testQueryUserLikeNickName() throws Exception {

        System.out.println(mjAdvanceQueryMapper.queryUserLikeNickName("帆"));
    }

    @Test
    public void testQueryActivityLikeUserNameAndLikeActivityName() throws Exception {

        System.out.println(mjAdvanceQueryMapper.queryActivityLikeUserNameAndLikeActivityName("帆"));
    }

    @Test
    public void testQueryUserLifeByUserIds() throws Exception {

        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setUserId(1);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        userLifeLineTb.setIds(ids);

        System.out.println(mjAdvanceQueryMapper.queryUserLifeByUserIds(userLifeLineTb));

    }
}