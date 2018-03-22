package com.huawei.ui.main.stories.about.activity;

import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: AboutActivity */
class C2309i implements IDeviceDFXBaseResponseCallback {
    final /* synthetic */ AboutActivity f8370a;

    C2309i(AboutActivity aboutActivity) {
        this.f8370a = aboutActivity;
    }

    public void onSuccess(int i, String str) {
        if (2 == i) {
            C2538c.m12674b("AboutActivity", "正在进行log采集");
            return;
        }
        this.f8370a.f8332y = false;
        this.f8370a.f8303D.post(new C2310j(this));
    }

    public void onFailure(int i, String str) {
        C2538c.m12674b("AboutActivity", "get device log failed");
        this.f8370a.f8332y = false;
        this.f8370a.f8303D.post(new C2311k(this));
    }
}
