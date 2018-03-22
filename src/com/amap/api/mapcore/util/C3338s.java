package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: DTDownloadEntity */
class C3338s implements cp<C3339t> {
    private C3339t f11844a = null;

    C3338s() {
    }

    public /* synthetic */ Object mo4032b(Cursor cursor) {
        return m16269a(cursor);
    }

    public C3339t m16269a(Cursor cursor) {
        try {
            return new C3339t(cursor.getString(cursor.getColumnIndex(C3344y.f11874s)), cursor.getInt(cursor.getColumnIndex(C3344y.f11875t)), cursor.getInt(cursor.getColumnIndex(C3344y.f11876u)), cursor.getInt(cursor.getColumnIndex(C3344y.f11877v)), cursor.getInt(cursor.getColumnIndex(C3344y.f11878w)));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public ContentValues mo4030a() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f11844a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(C3344y.f11874s, this.f11844a.m16275a());
                contentValues2.put(C3344y.f11875t, Long.valueOf(this.f11844a.m16276b()));
                contentValues2.put(C3344y.f11876u, Integer.valueOf(this.f11844a.m16278c()));
                contentValues2.put(C3344y.f11877v, Long.valueOf(this.f11844a.m16279d()));
                contentValues2.put(C3344y.f11878w, Long.valueOf(this.f11844a.m16280e()));
                return contentValues2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                contentValues = contentValues2;
                th = th3;
                th.printStackTrace();
                return contentValues;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return contentValues;
        }
    }

    public String mo4033b() {
        return C3344y.f11858c;
    }

    public void m16270a(C3339t c3339t) {
        this.f11844a = c3339t;
    }

    public static String m16267a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3344y.f11874s);
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }
}
