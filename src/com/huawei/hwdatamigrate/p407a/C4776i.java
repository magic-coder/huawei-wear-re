package com.huawei.hwdatamigrate.p407a;

/* compiled from: BOneInfoDB */
public class C4776i {
    public static final String f17624a;
    private static final String[] f17625b = new String[]{"_id", "name", "macaddress"};

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS bonename(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("name NVARCHAR(100) not null,");
        stringBuilder.append("macaddress NVARCHAR(50) not null");
        stringBuilder.append(")");
        f17624a = stringBuilder.toString();
    }
}
