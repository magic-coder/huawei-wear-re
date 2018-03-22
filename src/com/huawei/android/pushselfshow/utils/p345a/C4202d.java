package com.huawei.android.pushselfshow.utils.p345a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.android.pushagent.c.a.e;
import java.io.File;

public class C4202d {
    private static C4202d f15810a = new C4202d();

    private C4202d() {
    }

    private SQLiteDatabase m20403a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return SQLiteDatabase.openDatabase(str, null, 0);
        }
        file = file.getParentFile();
        if (!(file == null || file.exists() || !file.mkdirs())) {
            e.e("PushLogSC2712", "datafiledir.mkdirs true");
        }
        return SQLiteDatabase.openOrCreateDatabase(str, null);
    }

    public static C4202d m20404a() {
        return f15810a;
    }

    private void m20405a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.close();
    }

    public Cursor m20406a(String str, String str2, String str3) {
        SQLiteDatabase a = m20403a(str);
        if (a == null) {
            return null;
        }
        Cursor query = a.query(str2, null, str3, null, null, null, null);
        query.moveToFirst();
        m20405a(a);
        return query;
    }

    public Cursor m20407a(String str, String str2, String[] strArr) {
        SQLiteDatabase a = m20403a(str);
        if (a == null) {
            return null;
        }
        Cursor rawQuery = a.rawQuery(str2, strArr);
        rawQuery.moveToFirst();
        m20405a(a);
        return rawQuery;
    }

    public void m20408a(Context context, String str, String str2) {
        SQLiteDatabase a = m20403a(str);
        if (a != null) {
            a.execSQL(str2);
            m20405a(a);
        }
    }

    public void m20409a(Context context, String str, String str2, ContentValues contentValues) {
        SQLiteDatabase a = m20403a(str);
        if (a != null) {
            a.insert(str2, null, contentValues);
            m20405a(a);
        }
    }

    public void m20410a(String str, String str2, String str3, String[] strArr) {
        SQLiteDatabase a = m20403a(str);
        if (a != null) {
            a.delete(str2, str3, strArr);
            m20405a(a);
        }
    }

    public boolean m20411a(String str, String str2) {
        Cursor a = m20406a(str, "sqlite_master", "(tbl_name='" + str2 + "')");
        if (a == null) {
            e.a("PushLogSC2712", "cursor is null.");
            return false;
        }
        int count = a.getCount();
        a.close();
        return count > 0;
    }
}
