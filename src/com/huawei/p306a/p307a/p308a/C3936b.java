package com.huawei.p306a.p307a.p308a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.phoneserviceuni.common.d.a;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p491a.C5755a;
import com.sina.weibo.sdk.component.GameManager;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: RequestManagerEx */
public class C3936b {
    protected String m19582a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            try {
                stringBuffer.append(URLEncoder.encode((String) entry.getKey(), GameManager.DEFAULT_CHARSET)).append('=').append(URLEncoder.encode((String) entry.getValue(), GameManager.DEFAULT_CHARSET)).append('&');
            } catch (Exception e) {
                c.a(e, "RequestManagerEx");
            }
        }
        return stringBuffer.toString();
    }

    protected String m19580a(Context context, String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(str3);
        String d = a.d(context);
        if (TextUtils.isEmpty(d)) {
            d = HwAccountConstants.BLANK;
        }
        stringBuffer.append('?').append("cVer").append('=').append(d);
        stringBuffer.append('&').append("channel").append('=').append("100001");
        return stringBuffer.toString();
    }

    protected String m19581a(Context context, Map<String, String> map) {
        Map hashMap = new HashMap();
        CharSequence a = a.a(context, context.getPackageName());
        if (!TextUtils.isEmpty(a)) {
            map.put("cVersionName", a);
        }
        map.put("countryCode", HwAccountConstants.DEFAULT_COUNTRY_MNC);
        a = a.p();
        if (!TextUtils.isEmpty(a)) {
            map.put("model", a);
        }
        a = a.c();
        if (!TextUtils.isEmpty(a)) {
            map.put("systemid", a);
        }
        a = a.d();
        if (!TextUtils.isEmpty(a)) {
            map.put("brand", a);
        }
        Object a2 = C5755a.m26424a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "000000000000000";
        }
        map.put(BundleKey.KEY_IMEI, a2);
        a = a.r();
        if (!TextUtils.isEmpty(a)) {
            map.put("language", a);
        }
        a = a.e();
        if (!TextUtils.isEmpty(a)) {
            map.put("firmware", a);
        }
        a = a.o();
        if (!TextUtils.isEmpty(a)) {
            map.put("os", a);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Object obj = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? 1 : null;
                if (obj == null) {
                    hashMap.put(str, str2);
                }
            }
        }
        return m19582a(hashMap);
    }
}
