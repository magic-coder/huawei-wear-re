package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/* compiled from: DBSyncCache */
public class av extends C4810h {
    public /* bridge */ /* synthetic */ int mo4565a(ContentValues contentValues, String str, String[] strArr) {
        return super.mo4565a(contentValues, str, strArr);
    }

    public /* bridge */ /* synthetic */ Cursor mo4567a(String str, String[] strArr) {
        return super.mo4567a(str, strArr);
    }

    public /* bridge */ /* synthetic */ Cursor mo4568a(String str, String[] strArr, String str2, String str3, String str4) {
        return super.mo4568a(str, strArr, str2, str3, str4);
    }

    public /* bridge */ /* synthetic */ Cursor mo4569a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return super.mo4569a(strArr, str, strArr2, str2, str3, str4);
    }

    public /* bridge */ /* synthetic */ int mo4570b(String str, String[] strArr) {
        return super.mo4570b(str, strArr);
    }

    private av() {
    }

    public static av m23148a(Context context) {
        a = context.getApplicationContext();
        return ax.f17794a;
    }

    protected String mo4571b() {
        return "sync_cache";
    }

    protected String[] mo4572c() {
        return new String[]{"_id", "userId", "dataType", "data", "dataTime", "isDone", "modifiedTime"};
    }

    public static String m23149a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sync_cache(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("userId integer not null,");
        stringBuilder.append("dataType integer not null,");
        stringBuilder.append("data text not null,");
        stringBuilder.append("dataTime integer not null,");
        stringBuilder.append("isDone integer not null,");
        stringBuilder.append("modifiedTime integer");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
