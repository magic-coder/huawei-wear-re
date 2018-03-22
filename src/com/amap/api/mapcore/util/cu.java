package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: LogDBCreator */
public class cu implements cn {
    static final String f11623a = "a";
    static final String f11624b = "b";
    static final String f11625c = "c";
    static final String f11626d = "d";
    static final String f11627e = "e";
    static final String f11628f = "a1";
    static final String f11629g = "a2";
    static final String f11630h = "a3";
    static final String f11631i = "a4";
    static final String f11632j = "a5";
    static final String f11633k = "a6";
    static final String f11634l = "b1";
    static final String f11635m = "b2";
    static final String f11636n = "b3";
    static final String f11637o = "c1";
    static final String f11638p = "c2";
    static final String f11639q = "c3";
    private static final String f11640r = ("CREATE TABLE IF NOT EXISTS " + f11623a + " (_id integer primary key autoincrement, " + f11628f + "  varchar(20), " + f11629g + " varchar(10)," + f11630h + " varchar(50)," + f11631i + " varchar(100)," + f11632j + " varchar(20)," + f11633k + " integer);");
    private static final String f11641s = ("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + f11634l + " varchar(40), " + f11635m + " integer," + f11636n + "  integer," + f11628f + "  varchar(20));");
    private static final String f11642t = ("CREATE TABLE IF NOT EXISTS " + f11627e + " (_id integer primary key autoincrement," + f11637o + " integer," + f11638p + " integer," + f11639q + " integer);");
    private static cu f11643u;

    public static synchronized cu m15942a() {
        cu cuVar;
        synchronized (cu.class) {
            if (f11643u == null) {
                f11643u = new cu();
            }
            cuVar = f11643u;
        }
        return cuVar;
    }

    private cu() {
    }

    public void mo4034a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f11640r);
            sQLiteDatabase.execSQL(String.format(f11641s, new Object[]{f11624b}));
            sQLiteDatabase.execSQL(String.format(f11641s, new Object[]{f11625c}));
            sQLiteDatabase.execSQL(String.format(f11641s, new Object[]{f11626d}));
            sQLiteDatabase.execSQL(f11642t);
        } catch (Throwable th) {
            ca.m15831a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    public void mo4035a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public String mo4036b() {
        return "logdb.db";
    }

    public int mo4037c() {
        return 1;
    }
}
