package com.huawei.ui.main.stories.about.activity;

import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;

/* compiled from: AboutActivity */
class C2308h implements IDeviceDFXBaseResponseCallback {
    final /* synthetic */ C2307g f8369a;

    C2308h(C2307g c2307g) {
        this.f8369a = c2307g;
    }

    public void onSuccess(int i, String str) {
        this.f8369a.f8368a.f8330w.m11765a(false);
    }

    public void onFailure(int i, String str) {
        this.f8369a.f8368a.f8330w.m11765a(false);
    }
}
