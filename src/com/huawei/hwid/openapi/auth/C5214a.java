package com.huawei.hwid.openapi.auth;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.C5250e;
import com.huawei.hwid.openapi.p445e.C5251f;
import com.huawei.hwid.openapi.p445e.p447b.C5245a;
import com.huawei.hwid.openapi.p445e.p448c.C5247a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.constant.WBConstants;

public class C5214a {
    private static String f18819a = C5213b.f18818a;

    private static void m25353a(Activity activity) {
        C5250e.m25456c(activity);
        WebView.enablePlatformNotifications();
    }

    public static void m25354a(C5212a c5212a) {
        C5248c.m25447b(f18819a, "enter authorize, redirectUrl:" + c5212a.f18810f);
        C5214a.m25353a(c5212a.f18805a);
        CookieSyncManager.createInstance(c5212a.f18805a);
        Bundle bundle = new Bundle();
        bundle.putString(WBConstants.AUTH_PARAMS_CLIENT_ID, c5212a.f18808d);
        bundle.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, c5212a.f18810f);
        bundle.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, c5212a.f18809e);
        bundle.putString(WBConstants.AUTH_PARAMS_DISPLAY, c5212a.f18813i);
        bundle.putString("scope", c5212a.f18811g);
        bundle.putBoolean("download", true);
        bundle.putString(SMSKeyInfo.TAG_LANG, C5247a.m25439a());
        if (c5212a.f18815k != null) {
            bundle.putInt("deviceType", c5212a.f18815k.intValue());
        }
        if (TextUtils.isEmpty(c5212a.f18816l)) {
            bundle.putString(SNBConstant.FIELD_DEVICE_ID, c5212a.f18816l);
        }
        if (!(c5212a.f18807c == null || c5212a.f18807c.isEmpty())) {
            bundle.putAll(c5212a.f18807c);
        }
        if (!TextUtils.isEmpty(c5212a.f18814j)) {
            bundle.putString(SNBConstant.FIELD_DEVICE_ID, C5251f.m25458a(c5212a.f18805a));
            bundle.putString("device_type", C5251f.m25459a(c5212a.f18805a, C5251f.m25458a(c5212a.f18805a)));
            if (!TextUtils.isEmpty(c5212a.f18812h)) {
                bundle.putString("device_type", C5251f.m25459a(c5212a.f18805a, C5251f.m25458a(c5212a.f18805a)));
            }
            bundle.putString("sso_st", c5212a.f18814j);
        }
        new C5218e(c5212a, "https://login.vmall.com/oauth2/authorize?" + C5245a.m25428a(bundle)).show();
    }
}
