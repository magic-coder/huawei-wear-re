package cn.com.xy.sms.sdk.p220j.p221a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.com.xy.sms.p204a.C2900b;
import cn.com.xy.sms.p204a.C2902d;
import cn.com.xy.sms.p204a.C2909j;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2960c;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2995m;
import cn.com.xy.sms.sdk.p218i.C3013f;
import cn.com.xy.sms.sdk.p218i.C3015h;
import cn.com.xy.sms.sdk.p229l.C3038c;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3055t;
import cn.com.xy.sms.sdk.p229l.C3059x;
import cn.com.xy.sms.sdk.provider.ContactsProvider;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.SiteCountryInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;

public final class C3017b {
    private static long f10186a = 0;
    private static String f10187b = null;
    private static ExecutorService f10188c = Executors.newFixedThreadPool(1);
    private static C3016a f10189d = new C3016a();
    private static ExecutorService f10190e = Executors.newFixedThreadPool(3);
    private static BroadcastReceiver f10191f = null;

    static Map<String, Object> m13543a(Context context, String str, String str2, String str3, long j, Map<String, String> map) {
        Throwable th;
        if (context == null) {
            throw new Exception(" Context is null.");
        } else if (str == null) {
            throw new Exception(" phoneNumber is null.");
        } else if (str3 == null) {
            throw new Exception(" smsContent is null.");
        } else {
            Map<String, Object> map2 = null;
            String a = C2909j.m13080a();
            Map hashMap;
            Map<String, String> map3;
            String trim;
            try {
                C3038c.m13592a(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, str3, Long.valueOf(j), map);
                String valueOf = String.valueOf(j);
                if (map == null) {
                    hashMap = new HashMap();
                } else {
                    if (map.containsKey("msgId")) {
                        C2902d.m13074a(null, (String) map.get("msgId"));
                    }
                    map3 = map;
                }
                try {
                    if (!hashMap.containsKey("ALLOW_VERCODE_MSG")) {
                        hashMap.put("ALLOW_VERCODE_MSG", "true");
                    }
                    if (hashMap.containsKey("ALLOW_PERSONAL_MSG") && !C3041f.m13609b().m13101a(context, str)) {
                        hashMap.put("ALLOW_PERSONAL_MSG", "false");
                    }
                    hashMap.put("version", C2973a.m13384f());
                    hashMap.put("channel", C2947n.m13284d(context, Constant.TARGET_CHANNEL));
                    hashMap.put("smsCenterNum", str2);
                    if (f10187b == null) {
                        f10187b = C2978a.m13405b();
                    }
                    if (C3049n.m13653e(f10187b)) {
                        hashMap.put("provice", f10187b);
                    }
                    int c = C2947n.m13283c(C2917a.m13105a(), "RECOGNIZE_LEVEL");
                    if (c != -1) {
                        hashMap.put("RECOGNIZE_LEVEL", new StringBuilder(String.valueOf(c)).toString());
                    }
                    JSONArray a2 = C3041f.m13609b().m13094a(str3, j);
                    hashMap.put("hwParseTime", a2 == null ? "" : a2.toString());
                    trim = str3.trim();
                } catch (Throwable th2) {
                    th = th2;
                    trim = str3;
                    C3038c.m13593b(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, trim, Long.valueOf(j), hashMap, map2);
                    throw th;
                }
                try {
                    if (C3055t.m13710c(C2917a.m13109b(), "parseUtilMain", "jar") && C2995m.m13475a(C2917a.m13111d()).booleanValue()) {
                        map2 = "true".equals(hashMap.get("parseVerifyCode")) ? C2973a.m13372b(str, trim, hashMap) : C2973a.m13358a(str, trim, hashMap);
                        if (map2 == null) {
                            C2982a.m13415a("parseMsg", "result is null phoneNumber:" + str + " smsContent: " + trim + " msgID: " + ((String) hashMap.get("msgId")), null);
                            C3013f.m13539a(new C3015h(16, Constants.FIELD_APPLET_CONFIG_NUM, str, "msg", trim, "smsTime", valueOf));
                        }
                        String[] strArr = new String[4];
                        strArr[0] = "phoneNumber";
                        strArr[1] = str;
                        strArr[2] = HwAccountConstants.SERVICETOKENAUTH_IS_SECCUSS;
                        strArr[3] = String.valueOf(map2 != null);
                        C3013f.m13539a(new C3015h(14, strArr));
                    } else {
                        C3059x.m13732a();
                    }
                    if (C2960c.m13317a()) {
                        Map hashMap2;
                        if (System.currentTimeMillis() >= f10186a + 600000) {
                            C3013f.m13539a(new C3015h(2, new String[0]));
                            f10186a = System.currentTimeMillis();
                        }
                        if (map2 != null) {
                            String str4 = (String) hashMap.get("simIndex");
                            if (!C3049n.m13653e(str4)) {
                                map2.put("simIndex", str4);
                            }
                            if (!C3049n.m13653e((String) hashMap.get("msgTime"))) {
                                map2.put("msgTime", hashMap.get("msgTime"));
                            }
                            if (!C3049n.m13653e((String) map2.get("title_num"))) {
                                if (!C3049n.m13653e((String) hashMap.get("simIccid"))) {
                                    C3013f.m13539a(new C3015h(1, "simIccid", (String) hashMap.get("simIccid"), "receiveNum", str, SiteCountryInfo.TAG_SMS, trim, "centerNum", str2, "sceneId", str4));
                                }
                                C3013f.m13539a(new C3015h(6, "titleNo", str4));
                                C3013f.m13539a(new C3015h(3, "titleNo", str4));
                                C3013f.m13539a(new C3015h(8, "titleNo", str4));
                                C3013f.m13539a(new C3015h(5, "titleNo", str4, "type", "0"));
                            }
                            if ("true".equals((String) hashMap.get("pickUrl"))) {
                                str4 = C2900b.m13071a("", str, trim, valueOf, hashMap);
                                if (!C3049n.m13653e(str4)) {
                                    map2.put("url", str4);
                                }
                            }
                            hashMap2 = new HashMap();
                            hashMap2.putAll(map2);
                            ContactsProvider.m13743a(context, hashMap2);
                        }
                        C3013f.m13539a(new C3015h(10, Constants.FIELD_APPLET_CONFIG_NUM, str, "msg", trim, "cnum", str2, "smsTime", valueOf));
                        C3013f.m13539a(new C3015h(9, Constants.FIELD_APPLET_CONFIG_NUM, str, "msg", trim, "cnum", str2, "smsTime", valueOf));
                        if (Boolean.valueOf((String) hashMap.get("parse_recognise_value")).booleanValue()) {
                            if (!C3049n.m13653e((String) hashMap.get("msgId"))) {
                                C3015h c3015h = new C3015h(15, "msgId", (String) hashMap.get("msgId"), Constants.FIELD_APPLET_CONFIG_NUM, str, "cnum", str2, "msg", trim, "smsTime", valueOf);
                                try {
                                    if (!C3049n.m13653e((String) hashMap.get("ref_basevalue")) && Boolean.valueOf((String) hashMap.get("ref_basevalue")).booleanValue()) {
                                        map2.remove("ref_basevalue");
                                        hashMap2 = new HashMap();
                                        hashMap2.putAll(map2);
                                        c3015h.m13541a(hashMap2);
                                    }
                                } catch (Exception e) {
                                }
                                C3013f.m13539a(c3015h);
                            }
                        }
                        C2973a.m13360a(context, (String) hashMap.get("msgId"), str, str2, trim, j, hashMap, map2);
                        C3038c.m13593b(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, trim, Long.valueOf(j), hashMap, map2);
                        return map2;
                    }
                    Map<String, Object> hashMap3 = new HashMap();
                    try {
                        hashMap3.put("parseStatu", Integer.valueOf(-1));
                        C3038c.m13593b(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, trim, Long.valueOf(j), hashMap, hashMap3);
                        return hashMap3;
                    } catch (Throwable th3) {
                        map2 = hashMap3;
                        th = th3;
                        C3038c.m13593b(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, trim, Long.valueOf(j), hashMap, map2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    C2982a.m13415a("XIAOYUAN", "BaseParseService parseMsg: " + th.getMessage(), th);
                    C3038c.m13593b(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, trim, Long.valueOf(j), hashMap, map2);
                    return map2;
                }
            } catch (Throwable th5) {
                th = th5;
                hashMap = map;
                trim = str3;
                C3038c.m13593b(a, "cn.com.xy.sms.sdk.service.baseparse.BaseParseService", "parseMsg", context, str, str2, trim, Long.valueOf(j), hashMap, map2);
                throw th;
            }
        }
    }

    public static void m13544a(Context context) {
        try {
            if (f10191f == null) {
                f10191f = new C3019d();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("cn.com.xy.sms.iccidinfo.action");
                context.registerReceiver(f10191f, intentFilter);
            }
        } catch (Throwable th) {
            C2982a.m13415a("initSdk", "registerReceiver error " + th.getMessage(), th);
        }
    }

    public static void m13545a(Context context, String str, String str2, String str3, long j, Map<String, String> map, C2904g c2904g) {
        f10190e.execute(new C3018c(context, str, str2, str3, j, map, c2904g));
    }

    static /* synthetic */ void m13546a(Intent intent) {
        if (intent != null) {
            C2978a.m13411c(intent.getStringExtra("iccid"), intent.getIntExtra("simIndex", -1));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.Map<java.lang.String, java.lang.Object> m13547b(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, long r12, java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
        r6 = 0;
        r1 = 0;
        r3 = cn.com.xy.sms.sdk.p220j.p221a.C3017b.class;
        monitor-enter(r3);
        r0 = f10189d;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0.f10179a = r8;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0.f10180b = r9;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0.f10181c = r10;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0.f10182d = r11;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0.f10183e = r12;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0.f10184f = r14;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r0 = f10188c;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r2 = f10189d;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        r2 = r0.submit(r2);	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x0065 }
        if (r14 == 0) goto L_0x0053;
    L_0x001e:
        r0 = "PARSE_TIME_OUT";
        r0 = r14.containsKey(r0);	 Catch:{ Exception -> 0x004b }
        if (r0 == 0) goto L_0x0053;
    L_0x0026:
        r0 = "PARSE_TIME_OUT";
        r0 = r14.get(r0);	 Catch:{ Exception -> 0x004b }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004b }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x004b }
        r4 = r0.longValue();	 Catch:{ Exception -> 0x004b }
    L_0x0036:
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x003c;
    L_0x003a:
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
    L_0x003c:
        r0 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x00c7 }
        r0 = r2.get(r4, r0);	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x00c7 }
        r0 = (java.util.Map) r0;	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x00c7 }
        r1 = f10189d;	 Catch:{ all -> 0x009f }
        r1.m13542a();	 Catch:{ all -> 0x009f }
    L_0x0049:
        monitor-exit(r3);
        return r0;
    L_0x004b:
        r0 = move-exception;
        r4 = "XIAOYUAN";
        r5 = "parseMsg PARSE_TIME_OUT";
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);	 Catch:{ InterruptedException -> 0x0055, ExecutionException -> 0x005d, TimeoutException -> 0x00c7 }
    L_0x0053:
        r4 = r6;
        goto L_0x0036;
    L_0x0055:
        r0 = move-exception;
        r0 = f10189d;	 Catch:{ all -> 0x009f }
        r0.m13542a();	 Catch:{ all -> 0x009f }
        r0 = r1;
        goto L_0x0049;
    L_0x005d:
        r0 = move-exception;
        r0 = f10189d;	 Catch:{ all -> 0x009f }
        r0.m13542a();	 Catch:{ all -> 0x009f }
        r0 = r1;
        goto L_0x0049;
    L_0x0065:
        r0 = move-exception;
    L_0x0066:
        r2 = "XIAOYUAN";
        r4 = "BaseParseService_parseMsg";
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r4, r0);	 Catch:{ all -> 0x00be }
        if (r1 == 0) goto L_0x0073;
    L_0x006f:
        r0 = 1;
        r1.cancel(r0);	 Catch:{ Throwable -> 0x00c5 }
    L_0x0073:
        r0 = f10189d;	 Catch:{ Throwable -> 0x00bc }
        r1 = r0.f10185g;	 Catch:{ Throwable -> 0x00a2 }
        if (r1 == 0) goto L_0x007e;
    L_0x0079:
        r0 = r0.f10185g;	 Catch:{ Throwable -> 0x00a2 }
        r0.stop();	 Catch:{ Throwable -> 0x00a2 }
    L_0x007e:
        r0 = f10188c;	 Catch:{ Throwable -> 0x00bc }
        r0.shutdownNow();	 Catch:{ Throwable -> 0x00bc }
    L_0x0083:
        r0 = 1;
        r0 = java.util.concurrent.Executors.newFixedThreadPool(r0);	 Catch:{ all -> 0x00be }
        f10188c = r0;	 Catch:{ all -> 0x00be }
        r0 = new java.util.HashMap;	 Catch:{ all -> 0x00be }
        r0.<init>();	 Catch:{ all -> 0x00be }
        r1 = "parseStatu";
        r2 = -1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00be }
        r0.put(r1, r2);	 Catch:{ all -> 0x00be }
        r1 = f10189d;	 Catch:{ all -> 0x009f }
        r1.m13542a();	 Catch:{ all -> 0x009f }
        goto L_0x0049;
    L_0x009f:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
    L_0x00a2:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bc }
        r4 = "BaseParseCallable stopThread error ";
        r2.<init>(r4);	 Catch:{ Throwable -> 0x00bc }
        r4 = r0.getMessage();	 Catch:{ Throwable -> 0x00bc }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x00bc }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00bc }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ Throwable -> 0x00bc }
        goto L_0x007e;
    L_0x00bc:
        r0 = move-exception;
        goto L_0x0083;
    L_0x00be:
        r0 = move-exception;
        r1 = f10189d;	 Catch:{ all -> 0x009f }
        r1.m13542a();	 Catch:{ all -> 0x009f }
        throw r0;	 Catch:{ all -> 0x009f }
    L_0x00c5:
        r0 = move-exception;
        goto L_0x0073;
    L_0x00c7:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.j.a.b.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String, long, java.util.Map):java.util.Map<java.lang.String, java.lang.Object>");
    }

    public static void m13548b(Context context) {
        try {
            if (f10191f != null) {
                context.unregisterReceiver(f10191f);
                f10191f = null;
            }
        } catch (Throwable th) {
            C2982a.m13415a("ParseManager.unRegisterReceiver", "unRegisterReceiver error " + th.getMessage(), th);
        }
    }
}
