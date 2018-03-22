package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.unionpay.tsmservice.data.Constant;

/* compiled from: DBAppInfo */
public class C4814d extends C4810h {
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

    private C4814d() {
    }

    public static C4814d m23206a(Context context) {
        a = context.getApplicationContext();
        return C4816f.f17798a;
    }

    public static String m23207a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_app(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("package_name text not null,");
        stringBuilder.append("app_name text ,");
        stringBuilder.append("version text ,");
        stringBuilder.append("signature text ,");
        stringBuilder.append("cloud_code integer not null,");
        stringBuilder.append("sync_status integer not null,");
        stringBuilder.append("createTime text not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_app";
    }

    public String[] mo4572c() {
        return new String[]{"_id", SNBConstant.FIELD_PKG, "app_name", "version", Constant.KEY_SIGNATURE, "cloud_code", "sync_status", "createTime"};
    }
}
