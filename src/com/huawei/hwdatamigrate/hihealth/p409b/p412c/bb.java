package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/* compiled from: DBUserInfo */
public class bb extends C4810h {
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

    private bb() {
    }

    public static bb m23185a(Context context) {
        a = context.getApplicationContext();
        return bd.f17795a;
    }

    public static String m23186a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_user(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("huid text not null,");
        stringBuilder.append("nick_name text,");
        stringBuilder.append("head_url text,");
        stringBuilder.append("relate_type integer not null,");
        stringBuilder.append("height double,");
        stringBuilder.append("weight double,");
        stringBuilder.append("email text,");
        stringBuilder.append("mobile text,");
        stringBuilder.append("unit_category integer,");
        stringBuilder.append("sex integer,");
        stringBuilder.append("birthday integer,");
        stringBuilder.append("age integer,");
        stringBuilder.append("sync_status integer not null,");
        stringBuilder.append("create_time integer not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_user";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "huid", "nick_name", "head_url", "relate_type", "height", "weight", "email", "mobile", "unit_category", "sex", "birthday", "age", "sync_status", "create_time"};
    }
}
