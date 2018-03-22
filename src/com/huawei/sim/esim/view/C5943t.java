package com.huawei.sim.esim.view;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimConformBTFailActivity */
class C5943t implements IBaseResponseCallback {
    final /* synthetic */ EsimConformBTFailActivity f20458a;

    C5943t(EsimConformBTFailActivity esimConformBTFailActivity) {
        this.f20458a = esimConformBTFailActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("ConformReportActivity", new Object[]{"err_code " + i});
        this.f20458a.f20341u.removeMessages(6);
        Message obtain;
        if (1 == i) {
            obtain = Message.obtain();
            obtain.what = 4;
            this.f20458a.f20341u.sendMessage(obtain);
        } else if (2 == i) {
            obtain = Message.obtain();
            obtain.what = 2;
            this.f20458a.f20341u.sendMessage(obtain);
        } else {
            obtain = Message.obtain();
            obtain.what = 3;
            this.f20458a.f20341u.sendMessage(obtain);
        }
    }
}
