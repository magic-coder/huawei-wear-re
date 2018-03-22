package com.amap.api.services.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public class ah extends SQLiteOpenHelper {
    static final String f12325a = "a";
    static final String f12326b = "b";
    static final String f12327c = "c";
    static final String f12328d = "d";
    static final String f12329e = "e";
    static final String f12330f = "a1";
    static final String f12331g = "a2";
    static final String f12332h = "a3";
    static final String f12333i = "a4";
    static final String f12334j = "a5";
    static final String f12335k = "a6";
    static final String f12336l = "b1";
    static final String f12337m = "b2";
    static final String f12338n = "b3";
    static final String f12339o = "c1";
    static final String f12340p = "c2";
    static final String f12341q = "c3";
    private static final String f12342r = ("CREATE TABLE IF NOT EXISTS " + f12325a + " (_id integer primary key autoincrement, " + f12330f + "  varchar(20), " + f12331g + " varchar(10)," + f12332h + " varchar(50)," + f12333i + " varchar(100)," + f12334j + " varchar(20)," + f12335k + " integer);");
    private static final String f12343s = ("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + f12336l + " varchar(40), " + f12337m + " integer," + f12338n + "  integer," + f12330f + "  varchar(20));");
    private static final String f12344t = ("CREATE TABLE IF NOT EXISTS " + f12329e + " (_id integer primary key autoincrement," + f12339o + " integer," + f12340p + " integer," + f12341q + " integer);");

    public ah(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f12342r);
            sQLiteDatabase.execSQL(String.format(f12343s, new Object[]{f12326b}));
            sQLiteDatabase.execSQL(String.format(f12343s, new Object[]{f12327c}));
            sQLiteDatabase.execSQL(String.format(f12343s, new Object[]{f12328d}));
            sQLiteDatabase.execSQL(f12344t);
        } catch (Throwable th) {
            ay.m16709a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
