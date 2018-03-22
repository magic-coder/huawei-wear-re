package com.huawei.hwdatamigrate.common;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/* compiled from: PropertyTable */
public class C1000i {
    public static final Uri f1677a = Uri.parse("content://com.huawei.HwWearContentProvider/PropertyTable");
    public static final String f1678b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table IF NOT EXISTS PropertyTable(");
        stringBuilder.append("propKey varchar primary key ,");
        stringBuilder.append("propValue varchar");
        stringBuilder.append(")");
        f1678b = stringBuilder.toString();
    }

    public static long m3637a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insert("PropertyTable", "propKey", contentValues);
    }
}
