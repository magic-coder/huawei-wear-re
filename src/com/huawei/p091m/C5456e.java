package com.huawei.p091m;

import com.huawei.coresleepresult.p381a.C4359a;
import com.huawei.coresleepresult.p381a.C4361c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C4713a;
import com.huawei.m.d;
import com.huawei.p464l.p465a.C5417c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HwCoreSleepMgr */
class C5456e implements IBaseResponseCallback {
    final /* synthetic */ d f19302a;

    C5456e(d dVar) {
        this.f19302a = dVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HwCoreSleepMgr", new Object[]{"getCpcResult onResponse err_code = " + i});
        if (d.c(this.f19302a).hasMessages(1)) {
            d.c(this.f19302a).removeMessages(1);
        }
        if (i != 0 || obj == null) {
            C2538c.c("HwCoreSleepMgr", new Object[]{"get cpc result err"});
            this.f19302a.b = -1;
        } else {
            C4359a c4359a = (C4359a) obj;
            if (c4359a.m20950b().size() > 0) {
                d.a(this.f19302a, c4359a.m20950b());
            }
            if (c4359a.m20948a().size() > 0) {
                d.b(this.f19302a, c4359a.m20948a());
            }
            if (c4359a.m20952c().size() > 0) {
                d.c(this.f19302a, c4359a.m20952c());
                for (int i2 = 0; i2 < c4359a.m20952c().size(); i2++) {
                    String str = "" + ((C4361c) c4359a.m20952c().get(i2)).m20977b();
                    Map hashMap = new HashMap();
                    hashMap.put("value", str);
                    C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.CORESLEEP_1180002.m22567a(), hashMap, 0);
                }
            }
            Map hashMap2 = new HashMap();
            hashMap2.put("value", "2");
            C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.CORESLEEP_1180002.m22567a(), hashMap2, 0);
            d.d(this.f19302a);
            d.g(this.f19302a).m26146a(this.f19302a, d.e(this.f19302a), d.f(this.f19302a));
        }
        d.b(this.f19302a, false);
    }
}
