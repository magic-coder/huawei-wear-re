package cn.com.xy.sms.sdk.p208d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2944k;
import cn.com.xy.sms.sdk.p208d.p211c.C2945l;
import cn.com.xy.sms.sdk.p208d.p211c.C2956w;
import cn.com.xy.sms.sdk.p208d.p211c.C2957x;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3055t;
import java.io.BufferedReader;
import java.io.File;
import java.io.LineNumberReader;
import java.util.Hashtable;

public class C2922b {
    public static Object f9909a = new Object();
    private static C2969l f9910b = null;
    private static int f9911c = 1000;
    private static int f9912d = 100;
    private static Hashtable<SQLiteDatabase, Integer> f9913e = new Hashtable();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13133a(java.lang.String r4, android.content.ContentValues r5, java.lang.String r6, java.lang.String[] r7) {
        /*
        r2 = f9909a;
        monitor-enter(r2);
        r0 = 0;
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13136a();	 Catch:{ Throwable -> 0x0012, all -> 0x0019 }
        r1 = r0.update(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0012, all -> 0x0024 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x0012:
        r1 = move-exception;
        r1 = -1;
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
        goto L_0x0010;
    L_0x0019:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x001d:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);	 Catch:{ all -> 0x0021 }
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
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.b.a(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13134a(java.lang.String r4, java.lang.String r5, java.lang.String[] r6) {
        /*
        r2 = f9909a;
        monitor-enter(r2);
        r0 = 0;
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13136a();	 Catch:{ Throwable -> 0x0012, all -> 0x0019 }
        r1 = r0.delete(r4, r5, r6);	 Catch:{ Throwable -> 0x0012, all -> 0x0024 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x0012:
        r1 = move-exception;
        r1 = -1;
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r0);	 Catch:{ all -> 0x0021 }
        r0 = r1;
        goto L_0x0010;
    L_0x0019:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x001d:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);	 Catch:{ all -> 0x0021 }
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
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.b.a(java.lang.String, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m13135a(java.lang.String r6, android.content.ContentValues r7) {
        /*
        r0 = 0;
        r4 = f9909a;
        monitor-enter(r4);
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13136a();	 Catch:{ Throwable -> 0x0013, all -> 0x001b }
        r1 = 0;
        r2 = r0.insert(r6, r1, r7);	 Catch:{ Throwable -> 0x0013, all -> 0x0026 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r0);	 Catch:{ all -> 0x0023 }
        r0 = r2;
    L_0x0011:
        monitor-exit(r4);	 Catch:{ all -> 0x0023 }
        return r0;
    L_0x0013:
        r1 = move-exception;
        r2 = -1;
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r0);	 Catch:{ all -> 0x0023 }
        r0 = r2;
        goto L_0x0011;
    L_0x001b:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x001f:
        cn.com.xy.sms.sdk.p208d.C2922b.m13143a(r1);	 Catch:{ all -> 0x0023 }
        throw r0;	 Catch:{ all -> 0x0023 }
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0026:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.b.a(java.lang.String, android.content.ContentValues):long");
    }

    public static SQLiteDatabase m13136a() {
        SQLiteDatabase sQLiteDatabase = null;
        long currentTimeMillis = System.currentTimeMillis();
        while (sQLiteDatabase == null) {
            sQLiteDatabase = C2922b.m13137a(C2917a.m13105a());
            if (sQLiteDatabase == null) {
                if (System.currentTimeMillis() - currentTimeMillis >= ((long) f9911c)) {
                    break;
                }
                try {
                    Thread.sleep((long) f9912d);
                } catch (Throwable e) {
                    C2982a.m13415a("xiaoyuan", "DBManager getSQLiteDatabase error: " + e.getMessage(), e);
                }
            } else if (sQLiteDatabase.inTransaction()) {
                new StringBuilder("getSQLiteDatabase inTransaction hashcode: ").append(sQLiteDatabase.hashCode());
            }
        }
        return sQLiteDatabase;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.database.sqlite.SQLiteDatabase m13137a(android.content.Context r6) {
        /*
        r1 = 0;
        r3 = f9913e;
        monitor-enter(r3);
        r0 = f9913e;	 Catch:{ all -> 0x0070 }
        r0 = r0.size();	 Catch:{ all -> 0x0070 }
        r2 = 10;
        if (r0 < r2) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0070 }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        if (r6 != 0) goto L_0x001e;
    L_0x0013:
        r0 = "xiaoyuan";
        r2 = "createSQLiteDatabase: contexts is null";
        cn.com.xy.sms.sdk.p215g.C2982a.m13414a(r0, r2);	 Catch:{ all -> 0x0070 }
        monitor-exit(r3);	 Catch:{ all -> 0x0070 }
        r0 = r1;
        goto L_0x0010;
    L_0x001e:
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13150b(r6);	 Catch:{ all -> 0x0070 }
        r2 = r0.getReadableDatabase();	 Catch:{ all -> 0x0070 }
        if (r2 == 0) goto L_0x006d;
    L_0x0028:
        r0 = f9913e;	 Catch:{ all -> 0x0070 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0070 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0062;
    L_0x0032:
        r0 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0070 }
    L_0x0037:
        r4 = f9913e;	 Catch:{ all -> 0x0070 }
        r4.put(r2, r0);	 Catch:{ all -> 0x0070 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0070 }
        r5 = "$$$$$ db code : ";
        r4.<init>(r5);	 Catch:{ all -> 0x0070 }
        r5 = r2.hashCode();	 Catch:{ all -> 0x0070 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r5 = " cnt: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0070 }
        r4.append(r0);	 Catch:{ all -> 0x0070 }
        r0 = r2.isOpen();	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x006d;
    L_0x005a:
        r0 = f9913e;	 Catch:{ all -> 0x0070 }
        r0.remove(r2);	 Catch:{ all -> 0x0070 }
        monitor-exit(r3);	 Catch:{ all -> 0x0070 }
        r0 = r1;
        goto L_0x0010;
    L_0x0062:
        r0 = r0.intValue();	 Catch:{ all -> 0x0070 }
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0070 }
        goto L_0x0037;
    L_0x006d:
        monitor-exit(r3);
        r0 = r2;
        goto L_0x0010;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.b.a(android.content.Context):android.database.sqlite.SQLiteDatabase");
    }

    public static C2962e m13138a(String str, String[] strArr) {
        C2962e c2962e;
        Throwable th;
        SQLiteDatabase a;
        try {
            a = C2922b.m13136a();
            try {
                if (C2922b.m13152c(a)) {
                    return null;
                }
                c2962e = new C2962e(a, a.rawQuery(str, strArr), 0);
                return c2962e;
            } catch (Throwable th2) {
                th = th2;
                C2922b.m13143a(a);
                C2982a.m13415a("xiaoyuan", "DBManager rawQuery error: " + th.getMessage(), th);
                c2962e = null;
                return c2962e;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2922b.m13143a(a);
            C2982a.m13415a("xiaoyuan", "DBManager rawQuery error: " + th.getMessage(), th);
            c2962e = null;
            return c2962e;
        }
    }

    public static C2962e m13139a(String str, String[] strArr, String str2, String[] strArr2) {
        return C2922b.m13141a(false, str, strArr, str2, strArr2, null, null, null, null);
    }

    public static C2962e m13140a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a = C2922b.m13136a();
            try {
                return C2922b.m13152c(a) ? null : new C2962e(a, a.query(str, strArr, str2, strArr2, str3, str4, str5, str6), 0);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                sQLiteDatabase = a;
                th = th3;
                C2922b.m13143a(sQLiteDatabase);
                C2982a.m13415a("xiaoyuan", "DBManager 2query error: " + th.getMessage(), th);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            C2922b.m13143a(sQLiteDatabase);
            C2982a.m13415a("xiaoyuan", "DBManager 2query error: " + th.getMessage(), th);
            return null;
        }
    }

    public static C2962e m13141a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a = C2922b.m13136a();
            if (a == null) {
                return null;
            }
            try {
                return C2922b.m13152c(a) ? null : new C2962e(a, a.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6), 0);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                sQLiteDatabase = a;
                th = th3;
                C2922b.m13143a(sQLiteDatabase);
                C2982a.m13415a("xiaoyuan", "DBManager 1query error: " + th.getMessage(), th);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            C2922b.m13143a(sQLiteDatabase);
            C2982a.m13415a("xiaoyuan", "DBManager 1query error: " + th.getMessage(), th);
            return null;
        }
    }

    public static void m13142a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void m13143a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                synchronized (f9913e) {
                    if (sQLiteDatabase.isOpen()) {
                        Integer num = (Integer) f9913e.get(sQLiteDatabase);
                        if (num == null) {
                            new StringBuilder("$$$$$ db close cnt is null ").append(sQLiteDatabase.hashCode());
                        } else {
                            num = Integer.valueOf(num.intValue() - 1);
                            if (num.intValue() == 0) {
                                f9913e.remove(sQLiteDatabase);
                                sQLiteDatabase.close();
                            } else {
                                f9913e.put(sQLiteDatabase, num);
                            }
                        }
                    } else {
                        f9913e.remove(sQLiteDatabase);
                    }
                }
                if (f9913e.size() != 0) {
                }
            } catch (Throwable th) {
                C2982a.m13414a("xiaoyuan", "DBManager close error: " + th.getMessage());
            }
        }
    }

    private static void m13144a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Throwable th) {
        }
    }

    public static void m13145a(File file, boolean z, LineNumberReader lineNumberReader, BufferedReader bufferedReader, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            try {
                C3055t.m13697a(file);
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
                C2922b.m13143a(sQLiteDatabase);
            } catch (Throwable th4) {
                C2982a.m13415a("xiaoyuan", "DBManager closeDB error: " + th4.getMessage(), th4);
            }
        }
    }

    public static void m13146a(String str) {
        if (!C3049n.m13653e(str)) {
            C2978a.f10090a.execute(new C2968k(str));
        }
    }

    public static void m13147a(String str, boolean z, LineNumberReader lineNumberReader, BufferedReader bufferedReader, SQLiteDatabase sQLiteDatabase) {
        File file;
        if (z) {
            try {
                file = new File(str);
            } catch (Throwable th) {
                C2982a.m13415a("xiaoyuan", "DBManager closeDB error: " + th.getMessage(), th);
            }
            C2922b.m13145a(file, z, lineNumberReader, bufferedReader, sQLiteDatabase);
        }
        file = null;
        C2922b.m13145a(file, z, lineNumberReader, bufferedReader, sQLiteDatabase);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m13148a(java.io.File r9, boolean r10) {
        /*
        r0 = 0;
        r3 = 0;
        if (r9 == 0) goto L_0x000a;
    L_0x0004:
        r1 = r9.exists();
        if (r1 != 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r4 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0084, all -> 0x0073 }
        r1 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0084, all -> 0x0073 }
        r1.<init>(r9);	 Catch:{ Throwable -> 0x0084, all -> 0x0073 }
        r4.<init>(r1);	 Catch:{ Throwable -> 0x0084, all -> 0x0073 }
        r2 = new java.io.LineNumberReader;	 Catch:{ Throwable -> 0x0088, all -> 0x007a }
        r2.<init>(r4);	 Catch:{ Throwable -> 0x0088, all -> 0x007a }
        r3 = cn.com.xy.sms.sdk.p208d.C2922b.m13136a();	 Catch:{ Throwable -> 0x008e, all -> 0x007d }
        r3.beginTransaction();	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
    L_0x0021:
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x0039, all -> 0x007d }
        if (r1 != 0) goto L_0x002f;
    L_0x0027:
        r2.close();	 Catch:{ Throwable -> 0x0039, all -> 0x007d }
        cn.com.xy.sms.sdk.p208d.C2922b.m13145a(r9, r10, r2, r4, r3);
        r0 = 1;
        goto L_0x000a;
    L_0x002f:
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r1);	 Catch:{ Throwable -> 0x0039, all -> 0x007d }
        if (r5 != 0) goto L_0x0021;
    L_0x0035:
        r3.execSQL(r1);	 Catch:{ Throwable -> 0x0039, all -> 0x007d }
        goto L_0x0021;
    L_0x0039:
        r1 = move-exception;
        r5 = "XIAOYUAN";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
        r7 = "excSql: ";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
        r7 = r1.getMessage();	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r5, r6, r1);	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
        throw r1;	 Catch:{ Throwable -> 0x0053, all -> 0x007d }
    L_0x0053:
        r1 = move-exception;
        r8 = r4;
        r4 = r3;
        r3 = r8;
    L_0x0057:
        r5 = "XIAOYUAN";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007f }
        r7 = "excSql: ";
        r6.<init>(r7);	 Catch:{ all -> 0x007f }
        r7 = r1.getMessage();	 Catch:{ all -> 0x007f }
        r6 = r6.append(r7);	 Catch:{ all -> 0x007f }
        r6 = r6.toString();	 Catch:{ all -> 0x007f }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r5, r6, r1);	 Catch:{ all -> 0x007f }
        cn.com.xy.sms.sdk.p208d.C2922b.m13145a(r9, r10, r2, r3, r4);
        goto L_0x000a;
    L_0x0073:
        r0 = move-exception;
        r2 = r3;
        r4 = r3;
    L_0x0076:
        cn.com.xy.sms.sdk.p208d.C2922b.m13145a(r9, r10, r2, r4, r3);
        throw r0;
    L_0x007a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0076;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0076;
    L_0x007f:
        r0 = move-exception;
        r8 = r3;
        r3 = r4;
        r4 = r8;
        goto L_0x0076;
    L_0x0084:
        r1 = move-exception;
        r2 = r3;
        r4 = r3;
        goto L_0x0057;
    L_0x0088:
        r1 = move-exception;
        r2 = r3;
        r8 = r4;
        r4 = r3;
        r3 = r8;
        goto L_0x0057;
    L_0x008e:
        r1 = move-exception;
        r8 = r4;
        r4 = r3;
        r3 = r8;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.b.a(java.io.File, boolean):boolean");
    }

    public static long m13149b(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            long a = (long) C2922b.m13133a(str, contentValues, str2, strArr);
            return a < 1 ? C2922b.m13135a(str, contentValues) : -a;
        } catch (Throwable th) {
            Throwable th2 = th;
            long j = 0;
            Throwable th3 = th2;
            C2982a.m13415a("xiaoyuan", "DBManager saveOrUpdateTableData error: " + th3.getMessage(), th3);
            return j;
        }
    }

    private static synchronized C2969l m13150b(Context context) {
        C2969l c2969l;
        synchronized (C2922b.class) {
            if (f9910b == null) {
                f9910b = new C2969l(context, "smssdk.db", null, 40);
            }
            c2969l = f9910b;
        }
        return c2969l;
    }

    public static void m13151b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table  if not exists tb_sdk_param (id int primary key,p_key TEXT,p_value TEXT,pextend_value TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_phone_info (id INTEGER PRIMARY KEY,iccid TEXT ,city TEXT,provinces TEXT,operator TEXT,areacode TEXT,ispost INTEGER DEFAULT 0,num TEXT,cnum TEXT,updateTime LONG,deft  INTEGER DEFAULT 0,net_updateTime LONG DEFAULT 0,user_provinces TEXT,user_areacode TEXT,user_operator TEXT,sim_index INTEGER DEFAULT -1)");
            sQLiteDatabase.execSQL(" create table  if not exists tb_public_info (id INTEGER PRIMARY KEY, pubId INTEGER not null unique, pubName TEXT not null, pubType TEXT, classifyCode TEXT, weiXin TEXT, weiBoName TEXT, weiBoUrl TEXT, introduce TEXT, address TEXT, faxNum TEXT, webSite TEXT, moveWebSite TEXT, versionCode TEXT, email TEXT, parentPubId int, slogan TEXT, rectLogoName TEXT, circleLogoName TEXT, extend TEXT, hasmenu int, loadMenuTime long, updateInfoTime long default 0, corpLevel INTEGER default 0, rid TEXT, logoType  TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_public_menu_info (id INTEGER PRIMARY KEY, menuCode text not null, pubId INTEGER, menuName text not null, menuType text not null, sendTo text, sp text , menuDesc text , sms text, url text, phoneNum text, actionData text, extend text)");
            sQLiteDatabase.execSQL("create table  if not exists tb_public_num_info (id INTEGER PRIMARY KEY, pubId INTEGER not null, num text not null, purpose text , areaCode text not null, ptype int default 1, main INTEGER default 0, communication INTEGER default 0, isfull INTEGER default 0, minLen INTEGER default 0, maxLen INTEGER default 0, len INTEGER default 0, ntype text, extend text, lastloadtime LONG default 0, isuse LONG default 0, isrulenum INTEGER default 0, nameType INTEGER default 0)");
            sQLiteDatabase.execSQL(" create table  if not exists tb_centernum_location_info ( id INTEGER PRIMARY KEY, cnum TEXT not null unique, areaCode TEXT, city TEXT, checkTime long, operator TEXT )");
            sQLiteDatabase.execSQL("create table  if not exists tb_scene_config (scene_id TEXT,sceneType INTEGER DEFAULT '0',isCheck INTEGER DEFAULT '0',sceneVersion TEXT,isUse INTEGER DEFAULT '0',useCount INTEGER DEFAULT '0')");
            sQLiteDatabase.execSQL("create table  if not exists tb_res_download (id INTEGER PRIMARY KEY,scene_id TEXT,url TEXT,status INTEGER,pos INTEGER,last_load_time INTEGER DEFAULT '0' )");
            sQLiteDatabase.execSQL("create table  if not exists tb_scenerule_config (id TEXT,sceneRuleVersion TEXT,scene_id TEXT,province TEXT,operator TEXT,expire_date TEXT,Func_call INTEGER,Func_acc_url INTEGER,Func_reply_sms INTEGER,Func_config TEXT,res_urls TEXT,s_version TEXT,Scene_page_config TEXT,sceneType INTEGER DEFAULT '-1',isdownload INTEGER DEFAULT '0')");
            sQLiteDatabase.execSQL("create table  if not exists tb_jar_list (id INTEGER PRIMARY KEY,name TEXT,version TEXT,url TEXT,status INTEGER DEFAULT '0',update_time INTEGER DEFAULT '0',delaystart INTEGER DEFAULT '0',delayend INTEGER DEFAULT '0',count INTEGER DEFAULT '0',last_load_time INTEGER DEFAULT '0' ,is_use INTEGER DEFAULT '0' ,pver TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_count_scene (scene_id TEXT,count INT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_popup_action_scene (scene_id TEXT, date TEXT, parse_times INTEGER DEFAULT '0', popup_times INTEGER DEFAULT '0' ) ");
            sQLiteDatabase.execSQL("create table  if not exists tb_menu_action (phone_num TEXT, date TEXT, company_num TEXT, function_mode TEXT, click_times INTEGER DEFAULT '0'  ) ");
            sQLiteDatabase.execSQL("create table  if not exists tb_button_action_scene (scene_id TEXT, date TEXT, action_type INTEGER DEFAULT '0', times INTEGER DEFAULT '0', action_code TEXT  ) ");
            sQLiteDatabase.execSQL("create table  if not exists tb_train6 (id INTEGER PRIMARY KEY,train_num TEXT not null,start_city TEXT,end_city TEXT,train_type INTEGER default 0,start_time TEXT,end_time TEXT,mileage TEXT,station_list TEXT,duration TEXT,day TEXT,data_time LONG default 0)");
            sQLiteDatabase.execSQL("create table  if not exists tb_air (id INTEGER PRIMARY KEY,air_num TEXT not null unique,start_city TEXT,end_city TEXT,start_place TEXT,end_place TEXT,start_time TEXT,end_time TEXT,company TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_menu_list (id INTEGER PRIMARY KEY,name TEXT,version TEXT,url TEXT,status INTEGER DEFAULT '0',update_time INTEGER DEFAULT '0',delaystart INTEGER DEFAULT '0',delayend INTEGER DEFAULT '0',count INTEGER DEFAULT '0',last_load_time INTEGER DEFAULT '0' )");
            sQLiteDatabase.execSQL(C2944k.m13264a());
            sQLiteDatabase.execSQL("create table  if not exists tb_update_task ( id INTEGER PRIMARY KEY,content TEXT,t_group TEXT,t_version long )");
            sQLiteDatabase.execSQL("create table  if not exists tb_xml_res_download (id INTEGER PRIMARY KEY,scene_id TEXT,url TEXT,status INTEGER,pos INTEGER,last_load_time INTEGER DEFAULT '0' ,sceneType INTEGER DEFAULT '0',insert_time INTEGER DEFAULT '0' )");
            sQLiteDatabase.execSQL(" create table  if not exists tb_resourse_queue ( id INTEGER PRIMARY KEY, res_type INTEGER, res_version INTEGER, res_url TEXT, down_statu INTEGER DEFAULT '0', temp_filename TEXT, down_failed_time LONG DEFAULT '0')");
            sQLiteDatabase.execSQL(C2945l.m13271a());
            sQLiteDatabase.execSQL(" create table  if not exists tb_netquery_time (id INTEGER PRIMARY KEY,phone_num TEXT,area_code TEXT,request_time LONG DEFAULT 0,status INTEGER DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS tb_num_name (id INTEGER PRIMARY KEY, num TEXT NOT NULL UNIQUE, name TEXT NOT NULL,cmd TEXT , ec TEXT , cnum TEXT,mark_time LONG DEFAULT 0,mark_cmd INTEGER DEFAULT 0,mark_ec INTEGER DEFAULT 0,last_name_time INTEGER DEFAULT 0,last_name_pubid INTEGER DEFAULT 0,last_cmd_time INTEGER DEFAULT 0,last_ec_time INTEGER DEFAULT 0,last_query_time INTEGER DEFAULT 0)");
            sQLiteDatabase.execSQL(" create table  if not exists tb_emergency_queue ( id INTEGER PRIMARY KEY, emVersion INTEGER, emContent TEXT )");
            sQLiteDatabase.execSQL(C2956w.m13303a());
            sQLiteDatabase.execSQL(C2957x.m13306a());
            sQLiteDatabase.execSQL("create table  if not exists tb_msg_url (  id INTEGER PRIMARY KEY, url TEXT, check_time integer default 0, check_statu integer default 0, third_check_statu integer default 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_shard_data (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, num TEXT NOT NULL, encode_content TEXT NOT NULL, content_sign TEXT NOT NULL, status INTEGER DEFAULT 0, msg_time INTEGER DEFAULT 0)");
        } catch (Throwable th) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_public_info ADD COLUMN classifyCode TEXT");
        } catch (Throwable th2) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_scene_config ADD COLUMN isCheck INTEGER DEFAULT '0'");
        } catch (Throwable th3) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_scene_config ADD COLUMN useCount INTEGER DEFAULT '0'");
        } catch (Throwable th4) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_scene_config ADD COLUMN isUse INTEGER DEFAULT '0'");
        } catch (Throwable th5) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_jar_list ADD COLUMN is_use INTEGER DEFAULT '0'");
        } catch (Throwable th6) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_train6 ADD COLUMN station_list TEXT ");
        } catch (Throwable th7) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_train6 ADD COLUMN data_time LONG default 0 ");
        } catch (Throwable th8) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_match_cache ADD COLUMN bubble_lasttime INTEGER DEFAULT '0'");
        } catch (Throwable th9) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_match_cache ADD COLUMN card_lasttime INTEGER DEFAULT '0'");
        } catch (Throwable th10) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE tb_match_cache ADD COLUMN session_lasttime INTEGER DEFAULT '0'");
        } catch (Throwable th11) {
        }
        C2922b.m13144a(sQLiteDatabase, " ALTER TABLE tb_public_num_info ADD COLUMN lastloadtime LONG default 0");
        C2922b.m13144a(sQLiteDatabase, " ALTER TABLE tb_public_num_info ADD COLUMN isrulenum INTEGER default 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_netquery_time ADD COLUMN area_code TEXT");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_phone_info ADD COLUMN user_provinces TEXT ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_phone_info ADD COLUMN user_areacode TEXT ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_phone_info ADD COLUMN user_operator TEXT ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_phone_info ADD COLUMN sim_index INTEGER DEFAULT -1 ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN cnum TEXT ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN mark_time LONG DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN cmd TEXT ");
        C2922b.m13144a(sQLiteDatabase, " ALTER TABLE tb_public_info ADD COLUMN corpLevel INTEGER default 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_match_cache ADD COLUMN urls  TEXT");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_match_cache ADD COLUMN url_valid_statu INTEGER DEFAULT '0'");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_jar_list ADD COLUMN pver TEXT ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_button_action_scene ADD COLUMN action_code TEXT");
        try {
            sQLiteDatabase.execSQL(" UPDATE tb_button_action_scene SET action_code = action_type WHERE action_code = '' OR action_code IS NULL");
        } catch (Throwable th12) {
            C2982a.m13414a("XIAOYUAN", th12.getMessage());
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS tb_sms_parse_recorder (phone_num TEXT, sms_num INTEGER DEFAULT 0, success_num INTEGER DEFAULT 0, date_time INTEGER DEFAULT 0, query_flag INTEGER DEFAULT 0)");
        } catch (Throwable th122) {
            C2982a.m13414a("XIAOYUAN", th122.getMessage());
        }
        C2922b.m13144a(sQLiteDatabase, " ALTER TABLE tb_public_num_info ADD COLUMN isuse LONG default 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_public_info ADD COLUMN rid TEXT");
        C2922b.m13144a(sQLiteDatabase, " ALTER TABLE tb_public_info ADD COLUMN logoType TEXT");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_match_cache ADD COLUMN value_recognise_result  TEXT");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_match_cache ADD COLUMN recognise_lasttime INTEGER DEFAULT '0'");
        C2922b.m13144a(sQLiteDatabase, " ALTER TABLE tb_public_num_info ADD COLUMN nameType INTEGER default 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN mark_cmd INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN last_name_pubid INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN last_name_time INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN last_cmd_time INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN last_query_time INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_train6 ADD COLUMN day TEXT ");
        sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_train ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_netquery_time ADD COLUMN status INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN ec TEXT ");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN mark_ec INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_num_name ADD COLUMN last_ec_time INTEGER DEFAULT 0");
        C2922b.m13144a(sQLiteDatabase, "UPDATE tb_operator_parse_info SET msg=NULL");
        C2922b.m13144a(sQLiteDatabase, "ALTER TABLE tb_operator_parse_info ADD COLUMN numMsgMD5 TEXT");
    }

    private static boolean m13152c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.inTransaction()) {
            return false;
        }
        C2922b.m13143a(sQLiteDatabase);
        new StringBuilder("DBManager db inTransaction threadName:").append(Thread.currentThread().getName());
        return true;
    }
}
