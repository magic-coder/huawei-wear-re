package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;

/* compiled from: DBUserPreference */
public class be extends C4810h {
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

    private be() {
    }

    public static be m23195a(Context context) {
        a = context.getApplicationContext();
        return bg.f17796a;
    }

    public static String m23196a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS user_preference(");
        stringBuilder.append("_id integer primary key not null,");
        stringBuilder.append("key text not null,");
        stringBuilder.append("value text not null,");
        stringBuilder.append("user_id integer not null,");
        stringBuilder.append("sync_status integer not null,");
        stringBuilder.append("create_time integer not null,");
        stringBuilder.append("modified_time integer not null");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String m23197d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" CREATE INDEX UserPreferenceIndex ON user_preference(").append("user_id,").append("key)");
        return stringBuilder.toString();
    }

    public String mo4571b() {
        return "user_preference";
    }

    public String[] mo4572c() {
        return new String[]{"_id", SMSKeyInfo.TAG_KEY, "value", ReportCardInfo.COLUMN_NAME_CARD_USERID, "sync_status", "create_time", "modified_time"};
    }
}
