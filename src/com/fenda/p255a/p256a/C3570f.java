package com.fenda.p255a.p256a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB_Helper */
public class C3570f extends SQLiteOpenHelper {
    public static final String f13662a = "sync_data".toString();
    public static final String f13663b = "sync_data_time".toString();
    public static final String f13664c = "sync_data_steps".toString();
    public static final String f13665d = "sync_data_type".toString();
    private static final String f13666e = "DB_Helper".toString();
    private static final String f13667f = "syncdata.db".toString();

    public C3570f(Context context) {
        super(context, f13667f, null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS ").append(f13662a).append("(").append(f13663b).append(" INTEGER, ").append(f13664c).append(" INTEGER, ").append(f13665d).append(" INTEGER) ");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
