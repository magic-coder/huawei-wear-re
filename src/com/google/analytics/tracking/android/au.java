package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MapBuilder */
public class au {
    private Map<String, String> f14144a = new HashMap();

    public au m18279a(String str, String str2) {
        am.m18240a().m18241a(an.MAP_BUILDER_SET);
        if (str != null) {
            this.f14144a.put(str, str2);
        } else {
            ar.m18269d(" MapBuilder.set() called with a null paramName.");
        }
        return this;
    }

    public Map<String, String> m18280a() {
        return new HashMap(this.f14144a);
    }

    public static au m18276a(String str, Boolean bool) {
        am.m18240a().m18241a(an.CONSTRUCT_EXCEPTION);
        au auVar = new au();
        auVar.m18279a("&t", JoinConstants.EXCEPTION);
        auVar.m18279a("&exd", str);
        auVar.m18279a("&exf", m18277a(bool));
        return auVar;
    }

    public au m18278a(String str) {
        am.m18240a().m18241a(an.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
        String b = bj.m18344b(str);
        if (!TextUtils.isEmpty(b)) {
            Map a = bj.m18341a(b);
            m18279a("&cc", (String) a.get("utm_content"));
            m18279a("&cm", (String) a.get("utm_medium"));
            m18279a("&cn", (String) a.get("utm_campaign"));
            m18279a("&cs", (String) a.get("utm_source"));
            m18279a("&ck", (String) a.get("utm_term"));
            m18279a("&ci", (String) a.get("utm_id"));
            m18279a("&gclid", (String) a.get("gclid"));
            m18279a("&dclid", (String) a.get("dclid"));
            m18279a("&gmob_t", (String) a.get("gmob_t"));
        }
        return this;
    }

    static String m18277a(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? "1" : "0";
    }
}
