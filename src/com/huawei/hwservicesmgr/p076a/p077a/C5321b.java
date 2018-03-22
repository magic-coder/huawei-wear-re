package com.huawei.hwservicesmgr.p076a.p077a;

import com.huawei.hwdevicemgr.dmsdatatype.p074a.C4992a;
import com.huawei.hwservicesmgr.a.a.a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

/* compiled from: HWEphemerisManager */
class C5321b implements C4992a {
    final /* synthetic */ a f19052a;

    C5321b(a aVar) {
        this.f19052a = aVar;
    }

    public void mo4604a(Object obj) {
        C2538c.c("HWEphemerisManager", new Object[]{"fileCallback download success"});
        a.c(this.f19052a, 3);
        a.c(this.f19052a, false);
        a.j(this.f19052a);
        a.b(this.f19052a, 3);
        if (a.i(this.f19052a)) {
            a.b(this.f19052a, false);
            if (a.k(this.f19052a) != null) {
                a.k(this.f19052a).removeMessages(4);
            }
            a.a(this.f19052a, "com.huawei.bone.ephemeris.currentState.updating");
        }
        if (a.k(this.f19052a) != null) {
            a.k(this.f19052a).removeMessages(3);
            a.k(this.f19052a).sendEmptyMessageDelayed(3, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        }
    }

    public void mo4603a(int i, String str) {
        if (3 <= a.l(this.f19052a)) {
            C2538c.c("HWEphemerisManager", new Object[]{"download retry finish"});
            a.m(this.f19052a);
        } else if (a.n(this.f19052a) + 1 <= a.o(this.f19052a).size()) {
            a.p(this.f19052a);
            if (a.o(this.f19052a).size() == a.n(this.f19052a)) {
                a.d(this.f19052a, 0);
                a.q(this.f19052a);
                if (3 <= a.l(this.f19052a)) {
                    C2538c.c("HWEphemerisManager", new Object[]{"download retry finish done"});
                    a.m(this.f19052a);
                    return;
                }
            }
            try {
                a.a(this.f19052a, (String) a.o(this.f19052a).get(a.n(this.f19052a)), a.r(this.f19052a));
            } catch (IndexOutOfBoundsException e) {
                C2538c.e("HWEphemerisManager", new Object[]{"onFailure :", e.getMessage()});
            }
        } else {
            a.m(this.f19052a);
        }
    }
}
