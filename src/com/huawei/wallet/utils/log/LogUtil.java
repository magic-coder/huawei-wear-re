package com.huawei.wallet.utils.log;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.common.applog.AppLogApi;
import com.huawei.feedback.bean.MetadataBundle;
import com.huawei.p190v.C2538c;
import java.util.regex.Pattern;

public class LogUtil {
    private static final boolean f21616a = m28545b();
    private static final boolean f21617b;
    private static final Pattern f21618c = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    private static Context f21619d;
    private static String f21620e;
    private static String f21621f;

    static {
        boolean z;
        if (f21616a) {
            z = true;
        } else {
            z = Log.isLoggable("wallet", 3) ? false : false;
        }
        f21617b = z;
    }

    public static boolean m28542a() {
        return f21617b;
    }

    private static boolean m28545b() {
        try {
            return Log.class.getDeclaredField("HWLog").getBoolean(null);
        } catch (NoSuchFieldException e) {
            Log.e("wallet", "[getHWLog]:  can not find HwLog!");
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e("wallet", "getHWLog is IllegalArgumentException", null);
            return false;
        } catch (IllegalAccessException e3) {
            Log.e("wallet", "getHWLog is IllegalAccessException", null);
            return false;
        } catch (Exception e4) {
            Log.e("wallet", "getHWLog is Exception", null);
            return false;
        }
    }

    public static MetadataBundle m28536a(int i) {
        return new MetadataBundle(i, f21620e, f21621f);
    }

    private static String m28543b(String str, String str2, Throwable th, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str).append("    ");
        }
        if (!TextUtils.isEmpty(str2)) {
            if (z) {
                stringBuilder.append(m28537a(str2));
            } else {
                stringBuilder.append(str2);
            }
        }
        if (th != null) {
            stringBuilder.append("    ").append(m28538a(th));
        }
        return stringBuilder.toString();
    }

    public static void m28541a(String str, String str2, boolean z) {
        if (f21617b && !TextUtils.isEmpty(str2)) {
            C2538c.b("wallet", new Object[]{m28543b(str, str2, null, z)});
        }
    }

    public static void m28544b(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            String b = m28543b(str, str2, null, z);
            Log.i("wallet", b);
            AppLogApi.i("wallet", b);
        }
    }

    public static void m28540a(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            String b = m28543b(str, str2, th, z);
            Log.e("wallet", b, th);
            AppLogApi.e("wallet", b);
        }
    }

    public static void m28539a(String str, String str2, Throwable th, int i, MetadataBundle metadataBundle, boolean z, boolean z2) {
        if (metadataBundle != null) {
            String a;
            if (th != null) {
                a = m28538a(th);
            } else {
                a = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("MetaData", metadataBundle.toString());
            StringBuilder stringBuilder = new StringBuilder(m28543b(str, str2, null, z));
            if (a != null) {
                stringBuilder.append(a);
            }
            AppLogApi.e("wallet", stringBuilder.toString());
            AppLogApi.e("wallet", String.valueOf(i), bundle, Boolean.valueOf(z2), m28543b(str, str2, null, z), f21619d);
        }
    }

    public static String m28538a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static String m28537a(String str) {
        int i = 1;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            CharSequence valueOf = String.valueOf(charAt);
            if (!TextUtils.isEmpty(valueOf) && f21618c.matcher(valueOf).matches()) {
                if (i % 2 == 0) {
                    charAt = '*';
                }
                i++;
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }
}
