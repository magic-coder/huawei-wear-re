package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;
import com.huawei.openalliance.ad.p112a.p121e.C1256h;

public class C1268h {
    public static void m5599a(Context context, C1215a c1215a, C1221g c1221g, int i, C1216b c1216b, C1216b c1216b2) {
        if (context != null && c1221g != null && c1216b != null && c1216b2 != null) {
            C1249b.m5536a(context, i, c1221g, c1216b, c1216b2);
            if ((1 == i && (2 == c1221g.getCreativetype__() || 4 == c1221g.getCreativetype__())) || 2 == i) {
                C1256h.m5568a(context, c1215a.getSlotid__(), i, c1221g, null, false);
            }
        }
    }

    public static void m5600a(Context context, C1235b c1235b, int i, C1216b c1216b, C1216b c1216b2) {
        for (C1215a c1215a : c1235b.getMultiad__()) {
            if (!(c1215a == null || 200 != c1215a.getRetcode30__() || c1215a.getContent__() == null || c1215a.getContent__().isEmpty())) {
                for (C1221g a : c1215a.getContent__()) {
                    C1268h.m5599a(context, c1215a, a, i, c1216b, c1216b2);
                }
            }
        }
    }
}
