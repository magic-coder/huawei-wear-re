package com.huawei.hwdataaccessmodel.db.backup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hwdataaccessmodel.p065a.C0992a;
import com.huawei.p190v.C2538c;

/* compiled from: BackupKeyProviderDB */
public class C0994a extends SQLiteOpenHelper {
    private static byte[] f1668a = new byte[1];
    private static C0994a f1669b;

    private C0994a(Context context) {
        super(context, "HwCPBackupDatas.db", null, 1);
    }

    public SQLiteDatabase m3606a() {
        return getWritableDatabase();
    }

    public static C0994a m3605a(Context context) {
        C0994a c0994a;
        synchronized (f1668a) {
            if (f1669b == null) {
                f1669b = new C0994a(context);
            }
            c0994a = f1669b;
        }
        return c0994a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void m3607a(String str) {
        synchronized (f1668a) {
            SQLiteDatabase a = f1669b.m3606a();
            if (a != null) {
                try {
                    a.execSQL(C0992a.m3604a(str));
                } catch (SQLiteException e) {
                    C2538c.m12680e("BackupKeyProviderDB", "enter execSQL SQLiteException;", e.getMessage());
                } catch (Exception e2) {
                    C2538c.m12680e("BackupKeyProviderDB", "enter execSQL Exception;", e2.getMessage());
                }
            }
        }
    }
}
