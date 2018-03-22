package com.huawei.hwid.openapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import com.huawei.hwid.openapi.out.ResReqHandler;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p441b.C5227a;
import com.huawei.hwid.openapi.p441b.C5229c;
import com.huawei.hwid.openapi.p441b.C5230d;
import com.huawei.hwid.openapi.p442c.C5231a;
import com.huawei.hwid.openapi.p443d.p444a.C5237a;
import com.huawei.hwid.openapi.p445e.C5248c;
import java.util.HashMap;

public class OpenHwID {
    private static C5231a f18804a = null;

    public static void authorize(Activity activity, ResReqHandler resReqHandler, String str, Bundle bundle) {
        authorize(activity, null, resReqHandler, str, bundle);
    }

    public static void authorize(Activity activity, String str, ResReqHandler resReqHandler, String str2, Bundle bundle) {
        authorize(activity, str, resReqHandler, str2, null, bundle);
    }

    public static void authorize(Activity activity, String str, ResReqHandler resReqHandler, String str2, String str3, Bundle bundle) {
        authorize(activity, str, null, null, resReqHandler, str2, str3, bundle);
    }

    public static void authorize(Activity activity, String str, String str2, String str3, ResReqHandler resReqHandler, String str4, String str5, Bundle bundle) {
        C5227a.m25370a(new C5212a(activity, resReqHandler, str4, null, str2, str, null, str3, str5, null, null, 0, bundle));
    }

    public static String getAccessToken(Context context, String str, String str2, Bundle bundle) {
        return C5230d.m25373a(context, str, str2, bundle);
    }

    public static HashMap getUserInfo() {
        if (f18804a != null) {
            return f18804a.m25394c();
        }
        C5248c.m25450d("OpenHwID", "when call getUserInfo, mHwIDAdapter is null");
        return new HashMap();
    }

    public static void logOut(Context context, String str, String str2, Bundle bundle) {
        C5230d.m25375b(context, str, str2, bundle);
    }

    public static void login(Bundle bundle) {
        if (f18804a == null) {
            C5248c.m25450d("OpenHwID", "when call login, mHwIDAdapter is null");
        } else {
            f18804a.m25393b();
        }
    }

    public static void logout() {
        if (f18804a == null) {
            C5248c.m25450d("OpenHwID", "when call logout, mHwIDAdapter is null");
        } else {
            f18804a.m25395d();
        }
    }

    public static void releaseResouce() {
        if (f18804a == null) {
            f18804a = null;
        }
    }

    public static void setLoginProxy(Activity activity, String str, IHwIDCallBack iHwIDCallBack, Bundle bundle) {
        f18804a = new C5231a(activity, str, iHwIDCallBack, bundle);
    }

    public static void setPorxy(String str, int i, Bundle bundle) {
    }

    public static Boolean storeAccessToken(Context context, String str, String str2, String str3, Bundle bundle) {
        return Boolean.valueOf(C5230d.m25374a(context, str, str2, str3, bundle));
    }

    public static void userInfoRequest(Context context, ResReqHandler resReqHandler, String str) {
        C5229c.m25372a(context, new C5237a(str), resReqHandler);
    }

    public static void userInfoRequest(Context context, ResReqHandler resReqHandler, String str, int i, Bundle bundle) {
        C5229c.m25372a(context, new C5237a(str, i), resReqHandler);
    }
}
