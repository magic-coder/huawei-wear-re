package com.huawei.crowdtestsdk.home;

import android.content.Context;
import android.util.Base64;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.crowdtestsdk.bases.AuthRequestItem;
import com.huawei.crowdtestsdk.bases.AuthResponseItem;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.utils.PhoneInfo;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.uploadlog.p188c.C2510f;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import com.sina.weibo.sdk.component.GameManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AuthManager {
    public static int checkLicense(Context context) {
        C2511g.m12481b("BETACLUB_SDK", "[AuthManager.checkLicense] is called!");
        if (!NetworkUtils.checkNetworkStatus(context)) {
            return -20;
        }
        AuthResponseItem authInfoBeanFromServer = HttpBetaAccess.getInstance().getAuthInfoBeanFromServer(getAuthRequestItem(context));
        if (authInfoBeanFromServer == null) {
            return 0;
        }
        C2511g.m12477a("BETACLUB_SDK", "[AuthManager.checkLicense]resCode:" + authInfoBeanFromServer.getResCode());
        return authInfoBeanFromServer.getResCode();
    }

    private static AuthRequestItem getAuthRequestItem(Context context) {
        AuthRequestItem authRequestItem = new AuthRequestItem();
        String deviceId = PhoneInfo.getDeviceId(context);
        String serialNumber = PhoneInfo.getSerialNumber();
        String c = C2514j.m12523c();
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String sign = getSign(deviceId, serialNumber, valueOf.longValue(), 0, 1, c);
        authRequestItem.setDeviceId(deviceId);
        authRequestItem.setSn(serialNumber);
        authRequestItem.setUserName(c);
        authRequestItem.setTimeStamp(valueOf);
        authRequestItem.setSign(sign);
        authRequestItem.setQueryFlag(0);
        authRequestItem.setProductFlag(1);
        return authRequestItem;
    }

    private static String getSign(String str, String str2, long j, int i, int i2, String str3) {
        String encode;
        byte[] a;
        try {
            encode = URLEncoder.encode(getSortString(str, str2, j, i, i2, str3), GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[AuthManager.getSign] error1!", e);
            encode = null;
        }
        if (encode != null) {
            try {
                a = C2510f.m12474a(encode, str);
            } catch (Throwable e2) {
                C2511g.m12482b("BETACLUB_SDK", "[AuthManager.getSign] error2!", e2);
            }
            if (a == null) {
                return Base64.encodeToString(a, 2);
            }
            return null;
        }
        a = null;
        if (a == null) {
            return null;
        }
        return Base64.encodeToString(a, 2);
    }

    private static String getSortString(String str, String str2, long j, int i, int i2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("deviceId", str);
        hashMap.put("queryFlag", i + "");
        hashMap.put("productFlag", i2 + "");
        hashMap.put("sn", str2);
        hashMap.put("timeStamp", j + "");
        hashMap.put(HwPayConstant.KEY_USER_NAME, str3);
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList);
        StringBuffer stringBuffer = new StringBuffer("urlencode(");
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            stringBuffer.append((String) arrayList.get(i3));
            stringBuffer.append("=");
            stringBuffer.append((String) hashMap.get(arrayList.get(i3)));
            stringBuffer.append(SNBConstant.FILTER);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), ")");
        }
        return stringBuffer.toString();
    }
}
