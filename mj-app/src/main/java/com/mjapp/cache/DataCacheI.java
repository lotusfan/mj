package com.mjapp.cache;

import java.util.List;

/**
 * @title: DataCacheI
 * @description: 数据缓存接口定义
 * @author: zhangfan
 * @data: 2016年10月29日 16:17
 */
public interface DataCacheI<T> {

    void init();

    List<T> getAllList();

    boolean remove(T t);

    boolean refresh();

}
