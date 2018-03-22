package com.huawei.hwdatamigrate.p407a;

/* compiled from: QQHealthDBOld */
public class ag {
    public static final String f17393a;
    private static final String[] f17394b = new String[]{"_id", "data"};

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS qqhealth(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("data varchar(3000)");
        stringBuilder.append(")");
        f17393a = stringBuilder.toString();
    }
}
