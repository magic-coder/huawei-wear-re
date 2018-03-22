package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;
import com.huawei.hwappdfxmgr.upload.UploadFile;

/* compiled from: OfflineDBCreator */
class C3344y implements cn {
    private static C3344y f11855A;
    static final String f11856a = "update_item";
    static final String f11857b = "update_item_file";
    static final String f11858c = "update_item_download_info";
    static final String f11859d = "title";
    static final String f11860e = "url";
    static final String f11861f = "mAdcode";
    static final String f11862g = UploadFile.FILE_NAME;
    static final String f11863h = "version";
    static final String f11864i = "lLocalLength";
    static final String f11865j = "lRemoteLength";
    static final String f11866k = "localPath";
    static final String f11867l = "mIndex";
    static final String f11868m = "isProvince";
    static final String f11869n = "mCompleteCode";
    static final String f11870o = "mCityCode";
    static final String f11871p = "mState";
    static final String f11872q = "mAdcode";
    static final String f11873r = "file";
    static final String f11874s = "mAdcode";
    static final String f11875t = "fileLength";
    static final String f11876u = "splitter";
    static final String f11877v = "startPos";
    static final String f11878w = "endPos";
    private static final String f11879x = ("CREATE TABLE IF NOT EXISTS " + f11856a + " (_id integer primary key autoincrement, " + f11859d + "  TEXT, " + f11860e + " TEXT," + f11861f + " TEXT," + f11862g + " TEXT," + f11863h + " TEXT," + f11864i + " INTEGER," + f11865j + " INTEGER," + f11866k + " TEXT," + f11867l + " INTEGER," + f11868m + " INTEGER NOT NULL," + f11869n + " INTEGER," + f11870o + " TEXT," + f11871p + " INTEGER," + " UNIQUE(" + f11861f + "));");
    private static final String f11880y = ("CREATE TABLE IF NOT EXISTS " + f11857b + " (_id integer primary key autoincrement," + f11872q + " TTEXT, " + f11873r + " TEXT);");
    private static final String f11881z = ("CREATE TABLE IF NOT EXISTS " + f11858c + " (_id integer primary key autoincrement," + f11874s + " TEXT," + f11875t + " integer," + f11876u + " integer," + f11877v + " integer," + f11878w + " integer," + " UNIQUE(" + f11874s + "));");

    public static synchronized C3344y m16312a() {
        C3344y c3344y;
        synchronized (C3344y.class) {
            if (f11855A == null) {
                f11855A = new C3344y();
            }
            c3344y = f11855A;
        }
        return c3344y;
    }

    private C3344y() {
    }

    public void mo4034a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f11879x);
            sQLiteDatabase.execSQL(f11880y);
            sQLiteDatabase.execSQL(f11881z);
        } catch (Throwable th) {
            ca.m15831a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    public String mo4036b() {
        return "offlineDbV4.db";
    }

    public int mo4037c() {
        return 1;
    }

    public void mo4035a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
