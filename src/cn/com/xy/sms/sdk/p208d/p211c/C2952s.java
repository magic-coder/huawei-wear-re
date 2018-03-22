package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.List;

public final class C2952s {
    public static int m13289a(List<String> list) {
        try {
            if (list.size() == 0) {
                return 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : list) {
                if (!C3049n.m13653e(str)) {
                    stringBuilder.append("'");
                    stringBuilder.append(str.trim());
                    stringBuilder.append("',");
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.setLength(stringBuilder.length() - 1);
                return C2922b.m13134a("tb_jar_list", "name IN (" + stringBuilder + ")", null);
            }
            return -1;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteByName: " + th.getMessage(), th);
        }
    }

    public static C2951r m13290a(String str) {
        C2962e a;
        Throwable th;
        try {
            a = C2922b.m13139a("tb_jar_list", new String[]{"id", "name", "version", "url", "status", "last_load_time", "update_time", "delaystart", "delayend", "count"}, "name = ? ", new String[]{str});
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("id");
                        int a3 = a.m13325a("name");
                        int a4 = a.m13325a("version");
                        int a5 = a.m13325a("url");
                        int a6 = a.m13325a("status");
                        int a7 = a.m13325a("last_load_time");
                        int a8 = a.m13325a("update_time");
                        int a9 = a.m13325a("delaystart");
                        int a10 = a.m13325a("delayend");
                        int a11 = a.m13325a("count");
                        if (a.m13327b()) {
                            C2951r c2951r = new C2951r();
                            a.m13326b(a2);
                            c2951r.f10017a = a.m13328c(a3);
                            c2951r.f10018b = a.m13328c(a4);
                            c2951r.f10019c = a.m13328c(a5);
                            c2951r.f10021e = a.m13324a(a6);
                            a.m13326b(a7);
                            c2951r.f10020d = a.m13326b(a8);
                            c2951r.f10022f = a.m13326b(a9);
                            c2951r.f10023g = a.m13326b(a10);
                            a.m13324a(a11);
                            C2962e.m13322a(a, true);
                            return c2951r;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C2982a.m13415a("XIAOYUAN", "queryJarSubInfo: " + th.getMessage(), th);
                        C2962e.m13322a(a, true);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        C2962e.m13322a(a, true);
                        throw th;
                    }
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th4) {
            th = th4;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<cn.com.xy.sms.sdk.p208d.p211c.C2951r> m13291a() {
        /*
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = 0;
        r0 = "tb_jar_list";
        r3 = 10;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x00e7 }
        r4 = 0;
        r5 = "id";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 1;
        r5 = "name";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 2;
        r5 = "version";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 3;
        r5 = "url";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 4;
        r5 = "status";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 5;
        r5 = "last_load_time";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 6;
        r5 = "update_time";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 7;
        r5 = "delaystart";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 8;
        r5 = "delayend";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = 9;
        r5 = "count";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00e7 }
        r4 = "(is_use = ? or name = ? ) AND length(name) > 7 ";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00e7 }
        r6 = 0;
        r7 = "1";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00e7 }
        r6 = 1;
        r7 = "parseUtilMain";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00e7 }
        r1 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r0, r3, r4, r5);	 Catch:{ Throwable -> 0x00e7 }
        if (r1 == 0) goto L_0x00a6;
    L_0x005a:
        r0 = r1.m13323a();	 Catch:{ Throwable -> 0x00e7 }
        if (r0 <= 0) goto L_0x00a6;
    L_0x0060:
        r0 = "id";
        r0 = r1.m13325a(r0);	 Catch:{ Throwable -> 0x00e7 }
        r3 = "name";
        r3 = r1.m13325a(r3);	 Catch:{ Throwable -> 0x00e7 }
        r4 = "version";
        r4 = r1.m13325a(r4);	 Catch:{ Throwable -> 0x00e7 }
        r5 = "url";
        r5 = r1.m13325a(r5);	 Catch:{ Throwable -> 0x00e7 }
        r6 = "status";
        r6 = r1.m13325a(r6);	 Catch:{ Throwable -> 0x00e7 }
        r7 = "last_load_time";
        r7 = r1.m13325a(r7);	 Catch:{ Throwable -> 0x00e7 }
        r8 = "update_time";
        r8 = r1.m13325a(r8);	 Catch:{ Throwable -> 0x00e7 }
        r9 = "delaystart";
        r9 = r1.m13325a(r9);	 Catch:{ Throwable -> 0x00e7 }
        r10 = "delayend";
        r10 = r1.m13325a(r10);	 Catch:{ Throwable -> 0x00e7 }
        r11 = "count";
        r11 = r1.m13325a(r11);	 Catch:{ Throwable -> 0x00e7 }
    L_0x00a0:
        r12 = r1.m13327b();	 Catch:{ Throwable -> 0x00e7 }
        if (r12 != 0) goto L_0x00ab;
    L_0x00a6:
        r0 = 1;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r0);
    L_0x00aa:
        return r2;
    L_0x00ab:
        r12 = new cn.com.xy.sms.sdk.d.c.r;	 Catch:{ Throwable -> 0x00e7 }
        r12.<init>();	 Catch:{ Throwable -> 0x00e7 }
        r1.m13326b(r0);	 Catch:{ Throwable -> 0x00e7 }
        r13 = r1.m13328c(r3);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10017a = r13;	 Catch:{ Throwable -> 0x00e7 }
        r13 = r1.m13328c(r4);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10018b = r13;	 Catch:{ Throwable -> 0x00e7 }
        r13 = r1.m13328c(r5);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10019c = r13;	 Catch:{ Throwable -> 0x00e7 }
        r13 = r1.m13324a(r6);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10021e = r13;	 Catch:{ Throwable -> 0x00e7 }
        r1.m13326b(r7);	 Catch:{ Throwable -> 0x00e7 }
        r14 = r1.m13326b(r8);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10020d = r14;	 Catch:{ Throwable -> 0x00e7 }
        r14 = r1.m13326b(r9);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10022f = r14;	 Catch:{ Throwable -> 0x00e7 }
        r14 = r1.m13326b(r10);	 Catch:{ Throwable -> 0x00e7 }
        r12.f10023g = r14;	 Catch:{ Throwable -> 0x00e7 }
        r1.m13324a(r11);	 Catch:{ Throwable -> 0x00e7 }
        r2.add(r12);	 Catch:{ Throwable -> 0x00e7 }
        goto L_0x00a0;
    L_0x00e7:
        r0 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0105 }
        r5 = "queryAllJarSubInfo: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0105 }
        r5 = r0.getMessage();	 Catch:{ all -> 0x0105 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0105 }
        r4 = r4.toString();	 Catch:{ all -> 0x0105 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r0);	 Catch:{ all -> 0x0105 }
        r0 = 1;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r0);
        goto L_0x00aa;
    L_0x0105:
        r0 = move-exception;
        r2 = 1;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.s.a():java.util.List<cn.com.xy.sms.sdk.d.c.r>");
    }

    public static synchronized void m13292a(String str, String str2, int i) {
        synchronized (C2952s.class) {
            C2962e c2962e = null;
            try {
                long a;
                c2962e = C2922b.m13139a("tb_jar_list", new String[]{"url", "version"}, "name = ? ", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", str);
                if (i == 1) {
                    contentValues.put("is_use", Integer.valueOf(i));
                }
                new StringBuilder("更新或插入 name=").append(str).append(" version=").append(str2);
                if (c2962e == null || c2962e.m13323a() <= 0) {
                    contentValues.put("version", str2);
                    a = C2922b.m13135a("tb_jar_list", contentValues);
                } else {
                    if (!(C3049n.m13653e(str2) || "-1".equalsIgnoreCase(str2))) {
                        contentValues.put("version", str2);
                    }
                    a = (long) C2922b.m13133a("tb_jar_list", contentValues, "name = ? ", new String[]{str});
                }
                if (a > 0 && str.startsWith("PU")) {
                    String replaceFirst = str.replaceFirst("PU", "");
                    if (replaceFirst.length() >= 8) {
                        replaceFirst.substring(0, 8);
                    }
                }
                C2962e.m13322a(c2962e, true);
            } catch (Throwable th) {
                C2962e.m13322a(c2962e, true);
            }
        }
    }

    public static int m13293b(String str) {
        return ("parseUtilMain".equals(str) || "ParseHelper".equals(str) || "ScenesScanner".equals(str)) ? 1 : 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> m13294b() {
        /*
        r1 = 0;
        r6 = 1;
        r2 = new java.util.HashMap;
        r2.<init>();
        r0 = "tb_jar_list";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0049 }
        r4 = 0;
        r5 = "name";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0049 }
        r4 = 1;
        r5 = "version";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0049 }
        r4 = 0;
        r5 = 0;
        r1 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r0, r3, r4, r5);	 Catch:{ Throwable -> 0x0049 }
        if (r1 == 0) goto L_0x0039;
    L_0x0020:
        r0 = r1.m13323a();	 Catch:{ Throwable -> 0x0049 }
        if (r0 <= 0) goto L_0x0039;
    L_0x0026:
        r0 = "name";
        r0 = r1.m13325a(r0);	 Catch:{ Throwable -> 0x0049 }
        r3 = "version";
        r3 = r1.m13325a(r3);	 Catch:{ Throwable -> 0x0049 }
    L_0x0033:
        r4 = r1.m13327b();	 Catch:{ Throwable -> 0x0049 }
        if (r4 != 0) goto L_0x003d;
    L_0x0039:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r6);
    L_0x003c:
        return r2;
    L_0x003d:
        r4 = r1.m13328c(r0);	 Catch:{ Throwable -> 0x0049 }
        r5 = r1.m13328c(r3);	 Catch:{ Throwable -> 0x0049 }
        r2.put(r4, r5);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x0033;
    L_0x0049:
        r0 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0066 }
        r5 = "queryAllJarInfoMap: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0066 }
        r5 = r0.getMessage();	 Catch:{ all -> 0x0066 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0066 }
        r4 = r4.toString();	 Catch:{ all -> 0x0066 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r0);	 Catch:{ all -> 0x0066 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r6);
        goto L_0x003c;
    L_0x0066:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.s.b():java.util.HashMap<java.lang.String, java.lang.String>");
    }

    public static boolean m13295b(List<String> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = C2922b.m13136a();
            sQLiteDatabase.beginTransaction();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO tb_jar_list(name,version,is_use) ");
            stringBuilder.append("SELECT tempTb.name,tempTb.version,tempTb.is_use FROM (");
            stringBuilder.append("SELECT tbA.name,ifnull((CASE WHEN ('-1'=tbA.version OR ''=tbA.version) ");
            stringBuilder.append("THEN tbB.version ELSE tbA.version END),'-1')version,");
            stringBuilder.append("ifnull((CASE WHEN 1=tbA.is_use THEN tbA.is_use ELSE tbB.is_use END),0)is_use FROM (");
            stringBuilder.append("{SQL})tbA LEFT JOIN tb_jar_list tbB ON tbA.name=tbB.name)");
            stringBuilder.append("tempTb LEFT JOIN tb_jar_list ON tb_jar_list.name = tempTb.name");
            String stringBuilder2 = stringBuilder.toString();
            for (String replace : list) {
                sQLiteDatabase.execSQL(stringBuilder2.replace("{SQL}", replace));
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("DELETE FROM tb_jar_list WHERE id IN (SELECT min(id) FROM tb_jar_list GROUP BY name HAVING COUNT(id) > 1)");
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "insertJarSubInfo: " + th.getMessage(), th);
                }
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "insertJarSubInfo: " + th2.getMessage(), th2);
                }
                C2922b.m13143a(sQLiteDatabase);
            }
            return true;
        } catch (Throwable th22) {
            C2982a.m13415a("XIAOYUAN", "insertJarSubInfo: " + th22.getMessage(), th22);
        }
        C2922b.m13143a(sQLiteDatabase);
        return false;
        if (sQLiteDatabase.inTransaction()) {
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
        C2922b.m13143a(sQLiteDatabase);
        return false;
    }

    public static int m13296c() {
        try {
            return C2922b.m13134a("tb_jar_list", null, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteAll: " + th.getMessage(), th);
            return -1;
        }
    }
}
