package com.google.analytics.tracking.android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PersistentAnalyticsStore */
class az extends SQLiteOpenHelper {
    final /* synthetic */ ax f14148a;
    private boolean f14149b;
    private long f14150c = 0;

    az(ax axVar, Context context, String str) {
        this.f14148a = axVar;
        super(context, str, null, 1);
    }

    private boolean m18294a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    ar.m18269d("Error querying for table " + str);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
            ar.m18269d("Error querying for table " + str);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!this.f14149b || this.f14150c + 3600000 <= ax.a(this.f14148a).mo4232a()) {
            SQLiteDatabase sQLiteDatabase = null;
            this.f14149b = true;
            this.f14150c = ax.a(this.f14148a).mo4232a();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                ax.c(this.f14148a).getDatabasePath(ax.b(this.f14148a)).delete();
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.f14149b = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (m18294a("hits2", sQLiteDatabase)) {
            m18293a(sQLiteDatabase);
        } else {
            sQLiteDatabase.execSQL(ax.e());
        }
    }

    private void m18293a(SQLiteDatabase sQLiteDatabase) {
        Object obj = null;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
        Set hashSet = new HashSet();
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (Object add : columnNames) {
                hashSet.add(add);
            }
            if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                if (!hashSet.remove("hit_app_id")) {
                    obj = 1;
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                } else if (obj != null) {
                    sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                    return;
                } else {
                    return;
                }
            }
            throw new SQLiteException("Database column missing");
        } finally {
            rawQuery.close();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C3664u.m18376a(sQLiteDatabase.getPath());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
