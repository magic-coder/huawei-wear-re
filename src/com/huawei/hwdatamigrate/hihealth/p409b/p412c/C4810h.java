package com.huawei.hwdatamigrate.hihealth.p409b.p412c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: DBCommon */
abstract class C4810h {
    protected static Context f17785a;
    private SQLiteDatabase f17786b = C4805a.m23018a(f17785a).m23024c();

    protected abstract String mo4571b();

    protected abstract String[] mo4572c();

    protected C4810h() {
    }

    public long mo4566a(ContentValues contentValues) {
        return this.f17786b.insert(mo4571b(), null, contentValues);
    }

    public int mo4570b(String str, String[] strArr) {
        return this.f17786b.delete(mo4571b(), str, strArr);
    }

    public int mo4565a(ContentValues contentValues, String str, String[] strArr) {
        return this.f17786b.update(mo4571b(), contentValues, str, strArr);
    }

    public Cursor mo4568a(String str, String[] strArr, String str2, String str3, String str4) {
        return this.f17786b.query(mo4571b(), mo4572c(), str, strArr, str2, str3, str4);
    }

    public Cursor mo4569a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return this.f17786b.query(mo4571b(), strArr, str, strArr2, str2, str3, str4);
    }

    public Cursor mo4567a(String str, String[] strArr) {
        return this.f17786b.rawQuery(str, strArr);
    }
}
