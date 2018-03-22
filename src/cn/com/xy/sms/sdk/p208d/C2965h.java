package cn.com.xy.sms.sdk.p208d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2965h extends SQLiteOpenHelper {
    public C2965h(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 5);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            C2964g.m13334b(sQLiteDatabase);
            C2964g.m13335c(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ContactsDBManager MyDbHelper onCreate error: " + th.getMessage(), th);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_number_info");
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ContactsDBManager onDowngrade" + th.getMessage(), th);
        }
        C2964g.m13334b(sQLiteDatabase);
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        try {
            super.onOpen(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ContactsDBManager MyDbHelper onOpen error: " + th.getMessage(), th);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2964g.m13334b(sQLiteDatabase);
        C2964g.m13335c(sQLiteDatabase);
    }
}
