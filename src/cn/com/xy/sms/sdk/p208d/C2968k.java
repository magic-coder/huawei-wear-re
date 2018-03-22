package cn.com.xy.sms.sdk.p208d;

import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3040e;

final class C2968k implements Runnable {
    private final /* synthetic */ String f10058a;

    C2968k(String str) {
        this.f10058a = str;
    }

    public final void run() {
        try {
            synchronized (C2922b.f9909a) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabase = C2922b.m13136a();
                    sQLiteDatabase.execSQL(this.f10058a);
                    new StringBuilder("sql=").append(this.f10058a).append(" time=").append(C3040e.m13604a("yyyyMMdd hh:MM:ss", System.currentTimeMillis()));
                    C2922b.m13143a(sQLiteDatabase);
                } catch (Throwable th) {
                    C2922b.m13143a(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            C2982a.m13415a("XIAOYUAN", "execSQL: " + th2.getMessage(), th2);
        }
    }
}
