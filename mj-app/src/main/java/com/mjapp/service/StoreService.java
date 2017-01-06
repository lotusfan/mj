package com.mjapp.service;

import com.jcabi.aspects.Loggable;
import com.mjapp.dao.StoreCycleTbMapper;
import com.mjapp.dao.StoreTbMapper;
import com.mjapp.model.StoreCycleTb;
import com.mjapp.model.StoreTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: StoreService
 * @description: APP端相关店铺Service
 * @author: zhangfan
 * @data: 2016年10月16日 20:18
 */
@Loggable(trim = false)
@Service
public class StoreService {

    @Autowired
    private StoreTbMapper storeTbMapper;
    @Autowired
    private StoreCycleTbMapper storeCycleTbMapper;

    /**
     * 获取商家详情
     *
     * @param storeTb
     * @return
     */
    public StoreTb storeDetailS(StoreTb storeTb) {

        try {
            return storeTbMapper.getUniqueBy(storeTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取商家商圈列表
     *
     * @return
     */
    public List<StoreCycleTb> storeCycleListS() {

        try {
            return storeCycleTbMapper.getBy(new StoreCycleTb());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按商圈条件检索商家
     *
     * @param storeTb
     * @return
     */
    public List<StoreTb> storeListByCycleS(StoreTb storeTb) {

        try {
            return storeTbMapper.storeListByCycle(storeTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
