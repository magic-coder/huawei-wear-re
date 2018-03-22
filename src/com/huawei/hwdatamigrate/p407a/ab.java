package com.huawei.hwdatamigrate.p407a;

/* compiled from: MotionPathDB */
public class ab {
    public static final String f17377a;
    private static final String[] f17378b = new String[]{"recordDay", "data", "timeZone", "createTime", "lastModifyVersion", "huid", "uploadStatus", "deviceCode", "vendor", "coordinate", "attribute", "data1", "data2", "data3", "data4", "data5"};

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sporttrack(");
        stringBuilder.append("recordDay integer not null,");
        stringBuilder.append("data varchar(100) not null,");
        stringBuilder.append("createTime integer primary key not null,");
        stringBuilder.append("lastModifyVersion integer not null,");
        stringBuilder.append("timeZone varchar(100) not null,");
        stringBuilder.append("huid varchar(100) not null,");
        stringBuilder.append("uploadStatus integer not null,");
        stringBuilder.append("deviceCode integer,");
        stringBuilder.append("vendor varchar(100),");
        stringBuilder.append("coordinate varchar(100),");
        stringBuilder.append("attribute varchar(100),");
        stringBuilder.append("data1 varchar(100),");
        stringBuilder.append("data2 varchar(100),");
        stringBuilder.append("data3 varchar(100),");
        stringBuilder.append("data4 varchar(100),");
        stringBuilder.append("data5 varchar(100)");
        stringBuilder.append(")");
        f17377a = stringBuilder.toString();
    }
}
