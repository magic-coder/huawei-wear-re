package cn.com.xy.sms.sdk.p208d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class C2963f extends SQLiteOpenHelper {
    private String f10047a = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name =?";

    public C2963f(Context context) {
        super(context, "duoqu_contacts.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS contacts(_id INTEGER PRIMARY KEY AUTOINCREMENT, phone TEXT, name TEXT, update_time TEXT)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
