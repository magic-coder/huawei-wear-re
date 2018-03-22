package cn.com.xy.sms.sdk.p208d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.Hashtable;

public final class C2964g {
    private static Object f10048a = new Object();
    private static C2965h f10049b = null;
    private static int f10050c = 1000;
    private static int f10051d = 100;
    private static Hashtable<SQLiteDatabase, Integer> f10052e = new Hashtable();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13329a(java.lang.String r4, android.content.ContentValues r5, java.lang.String r6, java.lang.String[] r7) {
        /*
        r2 = f10048a;
        monitor-enter(r2);
        r0 = 0;
        r0 = cn.com.xy.sms.sdk.p208d.C2964g.m13330a();	 Catch:{ Throwable -> 0x0012, all -> 0x0019 }
        r1 = r0.update(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0012, all -> 0x0024 }
        cn.com.xy.sms.sdk.p208d.C2964g.m13332a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x0012:
        r1 = move-exception;
        r1 = -1;
        cn.com.xy.sms.sdk.p208d.C2964g.m13332a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
        goto L_0x0010;
    L_0x0019:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x001d:
        cn.com.xy.sms.sdk.p208d.C2964g.m13332a(r1);	 Catch:{ all -> 0x0021 }
        throw r0;	 Catch:{ all -> 0x0021 }
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0024:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.g.a(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public static SQLiteDatabase m13330a() {
        SQLiteDatabase sQLiteDatabase = null;
        long currentTimeMillis = System.currentTimeMillis();
        while (sQLiteDatabase == null) {
            sQLiteDatabase = C2964g.m13331a(C2917a.m13105a());
            if (sQLiteDatabase == null) {
                if (System.currentTimeMillis() - currentTimeMillis >= ((long) f10050c)) {
                    break;
                }
                try {
                    Thread.sleep((long) f10051d);
                } catch (Throwable e) {
                    C2982a.m13415a("XIAOYUAN", "ContactsDBManager DBManager getSQLiteDatabase error: " + e.getMessage(), e);
                }
            } else if (sQLiteDatabase.inTransaction()) {
                new StringBuilder("ContactsDBManager getSQLiteDatabase inTransaction hashcode: ").append(sQLiteDatabase.hashCode());
            }
        }
        return sQLiteDatabase;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.database.sqlite.SQLiteDatabase m13331a(android.content.Context r6) {
        /*
        r1 = 0;
        r3 = f10052e;
        monitor-enter(r3);
        r0 = f10052e;	 Catch:{ all -> 0x006f }
        r0 = r0.size();	 Catch:{ all -> 0x006f }
        r2 = 10;
        if (r0 < r2) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x006f }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        if (r6 != 0) goto L_0x001d;
    L_0x0013:
        r0 = "XIAOYUAN";
        r2 = "ContactsDBManager createSQLiteDatabase: contexts is null";
        cn.com.xy.sms.sdk.p215g.C2982a.m13414a(r0, r2);	 Catch:{ all -> 0x006f }
        monitor-exit(r3);	 Catch:{ all -> 0x006f }
        r0 = r1;
        goto L_0x0010;
    L_0x001d:
        r0 = cn.com.xy.sms.sdk.p208d.C2964g.m13333b(r6);	 Catch:{ all -> 0x006f }
        r2 = r0.getReadableDatabase();	 Catch:{ all -> 0x006f }
        if (r2 == 0) goto L_0x006c;
    L_0x0027:
        r0 = f10052e;	 Catch:{ all -> 0x006f }
        r0 = r0.get(r2);	 Catch:{ all -> 0x006f }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x006f }
        if (r0 != 0) goto L_0x0061;
    L_0x0031:
        r0 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x006f }
    L_0x0036:
        r4 = f10052e;	 Catch:{ all -> 0x006f }
        r4.put(r2, r0);	 Catch:{ all -> 0x006f }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r5 = "ContactsDBManager $$$$$ db code : ";
        r4.<init>(r5);	 Catch:{ all -> 0x006f }
        r5 = r2.hashCode();	 Catch:{ all -> 0x006f }
        r4 = r4.append(r5);	 Catch:{ all -> 0x006f }
        r5 = " cnt: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x006f }
        r4.append(r0);	 Catch:{ all -> 0x006f }
        r0 = r2.isOpen();	 Catch:{ all -> 0x006f }
        if (r0 != 0) goto L_0x006c;
    L_0x0059:
        r0 = f10052e;	 Catch:{ all -> 0x006f }
        r0.remove(r2);	 Catch:{ all -> 0x006f }
        monitor-exit(r3);	 Catch:{ all -> 0x006f }
        r0 = r1;
        goto L_0x0010;
    L_0x0061:
        r0 = r0.intValue();	 Catch:{ all -> 0x006f }
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x006f }
        goto L_0x0036;
    L_0x006c:
        monitor-exit(r3);
        r0 = r2;
        goto L_0x0010;
    L_0x006f:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.g.a(android.content.Context):android.database.sqlite.SQLiteDatabase");
    }

    public static void m13332a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                synchronized (f10052e) {
                    if (sQLiteDatabase.isOpen()) {
                        Integer num = (Integer) f10052e.get(sQLiteDatabase);
                        if (num == null) {
                            new StringBuilder("ContactsDBManager $$$$$ db close cnt is null ").append(sQLiteDatabase.hashCode());
                        } else {
                            num = Integer.valueOf(num.intValue() - 1);
                            if (num.intValue() == 0) {
                                f10052e.remove(sQLiteDatabase);
                                sQLiteDatabase.close();
                            } else {
                                f10052e.put(sQLiteDatabase, num);
                            }
                        }
                    } else {
                        f10052e.remove(sQLiteDatabase);
                    }
                }
            } catch (Throwable th) {
                C2982a.m13414a("XIAOYUAN", "ContactsDBManager close error: " + th.getMessage());
            }
        }
    }

    private static synchronized C2965h m13333b(Context context) {
        C2965h c2965h;
        synchronized (C2964g.class) {
            if (f10049b == null) {
                f10049b = new C2965h(context, "duoqu_contacts.db", null, 5);
            }
            c2965h = f10049b;
        }
        return c2965h;
    }

    public static void m13334b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS contacts(_id INTEGER PRIMARY KEY AUTOINCREMENT, phone TEXT, name TEXT, update_time TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_number_info (id INTEGER PRIMARY KEY, num TEXT UNIQUE, result TEXT, version TEXT, last_query_time INTEGER DEFAULT 0)");
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ContactsDBManager createDb error:" + th.getMessage(), th);
        }
    }

    public static void m13335c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE INDEX IDX_tb_number_info_last_query_time ON tb_number_info(last_query_time);");
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ContactsDBManager createIndex error:" + th.getMessage(), th);
        }
    }
}
