package com.it.config;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/09/27 10:16
 */
public class DataSourceContextHolder {

    public enum DomainType {
        BeiJing, ShangHai
    }

    private static final ThreadLocal<DomainType> threadLoal = new ThreadLocal<>();


    public static void setDataBaseType(DomainType domainType) throws Exception {
        if (domainType == null) {
            throw new NullPointerException();
        }
        threadLoal.set(domainType);
    }

    public static DomainType getDomainType() {
        return threadLoal.get();
    }

    public static void clearDomainType(){
        threadLoal.remove();
    }
}
