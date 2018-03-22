package com.huawei.bone.root;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.d.d;

/* compiled from: SplashActivity */
class aq implements IBaseResponseCallback {
    final /* synthetic */ SplashActivity f23319a;

    aq(SplashActivity splashActivity) {
        this.f23319a = splashActivity;
    }

    public void onResponse(int i, Object obj) {
        if (1 == i) {
            this.f23319a.f23281i = this.f23319a.f23274b.m30101o();
            if (d.e(this.f23319a.f23277e.getApplicationContext())) {
                this.f23319a.f23281i = this.f23319a.f23281i + 1;
                this.f23319a.f23274b.m30073a(this.f23319a.f23281i);
            }
            this.f23319a.m30195l();
            return;
        }
        this.f23319a.finish();
    }
}
