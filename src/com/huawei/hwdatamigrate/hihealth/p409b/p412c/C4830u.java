package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.database.Cursor;
import com.sina.weibo.sdk.constant.WBConstants;

/* compiled from: DBRealtimeData */
public class C4830u extends C4810h {
    public /* bridge */ /* synthetic */ int mo4565a(ContentValues contentValues, String str, String[] strArr) {
        return super.mo4565a(contentValues, str, strArr);
    }

    public /* bridge */ /* synthetic */ long mo4566a(ContentValues contentValues) {
        return super.mo4566a(contentValues);
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

    public static String m23283a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" create table  IF NOT EXISTS real_time_health(");
        stringBuilder.append("_id integer primary key  not null,");
        stringBuilder.append("start_time integer not null,");
        stringBuilder.append("end_time integer not null,");
        stringBuilder.append("type_id integer not null,");
        stringBuilder.append("value double not null,");
        stringBuilder.append("unit_id integer,");
        stringBuilder.append("client_id integer not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "real_time_health";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "start_time", "end_time", "type_id", "value", "unit_id", WBConstants.AUTH_PARAMS_CLIENT_ID};
    }
}
