package com.huawei.feedback.component;

import android.os.Bundle;

/* compiled from: AutoUploadService */
class C0813b implements Runnable {
    final /* synthetic */ Bundle f1278a;
    final /* synthetic */ String f1279b;
    final /* synthetic */ AutoUploadService f1280c;

    C0813b(AutoUploadService autoUploadService, Bundle bundle, String str) {
        this.f1280c = autoUploadService;
        this.f1278a = bundle;
        this.f1279b = str;
    }

    public void run() {
        this.f1280c.m2819a(this.f1278a, this.f1279b);
    }
}
