package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;

/* compiled from: AuthManager */
public class bn {
    public static int f11512a = -1;
    public static String f11513b = "";
    private static bv f11514c;
    private static String f11515d = "http://apiinit.amap.com/v3/log/init";
    private static String f11516e = null;

    private static boolean m15696a(Context context, bv bvVar, boolean z) {
        boolean z2 = true;
        f11514c = bvVar;
        try {
            String a = m15692a();
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", f11514c.f11558b);
            hashMap.put("X-INFO", bo.m15701a(context, f11514c, null, z));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{f11514c.f11557a, f11514c.f11559c}));
            dk a2 = dk.m16059a();
            dp bxVar = new bx();
            bxVar.m15469a(bt.m15765a(context));
            bxVar.m15813a(hashMap);
            bxVar.m15815b(m15693a(context));
            bxVar.m15812a(a);
            z2 = m15697a(a2.mo4043b(bxVar));
        } catch (Throwable th) {
            cd.m15825a(th, "Auth", "getAuth");
        }
        return z2;
    }

    public static synchronized boolean m15695a(Context context, bv bvVar) {
        boolean a;
        synchronized (bn.class) {
            a = m15696a(context, bvVar, true);
        }
        return a;
    }

    public static synchronized boolean m15698b(Context context, bv bvVar) {
        boolean a;
        synchronized (bn.class) {
            a = m15696a(context, bvVar, false);
        }
        return a;
    }

    public static void m15694a(String str) {
        bm.m15685a(str);
    }

    private static String m15692a() {
        return f11515d;
    }

    private static boolean m15697a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        String str;
        try {
            str = new String(bArr, GameManager.DEFAULT_CHARSET);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    int i = jSONObject.getInt("status");
                    if (i == 1) {
                        f11512a = 1;
                    } else if (i == 0) {
                        f11512a = 0;
                    }
                }
                if (jSONObject.has("info")) {
                    f11513b = jSONObject.getString("info");
                }
                if (f11512a == 0) {
                    Log.i("AuthFailure", f11513b);
                }
                if (f11512a != 1) {
                    return false;
                }
                return true;
            } catch (Throwable e) {
                cd.m15825a(e, "Auth", "lData");
                return false;
            } catch (Throwable e2) {
                cd.m15825a(e2, "Auth", "lData");
                return false;
            }
        } catch (UnsupportedEncodingException e3) {
            str = new String(bArr);
        }
    }

    private static Map<String, String> m15693a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", GameManager.DEFAULT_CHARSET);
            String a = bo.m15699a();
            hashMap.put("ts", a);
            hashMap.put(SMSKeyInfo.TAG_KEY, bm.m15690f(context));
            hashMap.put("scode", bo.m15702a(context, a, bw.m15798a("resType=json&encode=UTF-8&key=" + bm.m15690f(context))));
        } catch (Throwable th) {
            cd.m15825a(th, "Auth", "gParams");
        }
        return hashMap;
    }
}
