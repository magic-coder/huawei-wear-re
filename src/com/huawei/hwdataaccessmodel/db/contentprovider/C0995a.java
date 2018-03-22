package com.huawei.hwdataaccessmodel.db.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.p190v.C2538c;

/* compiled from: ContentProviderDB */
public class C0995a extends SQLiteOpenHelper {
    private static byte[] f1672a = new byte[1];
    private static C0995a f1673b;

    private C0995a(Context context) {
        super(context, "HwCPDatas.db", null, 2);
    }

    public static C0995a m3608a(Context context) {
        C0995a c0995a;
        synchronized (f1672a) {
            if (f1673b == null) {
                f1673b = new C0995a(context);
            }
            c0995a = f1673b;
        }
        return c0995a;
    }

    public SQLiteDatabase m3609a() {
        return getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void m3610a(String str) {
        synchronized (f1672a) {
            SQLiteDatabase a = f1673b.m3609a();
            if (a != null) {
                try {
                    a.execSQL(str);
                } catch (SQLiteException e) {
                    C2538c.m12680e("ContentProviderDB", "enter execSQL SQLiteException;", e.getMessage());
                } catch (Exception e2) {
                    C2538c.m12680e("ContentProviderDB", "enter execSQL Exception;", e2.getMessage());
                }
            }
        }
    }
}
