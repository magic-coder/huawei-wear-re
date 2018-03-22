package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;
import com.amap.api.mapcore.util.bv.C3299a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SDKEntity */
public class cz implements cp<bv> {
    private static String f11651a = cu.f11628f;
    private static String f11652b = cu.f11629g;
    private static String f11653c = cu.f11633k;
    private static String f11654d = cu.f11630h;
    private static String f11655e = cu.f11631i;
    private static String f11656f = cu.f11632j;
    private bv f11657g = null;

    public /* synthetic */ void mo4031a(Object obj) {
        m15973a((bv) obj);
    }

    public /* synthetic */ Object mo4032b(Cursor cursor) {
        return m15972a(cursor);
    }

    public ContentValues mo4030a() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f11657g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f11651a, dd.m16001a(this.f11657g.m15791a()));
                contentValues2.put(f11652b, dd.m16001a(this.f11657g.m15793b()));
                contentValues2.put(f11653c, Boolean.valueOf(this.f11657g.m15796e()));
                contentValues2.put(f11654d, dd.m16001a(this.f11657g.m15794c()));
                contentValues2.put(f11656f, dd.m16001a(this.f11657g.m15795d()));
                contentValues2.put(f11655e, dd.m16001a(m15968a(this.f11657g.m15797f())));
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

    public bv m15972a(Cursor cursor) {
        boolean z = true;
        bv bvVar = null;
        try {
            String b = dd.m16002b(cursor.getString(1));
            String b2 = dd.m16002b(cursor.getString(2));
            String b3 = dd.m16002b(cursor.getString(3));
            String[] b4 = m15969b(dd.m16002b(cursor.getString(4)));
            String b5 = dd.m16002b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            bvVar = new C3299a(b, b2, b3).m15788a(z).m15787a(b5).m15789a(b4).m15790a();
        } catch (bl e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bvVar;
    }

    public void m15973a(bv bvVar) {
        this.f11657g = bvVar;
    }

    public String mo4033b() {
        return cu.f11623a;
    }

    private String[] m15969b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String m15968a(String[] strArr) {
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

    public static String m15967a(String str) {
        Map hashMap = new HashMap();
        hashMap.put(f11651a, dd.m16001a(str));
        return co.m15916a(hashMap);
    }

    public static String m15970c() {
        return f11653c + "=1";
    }
}
