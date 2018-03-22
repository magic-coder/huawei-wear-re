package com.huawei.ui.homewear21.p175a;

import android.content.Intent;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class cc implements Runnable {
    final /* synthetic */ C2217a f8105a;

    private cc(C2217a c2217a) {
        this.f8105a = c2217a;
    }

    public void run() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "check notification is enable ");
        if (!C0977d.m3577p(this.f8105a.f7992A)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "check notification is disabled ");
            Intent intent = new Intent();
            intent.setAction("com.huawei.bone.notification.rebindService");
            this.f8105a.f7992A.sendBroadcast(intent, C0976c.f1642a);
            this.f8105a.bu.removeMessages(1021);
            this.f8105a.bu.sendEmptyMessageDelayed(1021, 20000);
            this.f8105a.aK = Boolean.valueOf(true);
        }
    }
}
