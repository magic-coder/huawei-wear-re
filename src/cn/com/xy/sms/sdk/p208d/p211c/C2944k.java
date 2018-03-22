package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;

public class C2944k {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m13263a(android.content.ContentValues r11, int r12) {
        /*
        r1 = 0;
        r8 = 1;
        r4 = -1;
        r0 = "msg_id";
        r0 = r11.get(r0);	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r0);	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        if (r2 != 0) goto L_0x00e2;
    L_0x0012:
        r2 = 1;
        r6 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r2 = 0;
        r6[r2] = r0;	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r0 = 2;
        r0 = new java.lang.String[r0];	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r2 = 0;
        r3 = "msg_num_md5";
        r0[r2] = r3;	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r2 = 1;
        r3 = "id";
        r0[r2] = r3;	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r2 = "tb_match_cache";
        r3 = " msg_id = ? ";
        r3 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r2, r0, r3, r6);	 Catch:{ Throwable -> 0x00ae, all -> 0x00cc }
        r2 = cn.com.xy.sms.sdk.p208d.p210b.C2921a.m13132b(r0, r3);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r0 = "msg_num_md5";
        r0 = r11.get(r0);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        if (r2 == 0) goto L_0x0054;
    L_0x003c:
        r1 = "msg_num_md5";
        r1 = cn.com.xy.sms.sdk.p229l.C3045j.m13620a(r2, r1);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r7 = "id";
        r2 = cn.com.xy.sms.sdk.p229l.C3045j.m13620a(r2, r7);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r4 = r2.longValue();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
    L_0x0054:
        if (r1 == 0) goto L_0x005c;
    L_0x0056:
        r0 = r1.equals(r0);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        if (r0 != 0) goto L_0x008b;
    L_0x005c:
        if (r1 == 0) goto L_0x0066;
    L_0x005e:
        r0 = "tb_match_cache";
        r1 = " msg_id = ? ";
        cn.com.xy.sms.sdk.p208d.C2922b.m13134a(r0, r1, r6);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
    L_0x0066:
        r0 = "tb_match_cache";
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13135a(r0, r11);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db, all -> 0x00d2 }
        r4 = "insert matchcache msgid: ";
        r2.<init>(r4);	 Catch:{ Throwable -> 0x00db, all -> 0x00d2 }
        r4 = 0;
        r4 = r6[r4];	 Catch:{ Throwable -> 0x00db, all -> 0x00d2 }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x00db, all -> 0x00d2 }
        r4 = " dataType: ";
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x00db, all -> 0x00d2 }
        r2.append(r12);	 Catch:{ Throwable -> 0x00db, all -> 0x00d2 }
        r9 = r3;
        r2 = r0;
        r0 = r9;
    L_0x0087:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r0, r8);
    L_0x008a:
        return r2;
    L_0x008b:
        r0 = "tb_match_cache";
        r1 = " msg_id = ? ";
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r0, r11, r1, r6);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r1 = "update matchcache msgid: ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r1 = 0;
        r1 = r6[r1];	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r1 = " dataType: ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r0.append(r12);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d2 }
        r0 = r3;
        r2 = r4;
        goto L_0x0087;
    L_0x00ae:
        r0 = move-exception;
        r2 = r4;
    L_0x00b0:
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d4 }
        r6 = "insertOrUpdate: ";
        r5.<init>(r6);	 Catch:{ all -> 0x00d4 }
        r6 = r0.getMessage();	 Catch:{ all -> 0x00d4 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x00d4 }
        r5 = r5.toString();	 Catch:{ all -> 0x00d4 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);	 Catch:{ all -> 0x00d4 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r8);
        goto L_0x008a;
    L_0x00cc:
        r0 = move-exception;
        r3 = r1;
    L_0x00ce:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r8);
        throw r0;
    L_0x00d2:
        r0 = move-exception;
        goto L_0x00ce;
    L_0x00d4:
        r0 = move-exception;
        r3 = r1;
        goto L_0x00ce;
    L_0x00d7:
        r0 = move-exception;
        r1 = r3;
        r2 = r4;
        goto L_0x00b0;
    L_0x00db:
        r2 = move-exception;
        r9 = r2;
        r10 = r3;
        r2 = r0;
        r0 = r9;
        r1 = r10;
        goto L_0x00b0;
    L_0x00e2:
        r0 = r1;
        r2 = r4;
        goto L_0x0087;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.k.a(android.content.ContentValues, int):long");
    }

    public static String m13264a() {
        return "create table  if not exists tb_match_cache (  id INTEGER PRIMARY KEY, msg_num_md5 TEXT, phonenum TEXT, msg_id TEXT, scene_id TEXT, popup_window_result TEXT, bubble_result TEXT, session_reuslt TEXT, card_result TEXT, save_time INTEGER DEFAULT '0', value_recognise_result TEXT, bubble_lasttime integer default 0, session_lasttime integer default 0, card_lasttime integer default 0, recognise_lasttime integer default 0, EXTEND TEXT, url_valid_statu integer default 0, urls TEXT )";
    }

    public static String m13265a(String str, String str2) {
        try {
            String b = C3049n.m13646b(str);
            if (!(C3049n.m13653e(b) || C3049n.m13653e(str2))) {
                return C3049n.m13658i(new StringBuilder(String.valueOf(b)).append(str2).toString());
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static void m13266a(long j) {
        try {
            C2944k.m13268a("bubble_result", "bubble_lasttime", j);
            C2944k.m13268a("session_reuslt", "session_lasttime", j);
            C2944k.m13268a("card_result", "card_lasttime", j);
            C2944k.m13268a("value_recognise_result", "recognise_lasttime", j);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "MatchCacheManager resetLastParseTime error:" + th.getLocalizedMessage(), th);
        }
    }

    public static void m13267a(String str, long j) {
        try {
            StringBuffer stringBuffer = new StringBuffer(" bubble_lasttime < ?");
            if (str.length() == 8) {
                stringBuffer.append(" and scene_id = ? ");
            } else {
                stringBuffer.append(" and scene_id like '?%' ");
            }
            new StringBuilder("sceneId =").append(str).append(" endParseTime=").append(j).append("result=").append(C2922b.m13134a("tb_match_cache", stringBuffer.toString(), new String[]{String.valueOf(j), str}));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteMatchCache: " + th.getMessage(), th);
        }
    }

    private static void m13268a(String str, String str2, long j) {
        try {
            C2922b.m13133a("tb_match_cache", C2921a.m13130a(null, str2, String.valueOf(j)), new StringBuilder(String.valueOf(str)).append(" IS NULL OR ").append(str).append("=''").toString(), null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "MatchCacheManager updateLastTime error:" + th.getLocalizedMessage(), th);
        }
    }

    public static void m13269b() {
        try {
            C2922b.m13134a("tb_match_cache", null, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteAll: " + th.getMessage(), th);
        }
    }

    public static boolean m13270b(String str, String str2) {
        if (C3049n.m13653e(str)) {
            return false;
        }
        int a;
        try {
            a = C3049n.m13653e(str2) ? C2922b.m13134a("tb_match_cache", " msg_id = ? ", new String[]{str}) : C2922b.m13134a("tb_match_cache", " msg_id = ? and msg_num_md5 = ? ", new String[]{str, str2});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteBubbleData: " + th.getMessage(), th);
            a = -1;
        }
        return a > 0;
    }
}
