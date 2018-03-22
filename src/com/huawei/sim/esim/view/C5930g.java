package com.huawei.sim.esim.view;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: ConformActivity */
class C5930g implements IBaseResponseCallback {
    final /* synthetic */ ConformActivity f20443a;

    C5930g(ConformActivity conformActivity) {
        this.f20443a = conformActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("ConformActivity", new Object[]{"err_code " + i});
        if (1 != i && 2 != i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.f20443a.f20305o.sendMessage(obtain);
        }
    }
}
