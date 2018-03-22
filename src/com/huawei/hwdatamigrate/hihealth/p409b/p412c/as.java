package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/* compiled from: DBSyncAnchor */
public class as extends C4810h {
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

    private as() {
    }

    public static as m23137a(Context context) {
        a = context.getApplicationContext();
        return au.f17793a;
    }

    protected String mo4571b() {
        return "sync_anchor";
    }

    protected String[] mo4572c() {
        return new String[]{"cloud_code", "main_user_id", "sync_data_type", "sync_type_version", "sync_type_time", "modify_time"};
    }

    public static String m23138a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sync_anchor(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("cloud_code integer no null,");
        stringBuilder.append("main_user_id integer no null,");
        stringBuilder.append("sync_data_type integer no null,");
        stringBuilder.append("sync_type_version integer no null,");
        stringBuilder.append("sync_type_time integer no null,");
        stringBuilder.append("modify_time integer no null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String m23139d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" CREATE INDEX SyncTypeIndex ON sync_anchor(").append("cloud_code,").append("main_user_id,").append("sync_data_type)");
        return stringBuilder.toString();
    }
}
