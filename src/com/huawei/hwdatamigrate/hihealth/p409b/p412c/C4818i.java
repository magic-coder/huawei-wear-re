package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;

/* compiled from: DBDataClient */
public class C4818i extends C4810h {
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

    private C4818i() {
    }

    public static C4818i m23225a(Context context) {
        a = context.getApplicationContext();
        return C4820k.f17799a;
    }

    public static String m23226a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_dataclient(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("client_uuid text not null,");
        stringBuilder.append("user_id integer not null,");
        stringBuilder.append("device_id integer not null,");
        stringBuilder.append("app_id integer not null,");
        stringBuilder.append("sync_status integer not null,");
        stringBuilder.append("cloud_device integer,");
        stringBuilder.append("create_time integer not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String m23227d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" CREATE INDEX ClientIndex ON hihealth_dataclient(").append("user_id,").append("device_id,").append("app_id)");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_dataclient";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "client_uuid", ReportCardInfo.COLUMN_NAME_CARD_USERID, SNBConstant.FIELD_DEVICE_ID, "app_id", "cloud_device", "sync_status", "create_time"};
    }
}
