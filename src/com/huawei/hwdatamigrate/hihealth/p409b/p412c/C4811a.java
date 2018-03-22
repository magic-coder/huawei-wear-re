package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/* compiled from: DBAccountInfo */
public class C4811a extends C4810h {
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

    private C4811a() {
    }

    public static C4811a m23073a(Context context) {
        a = context.getApplicationContext();
        return C4813c.f17797a;
    }

    public static String m23074a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_account(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("huid text not null,");
        stringBuilder.append("app_id integer not null,");
        stringBuilder.append("user_name text,");
        stringBuilder.append("access_token text,");
        stringBuilder.append("service_token text,");
        stringBuilder.append("third_open_id text,");
        stringBuilder.append("third_token text,");
        stringBuilder.append("site_id integer,");
        stringBuilder.append("expires_in integer,");
        stringBuilder.append("is_login integer,");
        stringBuilder.append("type integer,");
        stringBuilder.append("create_time integer");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_account";
    }

    public String[] mo4572c() {
        return new String[]{"huid", "app_id", "user_name", "access_token", "service_token", "third_open_id", "third_token", "site_id", "expires_in", "is_login", "type", "create_time"};
    }
}
