package com.huawei.feedback.p033a.p034a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.phoneserviceuni.common.p132d.C1373c;

/* compiled from: AutoUploadDatabaseHelper */
public class C0806a extends SQLiteOpenHelper {
    public C0806a(Context context) {
        super(context, "autoupload.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1373c.m6140c("AutoUploadDatabaseHelper", "DataBase onCreate, the database path is: " + sQLiteDatabase.getPath());
        C0807b.m2696a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C1373c.m6139b("AutoUploadDatabaseHelper", "DataBase onUpgrade oldVersion=" + i + "newVersion=" + i2 + " the database path is : " + sQLiteDatabase.getPath());
    }
}
