package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.inter.listener.MagLockConfigListener;
import com.huawei.openalliance.ad.p112a.p113a.C1237d;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p122h.C1250f;
import java.util.Arrays;

final class C1267g implements C1250f {
    final /* synthetic */ MagLockConfigListener f2694a;

    C1267g(MagLockConfigListener magLockConfigListener) {
        this.f2694a = magLockConfigListener;
    }

    public void mo2429a() {
    }

    public void mo2430a(Context context, C1212b c1212b, C1213c c1213c) {
        if (c1213c instanceof C1237d) {
            C1237d c1237d = (C1237d) c1213c;
            if (200 == c1237d.getRetcode_()) {
                C1266f.m5595b(context, c1237d);
                if (this.f2694a != null) {
                    this.f2694a.onConfig(200, C1266f.m5594b(c1237d));
                }
            } else if (this.f2694a != null) {
                this.f2694a.onConfig(Arrays.binarySearch(C1266f.f2693a, c1237d.getRetcode_()) >= 0 ? c1237d.getRetcode_() : 499, null);
            }
        }
    }

    public void mo2431b() {
    }
}
