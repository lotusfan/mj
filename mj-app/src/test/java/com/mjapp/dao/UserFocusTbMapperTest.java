package com.mjapp.dao;

import com.BaseTest;
import com.mjapp.model.UserFocusTb;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @title: UserFocusTbMapperTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年11月06日 15:34
 */
public class UserFocusTbMapperTest extends BaseTest{

    @Autowired
    private UserFocusTbMapper userFocusTbMapper;
    @Test
    public void testGetFocusUserIdByactiveUserId() throws Exception {

        UserFocusTb userFocusTb = new UserFocusTb();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        userFocusTb.setActiveUserId(1);
        userFocusTb.setIds(list);

        System.out.println(userFocusTbMapper.getFocusUserIdByactiveUserId(userFocusTb));
    }
}