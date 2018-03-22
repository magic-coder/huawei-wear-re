package com.huawei.hwid.openapi.p441b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5246b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;

public class C5230d {
    private static final String f18855a = C5213b.f18818a;

    public static String m25373a(Context context, String str, String str2, Bundle bundle) {
        if (str2 == null) {
            str2 = "";
        }
        Object obj = "";
        try {
            obj = C5246b.m25438b(context, str + HwAccountConstants.SPLIIT_UNDERLINE + str2, "");
        } catch (Throwable e) {
            C5248c.m25448b(f18855a, e.toString(), e);
        }
        if (TextUtils.isEmpty(obj)) {
            C5248c.m25450d(f18855a, "token is not exist for:" + C5243e.m25423a(str) + HwAccountConstants.SPLIIT_UNDERLINE + str2);
        }
        return obj;
    }

    public static boolean m25374a(Context context, String str, String str2, String str3, Bundle bundle) {
        try {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
                C5248c.m25448b(f18855a, "in store Token token:" + str3 + " clientId:" + C5243e.m25423a(str) + " is invalid", null);
                return false;
            }
            if (str2 == null) {
                str2 = "";
            }
            C5246b.m25437a(context, str + HwAccountConstants.SPLIIT_UNDERLINE + str2, str3);
            return true;
        } catch (Throwable e) {
            C5248c.m25448b(f18855a, "storeToken InvalidKeyException: " + e.toString(), e);
            return false;
        } catch (Throwable e2) {
            C5248c.m25448b(f18855a, "storeToken BadPaddingException: " + e2.toString(), e2);
            return false;
        } catch (Throwable e22) {
            C5248c.m25448b(f18855a, "storeToken IllegalBlockSizeException: " + e22.toString(), e22);
            return false;
        } catch (Throwable e222) {
            C5248c.m25448b(f18855a, "storeToken NoSuchAlgorithmException: " + e222.toString(), e222);
            return false;
        } catch (Throwable e2222) {
            C5248c.m25448b(f18855a, "storeToken NoSuchPaddingException: " + e2222.toString(), e2222);
            return false;
        } catch (Throwable e22222) {
            C5248c.m25448b(f18855a, "storeToken Exception: " + e22222.toString(), e22222);
            return false;
        }
    }

    public static void m25375b(Context context, String str, String str2, Bundle bundle) {
        if (str != null) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                C5246b.m25436a(context, str + HwAccountConstants.SPLIIT_UNDERLINE + str2);
            } catch (Throwable e) {
                C5248c.m25448b(f18855a, e.toString(), e);
            }
        }
    }
}
