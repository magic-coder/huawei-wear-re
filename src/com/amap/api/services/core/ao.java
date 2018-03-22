package com.amap.api.services.core;

import android.content.ContentValues;
import android.database.Cursor;
import com.amap.api.services.core.ad.C3390a;

/* compiled from: SDKEntity */
public class ao implements ap<ad> {
    private static String f12354a = ah.f12330f;
    private static String f12355b = ah.f12331g;
    private static String f12356c = ah.f12335k;
    private static String f12357d = ah.f12332h;
    private static String f12358e = ah.f12333i;
    private static String f12359f = ah.f12334j;
    private ad f12360g = null;

    public /* synthetic */ Object mo4106b(Cursor cursor) {
        return m16671a(cursor);
    }

    public ContentValues mo4105b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f12360g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f12354a, at.m16692a(this.f12360g.m16613a()));
                contentValues2.put(f12355b, at.m16692a(this.f12360g.m16614b()));
                contentValues2.put(f12356c, Boolean.valueOf(this.f12360g.m16617e()));
                contentValues2.put(f12357d, at.m16692a(this.f12360g.m16615c()));
                contentValues2.put(f12359f, at.m16692a(this.f12360g.m16616d()));
                contentValues2.put(f12358e, at.m16692a(m16668a(this.f12360g.m16618f())));
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

    public ad m16671a(Cursor cursor) {
        boolean z = true;
        ad adVar = null;
        try {
            String b = at.m16693b(cursor.getString(1));
            String b2 = at.m16693b(cursor.getString(2));
            String b3 = at.m16693b(cursor.getString(3));
            String[] b4 = m16669b(at.m16693b(cursor.getString(4)));
            String b5 = at.m16693b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            adVar = new C3390a(b, b2, b3).m16610a(z).m16609a(b5).m16611a(b4).m16612a();
        } catch (C3433v e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return adVar;
    }

    public void m16673a(ad adVar) {
        this.f12360g = adVar;
    }

    public String mo4107a() {
        return ah.f12325a;
    }

    private String[] m16669b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String m16668a(String[] strArr) {
        String str = null;
        if (strArr != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : strArr) {
                    stringBuilder.append(append).append(";");
                }
                str = stringBuilder.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    public static String m16667a(String str) {
        return f12354a + "='" + at.m16692a(str) + "'";
    }

    public static String m16670c() {
        return f12356c + "=1";
    }
}
