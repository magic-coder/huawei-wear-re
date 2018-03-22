package com.huawei.multisimsdk.multidevicemanager.p105e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.multisimsdk.multidevicemanager.common.C1158j;
import com.huawei.multisimsdk.multidevicemanager.common.InProgressData;
import com.huawei.multisimsdk.multidevicemanager.p103b.C1132a;
import com.huawei.multisimsdk.multidevicemanager.p104c.C1135b;
import com.huawei.multisimsdk.multidevicemanager.p105e.p107a.C1173a;

/* compiled from: Utils */
public class C1185k {
    private static final String f2602a = C1185k.class.getSimpleName();
    private static ConnectivityManager f2603b;
    private static final Character f2604c = Character.valueOf('{');

    public static int m5290a() {
        return ((int) (Math.random() * 100000.0d)) + 1;
    }

    public static String m5292a(Context context, String str, String str2) {
        String c = C1185k.m5302c(str);
        SharedPreferences sharedPreferences = null;
        StringBuffer stringBuffer = new StringBuffer("");
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("MultiSIM_info", 0);
        }
        if (sharedPreferences == null || str2 == null || str2.isEmpty()) {
            return "";
        }
        String string = sharedPreferences.getString(stringBuffer.append(c).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).toString(), "");
        if ("".equals(string)) {
            return "";
        }
        return C1173a.m5249b(context, string);
    }

    public static void m5300b(Context context, String str, String str2) {
        C1185k.m5298a(context, str, "Tag", str2);
        C1185k.m5298a(context, str2, "Tag", str);
    }

    public static boolean m5298a(Context context, String str, String str2, String str3) {
        String c = C1185k.m5302c(str);
        StringBuffer stringBuffer = new StringBuffer("");
        String a = C1173a.m5243a(context, str3);
        SharedPreferences sharedPreferences = null;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("MultiSIM_info", 0);
        }
        if (sharedPreferences == null || str2 == null || str2.isEmpty()) {
            return false;
        }
        String stringBuffer2 = stringBuffer.append(c).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).toString();
        Editor edit = sharedPreferences.edit();
        if (!"".equals(sharedPreferences.getString(stringBuffer2, ""))) {
            edit.remove(stringBuffer2);
        }
        edit.putString(stringBuffer2, a);
        edit.commit();
        return true;
    }

    public static boolean m5303c(Context context, String str, String str2) {
        String c = C1185k.m5302c(str);
        StringBuffer stringBuffer = new StringBuffer("");
        SharedPreferences sharedPreferences = null;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("MultiSIM_info", 0);
        }
        if (sharedPreferences == null || str2 == null || str2.isEmpty()) {
            return false;
        }
        String stringBuffer2 = stringBuffer.append(c).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).toString();
        Editor edit = sharedPreferences.edit();
        if (!"".equals(sharedPreferences.getString(stringBuffer2, ""))) {
            edit.remove(stringBuffer2);
        }
        edit.commit();
        return true;
    }

    private static String m5302c(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length > 5) {
            return str.substring(length - 5, length);
        }
        return null;
    }

    public static C1158j m5291a(Context context, String str) {
        C1158j c1158j = new C1158j();
        c1158j.m5171a(C1185k.m5290a());
        c1158j.m5172a("DevAuth");
        c1158j.m5174b("Token");
        c1158j.m5176d(C1185k.m5292a(context, str, "authen_Token"));
        return c1158j;
    }

    public static void m5294a(int i, InProgressData inProgressData) {
        Handler b = C1132a.m5034a().m5050b();
        if (b != null) {
            b.sendMessage(b.obtainMessage(i, inProgressData));
        }
    }

    public static boolean m5297a(Context context) {
        if (context != null) {
            if (f2603b == null) {
                f2603b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f2603b.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static void m5295a(Message message) {
        if (message != null && message.getTarget() != null) {
            try {
                message.sendToTarget();
            } catch (IllegalStateException e) {
                C1183h.m5286d(f2602a, "don't send again!!");
            }
        }
    }

    public static boolean m5299a(String str) {
        return (str == null || str.length() <= 1 || f2604c.charValue() == str.charAt(0)) ? false : true;
    }

    public static String m5293a(InProgressData inProgressData) {
        String primary;
        String str = null;
        if (inProgressData != null) {
            primary = inProgressData.getPrimary();
            str = inProgressData.getPrimaryIDtype();
        } else {
            primary = null;
        }
        return C1135b.m5056a(str, primary);
    }

    public static void m5296a(Message message, int i) {
        if (message != null) {
            C1183h.m5282b(f2602a, "sendMessagewitharg1 arg1 :" + i);
            message.arg1 = i;
            C1185k.m5295a(message);
        }
    }

    public static boolean m5301b(String str) {
        if (TextUtils.isEmpty(str) || !str.matches("[0-9]{2,3}")) {
            return false;
        }
        C1183h.m5282b(f2602a, "http connect result is match digital, result:" + str);
        return true;
    }
}
