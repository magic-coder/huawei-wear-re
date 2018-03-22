package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: UpdateLogEntity */
public class db implements cp<dc> {
    private static final String f11671b = cu.f11637o;
    private static final String f11672c = cu.f11638p;
    private static final String f11673d = cu.f11639q;
    private dc f11674a = null;

    public /* synthetic */ void mo4031a(Object obj) {
        m15991a((dc) obj);
    }

    public /* synthetic */ Object mo4032b(Cursor cursor) {
        return m15990a(cursor);
    }

    public ContentValues mo4030a() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f11674a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f11671b, Boolean.valueOf(this.f11674a.m15996a()));
                contentValues2.put(f11672c, Boolean.valueOf(this.f11674a.m15998b()));
                contentValues2.put(f11673d, Boolean.valueOf(this.f11674a.m16000c()));
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

    public dc m15990a(Cursor cursor) {
        dc dcVar;
        Throwable th;
        boolean z = true;
        try {
            boolean z2;
            boolean z3;
            int i = cursor.getInt(1);
            int i2 = cursor.getInt(2);
            int i3 = cursor.getInt(3);
            if (i == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (i2 == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (i3 == 0) {
                z = false;
            }
            dcVar = new dc();
            try {
                dcVar.m15995a(z2);
                dcVar.m15999c(z);
                dcVar.m15997b(z3);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return dcVar;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            dcVar = null;
            th = th4;
            th.printStackTrace();
            return dcVar;
        }
        return dcVar;
    }

    public void m15991a(dc dcVar) {
        this.f11674a = dcVar;
    }

    public String mo4033b() {
        return cu.f11627e;
    }
}
