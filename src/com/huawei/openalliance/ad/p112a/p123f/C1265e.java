package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p121e.C1256h;

public abstract class C1265e {
    protected int f2692a = 1;

    private void m5588a(Context context, C1215a c1215a, C1221g c1221g) {
        if (context != null && c1221g != null) {
            if ((1 == this.f2692a && (2 == c1221g.getCreativetype__() || 4 == c1221g.getCreativetype__())) || 2 == this.f2692a) {
                C1256h.m5568a(context, c1215a.getSlotid__(), this.f2692a, c1221g, null, false);
            }
        }
    }

    protected void m5589a(Context context, C1235b c1235b) {
        for (C1215a c1215a : c1235b.getMultiad__()) {
            if (!(c1215a == null || 200 != c1215a.getRetcode30__() || c1215a.getContent__() == null || c1215a.getContent__().isEmpty())) {
                for (C1221g a : c1215a.getContent__()) {
                    m5588a(context, c1215a, a);
                }
            }
        }
    }
}
