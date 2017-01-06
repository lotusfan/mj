package com.mjapp.action;

import com.jcabi.aspects.Loggable;
import com.mjapp.cache.SmsCache;
import org.springframework.stereotype.Controller;

/**
 * @title: SmsVaildate
 * @description: 短信规则的校验
 * @author: zhangfan
 * @data: 2016年10月04日 14:55
 */
@Loggable(trim = false)
@Controller
public class SmsVaildate {


    public boolean vcodeReg(String phone, String code) {

        if (code.equals(SmsCache.getReg(phone))) return true;
        return false;
    }

    public boolean vcodeBac(String phone, String code) {

        if (code.equals(SmsCache.getBac(phone))) return true;
        return false;
    }


    public boolean vsend(String phone) {

        if(SmsCache.getNum(phone) >= 20) return false;
        return true;
    }
}
