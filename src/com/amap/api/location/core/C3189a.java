package com.amap.api.location.core;

import android.content.Context;
import android.util.Log;
import com.aps.bh;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: AuthManager */
public class C3189a {
    static String f10680a = "";
    private static int f10681b = -1;
    private static String f10682c = "1";

    public static int m14106a() {
        return f10681b;
    }

    public static synchronized boolean m14108a(Context context) {
        boolean d;
        synchronized (C3189a.class) {
            try {
                byte[] e = C3189a.m14116e("resType=json&encode=UTF-8&ec=1");
                String a = bh.m17409a().m17417a(context, C3189a.m14112c(), e, "loc");
                if (a != null) {
                    d = C3189a.m14115d(a);
                } else {
                    f10681b = 0;
                    d = true;
                }
                if (f10681b != 1) {
                    f10681b = 0;
                }
            } catch (Throwable th) {
                if (f10681b != 1) {
                    f10681b = 0;
                }
            }
        }
        return d;
    }

    public static synchronized boolean m14111b(Context context) {
        boolean z;
        synchronized (C3189a.class) {
            z = true;
            try {
                byte[] e = C3189a.m14116e("resType=json&encode=UTF-8&ec=1&opertype=callamap&output=json");
                String a = bh.m17409a().m17417a(context, C3189a.m14114d(), e, "lswu");
                if (a != null) {
                    z = C3189a.m14113c(a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z;
    }

    private static boolean m14113c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("result")) {
                jSONObject = jSONObject.getJSONObject("result");
                if (jSONObject.has("callamap")) {
                    jSONObject = jSONObject.getJSONObject("callamap");
                    if (jSONObject.has("callamapflag")) {
                        f10682c = jSONObject.getString("callamapflag");
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String m14112c() {
        return "http://apiinit.amap.com/v3/log/init";
    }

    private static String m14114d() {
        return "http://restapi.amap.com/v3/config/resource?";
    }

    private static boolean m14115d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f10681b = 1;
                } else if (i == 0) {
                    f10681b = 0;
                }
            }
            if (jSONObject.has("info")) {
                f10680a = jSONObject.getString("info");
            }
            if (f10681b == 0) {
                Log.i("AuthFailure", f10680a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            f10681b = 0;
        }
        if (f10681b == 1) {
            return true;
        }
        return false;
    }

    public static boolean m14110b() {
        return "1".equals(f10682c);
    }

    private static byte[] m14116e(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            return C3189a.m14109b(C3189a.m14107a(stringBuffer.toString())).toString().getBytes(GameManager.DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String m14107a(String str) {
        String[] split = str.split(SNBConstant.FILTER);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : split) {
            stringBuffer.append(append);
            stringBuffer.append(SNBConstant.FILTER);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    public static String m14109b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a = C3192d.m14139a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + C3192d.m14140a(a, str));
        return stringBuffer.toString();
    }
}
