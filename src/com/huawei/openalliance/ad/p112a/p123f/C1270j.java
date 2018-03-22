package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p122h.C1250f;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

class C1270j implements C1250f {
    final /* synthetic */ C1269i f2705a;

    C1270j(C1269i c1269i) {
        this.f2705a = c1269i;
    }

    public void mo2429a() {
    }

    public void mo2430a(Context context, C1212b c1212b, C1213c c1213c) {
        if (c1213c instanceof C1235b) {
            C1235b c1235b = (C1235b) c1213c;
            if (this.f2705a.f2700g.mo2443a(c1235b)) {
                try {
                    this.f2705a.m5605b(context, c1235b);
                } catch (Exception e) {
                    C1336d.m5888c("MagLockAdSource", "iterator maglock content fail");
                }
            }
            this.f2705a.f2700g.mo2442a(c1235b.getRetcode__(), this.f2705a.f2699f);
            return;
        }
        this.f2705a.f2700g.mo2442a(499, this.f2705a.f2699f);
    }

    public void mo2431b() {
    }
}
