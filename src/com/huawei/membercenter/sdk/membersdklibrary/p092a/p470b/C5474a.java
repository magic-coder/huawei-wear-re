package com.huawei.membercenter.sdk.membersdklibrary.p092a.p470b;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p470b.p471a.C5472e;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5486h;

/* compiled from: DeviceProperty */
public class C5474a {
    private static String f19329a = "";
    private static String f19330b = "";

    public static String m26168a(Context context) {
        if (context == null) {
            return "";
        }
        if (C5474a.m26172c(context)) {
            return f19329a;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            f19329a = telephonyManager.getDeviceId();
        }
        if (TextUtils.isEmpty(f19329a)) {
            f19329a = C5474a.m26171b(context);
        }
        return f19329a;
    }

    public static String m26170a(String str, Context context) {
        if (TextUtils.isEmpty(str) || context == null) {
            return "";
        }
        if (!C5474a.m26172c(context)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            f19330b = C5474a.m26169a(telephonyManager, 0);
            if (!TextUtils.isEmpty(f19330b) && !f19330b.equals(str)) {
                return f19330b;
            }
            f19330b = C5474a.m26169a(telephonyManager, 1);
            if (!TextUtils.isEmpty(f19330b) && !f19330b.equals(str)) {
                return f19330b;
            }
            f19330b = C5474a.m26167a(0);
            if (!TextUtils.isEmpty(f19330b) && !f19330b.equals(str)) {
                return f19330b;
            }
            f19330b = C5474a.m26167a(1);
            if (TextUtils.isEmpty(f19330b) || f19330b.equals(str)) {
                return "";
            }
            return f19330b;
        } else if (TextUtils.isEmpty(f19330b) || f19330b.equals(str)) {
            return "";
        } else {
            return f19330b;
        }
    }

    private static String m26171b(Context context) {
        if (C5474a.m26172c(context)) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        CharSequence a = C5474a.m26169a(telephonyManager, 0);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = C5474a.m26169a(telephonyManager, 1);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        a2 = C5474a.m26167a(0);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        a2 = C5474a.m26167a(1);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    private static String m26169a(TelephonyManager telephonyManager, int i) {
        String str = null;
        if (C5474a.m26166a() >= 23 && telephonyManager != null && (i == 0 || i == 1)) {
            try {
                str = telephonyManager.getDeviceId(i);
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
        return str;
    }

    private static int m26166a() {
        return VERSION.SDK_INT;
    }

    private static String m26167a(int i) {
        if (C5472e.m26157a().m26163b() == null) {
            return null;
        }
        if (i == 0 || i == 1) {
            return C5472e.m26157a().m26162a(i);
        }
        return null;
    }

    private static boolean m26172c(Context context) {
        if (C5486h.m26204a(context) || VERSION.SDK_INT <= 22 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return false;
        }
        return true;
    }
}
