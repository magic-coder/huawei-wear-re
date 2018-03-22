package com.amap.api.services.core;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: UpdateLogEntity */
public class ar implements ap<as> {
    private static final String f12363b = ah.f12339o;
    private static final String f12364c = ah.f12340p;
    private static final String f12365d = ah.f12341q;
    private as f12366a = null;

    public /* synthetic */ Object mo4106b(Cursor cursor) {
        return m16680a(cursor);
    }

    public ContentValues mo4105b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f12366a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f12363b, Boolean.valueOf(this.f12366a.m16687a()));
                contentValues2.put(f12364c, Boolean.valueOf(this.f12366a.m16689b()));
                contentValues2.put(f12365d, Boolean.valueOf(this.f12366a.m16691c()));
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

    public as m16680a(Cursor cursor) {
        as asVar;
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
            asVar = new as();
            try {
                asVar.m16686a(z2);
                asVar.m16690c(z);
                asVar.m16688b(z3);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return asVar;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            asVar = null;
            th = th4;
            th.printStackTrace();
            return asVar;
        }
        return asVar;
    }

    public void m16682a(as asVar) {
        this.f12366a = asVar;
    }

    public String mo4107a() {
        return ah.f12329e;
    }
}
