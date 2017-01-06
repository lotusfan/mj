package com.mjapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcabi.aspects.Loggable;
import com.mjapp.model.constant.HTTPCODE;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * Action层的父类 提供Action层的访问控制和其它的一些验证方法
 */
@Loggable(trim = false)
public class ActionParent {


    /**
     * 判定请求是否受权访问接口
     *
     * @param httpServletRequest
     * @return
     */
    public boolean isRequestLegal(HttpServletRequest httpServletRequest) {
       /* if (!httpServletRequest.isRequestedSessionIdValid()) {
            return false;
        }
        return true;*/
        return httpServletRequest.isRequestedSessionIdValid();
    }

    /**
     * 生成返回前端统一Model形式
     *
     * @param httpCode
     * @param code
     * @param mark
     * @param o
     * @return
     */
    public ResponseModel generateResponseModel(Integer httpCode, String code, String mark, String token, Object o) {

        ResponseModel responseModel = new ResponseModel();
        if (httpCode != null)
            responseModel.setHttpCode(httpCode);
        if (code != null) {
            if (code.charAt(0) == '1')
                responseModel.setCode(SERVICECODE.REQUESTFAIL.getCode());
            else
                responseModel.setCode(code);
        }
        if (code != null)
            responseModel.setMark(mark);
        if (token != null)
            responseModel.setTokenId(token);
        responseModel.setO(o);
        return responseModel;
    }

    /**
     * 返回统一结构成功信息
     *
     * @param o
     * @return
     */
    public ResponseModel generateServerSuccess(SERVICECODE servicecode, Object o) {
        return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), servicecode.getCode(), servicecode.getMessage(), null, o);
    }

    /**
     * 返回统一结构有token成功信息
     *
     * @param servicecode
     * @param token
     * @param o
     * @return
     */
    public ResponseModel generateServerSuccess(SERVICECODE servicecode, String token, Object o) {
        return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), servicecode.getCode(), servicecode.getMessage(), token, o);
    }

    /**
     * 返回统一结构出错信息
     *
     * @param code
     * @param mark
     * @return
     */
    public ResponseModel generateServerError(String code, String mark) {

        return generateResponseModel(HTTPCODE.HTTPERROR.getCode(), code, mark, null, null);

    }

    /**
     * 返回统一结构服务器异常信息
     *
     * @return
     */
    public ResponseModel generateServerException(Exception e) {
        return generateResponseModel(HTTPCODE.HTTPERROR.getCode(), "-1", "服务器异常", null, null);
    }

    /**
     * 将requestModel中的Object转化成对应的类型
     *
     * @param requestModel
     * @param cl
     * @return
     */
    public <T> T transformJSONObjectToModel(RequestModel requestModel, Class<T> cl) {

        if(cl.getSimpleName().equals(String.class.getSimpleName())) return (T)requestModel.getO();

        return JSON.toJavaObject((JSONObject) requestModel.getO(), cl);
    }


    /**
     * 版本检测   不实现
     *
     * @param requestModel
     * @return
     */
    public String checkVersion(RequestModel requestModel) {
        return null;
    }


}
