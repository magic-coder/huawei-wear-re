package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: DTEntity */
class C3340u implements cp<C3343x> {
    private C3343x f11850a = null;

    C3340u() {
    }

    public /* synthetic */ Object mo4032b(Cursor cursor) {
        return m16283a(cursor);
    }

    public C3343x m16283a(Cursor cursor) {
        try {
            String string = cursor.getString(cursor.getColumnIndex(C3344y.f11859d));
            String string2 = cursor.getString(cursor.getColumnIndex(C3344y.f11860e));
            String string3 = cursor.getString(cursor.getColumnIndex(C3344y.f11861f));
            String string4 = cursor.getString(cursor.getColumnIndex(C3344y.f11862g));
            String string5 = cursor.getString(cursor.getColumnIndex(C3344y.f11863h));
            long j = cursor.getLong(cursor.getColumnIndex(C3344y.f11864i));
            long j2 = cursor.getLong(cursor.getColumnIndex(C3344y.f11865j));
            String string6 = cursor.getString(cursor.getColumnIndex(C3344y.f11866k));
            int i = cursor.getInt(cursor.getColumnIndex(C3344y.f11867l));
            boolean z = cursor.getInt(cursor.getColumnIndex(C3344y.f11868m)) == 1;
            int i2 = cursor.getInt(cursor.getColumnIndex(C3344y.f11869n));
            String string7 = cursor.getString(cursor.getColumnIndex(C3344y.f11870o));
            int i3 = cursor.getInt(cursor.getColumnIndex(C3344y.f11871p));
            C3337r c3337r = new C3337r();
            c3337r.m16238a(string);
            c3337r.m16250e(string2);
            c3337r.m16248d(string3);
            c3337r.m16246c(string4);
            c3337r.m16243b(string5);
            c3337r.m16242b(j);
            c3337r.m16245c(j2);
            c3337r.m16254g(string6);
            c3337r.m16236a(i);
            c3337r.m16239a(z);
            c3337r.m16241b(i2);
            c3337r.m16256h(string7);
            c3337r.f11829a = i3;
            return new C3343x(c3337r);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public ContentValues mo4030a() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f11850a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(C3344y.f11859d, this.f11850a.m16299b());
                contentValues2.put(C3344y.f11860e, this.f11850a.m16300c());
                contentValues2.put(C3344y.f11861f, this.f11850a.m16301d());
                contentValues2.put(C3344y.f11862g, this.f11850a.m16302e());
                contentValues2.put(C3344y.f11863h, this.f11850a.m16303f());
                contentValues2.put(C3344y.f11864i, Long.valueOf(this.f11850a.m16304g()));
                contentValues2.put(C3344y.f11865j, Long.valueOf(this.f11850a.m16305h()));
                contentValues2.put(C3344y.f11866k, this.f11850a.m16306i());
                contentValues2.put(C3344y.f11867l, Integer.valueOf(this.f11850a.m16307j()));
                contentValues2.put(C3344y.f11868m, Integer.valueOf(this.f11850a.m16308k() ? 1 : 0));
                contentValues2.put(C3344y.f11869n, Integer.valueOf(this.f11850a.m16309l()));
                contentValues2.put(C3344y.f11870o, this.f11850a.m16310m());
                contentValues2.put(C3344y.f11871p, Integer.valueOf(this.f11850a.m16311n()));
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
        return C3344y.f11856a;
    }

    public void m16284a(C3343x c3343x) {
        this.f11850a = c3343x;
    }

    public static String m16281a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3344y.f11861f);
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }
}
