package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.ArrayList;
import java.util.List;

public final class ae {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m13232a(cn.com.xy.sms.sdk.p208d.p211c.C2946m r11, int r12) {
        /*
        r10 = 1;
        r0 = -1;
        r2 = new android.content.ContentValues;
        r2.<init>();
        r3 = "id";
        r4 = r11.f9996b;
        r2.put(r3, r4);
        r3 = "sceneRuleVersion";
        r4 = r11.f9995a;
        r2.put(r3, r4);
        r3 = "scene_id";
        r4 = r11.f9997c;
        r2.put(r3, r4);
        r3 = "province";
        r4 = r11.f9998d;
        r2.put(r3, r4);
        r3 = "operator";
        r4 = r11.f9999e;
        r2.put(r3, r4);
        r3 = "expire_date";
        r4 = r11.f10000f;
        r2.put(r3, r4);
        r3 = "Func_call";
        r4 = r11.f10001g;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r3 = "Func_acc_url";
        r4 = r11.f10002h;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r3 = "Func_reply_sms";
        r4 = r11.f10003i;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r3 = "Func_config";
        r4 = r11.f10004j;
        r2.put(r3, r4);
        r3 = "res_urls";
        r4 = r11.f10005k;
        r2.put(r3, r4);
        r3 = "s_version";
        r4 = r11.f10006l;
        r2.put(r3, r4);
        r3 = "Scene_page_config";
        r4 = r11.f10007m;
        r2.put(r3, r4);
        r3 = "isdownload";
        r4 = r11.f10008n;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r3 = "sceneType";
        r4 = java.lang.Integer.valueOf(r12);
        r2.put(r3, r4);
        r3 = 0;
        r4 = r11.f9996b;	 Catch:{ Throwable -> 0x00d5 }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r4);	 Catch:{ Throwable -> 0x00d5 }
        if (r4 != 0) goto L_0x00af;
    L_0x0090:
        r4 = "tb_scenerule_config";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00d5 }
        r6 = 0;
        r7 = "id";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00d5 }
        r6 = 1;
        r7 = "sceneRuleVersion";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00d5 }
        r6 = "id = ? ";
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ Throwable -> 0x00d5 }
        r8 = 0;
        r9 = r11.f9996b;	 Catch:{ Throwable -> 0x00d5 }
        r7[r8] = r9;	 Catch:{ Throwable -> 0x00d5 }
        r3 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d5 }
    L_0x00af:
        if (r3 == 0) goto L_0x00cd;
    L_0x00b1:
        r4 = r3.m13323a();	 Catch:{ Throwable -> 0x00d5 }
        if (r4 <= 0) goto L_0x00cd;
    L_0x00b7:
        r4 = "tb_scenerule_config";
        r5 = "id=? ";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x00d5 }
        r7 = 0;
        r8 = r11.f9996b;	 Catch:{ Throwable -> 0x00d5 }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x00d5 }
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r4, r2, r5, r6);	 Catch:{ Throwable -> 0x00d5 }
        r0 = (long) r0;
    L_0x00c9:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r10);
    L_0x00cc:
        return r0;
    L_0x00cd:
        r4 = "tb_scenerule_config";
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13135a(r4, r2);	 Catch:{ Throwable -> 0x00d5 }
        goto L_0x00c9;
    L_0x00d5:
        r2 = move-exception;
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
        r6 = "insertOrUpdate: ";
        r5.<init>(r6);	 Catch:{ all -> 0x00f2 }
        r6 = r2.getMessage();	 Catch:{ all -> 0x00f2 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x00f2 }
        r5 = r5.toString();	 Catch:{ all -> 0x00f2 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r2);	 Catch:{ all -> 0x00f2 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r10);
        goto L_0x00cc;
    L_0x00f2:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ae.a(cn.com.xy.sms.sdk.d.c.m, int):long");
    }

    public static List<C2946m> m13233a(int i) {
        String str;
        List<C2946m> arrayList = new ArrayList();
        if (i == 1) {
            try {
                str = "sceneType = " + i;
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "queryAllSceneRule: " + th.getMessage(), th);
            } finally {
                boolean z = true;
                C2962e.m13322a(null, true);
            }
        } else {
            str = "sceneType != 1";
        }
        C2962e a = C2922b.m13139a("tb_scenerule_config", new String[]{"id", "scene_id", "province", "operator", "expire_date", "Func_call", "Func_acc_url", "Func_reply_sms", "Func_config", "res_urls", "s_version", "Scene_page_config", "isdownload", "sceneRuleVersion"}, str, null);
        if (a != null && a.m13323a() > 0) {
            int a2 = a.m13325a("id");
            int a3 = a.m13325a("scene_id");
            int a4 = a.m13325a("province");
            int a5 = a.m13325a("operator");
            int a6 = a.m13325a("expire_date");
            int a7 = a.m13325a("Func_call");
            int a8 = a.m13325a("Func_acc_url");
            int a9 = a.m13325a("Func_reply_sms");
            int a10 = a.m13325a("Func_config");
            int a11 = a.m13325a("res_urls");
            int a12 = a.m13325a("s_version");
            int a13 = a.m13325a("Scene_page_config");
            int a14 = a.m13325a("isdownload");
            int a15 = a.m13325a("sceneRuleVersion");
            while (a.m13327b()) {
                C2946m c2946m = new C2946m();
                c2946m.f9996b = a.m13328c(a2);
                c2946m.f9997c = a.m13328c(a3);
                c2946m.f9998d = a.m13328c(a4);
                c2946m.f9999e = a.m13328c(a5);
                c2946m.f10000f = a.m13328c(a6);
                c2946m.f10001g = a.m13324a(a7);
                c2946m.f10002h = a.m13324a(a8);
                c2946m.f10003i = a.m13324a(a9);
                c2946m.f10004j = a.m13328c(a10);
                c2946m.f10005k = a.m13328c(a11);
                c2946m.f10006l = a.m13328c(a12);
                c2946m.f10007m = a.m13328c(a13);
                c2946m.f10008n = a.m13324a(a14);
                c2946m.f9995a = a.m13328c(a15);
                arrayList.add(c2946m);
            }
        }
        C2962e.m13322a(a, true);
        return arrayList;
    }

    public static void m13234a() {
        synchronized (C2922b.f9909a) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = C2922b.m13136a();
                sQLiteDatabase.execSQL("DELETE FROM tb_scenerule_config WHERE FUNC_CALL=10 AND scene_id IN (SELECT scene_id FROM tb_scenerule_config WHERE 1=1 GROUP BY scene_id HAVING COUNT(scene_id) > 1)");
                C2922b.m13143a(sQLiteDatabase);
            } catch (Throwable th) {
                C2922b.m13143a(sQLiteDatabase);
            }
        }
    }

    public static int m13235b(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Func_call", Integer.valueOf(i));
            return C2922b.m13133a("tb_scenerule_config", contentValues, null, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateTag: " + th.getMessage(), th);
            return -1;
        }
    }
}
