package com.huawei.feedback.p033a.p034a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: DatabaseHelper */
public class C4402c extends SQLiteOpenHelper {
    private static C4402c f16305a = null;

    public static synchronized C4402c m21104a(Context context) {
        C4402c c4402c;
        synchronized (C4402c.class) {
            if (f16305a == null) {
                f16305a = new C4402c(context);
            }
            c4402c = f16305a;
        }
        return c4402c;
    }

    public C4402c(Context context) {
        super(context, "phoneservice.db", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c.c("DatabaseHelper", "DataBase onCreate, the database path is: " + sQLiteDatabase.getPath());
        C4403d.m21105a(sQLiteDatabase);
        C4404e.m21110a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        c.c("DatabaseHelper", "DataBase onUpgrade oldVersion=" + i + "newVersion=" + i2 + " the database path is : " + sQLiteDatabase.getPath());
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        c.c("DatabaseHelper", "DataBase onDowngrade oldVersion=" + i + "newVersion=" + i2);
    }
}
