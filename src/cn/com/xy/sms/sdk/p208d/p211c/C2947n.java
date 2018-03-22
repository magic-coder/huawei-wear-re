package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import android.content.Context;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2960c;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p218i.C3013f;
import cn.com.xy.sms.sdk.p218i.C3015h;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3055t;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class C2947n {
    public static HashMap<String, Object> f10009a = new HashMap();

    public static long m13272a(Context context, String str, String str2, String str3) {
        int a;
        String a2 = C2947n.m13275a(context, str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("p_key", str);
        contentValues.put("p_value", str2);
        contentValues.put("pextend_value", str3);
        if (a2 != null) {
            a = C2922b.m13133a("tb_sdk_param", contentValues, "p_key=?", new String[]{str});
        } else {
            a = (int) C2922b.m13135a("tb_sdk_param", contentValues);
        }
        return (long) a;
    }

    public static long m13273a(String str, long j, Context context) {
        C2962e c2962e = null;
        try {
            c2962e = C2922b.m13139a("tb_sdk_param", new String[]{"p_value"}, "p_key=?", new String[]{str});
            if (c2962e != null && c2962e.m13327b()) {
                String c = c2962e.m13328c(c2962e.m13325a("p_value"));
                if (!C3049n.m13653e(c)) {
                    j = Long.valueOf(c).longValue();
                    return j;
                }
            } else if (context != null) {
                C2947n.m13274a(str, new StringBuilder(String.valueOf(j)).toString());
                C2962e.m13322a(c2962e, true);
                return j;
            }
            C2962e.m13322a(c2962e, true);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getLongParam: " + th.getMessage(), th);
        } finally {
            C2962e.m13322a(c2962e, true);
        }
        return j;
    }

    public static long m13274a(String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("p_key", str);
            contentValues.put("p_value", str2);
            int a = C2922b.m13133a("tb_sdk_param", contentValues, "p_key=?", new String[]{str});
            f10009a.put(str, str2);
            if (a <= 0) {
                return C2922b.m13135a("tb_sdk_param", contentValues);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "setParam: " + th.getMessage(), th);
        }
        return 0;
    }

    public static String m13275a(Context context, String str) {
        Map a = C2947n.m13276a("p_key=?", new String[]{str}, 1);
        return (a == null || !a.containsKey(str)) ? null : (String) a.get(str);
    }

    public static Map<String, String> m13276a(String str, String[] strArr, int i) {
        Throwable th;
        C2962e a;
        try {
            a = C2922b.m13141a(false, "tb_sdk_param", new String[]{"p_key", "p_value"}, str, strArr, null, null, null, String.valueOf(i));
            if (a != null) {
                try {
                    if (a.m13323a() != 0) {
                        Map<String, String> hashMap = new HashMap();
                        while (a.m13327b()) {
                            hashMap.put(a.m13328c(a.m13325a("p_key")), a.m13328c(a.m13325a("p_value")));
                        }
                        C2962e.m13322a(a, true);
                        return hashMap;
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

    public static void m13277a() {
        try {
            String stringBuilder = new StringBuilder(String.valueOf(C2917a.m13105a().getFilesDir().getPath())).append(File.separator).append("parse").append(File.separator).toString();
            if (C3055t.m13704a(stringBuilder)) {
                C3055t.m13700a(stringBuilder, "ParseUtilCasual_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilEC_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilFinanceL_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilFinanceM_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilFinanceS_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilLife_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilMove_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilTelecom_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilTravel_", ".jar", null);
                C3055t.m13700a(stringBuilder, "ParseUtilUnicom_", ".jar", null);
            }
            if (C3055t.m13704a(C2917a.m13105a().getDir("outdex", 0).getPath())) {
                C3055t.m13707b("ParseUtilCasual_", ".dex", null);
                C3055t.m13707b("ParseUtilEC_", ".dex", null);
                C3055t.m13707b("ParseUtilFinanceL_", ".dex", null);
                C3055t.m13707b("ParseUtilFinanceM_", ".dex", null);
                C3055t.m13707b("ParseUtilFinanceS_", ".dex", null);
                C3055t.m13707b("ParseUtilLife_", ".dex", null);
                C3055t.m13707b("ParseUtilMove_", ".dex", null);
                C3055t.m13707b("ParseUtilTelecom_", ".dex", null);
                C3055t.m13707b("ParseUtilTravel_", ".dex", null);
                C3055t.m13707b("ParseUtilUnicom_", ".dex", null);
            }
        } catch (Throwable th) {
        }
    }

    public static void m13278a(Context context, String str, String str2, boolean z, boolean z2, Map<String, String> map) {
        Object obj;
        C2947n.m13279a(str);
        String a = C2947n.m13275a(context, "smartsms_enhance");
        if (a == null) {
            if (map != null) {
                a = (String) map.get("smartsms_enhance");
            }
            if (a == null) {
                a = "true";
            }
            C2947n.m13272a(context, "smartsms_enhance", a, null);
            f10009a.put("smartsms_enhance", a);
        }
        a = C2947n.m13275a(context, "SUPPORT_NETWORK_TYPE");
        if (a == null) {
            if (map != null) {
                a = (String) map.get("SUPPORT_NETWORK_TYPE");
            }
            if (a == null) {
                a = "1";
            }
            C2947n.m13272a(context, "SUPPORT_NETWORK_TYPE", a, null);
            f10009a.put("SUPPORT_NETWORK_TYPE", a);
        }
        a = C2947n.m13275a(context, "ONLINE_UPDATE_SDK_PERIOD");
        if (a == null) {
            if (map != null) {
                a = (String) map.get("ONLINE_UPDATE_SDK_PERIOD");
            }
            if (a == null) {
                a = "1";
            }
            C2947n.m13272a(context, "ONLINE_UPDATE_SDK_PERIOD", a, null);
            f10009a.put("ONLINE_UPDATE_SDK_PERIOD", a);
        }
        C2947n.m13272a(context, "PRELOADENABLE", new StringBuilder(String.valueOf(z)).toString(), null);
        C2947n.m13272a(context, "SMSLOCATEENABLE", new StringBuilder(String.valueOf(z2)).toString(), null);
        C2947n.m13272a(context, Constant.TARGET_CHANNEL, new StringBuilder(String.valueOf(str)).toString(), null);
        f10009a.put("PRELOADENABLE", Boolean.valueOf(z));
        f10009a.put("SMSLOCATEENABLE", Boolean.valueOf(z2));
        f10009a.put(Constant.TARGET_CHANNEL, str);
        String str3 = null;
        a = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        if (map != null) {
            a = (String) map.get("SIM_ICCID_2");
            str3 = (String) map.get("SMS_LOCATE_2");
            if (a != null) {
                C2943j.m13257a(a, false, str3, "", "", "", context);
                C3013f.m13539a(new C3015h(1, "simIccid", a, "smsLocate", str3));
            }
            a = (String) map.get("CUSTOM_LOCATION_SERVER_URL");
            str4 = (String) map.get("CUSTOM_PUBLIC_SERVER_URL");
            str3 = (String) map.get("CUSTOM_PUBINFO_SERVER_URL");
            str5 = (String) map.get("CUSTOM_SDK_SERVER_URL");
            str6 = (String) map.get("ONLINE_UPDATE_SDK");
            str16 = (String) map.get("QUERY_ONLINE");
            str7 = (String) map.get("SMS_LOCATE");
            str8 = (String) map.get("RECOGNIZE_LEVEL");
            str9 = (String) map.get("OPEN_POPUP_DRAG");
            str10 = (String) map.get("AUTO_UPDATE_DATA");
            f10009a.put("SECRETKEY", (String) map.get("SECRETKEY"));
            str15 = (String) map.get("POPUP_BG_TYPE");
            str12 = (String) map.get("SCENE_CENSUS_ONLINE");
            str11 = (String) map.get("CUSTOM_SDK_RES_DOWNLAOD_URL");
            str13 = (String) map.get("SUPPORT_NETWORK_TYPE_MAJOR");
            str14 = (String) map.get("ONLINE_UPDATE_RES_PERIOD");
            str17 = (String) map.get("REPARSE_BUBBLE_CYCLE");
            str18 = (String) map.get("COMPARE_PUBNUM_OPERATOR");
            f10009a.put("RSAPRVKEY", (String) map.get("RSAPRVKEY"));
            String str19 = str11;
            str11 = str15;
            str15 = str12;
            str12 = str10;
            str10 = str9;
            str9 = str8;
            str8 = str16;
            str16 = str19;
            String str20 = str6;
            str6 = str5;
            str5 = str3;
            str3 = str7;
            str7 = str20;
        }
        if (a == null) {
            a = "";
        }
        C2947n.m13272a(context, "CUSTOM_LOCATION_SERVER_URL", a, null);
        f10009a.put("CUSTOM_LOCATION_SERVER_URL", a);
        a = str4 == null ? "" : str4;
        if (!C3049n.m13653e(a)) {
            if (C2996a.m13497b()) {
                C2996a.f10133e = a;
            } else {
                C2996a.f10130b = a;
            }
        }
        str4 = str5 == null ? "" : str5;
        if (!C3049n.m13653e(str4)) {
            C2996a.f10135g = str4;
        }
        C2947n.m13272a(context, "CUSTOM_PUBINFO_SERVER_URL", str4, null);
        f10009a.put("CUSTOM_PUBINFO_SERVER_URL", str4);
        C2947n.m13272a(context, "CUSTOM_PUBLIC_SERVER_URL", a, null);
        f10009a.put("CUSTOM_PUBLIC_SERVER_URL", a);
        a = str6 == null ? "" : str6;
        C2947n.m13272a(context, "CUSTOM_SDK_SERVER_URL", a, null);
        f10009a.put("CUSTOM_SDK_SERVER_URL", a);
        if (!C3049n.m13653e(a)) {
            if (C2996a.m13497b()) {
                C2996a.f10134f = a;
            } else {
                C2996a.f10131c = a;
            }
        }
        a = str16 == null ? "" : str16;
        C2947n.m13272a(context, "CUSTOM_SDK_RES_DOWNLAOD_URL", a, null);
        f10009a.put("CUSTOM_SDK_RES_DOWNLAOD_URL", a);
        if (!C3049n.m13653e(a)) {
            C2996a.f10132d = a;
        }
        a = str7 == null ? "1" : str7;
        C2947n.m13272a(context, "ONLINE_UPDATE_SDK", a, null);
        f10009a.put("ONLINE_UPDATE_SDK", a);
        a = str8 == null ? "1" : str8;
        C2947n.m13272a(context, "QUERY_ONLINE", a, null);
        f10009a.put("QUERY_ONLINE", a);
        a = str15 == null ? "0" : str15;
        C2947n.m13272a(context, "SCENE_CENSUS_ONLINE", a, null);
        f10009a.put("SCENE_CENSUS_ONLINE", a);
        a = str9 == null ? "3" : str9;
        C2947n.m13272a(context, "RECOGNIZE_LEVEL", a, null);
        f10009a.put("RECOGNIZE_LEVEL", a);
        if (str10 == null) {
            obj = "0";
        } else {
            a = str10;
        }
        f10009a.put("OPEN_POPUP_DRAG", obj);
        a = str12 == null ? "0" : str12;
        C2947n.m13272a(context, "AUTO_UPDATE_DATA", a, null);
        f10009a.put("AUTO_UPDATE_DATA", a);
        a = str11 == null ? "1" : str11;
        C2947n.m13272a(context, "POPUP_BG_TYPE", a, null);
        f10009a.put("POPUP_BG_TYPE", a);
        a = str13 == null ? "2" : str13;
        C2947n.m13272a(context, "SUPPORT_NETWORK_TYPE_MAJOR", a, null);
        f10009a.put("SUPPORT_NETWORK_TYPE_MAJOR", a);
        a = str14 == null ? "2" : str14;
        C2947n.m13272a(context, "ONLINE_UPDATE_RES_PERIOD", a, null);
        f10009a.put("ONLINE_UPDATE_RES_PERIOD", a);
        a = str17 == null ? "-1" : str17;
        C2947n.m13272a(context, "REPARSE_BUBBLE_CYCLE", a, null);
        f10009a.put("REPARSE_BUBBLE_CYCLE", a);
        a = str18 == null ? "true" : str18;
        C2947n.m13272a(context, "COMPARE_PUBNUM_OPERATOR", a, null);
        f10009a.put("COMPARE_PUBNUM_OPERATOR", a);
        if (!C3049n.m13653e(str2)) {
            C2943j.m13257a(str2, true, str3, "", "", "", context);
            C3013f.m13539a(new C3015h(1, "simIccid", str2, "smsLocate", str3));
        }
        C2947n.m13272a(context, "APPVERSION", C2996a.f10136h, null);
    }

    public static void m13279a(String str) {
        try {
            String a = C2947n.m13275a(C2917a.m13105a(), Constant.TARGET_CHANNEL);
            if (!C3049n.m13653e(a) && !C3049n.m13653e(str) && !a.equals(str)) {
                C2947n.m13280a(true);
            }
        } catch (Throwable th) {
        }
    }

    public static void m13280a(boolean z) {
        if (z) {
            try {
                C2922b.m13134a("tb_scene_config", null, null);
            } catch (Throwable th) {
                return;
            }
            try {
                C2922b.m13134a("tb_scenerule_config", null, null);
            } catch (Throwable th2) {
                C2982a.m13415a("XIAOYUAN", "deleteAll: " + th2.getMessage(), th2);
            }
            try {
                C2922b.m13134a("tb_res_download", null, null);
            } catch (Throwable th22) {
                C2982a.m13415a("XIAOYUAN", "deleteAll: " + th22.getMessage(), th22);
            }
            try {
                C2922b.m13134a("tb_xml_res_download", null, null);
            } catch (Throwable th222) {
                C2982a.m13415a("XIAOYUAN", "deleteAll: " + th222.getMessage(), th222);
            }
            C2944k.m13269b();
        }
        C2952s.m13296c();
        C3055t.m13712d(C2917a.m13109b());
        C3055t.m13697a(C2917a.m13105a().getDir("outdex", 0));
        C2960c.m13318b();
    }

    public static boolean m13281a(Context context, String str, boolean z) {
        boolean z2;
        Object obj = f10009a.get(str);
        if (obj == null) {
            try {
                String a = C2947n.m13275a(context, str);
                if (a == null) {
                    f10009a.put(str, Boolean.valueOf(z));
                    z2 = z;
                } else {
                    z2 = !"false".equalsIgnoreCase(a);
                }
                try {
                    f10009a.put(str, Boolean.valueOf(z2));
                } catch (Throwable th) {
                    Throwable th2 = th;
                    C2982a.m13415a("XIAOYUAN", "getBooleanParam: " + th2.getMessage(), th2);
                    return z2;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                z2 = false;
                th2 = th4;
                C2982a.m13415a("XIAOYUAN", "getBooleanParam: " + th2.getMessage(), th2);
                return z2;
            }
        }
        z2 = Boolean.parseBoolean(obj.toString());
        return z2;
    }

    public static boolean m13282b(Context context, String str) {
        return C2947n.m13281a(context, str, false);
    }

    public static int m13283c(Context context, String str) {
        Object obj = f10009a.get(str);
        if (obj != null) {
            return Integer.parseInt((String) obj);
        }
        try {
            String a = C2947n.m13275a(context, str);
            if (a != null) {
                f10009a.put(str, a);
                return Integer.valueOf(a).intValue();
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getIntParam: " + th.getMessage(), th);
        }
        return -1;
    }

    public static String m13284d(Context context, String str) {
        String a;
        Object obj = f10009a.get(str);
        if (obj == null) {
            try {
                a = C2947n.m13275a(context, str);
                if (a != null) {
                    try {
                        f10009a.put(str, a);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        C2982a.m13415a("XIAOYUAN", "getStringParam: " + th2.getMessage(), th2);
                        return a;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                a = null;
                th2 = th4;
                C2982a.m13415a("XIAOYUAN", "getStringParam: " + th2.getMessage(), th2);
                return a;
            }
        }
        a = (String) obj;
        return a;
    }
}
