package com.huawei.logupload.p088a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.huawei.logupload.p090c.C1103f;

/* compiled from: UploadDatabaseHelper */
public class C1098c extends SQLiteOpenHelper {
    public C1098c(Context context) {
        super(context, "upload.db", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (C1103f.m4877a(2)) {
            Log.i("DataBase onCreate, the database path is: " + sQLiteDatabase.getPath(), "");
        }
        C1097a.m4845a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("alter table t_logupload add zipTime varchar(256)");
                sQLiteDatabase.execSQL("alter table t_logupload add logDetailInfo varchar(1024)");
                sQLiteDatabase.execSQL("alter table t_logupload add productName varchar(256)");
                sQLiteDatabase.execSQL("alter table t_logupload add romVersion varchar(256)");
                sQLiteDatabase.execSQL("alter table t_logupload add isPause varchar(4)");
            } catch (SQLException e) {
                e.printStackTrace();
                C1103f.m4881e("upload.db", "onUpgrade table t_logupload Error");
            }
        }
    }
}
