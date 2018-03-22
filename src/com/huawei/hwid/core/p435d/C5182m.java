package com.huawei.hwid.core.p435d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.p434c.C5147a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.core.p435d.p439c.C5168a;
import com.huawei.hwid.core.p435d.p439c.C5169b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: TerminalInfo */
public class C5182m {
    private static long f18654a = -1;
    private static int f18655b = 0;
    private static int f18656c = 1;
    private static String f18657d = "";
    private static String f18658e = "";
    private static String f18659f = "";

    public static String m25047a(Context context) {
        if (-1 == f18654a) {
            C5182m.m25051a(C5147a.m24824a(context).m24826a("DEVTP", -1));
            if (-1 == f18654a && (VERSION.SDK_INT <= 22 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    C5182m.m25051a((long) telephonyManager.getPhoneType());
                }
            }
        }
        C5165e.m24912e("TerminalInfo", "deviceType= " + f18654a);
        if (2 == f18654a) {
            C5147a.m24824a(context).m24830b("DEVTP", 2);
            return "2";
        }
        C5147a.m24824a(context).m24830b("DEVTP", 0);
        return "0";
    }

    public static String m25049a(Context context, String str) {
        if (-1 == f18654a) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                C5182m.m25051a((long) telephonyManager.getPhoneType());
            }
        }
        C5165e.m24912e("TerminalInfo", "deviceType= " + f18654a);
        if (2 == f18654a) {
            return "2";
        }
        if (C5182m.m25048a(context, 0).equals(str)) {
            return "6";
        }
        return "0";
    }

    private static synchronized void m25051a(long j) {
        synchronized (C5182m.class) {
            f18654a = j;
        }
    }

    public static String m25046a() {
        String str = "";
        str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        try {
            C5165e.m24904a("TerminalInfo", "TerminalType is: " + str);
            str = URLEncoder.encode(str, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C5165e.m24910d("TerminalInfo", "in getTerminalType Unsupported encoding exception");
        }
        return str;
    }

    public static String m25053b() {
        String str = "";
        str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        C5165e.m24904a("TerminalInfo", "getTerminalTypeWhenXML TerminalType is: " + str);
        return str;
    }

    public static String m25054b(Context context) {
        String c = C5182m.m25058c(context);
        if (c == null || DateLayout.NULL_DATE_FORMAT.equals(c)) {
            c = C5182m.m25048a(context, 0);
        }
        C5165e.m24904a("TerminalInfo", "UnitedId= " + C5203g.m25316a(c));
        return c;
    }

    public static String m25058c(Context context) {
        String d = C5182m.m25060d(context);
        if (!C5166b.m24950f() || C5166b.m24946e() || DateLayout.NULL_DATE_FORMAT.equals(d)) {
            return d;
        }
        return d + HwAccountConstants.SPLIIT_UNDERLINE + C5166b.m24940d();
    }

    public static String m25060d(Context context) {
        if (TextUtils.isEmpty(f18657d)) {
            String a = C5147a.m24824a(context).m24827a("DEVID_1", "");
            if (!TextUtils.isEmpty(a)) {
                if (TextUtils.isEmpty(a) || !C5166b.m24931a(a)) {
                    C5165e.m24910d("TerminalInfo", "cbcDecrypter devid failed!!!");
                    C5147a.m24824a(context).m24828a("DEVID_1");
                    f18657d = null;
                } else {
                    C5182m.m25052a(a);
                    return a;
                }
            }
            if (VERSION.SDK_INT <= 22 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    C5182m.m25052a(telephonyManager.getDeviceId());
                }
            }
            if (TextUtils.isEmpty(f18657d) || "unknown".equalsIgnoreCase(f18657d)) {
                return DateLayout.NULL_DATE_FORMAT;
            }
            C5147a.m24824a(context).m24831b("DEVID_1", f18657d);
        }
        return f18657d;
    }

    public static String m25061e(Context context) {
        if (!C5166b.m24950f() || C5166b.m24946e()) {
            return C5182m.m25062f(context);
        }
        return C5182m.m25062f(context) + HwAccountConstants.SPLIIT_UNDERLINE + C5166b.m24940d();
    }

    public static String m25062f(Context context) {
        if (TextUtils.isEmpty(f18658e)) {
            C5182m.m25056b(C5147a.m24824a(context).m24827a("SUBDEVID", ""));
            if (TextUtils.isEmpty(f18658e) || !C5166b.m24931a(f18658e)) {
                C5182m.m25052a(C5182m.m25060d(context));
                String g = C5182m.m25063g(context);
                if (!TextUtils.isEmpty(g)) {
                    C5182m.m25056b(g);
                } else if (C5169b.m24971b()) {
                    g = C5182m.m25064h(context);
                    if (g == null || !g.equals(f18657d)) {
                        C5182m.m25056b(g);
                    } else {
                        C5182m.m25056b(C5182m.m25065i(context));
                        if (f18658e == null || f18658e.equals(f18657d)) {
                            C5182m.m25056b(DateLayout.NULL_DATE_FORMAT);
                        }
                    }
                } else {
                    C5182m.m25056b(DateLayout.NULL_DATE_FORMAT);
                }
                if (TextUtils.isEmpty(f18658e) || "unknown".equalsIgnoreCase(f18658e)) {
                    return DateLayout.NULL_DATE_FORMAT;
                }
                C5147a.m24824a(context).m24831b("SUBDEVID", f18658e);
            } else {
                C5182m.m25056b(f18658e);
            }
        }
        C5165e.m24904a("TerminalInfo", "getNextDeviceIdOldWay :" + C5203g.m25316a(f18658e));
        return f18658e;
    }

    public static String m25063g(Context context) {
        if (context == null) {
            return "";
        }
        String str = "";
        if (VERSION.SDK_INT > 22 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String a = C5182m.m25050a(telephonyManager, f18655b);
        if (!TextUtils.isEmpty(a) && !a.equals(f18657d)) {
            return a;
        }
        str = C5182m.m25050a(telephonyManager, f18656c);
        return (TextUtils.isEmpty(str) || str.equals(f18657d)) ? "" : str;
    }

    private static String m25050a(TelephonyManager telephonyManager, int i) {
        if (VERSION.SDK_INT < 23) {
            C5165e.m24908c("TerminalInfo", "newDeviceId apilevel <23");
            return "";
        } else if (telephonyManager == null || (i != f18655b && i != f18656c)) {
            return "";
        } else {
            try {
                return telephonyManager.getDeviceId(i);
            } catch (Error e) {
                return "";
            } catch (Exception e2) {
                return "";
            }
        }
    }

    private static synchronized void m25052a(String str) {
        synchronized (C5182m.class) {
            if (str == null) {
                f18657d = "";
            } else {
                f18657d = str;
            }
        }
    }

    private static synchronized void m25056b(String str) {
        synchronized (C5182m.class) {
            if (str == null) {
                f18658e = "";
            } else {
                f18658e = str;
            }
        }
    }

    public static String m25064h(Context context) {
        String str = "";
        if (C5169b.m24971b()) {
            C5165e.m24904a("TerminalInfo", "multicard device");
            return C5169b.m24969a().mo4643a(0);
        }
        if (VERSION.SDK_INT <= 22 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getDeviceId();
            }
        }
        return str;
    }

    public static String m25065i(Context context) {
        String str = "";
        if (C5169b.m24971b()) {
            str = C5169b.m24969a().mo4643a(1);
        }
        C5165e.m24904a("TerminalInfo", "in getNextDeviceId isMultiSimEnabled:" + C5169b.m24971b() + " nextDeviceId:" + C5203g.m25316a(str));
        return str;
    }

    public static String m25048a(Context context, int i) {
        if (i >= 2) {
            return DateLayout.NULL_DATE_FORMAT;
        }
        int i2 = i + 1;
        if (TextUtils.isEmpty(f18659f)) {
            C5182m.m25059c(C5147a.m24824a(context).m24827a("UUID", ""));
            if (TextUtils.isEmpty(f18659f)) {
                C5182m.m25059c(UUID.randomUUID().toString());
                if (TextUtils.isEmpty(f18659f)) {
                    return DateLayout.NULL_DATE_FORMAT;
                }
                C5147a.m24824a(context).m24831b("UUID", f18659f);
            }
        }
        if (!TextUtils.isEmpty(f18659f) && f18659f.length() > 40) {
            f18659f = "";
            C5147a.m24824a(context).m24828a("UUID");
            f18659f = C5182m.m25048a(context, i2);
        }
        C5165e.m24904a("TerminalInfo", "getUUid :" + C5203g.m25316a(f18659f));
        return f18659f;
    }

    private static synchronized void m25059c(String str) {
        synchronized (C5182m.class) {
            f18659f = str;
        }
    }

    public static String m25055b(Context context, int i) {
        String str = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (C5169b.m24971b()) {
            CharSequence d;
            C5168a a = C5169b.m24969a();
            if (i == HwAccountConstants.NO_SUBID) {
                i = a.mo4642a();
            }
            if (5 == a.mo4645c(i)) {
                d = a.mo4646d(i);
                if (TextUtils.isEmpty(d)) {
                    d = a.mo4644b(i);
                    if (!TextUtils.isEmpty(d)) {
                        d = d.substring(0, 5);
                    }
                }
            } else {
                Object obj = str;
            }
            str = d;
        } else if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
            str = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(str)) {
                str = telephonyManager.getSubscriberId();
                if (!TextUtils.isEmpty(str)) {
                    str = str.substring(0, 5);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = HwAccountConstants.DEFAULT_DEVICEPLMN;
        }
        C5165e.m24904a("TerminalInfo", "getDevicePLMN = " + C5203g.m25316a(str));
        return str;
    }

    public static String m25057c() {
        return VERSION.RELEASE;
    }
}
