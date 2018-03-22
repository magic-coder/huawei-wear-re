package com.huawei.hwdataaccessmodel.db.backup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hwdataaccessmodel.p065a.C0992a;

public class HWBackupProvider extends ContentProvider {
    private C0994a f1666a;
    private SQLiteDatabase f1667b;

    public boolean onCreate() {
        this.f1666a = C0994a.m3605a(getContext());
        if (this.f1666a == null) {
            return false;
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (TextUtils.isEmpty(substring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        this.f1667b = this.f1666a.getReadableDatabase();
        return this.f1667b.query(substring, strArr, C0992a.m3604a(str), strArr2, null, null, str2);
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        this.f1667b = this.f1666a.getWritableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (TextUtils.isEmpty(substring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        Uri withAppendedPath = Uri.withAppendedPath(uri, "/" + this.f1667b.insert(substring, null, contentValues));
        getContext().getContentResolver().notifyChange(uri, null);
        return withAppendedPath;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        this.f1667b = this.f1666a.getWritableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (!TextUtils.isEmpty(substring)) {
            return this.f1667b.delete(substring, C0992a.m3604a(str), strArr);
        }
        throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        this.f1667b = this.f1666a.getWritableDatabase();
        String uri2 = uri.toString();
        Object substring = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
        if (!TextUtils.isEmpty(substring)) {
            return this.f1667b.update(substring, contentValues, C0992a.m3604a(str), strArr);
        }
        throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
    }
}
