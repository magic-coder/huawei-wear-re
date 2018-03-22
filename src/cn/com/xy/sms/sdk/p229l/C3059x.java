package cn.com.xy.sms.sdk.p229l;

import android.content.ContentValues;
import android.os.Process;
import cn.com.xy.sms.p204a.C2899a;
import cn.com.xy.sms.p204a.C2906g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2960c;
import cn.com.xy.sms.sdk.p208d.p211c.C2934a;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;
import cn.com.xy.sms.sdk.p208d.p211c.C2944k;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2951r;
import cn.com.xy.sms.sdk.p208d.p211c.C2952s;
import cn.com.xy.sms.sdk.p208d.p211c.aa;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p216h.p217a.C2995m;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.util.List;

public final class C3059x extends Thread {
    private static boolean f10310a = false;
    private static long f10311b = 0;
    private static long f10312c = 600000;

    public static synchronized void m13732a() {
        synchronized (C3059x.class) {
            if (!f10310a) {
                C3059x c3059x = new C3059x();
                c3059x.setPriority(1);
                c3059x.start();
            }
        }
    }

    public static void m13733a(C2951r c2951r, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        new StringBuilder("检查下载时间jarSubInfo.delaystart=").append(c2951r.f10022f).append("jarSubInfo.delayend=").append(c2951r.f10023g).append("nowTime=").append(currentTimeMillis).append(" jarSubInfo.status=").append(c2951r.f10021e);
        if (c2951r.f10021e == 0 && (z || c2951r.f10022f <= currentTimeMillis)) {
            new StringBuilder("超过周期，启动下载 name=").append(c2951r.f10017a).append(" url=").append(c2951r.f10019c);
            if (!C3049n.m13653e(c2951r.f10019c)) {
                String str = c2951r.f10017a + LightCloudConstants.ZIP_POSTFIX;
                if (C3055t.m13715f(c2951r.f10019c, C2917a.m13112e(), str) == -1) {
                    C2982a.m13414a("JarSubInfo", new StringBuilder(String.valueOf(str)).append("下载失败").toString());
                } else if (C3050o.m13676a(C2917a.m13112e() + str, C2917a.m13109b())) {
                    String str2;
                    String str3 = c2951r.f10017a + ".sql";
                    File file = new File(C2917a.m13109b() + str3);
                    if (file.exists()) {
                        str2 = c2951r.f10017a + ".txt";
                        String j = C3049n.m13659j(C2917a.m13109b() + str3);
                        str2 = C2995m.m13476a(C2917a.m13109b(), str2);
                        if (C2982a.f10101a) {
                        }
                        if (j.equals(str2)) {
                            str2 = c2951r.f10017a;
                            try {
                                if (!C3049n.m13653e(str2)) {
                                    C2960c.m13316a(str2.substring(2));
                                }
                            } catch (Throwable th) {
                                C2982a.m13415a("XIAOYUAN", "downloadJarInfo: " + th.getMessage(), th);
                                return;
                            }
                            C2917a.m13105a();
                            if (!C3059x.m13735a(file)) {
                                C2982a.m13414a("JarSubInfo", new StringBuilder(String.valueOf(str3)).append("更新sql执行失败").toString());
                                return;
                            }
                        }
                    }
                    str2 = c2951r.f10017a;
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("last_load_time", new StringBuilder(String.valueOf(currentTimeMillis2)).toString());
                        contentValues.put("status", new StringBuilder("1").toString());
                        C2922b.m13133a("tb_jar_list", contentValues, "name = ? ", new String[]{str2});
                        C2906g.m13078a(C2917a.m13105a(), "SMART_DATA_UPDATE_TIME", new StringBuilder(String.valueOf(currentTimeMillis2)).toString());
                    } catch (Throwable th2) {
                        C2982a.m13415a("XIAOYUAN", "updateLastLoadTime: " + th2.getMessage(), th2);
                    }
                    C3055t.m13700a(C2917a.m13109b(), c2951r.f10017a + HwAccountConstants.SPLIIT_UNDERLINE, ".jar", c2951r.f10017a + HwAccountConstants.SPLIIT_UNDERLINE + c2951r.f10018b + ".jar");
                    C3055t.m13707b(c2951r.f10017a + HwAccountConstants.SPLIIT_UNDERLINE, ".dex", c2951r.f10017a + HwAccountConstants.SPLIIT_UNDERLINE + c2951r.f10018b + ".dex");
                    str2 = c2951r.f10017a + HwAccountConstants.SPLIIT_UNDERLINE + c2951r.f10018b + ".jar";
                    C3055t.m13699a(C2917a.m13109b(), c2951r.f10017a + ".jar", str2);
                    C3050o.m13683c("640", C2917a.m13109b() + str2);
                    if ("parseUtilMain".equals(c2951r.f10017a) || "ParseSimpleBubbleUtil".equals(c2951r.f10017a)) {
                        C2973a.m13362a(c2951r.f10017a);
                        C2973a.m13359a();
                    } else {
                        C2973a.m13362a(c2951r.f10017a);
                        if ("OnlineUpdateCycleConfig".equals(c2951r.f10017a)) {
                            C2973a.m13374b();
                        } else if ("ParseVerifyCodeValidTime".equals(c2951r.f10017a)) {
                            C2973a.m13379c();
                        }
                    }
                    C3055t.m13709c(C2917a.m13112e() + str);
                    C2947n.m13274a("BEFORE_HAND_PARSE_SMS_TIME", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                    if (System.currentTimeMillis() > f10311b + C2973a.m13350a(14, f10312c)) {
                        C2944k.m13266a(0);
                        f10311b = System.currentTimeMillis();
                    }
                } else {
                    C2982a.m13414a("JarSubInfo", new StringBuilder(String.valueOf(str)).append("解压失败").toString());
                }
            }
        } else if (c2951r.f10021e == 1) {
            if (C2982a.f10101a) {
                new StringBuilder(String.valueOf(c2951r.f10017a)).append("已经下载，不需要下载 url=").append(c2951r.f10019c);
            }
        } else if (C2982a.f10101a) {
            new StringBuilder("当前时间不在下载区域内，不下载name=").append(c2951r.f10017a).append(" url=").append(c2951r.f10019c);
        }
    }

