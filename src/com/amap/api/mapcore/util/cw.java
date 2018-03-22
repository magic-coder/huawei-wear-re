package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LogEntity */
public abstract class cw implements cp<cx> {
    private static final String f11617a = cu.f11634l;
    private static final String f11618b = cu.f11635m;
    private static final String f11619c = cu.f11636n;
    private static final String f11620d = cu.f11628f;
    private cx f11621e = null;

    public /* synthetic */ void mo4031a(Object obj) {
        m15936a((cx) obj);
    }

    public /* synthetic */ Object mo4032b(Cursor cursor) {
        return m15935a(cursor);
    }

    public ContentValues mo4030a() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f11621e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f11617a, this.f11621e.m15959b());
                contentValues2.put(f11618b, Integer.valueOf(this.f11621e.m15956a()));
                contentValues2.put(f11620d, dd.m16001a(this.f11621e.m15962c()));
                contentValues2.put(f11619c, Integer.valueOf(this.f11621e.m15963d()));
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

    public cx m15935a(Cursor cursor) {
        Throwable th;
        cx cxVar = null;
        if (cursor == null) {
            return null;
        }
        try {
            String string = cursor.getString(1);
            int i = cursor.getInt(2);
            String string2 = cursor.getString(4);
            int i2 = cursor.getInt(3);
            cx cxVar2 = new cx();
            try {
                cxVar2.m15958a(string);
                cxVar2.m15957a(i);
                cxVar2.m15961b(dd.m16002b(string2));
                cxVar2.m15960b(i2);
                return cxVar2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                cxVar = cxVar2;
                th = th3;
                th.printStackTrace();
                return cxVar;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return cxVar;
        }
    }

    public void m15936a(cx cxVar) {
        this.f11621e = cxVar;
    }

    public static String m15933a(String str) {
        Map hashMap = new HashMap();
        hashMap.put(f11617a, str);
        return co.m15916a(hashMap);
    }

    public static String m15932a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(f11618b).append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
