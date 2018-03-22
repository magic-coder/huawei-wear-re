package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1238e;
import com.huawei.openalliance.ad.p112a.p113a.C1239f;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1217c;
import com.huawei.openalliance.ad.p112a.p122h.C1250f;
import com.huawei.openalliance.ad.p112a.p122h.C1284b;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.AdEventRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.List;

final class C1253e implements C1250f {
    final /* synthetic */ List f2669a;

    C1253e(List list) {
        this.f2669a = list;
    }

    public void mo2429a() {
    }

    public void mo2430a(Context context, C1212b c1212b, C1213c c1213c) {
        if (c1213c.responseCode == 0 && (c1212b instanceof C1238e) && (c1213c instanceof C1239f)) {
            List<C1217c> list = ((C1239f) c1213c).result__;
            C1357a a = C1357a.m5982a(context);
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        List arrayList = new ArrayList(4);
                        List arrayList2 = new ArrayList(4);
                        for (C1217c a2 : list) {
                            C1284b.m5666a(a2, arrayList, arrayList2);
                        }
                        a.m5992a(AdEventRecord.class.getSimpleName(), "_id", arrayList);
                        a.m5993a(AdEventRecord.class.getSimpleName(), arrayList2, 0);
                    }
                } catch (Exception e) {
                    C1336d.m5888c("AdEventManager", "handle event cache report result fail");
                    return;
                } finally {
                    a.close();
                }
            }
            a.close();
            return;
        }
        C1284b.m5665a(context, this.f2669a);
    }

    public void mo2431b() {
    }
}
