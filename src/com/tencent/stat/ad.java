package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.stat.p545b.C6463m;
import java.util.ArrayList;
import java.util.List;

class ad extends SQLiteOpenHelper {
    public ad(Context context) {
        super(context, C6463m.m29480v(context), null, 3);
    }

    private void m29399a(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Object th;
        Throwable th2;
        String str = null;
        try {
            query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", C6463m.m29454c(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    C6487u.f22536e.m29411f(th);
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (query != null) {
                        query.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    private void m29400b(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Object th;
        Cursor cursor;
        Throwable th2;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            try {
                List<ae> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new ae(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
                }
                ContentValues contentValues = new ContentValues();
                for (ae aeVar : arrayList) {
                    contentValues.put("content", C6463m.m29454c(aeVar.f22380b));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(aeVar.f22379a)});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C6487u.f22536e.m29412g("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m29399a(sQLiteDatabase);
            m29400b(sQLiteDatabase);
        }
        if (i == 2) {
            m29399a(sQLiteDatabase);
            m29400b(sQLiteDatabase);
        }
    }
}
