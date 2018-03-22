package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p218i.p219a.C3007a;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray m13227a(int r15) {
        /*
        r8 = 0;
        r14 = 1;
        r2 = "res_type = ? and down_statu = ? ";
        r0 = 7;
        r1 = new java.lang.String[r0];	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 0;
        r3 = "id";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 1;
        r3 = "res_type";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 2;
        r3 = "res_version";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 3;
        r3 = "res_url";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 4;
        r3 = "down_statu";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 5;
        r3 = "temp_filename";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = 6;
        r3 = "down_failed_time";
        r1[r0] = r3;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = "tb_resourse_queue";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r6 = java.lang.String.valueOf(r15);	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r4 = 1;
        r5 = "0";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r4 = 0;
        r5 = 0;
        r6 = "res_version asc";
        r7 = 0;
        r2 = cn.com.xy.sms.sdk.p208d.C2922b.m13140a(r0, r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x010f, all -> 0x0104 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r1 = "cursor=";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0.append(r2);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        if (r2 == 0) goto L_0x0102;
    L_0x005b:
        r0 = r2.m13323a();	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        if (r0 <= 0) goto L_0x0102;
    L_0x0061:
        r0 = "id";
        r1 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = "res_type";
        r3 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = "res_version";
        r4 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = "res_url";
        r5 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = "down_statu";
        r6 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = "temp_filename";
        r7 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = "down_failed_time";
        r9 = r2.m13325a(r0);	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
        r0.<init>();	 Catch:{ Throwable -> 0x0113, all -> 0x010a }
    L_0x0091:
        r8 = r2.m13327b();	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        if (r8 != 0) goto L_0x009b;
    L_0x0097:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r14);
    L_0x009a:
        return r0;
    L_0x009b:
        r8 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.<init>();	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "id";
        r11 = r2.m13324a(r1);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "res_type";
        r11 = r2.m13324a(r3);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "res_version";
        r11 = r2.m13324a(r4);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "res_url";
        r11 = r2.m13328c(r5);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "down_statu";
        r11 = r2.m13324a(r6);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "temp_filename";
        r11 = r2.m13328c(r7);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r10 = "down_failed_time";
        r12 = r2.m13326b(r9);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r8.put(r10, r12);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        r0.put(r8);	 Catch:{ Throwable -> 0x00e4, all -> 0x010a }
        goto L_0x0091;
    L_0x00e4:
        r1 = move-exception;
        r8 = r2;
    L_0x00e6:
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010c }
        r4 = "queryNeedDownResourse: ";
        r3.<init>(r4);	 Catch:{ all -> 0x010c }
        r4 = r1.getMessage();	 Catch:{ all -> 0x010c }
        r3 = r3.append(r4);	 Catch:{ all -> 0x010c }
        r3 = r3.toString();	 Catch:{ all -> 0x010c }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r1);	 Catch:{ all -> 0x010c }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r8, r14);
        goto L_0x009a;
    L_0x0102:
        r0 = r8;
        goto L_0x0097;
    L_0x0104:
        r0 = move-exception;
        r2 = r8;
    L_0x0106:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r14);
        throw r0;
    L_0x010a:
        r0 = move-exception;
        goto L_0x0106;
    L_0x010c:
        r0 = move-exception;
        r2 = r8;
        goto L_0x0106;
    L_0x010f:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x00e6;
    L_0x0113:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
        r8 = r2;
        goto L_0x00e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ad.a(int):org.json.JSONArray");
    }

    public static void m13228a(Integer num, boolean z, String str) {
        try {
            ContentValues contentValues = new ContentValues();
            if (z) {
                contentValues.put("res_url", "");
                contentValues.put("down_failed_time", "0");
                contentValues.put("down_statu", "1");
                contentValues.put("temp_filename", str);
            } else {
                contentValues.put("down_failed_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("down_statu", "0");
                contentValues.put("temp_filename", str);
            }
            C2922b.m13133a("tb_resourse_queue", contentValues, "id = ? ", new String[]{String.valueOf(num)});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "UpdateResourse: " + th.getMessage(), th);
        }
    }

    public static void m13229a(JSONArray jSONArray) {
        Throwable th;
        C2962e a;
        C2962e c2962e;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String str;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String str2 = (String) C3045j.m13620a(jSONObject, "del_history");
                if (!(C3049n.m13653e(str2) || !str2.equals("1") || jSONObject == null)) {
                    try {
                        C2922b.m13134a("tb_resourse_queue", "res_type = ? and res_version < ?", new String[]{new StringBuilder(String.valueOf((String) C3045j.m13620a(jSONObject, "res_type"))).toString(), new StringBuilder(String.valueOf((String) C3045j.m13620a(jSONObject, "res_version"))).toString()});
                        C3007a.m13529a(str2, str);
                    } catch (Throwable th2) {
                        C2982a.m13415a("XIAOYUAN", "handleJSONArray: " + th2.getMessage(), th2);
                        return;
                    }
                }
                C2962e c2962e2 = null;
                try {
                    str2 = (String) C3045j.m13620a(jSONObject, "res_type");
                    str = (String) C3045j.m13620a(jSONObject, "res_version");
                    if (jSONObject != null) {
                        a = C2922b.m13139a("tb_resourse_queue", new String[]{new StringBuilder(String.valueOf(str2)).toString(), new StringBuilder(String.valueOf(str)).toString()}, "res_type = ? and res_version = ? ", new String[]{new StringBuilder(String.valueOf(str2)).toString(), new StringBuilder(String.valueOf(str)).toString()});
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("res_type", str2);
                            contentValues.put("res_version", str);
                            contentValues.put("res_url", (String) C3045j.m13620a(jSONObject, "res_url"));
                            if (a == null || a.m13323a() <= 0) {
                                C2922b.m13135a("tb_resourse_queue", contentValues);
                            } else {
                                C2922b.m13133a("tb_resourse_queue", contentValues, "res_type = ? and res_version = ? ", new String[]{new StringBuilder(String.valueOf(str2)).toString(), new StringBuilder(String.valueOf(str)).toString()});
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            c2962e2 = a;
                        }
                    } else {
                        a = null;
                    }
                    C2962e.m13322a(a, true);
                } catch (Throwable th4) {
                    th2 = th4;
                }
            }
            return;
        }
        return;
        C2962e.m13322a(c2962e2, true);
        throw th2;
    }

    public static void m13230a(boolean z, String str) {
        int i = 0;
        try {
            ContentValues contentValues = new ContentValues();
            if (z) {
                i = 2;
            }
            contentValues.put("down_statu", Integer.valueOf(i));
            new StringBuilder("unzipSuess=").append(z).append(" fileNam=").append(str);
            C2922b.m13133a("tb_resourse_queue", contentValues, "temp_filename = ?", new String[]{str});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "UpdateResourse: " + th.getMessage(), th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m13231b(int r8) {
        /*
        r2 = 0;
        r7 = 1;
        r0 = "";
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0041 }
        r3 = "res_type = ";
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0041 }
        r1 = r1.append(r8);	 Catch:{ Throwable -> 0x0041 }
        r3 = " ORDER BY res_version desc LIMIT 1 ";
        r1 = r1.append(r3);	 Catch:{ Throwable -> 0x0041 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0041 }
        r3 = "tb_resourse_queue";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x0041 }
        r5 = 0;
        r6 = "res_version";
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0041 }
        r5 = 0;
        r2 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r3, r4, r1, r5);	 Catch:{ Throwable -> 0x0041 }
        if (r2 == 0) goto L_0x0037;
    L_0x002b:
        r1 = r2.m13323a();	 Catch:{ Throwable -> 0x0041 }
        if (r1 <= 0) goto L_0x0037;
    L_0x0031:
        r1 = r2.m13327b();	 Catch:{ Throwable -> 0x0041 }
        if (r1 != 0) goto L_0x003b;
    L_0x0037:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r7);
    L_0x003a:
        return r0;
    L_0x003b:
        r1 = 0;
        r0 = r2.m13328c(r1);	 Catch:{ Throwable -> 0x0041 }
        goto L_0x0031;
    L_0x0041:
        r1 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r5 = "queryNeedCheckResourse: ";
        r4.<init>(r5);	 Catch:{ all -> 0x005e }
        r5 = r1.getMessage();	 Catch:{ all -> 0x005e }
        r4 = r4.append(r5);	 Catch:{ all -> 0x005e }
        r4 = r4.toString();	 Catch:{ all -> 0x005e }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r1);	 Catch:{ all -> 0x005e }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r7);
        goto L_0x003a;
    L_0x005e:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ad.b(int):java.lang.String");
    }
}
