package com.it.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {

    private static final String DB_NAME = "mydb";

    public static class USER_TABLE_INFO {

        public static final String TABLE_NAME = "t_tenant_permission";
    }

    public static Map<String, String> table2Db;

    static {

        table2Db = new HashMap<>();

        table2Db.put(USER_TABLE_INFO.TABLE_NAME, DB_NAME);
    }
}
