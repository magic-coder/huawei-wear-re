package com.huawei.hwdatamigrate.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hwdatamigrate.hihealth.sync.d.l;

/* compiled from: DBHelper */
public class C0997e extends SQLiteOpenHelper {
    public C0997e(Context context) {
        super(context, "HwWearDatas.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        l.a(sQLiteDatabase, C1000i.f1678b);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
