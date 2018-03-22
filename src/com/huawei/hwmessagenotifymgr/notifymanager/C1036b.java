package com.huawei.hwmessagenotifymgr.notifymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.p190v.C2538c;

/* compiled from: HwNotificationContentProvider */
class C1036b extends SQLiteOpenHelper {
    public C1036b(Context context) {
        super(context, "notification.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS NotificationList( name NVARCHAR(300) not null PRIMARY KEY ) ");
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", "start");
            sQLiteDatabase.insert("NotificationList", "name", contentValues);
        } catch (SQLException e) {
            C2538c.m12680e("HwNotificationContentProvider", "enter oncreate SQLException;", e.getMessage());
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
