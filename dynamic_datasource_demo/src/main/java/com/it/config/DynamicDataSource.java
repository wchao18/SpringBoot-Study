package com.it.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @author wangchao
 * @description 动态数据源配置
 * @date 2019/09/27 10:58
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static DynamicDataSource instance;
    private static byte[] lock = new byte[0];

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    public static synchronized DynamicDataSource getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DynamicDataSource();
                }
            }
        }
        return instance;
    }
}
