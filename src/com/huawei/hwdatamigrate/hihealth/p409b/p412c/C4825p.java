package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;

/* compiled from: DBGoalInfo */
public class C4825p extends C4810h {
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

    private C4825p() {
    }

    public static C4825p m23255a(Context context) {
        a = context.getApplicationContext();
        return C4827r.f17801a;
    }

    public static String m23256a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS goal_value(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("goal_type integer,");
        stringBuilder.append("goal_value double,");
        stringBuilder.append("goal_unit integer,");
        stringBuilder.append("user_id integer,");
        stringBuilder.append("target_type integer,");
        stringBuilder.append("deadline integer,");
        stringBuilder.append("sync_status integer not null,");
        stringBuilder.append("modified_time integer");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "goal_value";
    }

    public String[] mo4572c() {
        return new String[]{"_id", "goal_type", "goal_value", "goal_unit", ReportCardInfo.COLUMN_NAME_CARD_USERID, "target_type", "deadline", "sync_status", "modified_time"};
    }
}