    public static void m13734a(boolean z, boolean z2) {
        if (C2996a.m13491a()) {
            C3059x.m13737c();
            List a = C2952s.m13291a();
            try {
                if (!a.isEmpty()) {
                    String d = C2947n.m13284d(C2917a.m13105a(), "EM_VERSION");
                    if (C3049n.m13653e(d)) {
                        d = "-1";
                    }
                    String a2 = C2991i.m13456a(a, aa.m13217b(), d, z2);
                    if (!C3049n.m13653e(a2)) {
                        C2996a.m13483a(0, a2, new C3060y(z), C2996a.m13498c() + "updatejar", null, false);
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "checkJarsUpdate: " + th.getMessage(), th);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m13735a(java.io.File r13) {
        /*
        r0 = r13.exists();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        r4 = 0;
        r1 = 0;
        r2 = 0;
        r3 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x021a, all -> 0x0209 }
        r0 = new java.io.FileReader;	 Catch:{ Throwable -> 0x021a, all -> 0x0209 }
        r0.<init>(r13);	 Catch:{ Throwable -> 0x021a, all -> 0x0209 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x021a, all -> 0x0209 }
        r1 = new java.io.LineNumberReader;	 Catch:{ Throwable -> 0x0221, all -> 0x020e }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0221, all -> 0x020e }
        r2 = cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13119a();	 Catch:{ Throwable -> 0x0227, all -> 0x0212 }
        r2.beginTransaction();	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
    L_0x0021:
        r0 = r1.readLine();	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        if (r0 != 0) goto L_0x0040;
    L_0x0027:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01b7 }
        r4 = "updateParse deleteAllFile filePath=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x01b7 }
        r4 = r13.getPath();	 Catch:{ Throwable -> 0x01b7 }
        r0.append(r4);	 Catch:{ Throwable -> 0x01b7 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13697a(r13);	 Catch:{ Throwable -> 0x01b7 }
    L_0x0039:
        r0 = 0;
        r4 = 0;
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13124a(r0, r4, r1, r3, r2);
        r0 = 1;
        goto L_0x0007;
    L_0x0040:
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r0);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        if (r4 != 0) goto L_0x0021;
    L_0x0046:
        r6 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r6.<init>();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = 0;
        r5 = ",";
        r5 = r0.indexOf(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r7 = r0.substring(r4, r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = ",";
        r4 = r0.indexOf(r4);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = r4 + 1;
        r5 = r0.length();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = r0.substring(r4, r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = 0;
        r5 = ",";
        r5 = r0.indexOf(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r8 = r0.substring(r4, r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = ",";
        r4 = r0.indexOf(r4);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = r4 + 1;
        r5 = r0.length();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = r0.substring(r4, r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = 0;
        r5 = ",";
        r5 = r0.indexOf(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = r0.substring(r4, r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = ",";
        r5 = r0.indexOf(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = r5 + 1;
        r9 = r0.length();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = r0.substring(r5, r9);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = 0;
        r9 = ",";
        r9 = r0.indexOf(r9);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = r0.substring(r5, r9);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = ",";
        r9 = r0.indexOf(r9);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = r9 + 1;
        r10 = r0.length();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = r0.substring(r9, r10);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = "scene_id";
        r6.put(r9, r7);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = "match_id";
        r6.put(r9, r8);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = "regex_type";
        r6.put(r9, r4);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = "version_code";
        r6.put(r9, r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = "regex_text";
        r6.put(r5, r0);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = "scene_id=";
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = r0.append(r7);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = " match_id=";
        r0 = r0.append(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0 = r0.append(r8);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = " regex_type=";
        r0 = r0.append(r5);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r0.append(r4);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r4 = 0;
        r0 = "tb_regex";
        r9 = "scene_id= ? and match_id =?";
        r10 = 2;
        r10 = new java.lang.String[r10];	 Catch:{ Throwable -> 0x0183, all -> 0x019e }
        r11 = 0;
        r10[r11] = r7;	 Catch:{ Throwable -> 0x0183, all -> 0x019e }
        r7 = 1;
        r10[r7] = r8;	 Catch:{ Throwable -> 0x0183, all -> 0x019e }
        r0 = r2.update(r0, r6, r9, r10);	 Catch:{ Throwable -> 0x0183, all -> 0x019e }
        r4 = (long) r0;
    L_0x0107:
        r8 = 0;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0021;
    L_0x010d:
        r0 = "tb_regex";
        r4 = 0;
        r2.insert(r0, r4, r6);	 Catch:{ Throwable -> 0x0116, all -> 0x019e }
        goto L_0x0021;
    L_0x0116:
        r0 = move-exception;
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r6 = "handleLine: ";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r6 = r0.getMessage();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        goto L_0x0021;
    L_0x0131:
        r0 = move-exception;
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        r6 = "handleLine: ";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        r6 = r0.getMessage();	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);	 Catch:{ Throwable -> 0x014c, all -> 0x019e }
        goto L_0x0021;
    L_0x014c:
        r0 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
    L_0x0150:
        r4 = "JarSubInfo";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0215 }
        r6 = "updateParse error:";
        r5.<init>(r6);	 Catch:{ all -> 0x0215 }
        r6 = r0.getMessage();	 Catch:{ all -> 0x0215 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0215 }
        r5 = r5.toString();	 Catch:{ all -> 0x0215 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);	 Catch:{ all -> 0x0215 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01d3 }
        r4 = "updateParse deleteAllFile filePath=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x01d3 }
        r4 = r13.getPath();	 Catch:{ Throwable -> 0x01d3 }
        r0.append(r4);	 Catch:{ Throwable -> 0x01d3 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13697a(r13);	 Catch:{ Throwable -> 0x01d3 }
    L_0x017b:
        r0 = 0;
        r4 = 0;
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13124a(r0, r4, r1, r2, r3);
        r0 = 0;
        goto L_0x0007;
    L_0x0183:
        r0 = move-exception;
        r7 = "XIAOYUAN";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = "handleLine: ";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r9 = r0.getMessage();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r8 = r8.append(r9);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r7, r8, r0);	 Catch:{ Throwable -> 0x0131, all -> 0x019e }
        goto L_0x0107;
    L_0x019e:
        r0 = move-exception;
    L_0x019f:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01ee }
        r5 = "updateParse deleteAllFile filePath=";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x01ee }
        r5 = r13.getPath();	 Catch:{ Throwable -> 0x01ee }
        r4.append(r5);	 Catch:{ Throwable -> 0x01ee }
        cn.com.xy.sms.sdk.p229l.C3055t.m13697a(r13);	 Catch:{ Throwable -> 0x01ee }
    L_0x01b1:
        r4 = 0;
        r5 = 0;
        cn.com.xy.sms.sdk.p208d.p209a.C2918a.m13124a(r4, r5, r1, r3, r2);
        throw r0;
    L_0x01b7:
        r0 = move-exception;
        r4 = "JarSubInfo";
        r5 = new java.lang.StringBuilder;
        r6 = "updateParse deleteAllFile error:";
        r5.<init>(r6);
        r6 = r0.getMessage();
        r5 = r5.append(r6);
        r5 = r5.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);
        goto L_0x0039;
    L_0x01d3:
        r0 = move-exception;
        r4 = "JarSubInfo";
        r5 = new java.lang.StringBuilder;
        r6 = "updateParse deleteAllFile error:";
        r5.<init>(r6);
        r6 = r0.getMessage();
        r5 = r5.append(r6);
        r5 = r5.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);
        goto L_0x017b;
    L_0x01ee:
        r4 = move-exception;
        r5 = "JarSubInfo";
        r6 = new java.lang.StringBuilder;
        r7 = "updateParse deleteAllFile error:";
        r6.<init>(r7);
        r7 = r4.getMessage();
        r6 = r6.append(r7);
        r6 = r6.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r5, r6, r4);
        goto L_0x01b1;
    L_0x0209:
        r0 = move-exception;
        r3 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x019f;
    L_0x020e:
        r0 = move-exception;
        r1 = r2;
        r2 = r4;
        goto L_0x019f;
    L_0x0212:
        r0 = move-exception;
        r2 = r4;
        goto L_0x019f;
    L_0x0215:
        r0 = move-exception;
        r12 = r2;
        r2 = r3;
        r3 = r12;
        goto L_0x019f;
    L_0x021a:
        r0 = move-exception;
        r3 = r4;
        r12 = r1;
        r1 = r2;
        r2 = r12;
        goto L_0x0150;
    L_0x0221:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0150;
    L_0x0227:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x0150;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.l.x.a(java.io.File):boolean");
    }

    public static void m13736b() {
        try {
            int a = C2899a.m13063a(C2917a.m13105a(), null) + 1;
            C2906g.m13078a(C2917a.m13105a(), "PARSE_VERSION", new StringBuilder(String.valueOf(a)).toString());
            if (System.currentTimeMillis() >= C2917a.f9891a + 600000) {
                C3041f.m13609b().m13097a(C2917a.m13105a(), a);
                C2917a.f9891a = System.currentTimeMillis();
            }
        } catch (Throwable th) {
        }
    }

    private static void m13737c() {
        if (C2899a.m13070b()) {
            C2951r a = C2952s.m13290a("parseUtilMain");
            new StringBuilder("parseUtilMain jarSubInfo=").append(a);
            if (a == null) {
                C2952s.m13292a("parseUtilMain", "-1", 1);
                C2952s.m13292a("ScenesScanner", "-1", 1);
                C2952s.m13292a("ParseSimpleBubbleUtil", "-1", 1);
                C2952s.m13292a("ParseUtilBubble", "-1", 1);
            }
        }
    }

    public final void run() {
        try {
            if (!f10310a) {
                f10310a = true;
                Process.setThreadPriority(10);
                int c = C2947n.m13283c(C2917a.m13105a(), "ONLINE_UPDATE_SDK");
                C3046k.m13626a();
                if (!("5Mj22a4wHUAWEICARD".equals(C3046k.f10294a) && c == 0) && C2996a.m13492a(2)) {
                    C3059x.m13734a(true, true);
                    if (c != 0) {
                        C2934a.m13204a(C2937d.UPDATE_PUBINFO);
                        C3056u.m13724b();
                    }
                }
                f10310a = false;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
        }
    }
}
