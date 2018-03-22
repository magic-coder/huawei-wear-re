package com.google.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: DataLayerPersistentStoreImpl */
class C3692r extends SQLiteOpenHelper {
    final /* synthetic */ C3688n f14353a;

    C3692r(C3688n c3688n, Context context, String str) {
        this.f14353a = c3688n;
        super(context, str, null, 1);
    }

    private boolean m18604a(String str, SQLiteDatabase sQLiteDatabase) {
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
                    C3700z.m18626b("Error querying for table " + str);
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
            C3700z.m18626b("Error querying for table " + str);
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
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (SQLiteException e) {
            this.f14353a.f14344c.getDatabasePath("google_tagmanager.db").delete();
        }
        if (sQLiteDatabase == null) {
            return super.getWritableDatabase();
        }
        return sQLiteDatabase;
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
        if (m18604a("datalayer", sQLiteDatabase)) {
            m18603a(sQLiteDatabase);
        } else {
            sQLiteDatabase.execSQL(C3688n.f14342a);
        }
    }

    private void m18603a(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
        Set hashSet = new HashSet();
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (Object add : columnNames) {
                hashSet.add(add);
            }
            if (!hashSet.remove(SMSKeyInfo.TAG_KEY) || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                throw new SQLiteException("Database column missing");
            } else if (!hashSet.isEmpty()) {
                throw new SQLiteException("Database has extra columns");
            }
        } finally {
            rawQuery.close();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C3698x.m18619a(sQLiteDatabase.getPath());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
