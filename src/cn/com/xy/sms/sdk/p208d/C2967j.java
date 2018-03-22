package cn.com.xy.sms.sdk.p208d;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2967j extends SQLiteOpenHelper {
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            C2966i.m13337b(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "MyDbHelper onCreate error: " + th.getMessage(), th);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_base_value");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_conversation");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_key");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_log");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_log_exception");
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyaun", "DBManager onDowngrade" + th.getMessage(), th);
        }
        C2966i.m13337b(sQLiteDatabase);
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        try {
            super.onOpen(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "MyDbHelper onOpen error: " + th.getMessage(), th);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2966i.m13337b(sQLiteDatabase);
    }
}
