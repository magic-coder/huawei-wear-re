package cn.com.xy.sms.sdk.p208d.p209a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2919b extends SQLiteOpenHelper {
    public C2919b(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 3);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            C2918a.m13126b(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "onCreate: " + th.getMessage(), th);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_regex");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_phone_pubid");
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyaun", "BizportDBManager onDowngrade" + th.getMessage(), th);
        }
        C2918a.m13126b(sQLiteDatabase);
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2918a.m13126b(sQLiteDatabase);
    }
}
