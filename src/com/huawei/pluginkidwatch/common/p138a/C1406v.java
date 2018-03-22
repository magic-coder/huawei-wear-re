package com.huawei.pluginkidwatch.common.p138a;

import com.huawei.p190v.C2538c;

/* compiled from: SosContactDB */
public class C1406v {
    public static final String[] f3179a = new String[]{"_id", "phoneNum", "deviceCode", "sosindex"};
    public static final String f3180b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS allsoscontact(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("phoneNum NVARCHAR(300) not null,");
        stringBuilder.append("deviceCode integer not null,");
        stringBuilder.append("sosindex integer not null");
        stringBuilder.append(")");
        C2538c.m12674b("SosContactDB", "===createTableSQL", stringBuilder.toString());
        f3180b = stringBuilder.toString();
    }
}
