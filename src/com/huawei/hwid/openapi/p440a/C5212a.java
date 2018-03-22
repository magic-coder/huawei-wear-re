package com.huawei.hwid.openapi.p440a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.out.ResReqHandler;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.constant.WBConstants;

public class C5212a {
    public Activity f18805a;
    public ResReqHandler f18806b;
    public Bundle f18807c;
    public String f18808d;
    public String f18809e;
    public String f18810f;
    public String f18811g;
    public String f18812h;
    public String f18813i;
    public String f18814j;
    public Integer f18815k;
    public String f18816l;
    public int f18817m = 0;

    public C5212a(Activity activity, ResReqHandler resReqHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, int i, Bundle bundle) {
        this.f18805a = activity;
        this.f18811g = str4;
        this.f18806b = resReqHandler;
        this.f18810f = str3;
        if (str3 == null) {
            this.f18810f = "oob";
        }
        this.f18809e = str2;
        if (str2 == null) {
            this.f18809e = SNBConstant.FIELD_TOKEN;
        }
        this.f18808d = str;
        this.f18812h = str5;
        this.f18815k = num;
        this.f18813i = str6;
        if (str6 == null) {
            this.f18813i = "mobile";
        }
        this.f18814j = str7;
        this.f18816l = str8;
        this.f18817m = i;
        this.f18807c = bundle;
    }

    public boolean m25349a() {
        return (this.f18805a == null || this.f18806b == null || TextUtils.isEmpty(this.f18808d) || this.f18810f == null || this.f18809e == null || this.f18817m > 2) ? false : true;
    }

    public String m25350b() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = "=";
        String str2 = HwAccountConstants.BLANK;
        stringBuffer.append("clientId").append(str).append(C5243e.m25423a(this.f18808d)).append(str2).append("responseType").append(str).append(this.f18809e).append(str2).append("redirectUrl").append(str).append(this.f18810f).append(str2).append("scope").append(str).append(this.f18811g).append(str2).append("state").append(str).append(this.f18812h).append(str2).append(WBConstants.AUTH_PARAMS_DISPLAY).append(str).append(this.f18813i).append(str2).append("sso_st").append(str).append(C5243e.m25423a(this.f18814j)).append(str2).append("deviceType").append(str).append(this.f18815k).append(str2).append(SNBConstant.FIELD_DEVICE_ID).append(str).append(C5243e.m25423a(this.f18816l)).append(str2).append("authTimes").append(str).append(this.f18817m).append(str2).append("max_authTimes").append(str).append(2);
        stringBuffer.append(C5243e.m25421a(this.f18807c));
        return stringBuffer.toString();
    }

    public void m25351c() {
        this.f18817m++;
    }
}
