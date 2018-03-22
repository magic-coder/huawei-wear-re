package cn.com.xy.sms.sdk.p214f;

import android.content.Context;
import android.telephony.TelephonyManager;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2942i;
import cn.com.xy.sms.sdk.p208d.p211c.C2943j;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2948o;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2923a;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.SiteCountryInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C2978a {
    public static final ExecutorService f10090a = Executors.newFixedThreadPool(1);
    public static final ExecutorService f10091b = Executors.newFixedThreadPool(2);
    private static final HashMap<String, String[]> f10092c = new HashMap();
    private static boolean f10093d = false;
    private static Map<String, Long> f10094e = Collections.synchronizedMap(new HashMap());

    public static String m13390a() {
        for (Entry value : f10092c.entrySet()) {
            String[] strArr = (String[]) value.getValue();
            String str = strArr[0];
            String str2 = strArr[3];
            if ("1".equals(strArr[6])) {
                return C3049n.m13653e(str2) ? str : str2;
            }
        }
        return null;
    }

    private static String m13391a(int i) {
        Set<Entry> entrySet = f10092c.entrySet();
        String valueOf = String.valueOf(i);
        for (Entry value : entrySet) {
            String[] strArr = (String[]) value.getValue();
            String str = strArr[3];
            if (valueOf.equals(strArr[5])) {
                return str;
            }
        }
        return null;
    }

    public static String m13392a(Context context) {
        C2942i a = C2943j.m13258a(context);
        if (a != null && !C3049n.m13653e(a.f9980b)) {
            return a.f9980b;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return !C3049n.m13653e(telephonyManager.getSimSerialNumber()) ? telephonyManager.getSimSerialNumber() : "";
    }

    public static String m13393a(String str, int i) {
        String b = C2978a.m13406b(str, 3);
        return !C3049n.m13653e(b) ? b : i >= 0 ? C2978a.m13391a(i) : null;
    }

    public static String m13394a(String str, int i, String str2, String str3) {
        try {
            if (!C3049n.m13653e(str2)) {
                Object obj;
                if (f10092c.get(str2) == null || C3049n.m13653e(((String[]) f10092c.get(str2))[0])) {
                    int i2 = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    C2978a.m13397a(str2);
                }
            }
            String a = C2978a.m13393a(str2, i);
            if (!C3049n.m13653e(a)) {
                return a;
            }
            C2948o c2948o;
            String b = C3049n.m13646b(str);
            if (C3049n.m13653e(b)) {
                c2948o = null;
            } else {
                c2948o = C2923a.m13153a(b);
                if (c2948o == null) {
                    c2948o = C2923a.m13156b(b);
                    if (c2948o != null) {
                        C2923a.m13154a(b, c2948o);
                    }
                }
            }
            if (!C3049n.m13653e(str) && (c2948o == null || c2948o.f10016g <= System.currentTimeMillis() - C2973a.m13350a(0, 7776000000L))) {
                C2978a.m13400a(str, str2, str3, true, true);
            }
            if (c2948o == null || C3049n.m13653e(c2948o.f10012c)) {
                C2978a.m13402a(false);
                if (C3049n.m13653e(str2)) {
                    a = String.valueOf(C2978a.m13404b(str3));
                    if ("-1".equals(a)) {
                        a = C2978a.m13410c();
                        if (!C3049n.m13653e(a)) {
                            return a;
                        }
                        a = C2978a.m13390a();
                        if (!C3049n.m13653e(a)) {
                            return a;
                        }
                    }
                    a = C2978a.m13412d(a);
                    if (!C3049n.m13653e(a)) {
                        return a;
                    }
                }
                if (C3049n.m13653e(str2)) {
                    a = null;
                } else {
                    String[] strArr = (String[]) f10092c.get(str2);
                    if (strArr == null) {
                        a = null;
                    } else {
                        a = strArr[0];
                        if (C3049n.m13653e(a)) {
                            a = null;
                        }
                    }
                }
                if (!C3049n.m13653e(a)) {
                    new StringBuilder("返回指定iccid的区域编码 areaCode=").append(a).append(" iccid=").append(str2);
                    return a;
                }
                return PayManagerSettingSwitchDialog.COUNTRY_CODE_CN;
            }
            new StringBuilder("返回短信中心的区域编码 areaCode=").append(c2948o.f10012c);
            return c2948o.f10012c;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getAreaCodeByCnumOrIccid: " + th.getMessage(), th);
        }
    }

    public static String m13395a(String str, String str2) {
        return C3049n.m13653e(str2) ? String.valueOf(C2978a.m13409c(str)) : "移动".equals(str2) ? "1" : "联通".equals(str2) ? "2" : "电信".equals(str2) ? "3" : "-2";
    }

    static void m13396a(Context context, C2942i c2942i, boolean z) {
        String str = null;
        if (c2942i != null && !C3049n.m13653e(c2942i.f9980b)) {
            long a = C2973a.m13350a(16, 4838400000L);
            boolean z2 = (c2942i == null || C3049n.m13653e(c2942i.f9982d) || !c2942i.f9982d.equals("未知") || c2942i.f9989k + a >= System.currentTimeMillis()) ? (C3049n.m13653e(c2942i.f9982d) && c2942i.f9989k == 0) || (!C3049n.m13653e(c2942i.f9982d) && c2942i.f9989k < System.currentTimeMillis() - a) : true;
            new StringBuilder("loadIccidLocate-------: ").append(c2942i.f9987i).append(HwAccountConstants.BLANK).append(c2942i.f9982d).append(HwAccountConstants.BLANK).append(c2942i.f9988j).append(HwAccountConstants.BLANK).append(c2942i.f9981c).append(" locateEnable: ").append(z2);
            new StringBuilder("info.updateTime < System.currentTimeMillis()-weekTime: ").append((System.currentTimeMillis() - a) - c2942i.f9989k);
            if (z2) {
                String str2;
                String str3 = "";
                if (c2942i != null) {
                    if (!C3049n.m13653e(c2942i.f9983e) && ("10000".equals(c2942i.f9984f.trim()) || ResultCode.ERROR_INTERFACE_GET_APP_DETAIL.equals(c2942i.f9984f.trim()) || "10086".equals(c2942i.f9984f.trim()))) {
                        str3 = c2942i.f9983e;
                    }
                    str = c2942i.f9980b;
                    str2 = str3;
                    str3 = c2942i.f9984f;
                } else {
                    str2 = str3;
                    str3 = null;
                }
                C2978a.m13400a(str2, str, str3, z, true);
            }
        }
    }

    public static void m13397a(String str) {
        C2942i a = C2943j.m13260a(str, C2917a.m13105a());
        if (a != null) {
            C2978a.m13398a(str, a.f9987i, a.f9988j, a.f9992n, a.f9993o, a.f9994p, a.f9990l);
        } else {
            C2978a.m13398a(str, null, null, null, null, -1, 0);
        }
        try {
            if (!C3049n.m13653e(str)) {
                Object obj;
                if (!C3049n.m13653e(str)) {
                    Long l = (Long) f10094e.get(str);
                    if (l != null) {
                        obj = l.longValue() + C2973a.m13350a(4, (long) StatisticConfig.MIN_UPLOAD_INTERVAL) > System.currentTimeMillis() ? 1 : null;
                        if (obj == null) {
                            if (a != null) {
                                C2978a.m13400a(null, str, null, true, true);
                            } else {
                                f10090a.execute(new C2979b(a));
                            }
                        }
                        return;
                    }
                }
                obj = null;
                if (obj == null) {
                    return;
                }
                if (a != null) {
                    f10090a.execute(new C2979b(a));
                } else {
                    C2978a.m13400a(null, str, null, true, true);
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "IccidLocationUtil updateIccidInfo: " + th.getMessage(), th);
        }
    }

    public static void m13398a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        if (str != null) {
            Object obj = (String[]) f10092c.get(str);
            if (obj == null) {
                obj = new String[]{str2, String.valueOf(System.currentTimeMillis()), C2978a.m13395a(str, str3), str4, C2978a.m13395a(null, str5), String.valueOf(i), String.valueOf(i2)};
            } else {
                obj[0] = str2;
                obj[1] = String.valueOf(System.currentTimeMillis());
                obj[2] = C2978a.m13395a(str, str3);
                obj[3] = str4;
                obj[4] = C2978a.m13395a(null, str5);
                obj[5] = String.valueOf(i);
                obj[6] = String.valueOf(i2);
            }
            f10092c.put(str, obj);
        }
    }

    public static void m13400a(String str, String str2, String str3, boolean z, boolean z2) {
        try {
            if (C2996a.m13491a()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!C3049n.m13653e(str2)) {
                    f10094e.put(str2, Long.valueOf(currentTimeMillis));
                }
                if (z) {
                    f10090a.execute(new C2981d(str, str2, str3));
                } else {
                    C2978a.m13407b(str, str2, str3, false);
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "IccidLocationUtil queryIccid: " + th.getMessage(), th);
        }
    }

    public static void m13401a(HashMap<String, String> hashMap, boolean z) {
        if (hashMap != null) {
            C2942i c2942i;
            String str = (String) hashMap.get("simIccid");
            String str2 = (String) hashMap.get("receiveNum");
            String str3 = (String) hashMap.get("centerNum");
            hashMap.get("sceneId");
            hashMap.get(SiteCountryInfo.TAG_SMS);
            hashMap.get("smsLocate");
            C2942i a = str == null ? C2943j.m13258a(C2917a.m13105a()) : C2943j.m13260a(str, C2917a.m13105a());
            if (a == null) {
                a = new C2942i();
                a.f9983e = str3;
                a.f9980b = str;
                a.f9984f = str2;
                c2942i = a;
            } else {
                if (str3 != null && str3.length() > 0 && a.f9983e == null) {
                    a.f9983e = str3;
                }
                if (str2 != null && str2.length() > 0 && a.f9984f == null) {
                    a.f9984f = str2;
                }
                c2942i = a;
            }
            C2943j.m13262a(c2942i.f9980b, str3, str2, C2917a.m13105a());
            Context a2 = C2917a.m13105a();
            C2947n.m13282b(C2917a.m13105a(), "SMSLOCATEENABLE");
            C2978a.m13396a(a2, c2942i, z);
        }
    }

    public static void m13402a(boolean z) {
        if (z || !f10093d) {
            f10093d = true;
            f10092c.clear();
            String b = C3041f.m13609b().m13102b(0);
            String b2 = C3041f.m13609b().m13102b(1);
            if (!C3049n.m13653e(b)) {
                C2978a.m13397a(b);
            }
            if (!C3049n.m13653e(b2)) {
                C2978a.m13397a(b2);
            }
        }
    }

    private static boolean m13403a(String str, String str2, String str3) {
        return (C3049n.m13653e(str2) || !str2.equals(str) || C3049n.m13653e(str3)) ? false : true;
    }

    public static int m13404b(String str) {
        return C3049n.m13653e(str) ? -1 : "10086,1008611,1008601".indexOf(str) != -1 ? 1 : "10010,10011".indexOf(str) != -1 ? 2 : "10000,10001".indexOf(str) != -1 ? 3 : -1;
    }

    public static String m13405b() {
        C2942i a = C2943j.m13258a(C2917a.m13105a());
        return a != null ? a.f9982d : "";
    }

    public static String m13406b(String str, int i) {
        if (!C3049n.m13653e(str)) {
            HashMap hashMap = f10092c;
            if (!f10092c.isEmpty()) {
                String[] strArr = (String[]) f10092c.get(str);
                return (strArr == null || strArr.length <= i) ? null : strArr[i];
            }
        }
        return null;
    }

    private static void m13407b(String str, String str2, String str3, boolean z) {
        try {
            C2996a.m13495b(str2);
            C2904g c2980c = new C2980c(str2, str);
            String a = C2991i.m13449a(str, str2, str3);
            if (!C3049n.m13653e(a)) {
                C2996a.m13489a(a, "990005", c2980c, z, false, LocationManagerProxy.KEY_LOCATION_CHANGED, false);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "queryLocationRequest: " + th.getMessage(), th);
        }
    }

    public static boolean m13408b(boolean z) {
        try {
            if (C2943j.m13258a(C2917a.m13105a()) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("simIccid", C3050o.m13666a());
                C2978a.m13401a(hashMap, z);
                return false;
            }
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "queryAreaCode: " + e.getMessage(), e);
        }
        return true;
    }

    public static int m13409c(String str) {
        if (str != null && str.length() > 6) {
            String substring = str.substring(4, 6);
            if (substring.equals("00") || substring.equals("02") || substring.equals("05") || substring.equals(SNBConstant.PAYMENT_CHANNEL)) {
                return 1;
            }
            if (substring.equals("01")) {
                return 2;
            }
            if (substring.equals("03")) {
                return 3;
            }
        }
        return -2;
    }

    private static String m13410c() {
        String str = null;
        for (Entry value : f10092c.entrySet()) {
            String[] strArr = (String[]) value.getValue();
            String str2 = strArr[0];
            String str3 = strArr[3];
            if (C3049n.m13653e(str3)) {
                if (C3049n.m13653e(str2)) {
                    return null;
                }
                if (str != null && !str.equals(str2)) {
                    return null;
                }
                str = str2;
            } else if (str != null && !str.equals(str3)) {
                return null;
            } else {
                str = str3;
            }
        }
        return str;
    }

    public static void m13411c(String str, int i) {
        C2942i a = C2943j.m13259a(str, i);
        if (a != null) {
            C2978a.m13398a(C3049n.m13653e(str) ? String.valueOf(i) : str, a.f9987i, a.f9988j, a.f9992n, a.f9993o, a.f9994p, a.f9990l);
        }
    }

    private static String m13412d(String str) {
        int i = 0;
        if (f10092c.isEmpty() || C3049n.m13653e(str)) {
            return null;
        }
        try {
            int i2 = 0;
            Object obj = null;
            for (Entry value : f10092c.entrySet()) {
                String[] strArr = (String[]) value.getValue();
                String str2 = strArr[0];
                String str3 = strArr[2];
                String str4 = strArr[3];
                if (C2978a.m13403a(str, strArr[4], str4)) {
                    int i3 = str4.equals(obj) ? i + 1 : i;
                    i2++;
                    obj = str4;
                    i = i3;
                } else if (C3049n.m13653e(str4) && C2978a.m13403a(str, str3, str2)) {
                    if (str2.equals(obj)) {
                        i++;
                    }
                    i2++;
                    obj = str2;
                }
            }
            if (i2 == 1 || (i2 == f10092c.size() && i + 1 == f10092c.size())) {
                return obj;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "IccidLocationUtil getAreaCodeByNumOperator: " + th.getMessage(), th);
        }
        return null;
    }
}
