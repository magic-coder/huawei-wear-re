package com.huawei.hwdatamigrate.p407a;

/* compiled from: MemberDatasDB */
public class aa {
    public static final String[] f17375a = new String[]{"_d", "userid", "local", "packageName", "ts", "datas"};
    public static final String f17376b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS MemberDatasTable(");
        stringBuilder.append("_d integer,");
        stringBuilder.append("userid NVARCHAR(300) not null primary key,");
        stringBuilder.append("local NVARCHAR(300) ,");
        stringBuilder.append("packageName NVARCHAR(128),");
        stringBuilder.append("ts NVARCHAR(128),");
        stringBuilder.append("isSupport integer,");
        stringBuilder.append("datas varchar(600)");
        stringBuilder.append(")");
        f17376b = stringBuilder.toString();
    }
}
