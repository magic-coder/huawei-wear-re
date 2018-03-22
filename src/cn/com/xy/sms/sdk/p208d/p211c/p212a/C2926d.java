package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p220j.p224d.C3030f;
import java.util.HashMap;
import java.util.Map;

final class C2926d implements Runnable {
    private final /* synthetic */ String f9928a;

    C2926d(String str) {
        this.f9928a = str;
    }

    public final void run() {
        try {
            Map hashMap = new HashMap();
            hashMap.put("SUPPORT_NET_QUERY", "1");
            C2917a.m13105a();
            C3030f.m13570a(this.f9928a, 1, null, hashMap, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "NumNameManager queryPubInfoIfNeed error:" + th.getMessage(), th);
        }
    }
}
