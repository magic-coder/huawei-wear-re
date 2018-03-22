package com.huawei.pay.p130e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.pay.e.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Util */
public class C5730c {
    public static boolean m26410a(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean m26408a(Context context) {
        if (context == null) {
            return false;
        }
        boolean isAvailable;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                isAvailable = activeNetworkInfo.isAvailable();
                return isAvailable;
            }
            a.d("Network NotAvailable", false);
        }
        isAvailable = false;
        return isAvailable;
    }

    public static String m26407a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        List arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        int i = 0;
        while (i < arrayList.size()) {
            String str = (String) arrayList.get(i);
            if (!"sign".equals(str)) {
                String str2 = (String) map.get(str);
                if (str2 != null) {
                    stringBuffer.append((i == 0 ? "" : SNBConstant.FILTER) + str + "=" + str2);
                }
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static int m26406a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static boolean m26409a(Context context, String str) {
        if (context == null) {
            a.d("isPackageHasInstalled context is null.", false);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            a.c("isPackageHasInstalled packageName is null.", false);
            return false;
        } else {
            String replaceAll = str.replaceAll(HwAccountConstants.BLANK, "");
            for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(0)) {
                if (applicationInfo.packageName.equals(replaceAll)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean m26411b(Context context) {
        return Secure.getInt(context.getContentResolver(), "fp_shortcut_enabled", 0) != 0;
    }

    public static boolean m26412c(Context context) {
        return false;
    }
}
