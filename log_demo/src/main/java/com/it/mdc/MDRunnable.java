package com.it.mdc;

import org.slf4j.MDC;

import java.util.Map;

/**
 * 解决线程子线程丢失traceId的问题
 **/
public class MDRunnable implements Runnable {

    private Runnable runnable;

    private final Map<String, String> map;

    public MDRunnable(Runnable runnable) {
        this.runnable = runnable;
        this.map = MDC.getCopyOfContextMap();
    }

    @Override
    public void run() {
        // 传入已保存的MDC值
        for (Map.Entry<String, String> entry : map.entrySet()) {
            MDC.put(entry.getKey(), entry.getValue());
        }
        // 装饰器模式，执行run方法
        runnable.run();
        // 移除已保存的MDC值
        for (Map.Entry<String, String> entry : map.entrySet()) {
            MDC.remove(entry.getKey());
        }
    }
}
