package com.huawei.uploadlog.p186a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.uploadlog.p188c.C2511g;

/* compiled from: UploadDatabaseHelper */
public class C2497b extends SQLiteOpenHelper {
    public C2497b(Context context) {
        super(context, "logupload.db", null, 6);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C2511g.m12477a("DataBase onCreate, the database path is: " + sQLiteDatabase.getPath(), "");
        C2496a.m12416a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (sQLiteDatabase != null) {
            try {
                C2511g.m12477a("BETACLUB_SDK", "Databases Upgrade..............");
                sQLiteDatabase.execSQL("drop table if exists t_logupload_temp");
                sQLiteDatabase.execSQL("alter table t_logupload rename to t_logupload_temp");
                C2496a.m12416a(sQLiteDatabase);
                sQLiteDatabase.execSQL("insert into t_logupload select * from t_logupload_temp");
                sQLiteDatabase.execSQL("drop table if exists t_logupload_temp");
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "[UploadDatabaseHelper.onUpgrade]Error:", e);
                C2511g.m12484d("BETACLUB_SDK", "onUpgrade table t_logupload Error");
            }
        }
    }
}
