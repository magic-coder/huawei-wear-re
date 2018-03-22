package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWFitnessMgr */
class C5049r implements IBaseResponseCallback {
    final /* synthetic */ int f18259a;
    final /* synthetic */ q f18260b;

    C5049r(q qVar, int i) {
        this.f18260b = qVar;
        this.f18259a = i;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"reverseDataSync  onResponse!err_code=", Integer.valueOf(i)});
        C2538c.b("HWFitnessMgr", new Object[]{"reverseDataSync  onResponse!type=", Integer.valueOf(this.f18259a), " data=", obj});
        synchronized (q.p()) {
            q qVar = this.f18260b;
            qVar.c++;
        }
        if (i == 0 && (obj instanceof List)) {
            C2538c.c("HWFitnessMgr", new Object[]{"reverseDataSync  type=", Integer.valueOf(this.f18259a), "sucess!"});
            obj = (List) obj;
        } else {
            obj = null;
        }
        q.a(this.f18260b, this.f18259a, obj);
    }
}
