package cn.com.xy.sms.sdk.p208d.p209a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3055t;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.Hashtable;

public final class C2918a {
    public static Object f9904a = new Object();
    private static C2919b f9905b = null;
    private static int f9906c = 1000;
    private static int f9907d = 100;
    private static Hashtable<SQLiteDatabase, Integer> f9908e = new Hashtable();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13117a(java.lang.String r4, android.content.ContentValues r5, java.lang.String r6, java.lang.String[] r7) {
        /*
        r2 = f9904a;
        monitor-enter(r2);
        r0 = 0;
        r0 = cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13119a();	 Catch:{ Throwable -> 0x0012, all -> 0x0019 }
        r1 = r0.update(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0012, all -> 0x0024 }
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13122a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x0012:
        r1 = move-exception;
        r1 = -1;
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13122a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
        goto L_0x0010;
    L_0x0019:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x001d:
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13122a(r1);	 Catch:{ all -> 0x0021 }
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
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.a.a.a(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13118a(java.lang.String r4, java.lang.String r5, java.lang.String[] r6) {
        /*
        r2 = f9904a;
        monitor-enter(r2);
        r0 = 0;
        r0 = cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13119a();	 Catch:{ Throwable -> 0x0012, all -> 0x0019 }
        r1 = r0.delete(r4, r5, r6);	 Catch:{ Throwable -> 0x0012, all -> 0x0024 }
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13122a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x0012:
        r1 = move-exception;
        r1 = -1;
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13122a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
        goto L_0x0010;
    L_0x0019:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x001d:
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13122a(r1);	 Catch:{ all -> 0x0021 }
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
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.a.a.a(java.lang.String, java.lang.String, java.lang.String[]):int");
    }

    public static SQLiteDatabase m13119a() {
        SQLiteDatabase sQLiteDatabase = null;
        long currentTimeMillis = System.currentTimeMillis();
        while (sQLiteDatabase == null) {
            sQLiteDatabase = C2918a.m13120a(C2917a.m13105a());
            if (sQLiteDatabase != null || System.currentTimeMillis() - currentTimeMillis >= ((long) f9906c)) {
                break;
            }
            try {
                Thread.sleep((long) f9907d);
            } catch (InterruptedException e) {
                new StringBuilder("BizportDBManager getSQLiteDatabase ").append(e.getMessage());
            }
        }
        return sQLiteDatabase;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.database.sqlite.SQLiteDatabase m13120a(android.content.Context r5) {
        /*
        r1 = 0;
        r3 = f9908e;
        monitor-enter(r3);
        r0 = f9908e;	 Catch:{ all -> 0x004f }
        r0 = r0.size();	 Catch:{ all -> 0x004f }
        r2 = 10;
        if (r0 < r2) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x004f }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = r5.getApplicationContext();	 Catch:{ all -> 0x004f }
        r0 = cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13125b(r0);	 Catch:{ all -> 0x004f }
        r2 = r0.getReadableDatabase();	 Catch:{ all -> 0x004f }
        if (r2 == 0) goto L_0x004c;
    L_0x001f:
        r0 = f9908e;	 Catch:{ all -> 0x004f }
        r0 = r0.get(r2);	 Catch:{ all -> 0x004f }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x004f }
        if (r0 != 0) goto L_0x0041;
    L_0x0029:
        r0 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x004f }
    L_0x002e:
        r4 = f9908e;	 Catch:{ all -> 0x004f }
        r4.put(r2, r0);	 Catch:{ all -> 0x004f }
        r0 = r2.isOpen();	 Catch:{ all -> 0x004f }
        if (r0 != 0) goto L_0x004c;
    L_0x0039:
        r0 = f9908e;	 Catch:{ all -> 0x004f }
        r0.remove(r2);	 Catch:{ all -> 0x004f }
        monitor-exit(r3);	 Catch:{ all -> 0x004f }
        r0 = r1;
        goto L_0x0010;
    L_0x0041:
        r0 = r0.intValue();	 Catch:{ all -> 0x004f }
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x004f }
        goto L_0x002e;
    L_0x004c:
        monitor-exit(r3);
        r0 = r2;
        goto L_0x0010;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.a.a.a(android.content.Context):android.database.sqlite.SQLiteDatabase");
    }

    public static C2962e m13121a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a = C2918a.m13119a();
            try {
                return new C2962e(a, a.query(str, strArr, str2, strArr2, null, null, str5, str6), 1);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                sQLiteDatabase = a;
                th = th3;
                C2918a.m13122a(sQLiteDatabase);
                new StringBuilder("BizportDBManager 1query ").append(th.getMessage());
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            C2918a.m13122a(sQLiteDatabase);
            new StringBuilder("BizportDBManager 1query ").append(th.getMessage());
            return null;
        }
    }

    public static void m13122a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                synchronized (f9908e) {
                    Integer num = (Integer) f9908e.get(sQLiteDatabase);
                    if (num == null) {
                        new StringBuilder("$$$$$ db close cnt is null ").append(sQLiteDatabase.hashCode());
                    } else {
                        num = Integer.valueOf(num.intValue() - 1);
                        if (num.intValue() == 0) {
                            f9908e.remove(sQLiteDatabase);
                            sQLiteDatabase.close();
                        } else {
                            f9908e.put(sQLiteDatabase, num);
                        }
                    }
                }
                if (f9908e.size() == 0 && f9905b != null) {
                    f9905b.close();
                }
            } catch (Throwable th) {
                new StringBuilder("BizportDBManager close ").append(th.getMessage());
            }
        }
    }

    public static void m13123a(String str, boolean z) {
        LineNumberReader lineNumberReader;
        Throwable th;
        Reader reader;
        SQLiteDatabase sQLiteDatabase;
        Reader reader2;
        Object obj;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (C3055t.m13704a(str)) {
            try {
                Reader bufferedReader3 = new BufferedReader(new FileReader(new File(str)));
                try {
                    lineNumberReader = new LineNumberReader(bufferedReader3);
                    try {
                        SQLiteDatabase a = C2918a.m13119a();
                        try {
                            a.beginTransaction();
                            while (true) {
                                String readLine = lineNumberReader.readLine();
                                if (readLine == null) {
                                    lineNumberReader.close();
                                    C2918a.m13124a(str, false, lineNumberReader, bufferedReader3, a);
                                    return;
                                } else if (!C3049n.m13653e(readLine)) {
                                    a.execSQL(readLine);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            reader = bufferedReader3;
                            sQLiteDatabase = a;
                            bufferedReader2 = reader;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        reader = bufferedReader3;
                        obj = bufferedReader2;
                        reader2 = reader;
                        C2918a.m13124a(str, false, lineNumberReader, bufferedReader2, sQLiteDatabase);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = bufferedReader2;
                    reader = bufferedReader3;
                    obj = bufferedReader2;
                    reader2 = reader;
                    C2918a.m13124a(str, false, lineNumberReader, bufferedReader2, sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                lineNumberReader = bufferedReader2;
                sQLiteDatabase = bufferedReader2;
                C2918a.m13124a(str, false, lineNumberReader, bufferedReader2, sQLiteDatabase);
                throw th;
            }
        }
    }

    public static void m13124a(String str, boolean z, LineNumberReader lineNumberReader, BufferedReader bufferedReader, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            try {
                C3055t.m13712d(str);
            } catch (Throwable th) {
            }
        }
        if (lineNumberReader != null) {
            try {
                lineNumberReader.close();
            } catch (Throwable th2) {
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th3) {
            }
        }
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                }
                C2918a.m13122a(sQLiteDatabase);
            } catch (Throwable th4) {
                new StringBuilder("BizportDBManager closeDB ").append(th4.getMessage());
            }
        }
    }

    private static synchronized C2919b m13125b(Context context) {
        C2919b c2919b;
        synchronized (C2918a.class) {
            if (f9905b == null) {
                f9905b = new C2919b(context, "bizport.db", null, 3);
            }
            c2919b = f9905b;
        }
        return c2919b;
    }

    static /* synthetic */ void m13126b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table  if not exists tb_regex (scene_id TEXT,match_id TEXT,regex_text TEXT,version_code TEXT,regex_type INTEGER  DEFAULT '0',last_use_time INTEGER  DEFAULT '0',state INTEGER  DEFAULT '0' )");
            sQLiteDatabase.execSQL("create index if not exists indx_s_m on tb_regex (scene_id,match_id)");
            sQLiteDatabase.execSQL("create table  if not exists tb_phone_pubid(id INTEGER PRIMARY KEY AUTOINCREMENT,phonenum TEXT,publd TEXT,queryflag TEXT,querytime number(24))");
            try {
                sQLiteDatabase.execSQL("ALTER TABLE tb_regex ADD COLUMN last_use_time INTEGER DEFAULT '0'");
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            C2982a.m13415a("XIAOYUAN", "createDb: " + th2.getMessage(), th2);
        }
    }
}
