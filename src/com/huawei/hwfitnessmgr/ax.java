package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: HWFitnessMgr */
class ax implements Runnable {
    WeakReference<q> f18170a;
    IBaseResponseCallback f18171b;

    ax(q qVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f18170a = new WeakReference(qVar);
        this.f18171b = iBaseResponseCallback;
    }

    public void run() {
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"syncFitnessDetailData isDatalogin:" + w.a(a.a(BaseApplication.b()).c())});
        q qVar = (q) this.f18170a.get();
        if (!w.a(a.a(BaseApplication.b()).c())) {
            if (this.f18171b != null) {
                this.f18171b.onResponse(0, "isDatalogin is false");
            }
            q.i(q.q());
        } else if (qVar != null) {
            q.b(qVar, this.f18171b);
        }
        if (qVar != null && qVar.a() != null) {
            qVar.a().m19761b(BaseApplication.b());
        }
    }
}
