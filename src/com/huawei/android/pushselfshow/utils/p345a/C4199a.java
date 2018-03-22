package com.huawei.android.pushselfshow.utils.p345a;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import java.io.File;

public class C4199a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList m20394a(android.content.Context r6, java.lang.String r7) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "hwpushApp.db";
        r1 = com.huawei.android.pushselfshow.utils.p345a.C4199a.m20397c(r6, r1);	 Catch:{ Exception -> 0x0058 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0058 }
        if (r2 == 0) goto L_0x0019;
    L_0x0011:
        r1 = "PushSelfShowLog";
        r2 = "database is null,can't queryAppinfo";
        com.huawei.android.pushagent.c.a.e.a(r1, r2);	 Catch:{ Exception -> 0x0058 }
    L_0x0018:
        return r0;
    L_0x0019:
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
        r3.<init>();	 Catch:{ Exception -> 0x0058 }
        r4 = "dbName path is ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0058 }
        r3 = r3.append(r1);	 Catch:{ Exception -> 0x0058 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0058 }
        com.huawei.android.pushagent.c.a.e.a(r2, r3);	 Catch:{ Exception -> 0x0058 }
        r2 = com.huawei.android.pushselfshow.utils.p345a.C4202d.m20404a();	 Catch:{ Exception -> 0x0058 }
        r3 = "openmarket";
        r2 = r2.m20411a(r1, r3);	 Catch:{ Exception -> 0x0058 }
        if (r2 == 0) goto L_0x0018;
    L_0x003d:
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0058 }
        r3 = 0;
        r2[r3] = r7;	 Catch:{ Exception -> 0x0058 }
        r3 = "select * from openmarket where package = ?;";
        r4 = com.huawei.android.pushselfshow.utils.p345a.C4202d.m20404a();	 Catch:{ Exception -> 0x0058 }
        r2 = r4.m20407a(r1, r3, r2);	 Catch:{ Exception -> 0x0058 }
        if (r2 != 0) goto L_0x0061;
    L_0x0050:
        r1 = "PushSelfShowLog";
        r2 = "cursor is null.";
        com.huawei.android.pushagent.c.a.e.a(r1, r2);	 Catch:{ Exception -> 0x0058 }
        goto L_0x0018;
    L_0x0058:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = "queryAppinfo error";
        com.huawei.android.pushagent.c.a.e.d(r2, r3, r1);
        goto L_0x0018;
    L_0x0061:
        r1 = r2.getCount();	 Catch:{ Exception -> 0x00ab }
        if (r1 <= 0) goto L_0x009c;
    L_0x0067:
        r1 = "msgid";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x00ab }
        r1 = r2.getString(r1);	 Catch:{ Exception -> 0x00ab }
        r0.add(r1);	 Catch:{ Exception -> 0x00ab }
        r3 = "TAG";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r4.<init>();	 Catch:{ Exception -> 0x00ab }
        r5 = "msgid and packageName is  ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ab }
        r1 = r4.append(r1);	 Catch:{ Exception -> 0x00ab }
        r4 = ",";
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x00ab }
        r1 = r1.append(r7);	 Catch:{ Exception -> 0x00ab }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ab }
        com.huawei.android.pushagent.c.a.e.a(r3, r1);	 Catch:{ Exception -> 0x00ab }
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x00ab }
        if (r1 != 0) goto L_0x0067;
    L_0x009c:
        r2.close();	 Catch:{ Exception -> 0x00a1 }
        goto L_0x0018;
    L_0x00a1:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = "cursor.close() ";
        com.huawei.android.pushagent.c.a.e.d(r2, r3, r1);	 Catch:{ Exception -> 0x0058 }
        goto L_0x0018;
    L_0x00ab:
        r1 = move-exception;
        r3 = "TAG";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r4.<init>();	 Catch:{ all -> 0x00d7 }
        r5 = "queryAppinfo error ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x00d7 }
        r5 = r1.toString();	 Catch:{ all -> 0x00d7 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00d7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00d7 }
        com.huawei.android.pushagent.c.a.e.c(r3, r4, r1);	 Catch:{ all -> 0x00d7 }
        r2.close();	 Catch:{ Exception -> 0x00cd }
        goto L_0x0018;
    L_0x00cd:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = "cursor.close() ";
        com.huawei.android.pushagent.c.a.e.d(r2, r3, r1);	 Catch:{ Exception -> 0x0058 }
        goto L_0x0018;
    L_0x00d7:
        r1 = move-exception;
        r2.close();	 Catch:{ Exception -> 0x00dc }
    L_0x00db:
        throw r1;	 Catch:{ Exception -> 0x0058 }
    L_0x00dc:
        r2 = move-exception;
        r3 = "PushSelfShowLog";
        r4 = "cursor.close() ";
        com.huawei.android.pushagent.c.a.e.d(r3, r4, r2);	 Catch:{ Exception -> 0x0058 }
        goto L_0x00db;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.a.a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    public static void m20395a(Context context, String str, String str2) {
        try {
            if (!context.getDatabasePath("hwpushApp.db").exists()) {
                context.openOrCreateDatabase("hwpushApp.db", 0, null);
            }
            String c = C4199a.m20397c(context, "hwpushApp.db");
            if (TextUtils.isEmpty(c)) {
                e.d("PushSelfShowLog", "database is null,can't insert appinfo into db");
                return;
            }
            e.a("PushSelfShowLog", "dbName path is " + c);
            if (!C4202d.m20404a().m20411a(c, "openmarket")) {
                C4202d.m20404a().m20408a(context, c, "create table openmarket(    _id INTEGER PRIMARY KEY AUTOINCREMENT,     msgid  TEXT,    package TEXT);");
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", str);
            contentValues.put("package", str2);
            C4202d.m20404a().m20409a(context, c, "openmarket", contentValues);
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "insertAppinfo error", e);
        }
    }

    public static void m20396b(Context context, String str) {
        try {
            String c = C4199a.m20397c(context, "hwpushApp.db");
            if (TextUtils.isEmpty(c)) {
                e.d("PushSelfShowLog", "database is null,can't delete appinfo");
                return;
            }
            e.a("PushSelfShowLog", "dbName path is " + c);
            if (C4202d.m20404a().m20411a(c, "openmarket")) {
                C4202d.m20404a().m20410a(c, "openmarket", "package = ?", new String[]{str});
            }
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "Delete Appinfo error", e);
        }
    }

    private static String m20397c(Context context, String str) {
        String str2 = "";
        if (context == null) {
            return str2;
        }
        File databasePath = context.getDatabasePath("hwpushApp.db");
        return databasePath.exists() ? databasePath.getAbsolutePath() : str2;
    }
}
