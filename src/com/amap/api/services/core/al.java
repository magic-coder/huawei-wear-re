package com.amap.api.services.core;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: LogEntity */
public abstract class al implements ap<am> {
    private static final String f12320a = ah.f12336l;
    private static final String f12321b = ah.f12337m;
    private static final String f12322c = ah.f12338n;
    private static final String f12323d = ah.f12330f;
    private am f12324e = null;

    public /* synthetic */ Object mo4106b(Cursor cursor) {
        return m16633a(cursor);
    }

    public ContentValues mo4105b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f12324e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f12320a, this.f12324e.m16659b());
                contentValues2.put(f12321b, Integer.valueOf(this.f12324e.m16656a()));
                contentValues2.put(f12323d, at.m16692a(this.f12324e.m16662c()));
                contentValues2.put(f12322c, Integer.valueOf(this.f12324e.m16663d()));
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

    public am m16633a(Cursor cursor) {
        Throwable th;
        am amVar = null;
        if (cursor == null) {
            return null;
        }
        try {
            String string = cursor.getString(1);
            int i = cursor.getInt(2);
            String string2 = cursor.getString(4);
            int i2 = cursor.getInt(3);
            am amVar2 = new am();
            try {
                amVar2.m16658a(string);
                amVar2.m16657a(i);
                amVar2.m16661b(at.m16693b(string2));
                amVar2.m16660b(i2);
                return amVar2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                amVar = amVar2;
                th = th3;
                th.printStackTrace();
                return amVar;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return amVar;
        }
    }

    public void m16634a(am amVar) {
        this.f12324e = amVar;
    }

    public static String m16632a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(f12320a).append("='").append(str).append("'");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String m16631a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(f12321b).append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
