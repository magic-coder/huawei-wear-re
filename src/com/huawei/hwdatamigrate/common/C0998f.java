package com.huawei.hwdatamigrate.common;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: DBStorageUtil */
public class C0998f {
    public static String m3621a(ContentResolver contentResolver, String str) {
        String str2 = "";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(C1000i.f1677a, null, " propKey = ?", new String[]{str}, null);
        if (query == null) {
            return str2;
        }
        String str3;
        if (query.moveToNext()) {
            str3 = query.getString(query.getColumnIndex("propValue")).toString();
        } else {
            str3 = str2;
        }
        query.close();
        return str3;
    }

    public static void m3622a(ContentResolver contentResolver, String str, String str2) {
        long update;
        ContentValues contentValues = new ContentValues();
        contentValues.put("propKey", str);
        contentValues.put("propValue", str2);
        if (C0998f.m3623b(contentResolver, str)) {
            update = (long) contentResolver.update(C1000i.f1677a, contentValues, " propKey = ?", new String[]{str});
        } else {
            update = ContentUris.parseId(contentResolver.insert(C1000i.f1677a, contentValues));
        }
        if (update >= 0) {
        }
    }

    private static boolean m3623b(ContentResolver contentResolver, String str) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(C1000i.f1677a, null, " propKey = ?", new String[]{str}, null);
        if (query == null) {
            return false;
        }
        boolean z;
        if (query.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        query.close();
        return z;
    }
}
