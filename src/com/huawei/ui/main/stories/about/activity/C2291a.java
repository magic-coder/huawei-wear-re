package com.huawei.ui.main.stories.about.activity;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.main.stories.guide.p181a.C2378a;

/* compiled from: AboutActivity */
class C2291a implements Runnable {
    final /* synthetic */ AboutActivity f8334a;

    C2291a(AboutActivity aboutActivity) {
        this.f8334a = aboutActivity;
    }

    public void run() {
        this.f8334a.f8331x = 0;
        new C2378a(BaseApplication.m2632b()).m12009k(true);
        this.f8334a.m11774b(true);
    }
}
