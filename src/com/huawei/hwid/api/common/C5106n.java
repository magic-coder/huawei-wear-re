package com.huawei.hwid.api.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p429a.C5117b;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: SDKUtil */
public class C5106n {
    private static LoginHandler f18411a;
    private static C5117b f18412b;
    private static boolean f18413c = true;
    private static String f18414d;

    public static synchronized void m24586a(LoginHandler loginHandler) {
        synchronized (C5106n.class) {
            f18411a = loginHandler;
            C5165e.m24906b("SDKUtil", "setHandler, mHandler is " + f18411a);
        }
    }

    public static LoginHandler m24581a() {
        C5165e.m24906b("SDKUtil", "getHandler, mHandler is " + f18411a);
        return f18411a;
    }

    public static synchronized void m24587a(C5117b c5117b) {
        synchronized (C5106n.class) {
            f18412b = c5117b;
            C5165e.m24906b("SDKUtil", "setOpLogItem");
        }
    }

    public static C5117b m24592b() {
        C5165e.m24906b("SDKUtil", "getOpLogItem ");
        return f18412b;
    }

    public static String m24584a(boolean z, boolean z2) {
        return String.format("{aidl:%s,needauth:%s}", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public static synchronized void m24588a(boolean z) {
        synchronized (C5106n.class) {
            f18413c = z;
            C5165e.m24906b("SDKUtil", "setNeedInit, mNeedInit is " + f18413c);
        }
    }

    public static boolean m24595c() {
        C5165e.m24906b("SDKUtil", "isNeedInit, mNeedInit is " + f18413c);
        return f18413c;
    }

    public static synchronized void m24585a(Context context, String str) {
        synchronized (C5106n.class) {
            f18414d = str;
            C5176g.m25009a(context, "curName", f18414d);
            C5165e.m24906b("SDKUtil", "setCurrentLoginUserName, mCurrentLoginUserName is " + C5203g.m25322d(f18414d));
        }
    }

    public static String m24583a(Context context) {
        if (TextUtils.isEmpty(f18414d)) {
            C5106n.m24585a(context, C5176g.m25017b(context, "curName"));
        }
        C5165e.m24906b("SDKUtil", "getCurrentLoginUserName, mCurrentLoginUserName is " + C5203g.m25322d(f18414d));
        return f18414d;
    }

    public static boolean m24593b(Context context) {
        if (context != null) {
            return C5166b.m24958j(context);
        }
        C5165e.m24906b("SDKUtil", "context is null");
        return false;
    }

    public static boolean m24589a(Context context, int i) {
        if (context == null) {
            C5165e.m24906b("SDKUtil", "context is null");
            return false;
        } else if (C5106n.m24596d(context) < i) {
            return true;
        } else {
            return false;
        }
    }

    static boolean m24591a(Context context, CloudRequestHandler cloudRequestHandler) {
        if (cloudRequestHandler == null) {
            C5165e.m24906b("SDKUtil", "requestHandler is null");
            return false;
        } else if (context != null) {
            return true;
        } else {
            C5165e.m24906b("SDKUtil", "context is null");
            cloudRequestHandler.onError(new ErrorStatus(12, "context is null"));
            return false;
        }
    }

    static HwAccount m24582a(Context context, Bundle bundle) {
        HwAccount hwAccount = new HwAccount();
        if (bundle != null) {
            String string = bundle.getString("accountName");
            String string2 = bundle.getString("userId");
            String string3 = bundle.getString("deviceId");
            String string4 = bundle.getString("subDeviceId");
            String string5 = bundle.getString("deviceType");
            int i = bundle.getInt("siteId");
            String string6 = bundle.getString("serviceToken");
            String string7 = bundle.getString("accountType");
            String string8 = bundle.getString("loginUserName");
            String string9 = bundle.getString("countryIsoCode");
            hwAccount.m25121b(string);
            hwAccount.m25133h(string3);
            hwAccount.m25135i(string4);
            hwAccount.m25137j(string5);
            hwAccount.m25118a(i);
            hwAccount.m25129f(string6);
            hwAccount.m25125d(string2);
            hwAccount.m25123c(C5166b.m24960l(context));
            hwAccount.m25131g(string7);
            hwAccount.m25139k(string8);
            hwAccount.m25119a(string9);
        }
        return hwAccount;
    }

    public static String m24594c(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
            C5165e.m24906b("SDKUtil", "versionName " + str);
            return str;
        } catch (NameNotFoundException e) {
            C5165e.m24910d("SDKUtil", "getVersionTag error = " + e.getMessage());
        } catch (Exception e2) {
            C5165e.m24910d("SDKUtil", "getVersionTag error" + e2.getMessage());
        }
        return "";
    }

    public static int m24596d(Context context) {
        try {
            int i = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionCode;
            C5165e.m24906b("SDKUtil", "versionCode " + i);
            return i;
        } catch (NameNotFoundException e) {
            C5165e.m24910d("SDKUtil", "getVersionTag error" + e.getMessage());
        } catch (Exception e2) {
            C5165e.m24910d("SDKUtil", "getVersionTag error" + e2.getMessage());
        }
        return 0;
    }

    public static boolean m24590a(Context context, Intent intent) {
        if (intent == null || context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
            return false;
        }
        return true;
    }
}
