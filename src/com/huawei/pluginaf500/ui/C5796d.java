package com.huawei.pluginaf500.ui;

import com.huawei.pluginaf500.h;

/* compiled from: AF500GuideActivity */
class C5796d implements C5795f {
    final /* synthetic */ AF500GuideActivity f19958a;

    C5796d(AF500GuideActivity aF500GuideActivity) {
        this.f19958a = aF500GuideActivity;
    }

    public void mo5118a(boolean z) {
        this.f19958a.f19644b = z;
    }

    public void mo5119b(boolean z) {
        if (z) {
            this.f19958a.m26599c(h.connect_searching);
        } else {
            this.f19958a.f19665y.sendEmptyMessage(104);
        }
    }
}
