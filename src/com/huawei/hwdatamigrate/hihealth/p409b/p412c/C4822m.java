package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.nfc.PluginPayAdapter;

/* compiled from: DBDeviceInfo */
public class C4822m extends C4810h {
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

    private C4822m() {
    }

    public static C4822m m23245a(Context context) {
        a = context.getApplicationContext();
        return C4824o.f17800a;
    }

    public static String m23246a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_device(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("device_unique_code text not null,");
        stringBuilder.append("deviceName text,");
        stringBuilder.append("device_type integer,");
        stringBuilder.append("firmwareVersion text,");
        stringBuilder.append("hardwareVersion text,");
        stringBuilder.append("softwareVersion text,");
        stringBuilder.append("manufacturer text,");
        stringBuilder.append("model text,");
        stringBuilder.append("device_sn text,");
        stringBuilder.append("device_mac text,");
        stringBuilder.append("createTime text not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_device";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "device_unique_code", "deviceName", "device_type", "firmwareVersion", "hardwareVersion", "softwareVersion", "manufacturer", "model", PluginPayAdapter.KEY_DEVICE_INFO_SN, "device_mac", "createTime"};
    }
}
