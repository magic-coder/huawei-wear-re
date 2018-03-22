package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

/* compiled from: AdwordsClickReferrerListener */
class C3676a implements C3675j {
    private final Context f14242a;

    public C3676a(Context context) {
        this.f14242a = context;
    }

    public void mo4270a(Map<Object, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            obj = map.get("gtm");
            if (obj != null && (obj instanceof Map)) {
                obj = ((Map) obj).get("url");
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        C3699y.m18623b(this.f14242a, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
