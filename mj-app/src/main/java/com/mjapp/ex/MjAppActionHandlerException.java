package com.mjapp.ex;

import com.alibaba.fastjson.JSON;
import com.mjapp.action.ActionParent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @title: MjAppActionHandlerException
 * @description: mjapp Action层抛出异常捕获
 * @author: zhangfan
 * @data: 2016年10月16日 18:41
 */
@Component
public class MjAppActionHandlerException implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(MjAppActionHandlerException.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        PrintWriter printWriter = null;
        PrintWriter printWriter1 = null;
        StringWriter stringWriter = null;

        try {
            stringWriter = new StringWriter();
            printWriter1 = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter1);
            logger.error(stringWriter.toString());

            printWriter = httpServletResponse.getWriter();
            ActionParent actionParent = new ActionParent();
            printWriter.write(JSON.toJSONString(actionParent.generateServerException(e)));
            printWriter.flush();
        } catch (Exception e1) {

        } finally {
            try {
                if (printWriter != null) printWriter.close();
                if (printWriter1 != null) printWriter1.close();
                if (stringWriter != null) stringWriter.close();
            } catch (Exception e2) {
            }
        }

        return new ModelAndView();
    }
}
