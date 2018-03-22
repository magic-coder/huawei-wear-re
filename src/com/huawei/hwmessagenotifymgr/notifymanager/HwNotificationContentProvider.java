package com.huawei.hwmessagenotifymgr.notifymanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.huawei.p190v.C2538c;

public class HwNotificationContentProvider extends ContentProvider {
    private static UriMatcher f1925a;
    private C1036b f1926b;
    private SQLiteDatabase f1927c;

    static {
        f1925a = null;
        f1925a = new UriMatcher(-1);
        f1925a.addURI("com.huawei.HwNotificationContentProvider", "NotificationList", 1);
        f1925a.addURI("com.huawei.HwNotificationContentProvider", "NotificationList/#", 2);
    }

    public boolean onCreate() {
        C2538c.m12674b("HwNotificationContentProvider", "enter oncreate");
        this.f1926b = new C1036b(getContext());
        if (this.f1926b == null) {
            return false;
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        String str4;
        Exception e;
        C2538c.m12674b("HwNotificationContentProvider", "enter query");
        this.f1927c = this.f1926b.getReadableDatabase();
        String str5 = "";
        switch (f1925a.match(uri)) {
            case 1:
                str3 = "NotificationList";
                str4 = str;
                break;
            case 2:
                str3 = "NotificationList";
                String str6 = "";
                try {
                    str5 = (String) uri.getPathSegments().get(2);
                    try {
                        C2538c.m12674b("HwNotificationContentProvider", "enter query :name" + str5);
                    } catch (Exception e2) {
                        e = e2;
                        C2538c.m12674b("HwNotificationContentProvider", "parse name:" + e.toString());
                        str4 = "name=" + str5;
                        return this.f1927c.query(str3, strArr, str4, strArr2, null, null, str2);
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    str5 = str6;
                    e = exception;
                    C2538c.m12674b("HwNotificationContentProvider", "parse name:" + e.toString());
                    str4 = "name=" + str5;
                    return this.f1927c.query(str3, strArr, str4, strArr2, null, null, str2);
                }
                str4 = "name=" + str5;
            default:
                throw new IllegalArgumentException("This is a unKnow Uri" + uri.toString());
        }
        return this.f1927c.query(str3, strArr, str4, strArr2, null, null, str2);
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        this.f1927c = this.f1926b.getWritableDatabase();
        switch (f1925a.match(uri)) {
            case 1:
                return Uri.withAppendedPath(uri, "/" + this.f1927c.insert("NotificationList", "name", contentValues));
            default:
                throw new IllegalArgumentException("This is a unKnow Uri" + uri.toString());
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        Exception e;
        this.f1927c = this.f1926b.getWritableDatabase();
        switch (f1925a.match(uri)) {
            case 1:
                return this.f1927c.delete("NotificationList", str, strArr);
            case 2:
                String str2;
                String str3 = "";
                try {
                    str2 = (String) uri.getPathSegments().get(2);
                    try {
                        C2538c.m12674b("HwNotificationContentProvider", "enter query :name" + str2);
                    } catch (Exception e2) {
                        e = e2;
                        C2538c.m12674b("HwNotificationContentProvider", "parse name:" + e.toString());
                        return this.f1927c.delete("NotificationList", "name = " + str2, strArr);
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    str2 = str3;
                    e = exception;
                    C2538c.m12674b("HwNotificationContentProvider", "parse name:" + e.toString());
                    return this.f1927c.delete("NotificationList", "name = " + str2, strArr);
                }
                return this.f1927c.delete("NotificationList", "name = " + str2, strArr);
            default:
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
