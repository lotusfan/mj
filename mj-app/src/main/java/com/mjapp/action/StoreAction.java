package com.mjapp.action;

import com.jcabi.aspects.Loggable;
import com.mjapp.model.StoreCycleTb;
import com.mjapp.model.StoreTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;
import com.mjapp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @title: StoreAction
 * @description: APP端相关店铺接口
 * @author: zhangfan
 * @data: 2016年10月11日 20:27
 */
@Loggable(trim = false)
@Controller
@RequestMapping("store")
public class StoreAction extends ActionParent{

    @Autowired
    private StoreService storeService;

    /**
     * 获取商家详情
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "det", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getStoreDetail(@RequestBody RequestModel requestModel) {


        StoreTb storeTb = transformJSONObjectToModel(requestModel, StoreTb.class);

        storeTb = storeService.storeDetailS(storeTb);
        if (storeTb == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, storeTb);
    }


    /**
     * 获取商家商圈列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "cyc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getStoreCycleList(@RequestBody RequestModel requestModel) {

        List<StoreCycleTb> list = storeService.storeCycleListS();
        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }


    /**
     * 按商圈条件检索商家
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "slbc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getStoreListByCycle(@RequestBody RequestModel requestModel) {

        StoreTb storeTb = transformJSONObjectToModel(requestModel, StoreTb.class);

        List<StoreTb> list = storeService.storeListByCycleS(storeTb);
        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }
}
