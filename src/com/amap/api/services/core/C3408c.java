package com.amap.api.services.core;

import com.amap.api.services.core.ad.C3390a;

/* compiled from: ConfigableConst */
public class C3408c {
    public static final String[] f12480a = new String[]{"com.amap.api.services"};

    public static String m16874a() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restapi.amap.com/v3";
        }
        return "https://restapi.amap.com/v3";
    }

    public static String m16875b() {
        return ServiceSettings.getInstance().getLanguage();
    }

    public static ad m16873a(boolean z) {
        String str = "getSDKInfo";
        ad adVar = null;
        try {
            adVar = new C3390a("sea", "2.5.0", "AMAP SDK Android Search 2.5.0").m16611a(f12480a).m16610a(z).m16612a();
        } catch (Throwable e) {
            C3409d.m16881a(e, "ConfigableConst", str);
        }
        return adVar;
    }
}
