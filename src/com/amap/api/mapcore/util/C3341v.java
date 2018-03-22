package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: DTFileEntity */
class C3341v implements cp<C3342w> {
    private C3342w f11851a = null;

    C3341v() {
    }

    public /* synthetic */ Object mo4032b(Cursor cursor) {
        return m16291a(cursor);
    }

    public C3342w m16291a(Cursor cursor) {
        try {
            return new C3342w(cursor.getString(cursor.getColumnIndex(C3344y.f11872q)), cursor.getString(cursor.getColumnIndex(C3344y.f11873r)));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public ContentValues mo4030a() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f11851a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(C3344y.f11872q, this.f11851a.m16296a());
                contentValues2.put(C3344y.f11873r, this.f11851a.m16297b());
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
        return C3344y.f11857b;
    }

    public void m16292a(C3342w c3342w) {
        this.f11851a = c3342w;
    }

    public static String m16288a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3344y.f11872q);
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

    public static String m16289b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3344y.f11872q);
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }
}
