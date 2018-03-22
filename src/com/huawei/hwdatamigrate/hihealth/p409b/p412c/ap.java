package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.sina.weibo.sdk.constant.WBConstants;

/* compiled from: DBStatDay */
public class ap extends C4810h {
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

    private ap() {
    }

    public static ap m23126a(Context context) {
        a = context.getApplicationContext();
        return ar.f17792a;
    }

    public static String m23127a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS hihealth_stat_day(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("date integer not null,");
        stringBuilder.append("hihealth_type integer not null,");
        stringBuilder.append("stat_type integer not null,");
        stringBuilder.append("value double not null,");
        stringBuilder.append("user_id integer,");
        stringBuilder.append("unit_id integer not null,");
        stringBuilder.append("client_id integer,");
        stringBuilder.append("timeZone text not null,");
        stringBuilder.append("sync_status integer not null,");
        stringBuilder.append("modified_time integer not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String m23128d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" CREATE INDEX StatIndex ON hihealth_stat_day(").append("date,").append("stat_type,").append("client_id)");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "hihealth_stat_day";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "date", "hihealth_type", "stat_type", "value", ReportCardInfo.COLUMN_NAME_CARD_USERID, "unit_id", WBConstants.AUTH_PARAMS_CLIENT_ID, "timeZone", "sync_status", "modified_time"};
    }
}
