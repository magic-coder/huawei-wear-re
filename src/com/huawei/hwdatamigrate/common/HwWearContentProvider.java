package com.huawei.hwdatamigrate.common;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class HwWearContentProvider extends ContentProvider {
    private static UriMatcher f1674a;
    private C0997e f1675b;
    private SQLiteDatabase f1676c;

    static {
        f1674a = null;
        f1674a = new UriMatcher(-1);
        f1674a.addURI("com.huawei.HwWearContentProvider", "PropertyTable", 1);
    }

    public boolean onCreate() {
        this.f1675b = new C0997e(getContext());
        if (this.f1675b == null) {
            return false;
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f1676c = this.f1675b.getReadableDatabase();
        String str3 = "";
        switch (f1674a.match(uri)) {
            case 1:
                return this.f1676c.query("PropertyTable", strArr, str, strArr2, null, null, str2);
            default:
                throw new IllegalArgumentException("This is a unKnown Uri" + uri.toString());
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        this.f1676c = this.f1675b.getWritableDatabase();
        switch (f1674a.match(uri)) {
            case 1:
                Uri withAppendedPath = Uri.withAppendedPath(uri, "/" + C1000i.m3637a(this.f1676c, contentValues));
                getContext().getContentResolver().notifyChange(uri, null);
                return withAppendedPath;
            default:
                throw new IllegalArgumentException("This is a unKnow Uri" + uri.toString());
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        this.f1676c = this.f1675b.getWritableDatabase();
        String str2 = "";
        switch (f1674a.match(uri)) {
            case 1:
                return this.f1676c.delete("PropertyTable", str, strArr);
            default:
                throw new IllegalArgumentException("This is a unKnow Uri" + uri.toString());
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        this.f1676c = this.f1675b.getWritableDatabase();
        String str2 = "";
        switch (f1674a.match(uri)) {
            case 1:
                return this.f1676c.update("PropertyTable", contentValues, str, strArr);
            default:
                throw new IllegalArgumentException("This is a unKnow Uri" + uri.toString());
        }
    }
}
