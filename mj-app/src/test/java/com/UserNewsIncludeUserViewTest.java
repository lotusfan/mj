package com;

import com.mjapp.dao.UserNewsTbMapper;
import com.mjapp.model.UserNewsTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @title: UserNewsIncludeUserViewTest
 * @description: 测试
 * @author: zhangfan
 * @data: 2016年10月23日 18:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserNewsIncludeUserViewTest {

    @Autowired
    private UserNewsTbMapper userNewsTbMapper;

    @Test
    public void test(){
        UserNewsTb userNewsTb = new UserNewsTb();
        userNewsTb.setId(1);
//        userNewsTb = userNewsTbMapper.getByIncludeUserView(userNewsTb);
        System.out.println(userNewsTb);
    }
}
