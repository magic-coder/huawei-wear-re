package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: DBTypeInherit */
public class az extends C4810h {
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

    public static String m23167a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_type_inherit(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("type_id integer no null,");
        stringBuilder.append("parent_type_id integer no null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_type_inherit";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "type_id", "parent_type_id"};
    }
}
