package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public class cs extends SQLiteOpenHelper {
    private cn f11622a;

    public cs(Context context, String str, CursorFactory cursorFactory, int i, cn cnVar) {
        super(context, str, cursorFactory, i);
        this.f11622a = cnVar;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f11622a.mo4034a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f11622a.mo4035a(sQLiteDatabase, i, i2);
    }
}
