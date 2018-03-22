package com.huawei.hwdataaccessmodel.db.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class HWContentProvider extends ContentProvider {
    private C0995a f1670a;
    private SQLiteDatabase f1671b;

    public boolean onCreate() {
        this.f1670a = C0995a.m3608a(getContext());
        if (this.f1670a == null) {
            return false;
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f1671b = this.f1670a.getReadableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (!TextUtils.isEmpty(substring)) {
            return this.f1671b.query(substring, strArr, str, strArr2, null, null, str2);
        }
        throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        this.f1671b = this.f1670a.getWritableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (TextUtils.isEmpty(substring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        Uri withAppendedPath = Uri.withAppendedPath(uri, "/" + this.f1671b.insert(substring, null, contentValues));
        getContext().getContentResolver().notifyChange(uri, null);
        return withAppendedPath;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        this.f1671b = this.f1670a.getWritableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (!TextUtils.isEmpty(substring)) {
            return this.f1671b.delete(substring, str, strArr);
        }
        throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        this.f1671b = this.f1670a.getWritableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (!TextUtils.isEmpty(substring)) {
            return this.f1671b.update(substring, contentValues, str, strArr);
        }
        throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
    }
}
