package com.huawei.p388g.p391b;

import com.huawei.ab.m;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.login.ui.login.a;
import com.huawei.n.c;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.operation.utils.OperationUtils;
import com.huawei.up.model.UserInfomation;
import com.snowballtech.business.config.ParseConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HWAdapterHelper */
public class C4503a {
    private static final String f16676a = C4503a.class.getSimpleName();

    private static Map<String, String> m21563a() {
        Map<String, String> hashMap = new HashMap();
        a a = a.a(BaseApplication.b());
        String g = a.g();
        String f = a.f();
        hashMap.put("huid", a.c());
        hashMap.put("severToken", g);
        hashMap.put("accessToken", f);
        return hashMap;
    }

    private static Map<String, String> m21565b() {
        Map<String, String> hashMap = new HashMap();
        UserInfomation a = m.a(BaseApplication.b()).a();
        if (a != null) {
            hashMap.put("birthday", a.getBirthday());
            hashMap.put(UserInfo.GENDER, String.valueOf(a.getGender()));
            hashMap.put("weight", String.valueOf(a.getWeight()));
            hashMap.put("height", String.valueOf(a.getHeight()));
            hashMap.put("name", a.getName());
            hashMap.put(UserInfo.LANGUAGECODE, a.getLanguageCode());
            hashMap.put("portraitUrl", a.getPortraitUrl());
            hashMap.put("picPath", a.getPicPath());
        }
        return hashMap;
    }

    private static Map<String, String> m21566c() {
        Map<String, String> hashMap = new HashMap();
        DeviceInfo c = c.a(BaseApplication.b()).c();
        if (c != null) {
            hashMap.put("deviceName", c.getDeviceName());
            hashMap.put("productType", String.valueOf(c.getProductType()));
            hashMap.put("deviceConnectState", String.valueOf(c.getDeviceConnectState()));
        }
        return hashMap;
    }

    private static Map<String, String> m21567d() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("deviceModel", OperationUtils.getDeviceModel());
        hashMap.put("deviceId", d.h(BaseApplication.b()));
        hashMap.put("deviceType", OperationUtils.getPhoneType());
        hashMap.put("deviceSn", OperationUtils.getDeviceSn());
        return hashMap;
    }

    private static Map<String, String> m21568e() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("version", d.f(BaseApplication.b()));
        hashMap.put(AppOpenOrDownHelper.APP_ID_PARAM, OperationUtils.getAppId(BaseApplication.b()));
        hashMap.put("sysVersion", OperationUtils.getSysVersion());
        hashMap.put(ParseConfig.CFG_ENVIRONMENT, String.valueOf(d.i(BaseApplication.b())));
        hashMap.put("appType", String.valueOf(OperationUtils.getAppType()));
        hashMap.put("iversion", String.valueOf(OperationUtils.getIVersion()));
        hashMap.put("utc", String.valueOf(OperationUtils.getUTC()));
        return hashMap;
    }

    public static Map<String, String> m21564a(String[] strArr) {
        Map<String, String> hashMap = new HashMap();
        for (String str : strArr) {
            if (str.equals("getLoginInfo")) {
                hashMap.putAll(C4503a.m21563a());
            } else if (str.equals("getUserInfo")) {
                hashMap.putAll(C4503a.m21565b());
            } else if (str.equals("getDeviceInfo")) {
                hashMap.putAll(C4503a.m21566c());
            } else if (str.equals("getPhoneInfo")) {
                hashMap.putAll(C4503a.m21567d());
            } else if (str.equals("getAppInfo")) {
                hashMap.putAll(C4503a.m21568e());
            }
        }
        return hashMap;
    }
}
