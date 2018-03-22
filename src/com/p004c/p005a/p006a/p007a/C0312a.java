package com.p004c.p005a.p006a.p007a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.p004c.p005a.p008b.p009a.C0313a;

public final class C0312a {
    public static String m127a(Context context) {
        StringBuffer stringBuffer = new StringBuffer("1.0");
        String a = C0313a.m130a(context);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C0313a.m146h();
            return null;
        }
        String b;
        Configuration configuration = context.getResources().getConfiguration();
        String str = "";
        if (!(configuration == null || configuration.locale == null)) {
            str = configuration.locale.toString();
        }
        String str2 = "";
        try {
            b = C0313a.m135b(telephonyManager.getDeviceId());
        } catch (SecurityException e) {
            e.printStackTrace();
            b = str2;
        }
        str2 = C0313a.m141e(context);
        if (C0313a.m144f(context)) {
            stringBuffer.append(",").append("Android" + VERSION.RELEASE).append(",").append(str).append(",").append(Build.MODEL).append(",").append(Build.DISPLAY).append(",").append(str2).append(",").append(b).append(",").append(a).append(",").append(C0313a.m134b(context));
            C0313a.m146h();
        } else {
            stringBuffer.append(",,,,,").append(str2).append(",").append(b).append(",").append(a).append(",");
            C0313a.m146h();
        }
        return stringBuffer.toString();
    }
}
