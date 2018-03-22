package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.wxop.stat.p547b.C6523r;
import java.util.ArrayList;
import java.util.List;

final class C6527d extends SQLiteOpenHelper {
    private String f22743a = "";
    private Context f22744b = null;

    public C6527d(Context context, String str) {
        super(context, str, null, 3);
        this.f22743a = str;
        this.f22744b = context.getApplicationContext();
        if (C6544v.m29830b()) {
            am.f22624h.m29702a("SQLiteOpenHelper " + this.f22743a);
        }
    }

    private static void m29796a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        String str = null;
        Cursor query;
        try {
            query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", C6523r.m29788b(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    am.f22624h.m29705b(th);
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static void m29797b(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        Cursor cursor;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            try {
                List<C6528e> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new C6528e(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
                }
                ContentValues contentValues = new ContentValues();
                for (C6528e c6528e : arrayList) {
                    contentValues.put("content", C6523r.m29788b(c6528e.f22746b));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(c6528e.f22745a)});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final synchronized void close() {
        super.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        am.f22624h.m29709f("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            C6527d.m29796a(sQLiteDatabase);
            C6527d.m29797b(sQLiteDatabase);
        }
        if (i == 2) {
            C6527d.m29796a(sQLiteDatabase);
            C6527d.m29797b(sQLiteDatabase);
        }
    }
}
