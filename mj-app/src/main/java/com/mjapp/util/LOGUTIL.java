/**
 * @filename: LOGUTIL.java
 * @description: 
 * @version: 1.0
 * @author: 李磊
 * @data: 2016年8月30日 下午1:12:45
 */
package com.mjapp.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @title: LOGUTIL
 * @description: JSON 日志
 * @version: 1.0
 * @author: zhangfan
 * @data: 2016年8月30日 下午1:12:45
 */
public class LOGUTIL {

	public static void info(Logger logger, String message, Object o) {
		try {
			if(o == null) return;
			logger.info("-"+ message +"-" + JSON.toJSONString(o));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void infoException(Logger logger, String message, Exception e) {
		StringWriter stringWriter = null;
		PrintWriter printWriter = null;
		try {
			stringWriter = new StringWriter();
			printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			logger.error(stringWriter.toString());
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("打印日志出错:" + e1.getMessage());
		} finally {
			try {
				if(stringWriter != null) stringWriter.close();
				if(printWriter != null) printWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
