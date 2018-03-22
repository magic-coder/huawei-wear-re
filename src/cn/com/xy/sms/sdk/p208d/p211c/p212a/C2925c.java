package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.ah;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.C3006k;
import cn.com.xy.sms.sdk.p229l.C3046k;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

public final class C2925c {
    private static long m13157a(String str, String str2, String str3, int i, long j) {
        if (C3049n.m13653e(str) || C3049n.m13653e(str2)) {
            return -1;
        }
        try {
            C2924b a = C2925c.m13160a(str, false);
            if (a != null) {
                String[] a2 = C2925c.m13171a(a.f9916b, a.f9922h, str2, j, ";");
                if (a2 == null) {
                    return -1;
                }
                String str4 = a2[0];
                String str5 = a2[1];
                String valueOf = String.valueOf(a.f9924j);
                String valueOf2 = String.valueOf(a.f9921g);
                if (!(C3049n.m13653e(str4) || str4.equals(a.f9916b))) {
                    valueOf = "0";
                }
                if (a2.length == 3 && "ResetPubId".equals(a2[2])) {
                    valueOf2 = "-1";
                }
                return C2925c.m13158a(str, "name", str4, "last_name_time", str5, "last_query_time", valueOf, "last_name_pubid", valueOf2, "cnum", str3, "mark_time", "1");
            }
            return C2925c.m13159a(Constants.FIELD_APPLET_CONFIG_NUM, str, "name", str2, "last_name_time", String.valueOf(j), "cnum", str3, "mark_time", "1", "last_name_pubid", "-1");
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "NumNameManager saveOrUpdateNameInfo: " + th.getMessage(), th);
            return -1;
        }
    }

    private static long m13158a(String str, String... strArr) {
        return (long) C2922b.m13133a("tb_num_name", C2921a.m13130a(null, strArr), "num = ? ", new String[]{str});
    }

    private static long m13159a(String... strArr) {
        return C2922b.m13135a("tb_num_name", C2921a.m13130a(null, strArr));
    }

    public static cn.com.xy.sms.sdk.p208d.p211c.p212a.C2924b m13160a(java.lang.String r6, boolean r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = 0;
        r5 = 1;
        r0 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = "num";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = " = ? ";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        if (r7 == 0) goto L_0x0033;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
    L_0x0010:
        r2 = " AND (";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = "mark_time";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = " = 1 OR ";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = "mark_cmd";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = " = 1 OR ";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = "mark_ec";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = " = 1) ";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0.append(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
    L_0x0033:
        r0 = r0.toString();	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = 1;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r3 = 0;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r2[r3] = r6;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r3 = 1;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0 = cn.com.xy.sms.sdk.p208d.p211c.p212a.C2925c.m13161a(r0, r2, r3);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        if (r0 == 0) goto L_0x004a;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
    L_0x0044:
        r2 = r0.size();	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        if (r2 > 0) goto L_0x004f;
    L_0x004a:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r5);
        r0 = r1;
    L_0x004e:
        return r0;
    L_0x004f:
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r0 = (cn.com.xy.sms.sdk.p208d.p211c.p212a.C2924b) r0;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r5);
        goto L_0x004e;
    L_0x005a:
        r0 = move-exception;
        r2 = "XIAOYUAN";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r4 = "NumNameManager queryDataByNum: ";	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r4 = r0.getMessage();	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r0);	 Catch:{ Throwable -> 0x005a, all -> 0x0078 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r5);
        r0 = r1;
        goto L_0x004e;
    L_0x0078:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.a.c.a(java.lang.String, boolean):cn.com.xy.sms.sdk.d.c.a.b");
    }

    public static List<C2924b> m13161a(String str, String[] strArr, int i) {
        Throwable th;
        if (i <= 0) {
            return null;
        }
        C2962e a;
        try {
            a = C2922b.m13140a("tb_num_name", new String[]{"id", Constants.FIELD_APPLET_CONFIG_NUM, "name", "cmd", "ec", "cnum", "mark_time", "mark_cmd", "mark_ec", "last_name_pubid", "last_name_time", "last_cmd_time", "last_ec_time", "last_query_time"}, str, strArr, null, null, null, String.valueOf(i));
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        List<C2924b> arrayList = new ArrayList();
                        while (a.m13327b()) {
                            C2924b c2924b = new C2924b();
                            a.m13324a(a.m13325a("id"));
                            c2924b.f9915a = a.m13328c(a.m13325a(Constants.FIELD_APPLET_CONFIG_NUM));
                            c2924b.f9916b = a.m13328c(a.m13325a("name"));
                            c2924b.f9918d = a.m13328c(a.m13325a("cmd"));
                            c2924b.f9917c = a.m13328c(a.m13325a("cnum"));
                            c2924b.f9919e = a.m13326b(a.m13325a("mark_time"));
                            c2924b.f9920f = a.m13324a(a.m13325a("mark_cmd"));
                            c2924b.f9921g = a.m13324a(a.m13325a("last_name_pubid"));
                            c2924b.f9922h = a.m13326b(a.m13325a("last_name_time"));
                            c2924b.f9923i = a.m13326b(a.m13325a("last_cmd_time"));
                            c2924b.f9924j = a.m13326b(a.m13325a("last_query_time"));
                            c2924b.f9925k = a.m13328c(a.m13325a("ec"));
                            c2924b.f9926l = a.m13324a(a.m13325a("mark_ec"));
                            c2924b.f9927m = a.m13326b(a.m13325a("last_ec_time"));
                            arrayList.add(c2924b);
                        }
                        C2962e.m13322a(a, true);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C2962e.m13322a(a, true);
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }

    private static void m13162a(int i, String str, String[] strArr, int i2) {
        boolean a = C2925c.m13169a();
        String valueOf = String.valueOf(i);
        String[] strArr2 = null;
        switch (i2) {
            case 1:
                if (a) {
                    strArr2 = new String[]{"mark_time", valueOf};
                    break;
                }
                break;
            case 2:
                strArr2 = new String[]{"mark_cmd", valueOf};
                break;
            case 3:
                strArr2 = new String[]{"mark_ec", valueOf};
                break;
            default:
                if (!a) {
                    strArr2 = new String[]{"mark_cmd", valueOf, "mark_ec", valueOf};
                    break;
                } else {
                    strArr2 = new String[]{"mark_time", valueOf, "mark_cmd", valueOf, "mark_ec", valueOf};
                    break;
                }
        }
        if (strArr2 != null) {
            C2925c.m13166a(str, strArr, strArr2);
        }
    }

    public static void m13163a(String str, int i) {
        C2925c.m13166a("num = ?", new String[]{str}, "last_name_pubid", String.valueOf(i));
    }

    public static void m13164a(String str, int i, int i2) {
        if (!C3049n.m13653e(str)) {
            C2925c.m13162a(0, "num = ?", new String[]{str}, 0);
        }
    }

    public static void m13165a(String str, long j, int i) {
        C2925c.m13166a("num = ?", new String[]{str}, "last_query_time", String.valueOf(j), "mark_time", "1");
    }

    private static void m13166a(String str, String[] strArr, String... strArr2) {
        if (strArr2 != null) {
            try {
                if (strArr2.length != 0) {
                    C2922b.m13133a("tb_num_name", C2921a.m13130a(null, strArr2), str, strArr);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "NumNameManager updateNunNameInfo: " + th.getMessage(), th);
            }
        }
    }

    public static void m13167a(HashMap<String, String> hashMap) {
        try {
            String b = C3049n.m13646b((String) hashMap.get(Constants.FIELD_APPLET_CONFIG_NUM));
            String str = (String) hashMap.get("msg");
            String str2 = (String) hashMap.get("cnum");
            long parseLong = Long.parseLong((String) hashMap.get("smsTime"));
            String[] b2 = C2973a.m13376b(str);
            str = b2[0];
            String str3 = b2[1];
            C2925c.m13157a(b, str, str2, 1, parseLong);
            if (C3049n.m13644a(b, str3)) {
                C2925c.m13170a(b, str2, "ec", str3, "mark_ec", "1", "last_ec_time", parseLong, ";");
            }
            long currentTimeMillis = System.currentTimeMillis() - parseLong;
            if (currentTimeMillis >= 0 && currentTimeMillis < FileWatchdog.DEFAULT_DELAY) {
                C2996a.f10137i.execute(new C2926d(b));
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "NumNameManager parseNumNameForMsg: " + th.getMessage(), th);
        }
    }

    public static void m13168a(List<String> list, int i, int i2) {
        if (!list.isEmpty()) {
            C2925c.m13162a(0, "num IN (" + ah.m13243a(list.size()) + ")", (String[]) list.toArray(new String[list.size()]), 0);
        }
    }

    public static boolean m13169a() {
        boolean z = false;
        String[] strArr = new String[]{"HUAWEICARD"};
        for (int i = 0; i <= 0; i++) {
            if (strArr[0].equals(C3006k.f10165k)) {
                break;
            }
        }
        z = true;
        return C2947n.m13281a(C2917a.m13105a(), "num_name_power", z);
    }

    private static boolean m13170a(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8) {
        if (!C3049n.m13644a(str, str3, str4, str5, str6, str7, str8)) {
            return false;
        }
        try {
            C2924b a = C2925c.m13160a(str, false);
            if (a != null) {
                String str9;
                long j2;
                if ("cmd".equals(str3)) {
                    str9 = a.f9918d;
                    j2 = a.f9923i;
                } else {
                    str9 = a.f9925k;
                    j2 = a.f9927m;
                }
                String[] a2 = C2925c.m13171a(str9, j2, str4, j, str8);
                if (a2 == null) {
                    return false;
                }
                String str10 = a2[0];
                str9 = a2[1];
                return C2925c.m13158a(str, str3, str10, str7, str9, "cnum", str2, str5, str6) > 0;
            } else {
                return C2925c.m13159a(Constants.FIELD_APPLET_CONFIG_NUM, str, str3, str4, "cnum", str2, str5, str6, str7, String.valueOf(j)) > 0;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "NumNameManager saveOrUpdateNumInfo: " + th.getMessage(), th);
            return false;
        }
    }

    private static String[] m13171a(String str, long j, String str2, long j2, String str3) {
        if (C3049n.m13653e(str)) {
            return new String[]{str2, String.valueOf(j2)};
        } else if (C3049n.m13653e(str2)) {
            return new String[]{str, String.valueOf(j)};
        } else if (!str2.equals(str) || j2 == j) {
            List asList = Arrays.asList(str.split(str3));
            int size = asList.size();
            Object obj = j2 >= j ? 1 : null;
            Object obj2 = size < 5 ? 1 : null;
            if (obj == null && (obj2 == null || asList.contains(str2))) {
                return null;
            }
            if (obj == null || !str2.equals(asList.get(size - 1))) {
                if (obj != null) {
                    boolean contains = asList.contains(str2);
                    if (obj2 != null || contains) {
                        String str4;
                        if (!contains) {
                            str4 = str;
                        } else if (asList == null || C3049n.m13653e(str2)) {
                            obj2 = "";
                        } else {
                            size = asList.size();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < size; i++) {
                                str4 = (String) asList.get(i);
                                if (!str4.equals(str2)) {
                                    if (stringBuilder.length() > 0 && !C3049n.m13653e(str3)) {
                                        stringBuilder.append(str3);
                                    }
                                    stringBuilder.append(str4);
                                }
                            }
                            obj2 = stringBuilder.toString();
                        }
                        return new String[]{new StringBuilder(String.valueOf(obj2)).append(str3).append(str2).toString(), String.valueOf(j2), "ResetPubId"};
                    }
                    return new String[]{str2, String.valueOf(j2), "ResetPubId"};
                }
                return new String[]{new StringBuilder(String.valueOf(str2)).append(str3).append(str).toString(), String.valueOf(j)};
            } else if (j2 == j) {
                return null;
            } else {
                return new String[]{str, String.valueOf(j2)};
            }
        } else {
            return new String[]{str2, String.valueOf(j2)};
        }
    }

    public static void m13172b(HashMap<String, String> hashMap) {
        try {
            String b = C3049n.m13646b((String) hashMap.get(Constants.FIELD_APPLET_CONFIG_NUM));
            String b2 = C2973a.m13371b(b, (String) hashMap.get("msg"));
            if (!C3049n.m13653e(b2)) {
                String str = (String) hashMap.get("cnum");
                long parseLong = Long.parseLong((String) hashMap.get("smsTime"));
                if (C3049n.m13644a(b, b2.trim())) {
                    C2925c.m13170a(b, str, "cmd", b2.trim(), "mark_cmd", "1", "last_cmd_time", parseLong, ";&XY_PIX&;");
                }
            }
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "NumNameManager parseCmdForMsg: " + e.getMessage(), e);
        }
    }

    public static void m13173c(HashMap<String, String> hashMap) {
        try {
            if ("SAMCLASSFIYVwIDAQAB".equals(C3046k.f10294a)) {
                C2996a.f10137i.execute(new C2927e(hashMap));
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "NumNameManager queryPublicInfoAsynchronous: " + th.getMessage(), th);
        }
    }
}
