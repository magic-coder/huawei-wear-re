package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HomeFragment */
class ax implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8067a;

    ax(C2217a c2217a) {
        this.f8067a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            this.f8067a.aA = (List) obj;
            if (this.f8067a.aA == null || this.f8067a.aA.size() <= 0) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startMessageNotificationObserver fail!");
            } else {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "startMessageNotificationObserver count = " + this.f8067a.aA.size());
            }
            this.f8067a.bu.sendEmptyMessage(1016);
        }
    }
}
