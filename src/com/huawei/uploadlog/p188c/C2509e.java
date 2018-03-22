package com.huawei.uploadlog.p188c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.huawei.androidcommon.utils.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DeviceUtils */
public class C2509e {
    public static String m12472a(Context context) {
        try {
            String str = "^[0-9a-zA-Z]+$";
            String a = C2514j.m12507a(context);
            Matcher matcher = Pattern.compile(str).matcher(a);
            if (!C2517m.m12573a(a, "0") && !StringUtils.isNullOrEmpty(a) && matcher.matches()) {
                return a;
            }
            int i = 0;
            while (i < 5) {
                a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                Matcher matcher2 = Pattern.compile(str).matcher(a);
                if (C2517m.m12573a(a, "0") || !matcher2.matches()) {
                    i++;
                } else {
                    C2514j.m12511a(context, a);
                    return a;
                }
            }
            return a;
        } catch (Throwable e) {
            C2511g.m12482b("BetaClub Upload", "[Deviceutils.getIMEI] error:", e);
            return "0";
        }
    }
}
