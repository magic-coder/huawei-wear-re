package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: GAThread */
class aj implements Runnable {
    final /* synthetic */ Map f14066a;
    final /* synthetic */ ai f14067b;

    aj(ai aiVar, Map map) {
        this.f14067b = aiVar;
        this.f14066a = map;
    }

    public void run() {
        if (TextUtils.isEmpty((CharSequence) this.f14066a.get("&cid"))) {
            this.f14066a.put("&cid", this.f14067b.f14063f);
        }
        if (!ao.m18247a(this.f14067b.f14065i).m18253c() && !this.f14067b.m18229c(this.f14066a)) {
            if (!TextUtils.isEmpty(this.f14067b.f14062e)) {
                am.m18240a().m18242a(true);
                this.f14066a.putAll(new au().m18278a(this.f14067b.f14062e).m18280a());
                am.m18240a().m18242a(false);
                this.f14067b.f14062e = null;
            }
            this.f14067b.m18231d(this.f14066a);
            this.f14067b.f14064h.mo4263a(aq.m18263a(this.f14066a), Long.valueOf((String) this.f14066a.get("&ht")).longValue(), this.f14067b.m18225b(this.f14066a), this.f14067b.f14061d);
        }
    }
}
