package com.mjapp.service;

import com.BaseTest;
import com.mjapp.model.UserTb;
import com.mjapp.model.constant.PAYTYPE;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @title: PaymentManagerServiceTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年12月04日 16:34
 */
public class PaymentManagerServiceTest extends BaseTest{

    @Autowired
    private PaymentManagerService paymentManagerService;

    @Test
    public void testCreateOrderS() throws Exception {

        System.out.println(paymentManagerService.createOrderS(1, 1, PAYTYPE.ZHIFUBAO));

    }
}