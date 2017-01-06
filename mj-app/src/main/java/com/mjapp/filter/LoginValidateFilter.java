package com.mjapp.filter;

import com.alibaba.fastjson.JSON;
import com.mjapp.model.constant.HTTPCODE;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.ResponseModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by zhangfan on 2015/3/12.
 */
public class LoginValidateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        if (!(servletRequest instanceof HttpServletRequest)) {
            return;
        }
        if (!(servletResponse instanceof HttpServletResponse)) {
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (!isRequestLegal(httpServletRequest)) {

            ResponseModel responseModel = new ResponseModel();
            responseModel.setHttpCode(HTTPCODE.HTTPSUCCESS.getCode());
            responseModel.setCode(SERVICECODE.REQUESTLEGAL.getCode());

            OutputStream outputStream = httpServletResponse.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            try {
                outputStreamWriter.write(JSON.toJSONString(responseModel));
                outputStreamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            }
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }

    /*public boolean isRequestLegal(HttpServletRequest httpServletRequest) {

        if (!httpServletRequest.isRequestedSessionIdValid()) {
            return false;
        }

        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String) httpSession.getAttribute("username");

        if (username == null || username.length() < 1) {
            return false;
        }

        return true;

    }*/

    /**
     * redis 校验
     *
     * @param httpServletRequest
     * @return
     */
    public boolean isRequestLegal(HttpServletRequest httpServletRequest) {
        String usernameSession = (String) httpServletRequest.getSession().getAttribute("username");
        String username = httpServletRequest.getHeader("X-Auth-UserId");

        if (usernameSession == null || usernameSession.length() < 1) {
            return false;
        }
        if (!usernameSession.equals(username)) {
            return false;
        }
        return true;

    }


}
