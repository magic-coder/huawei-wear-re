package com.huawei.feedback.component;

import android.content.Intent;
import android.util.Log;
import com.huawei.feedback.C0811c;

/* compiled from: AutoUploadService */
class C0814c implements Runnable {
    final /* synthetic */ boolean f1281a;
    final /* synthetic */ AutoUploadService f1282b;

    C0814c(AutoUploadService autoUploadService, boolean z) {
        this.f1282b = autoUploadService;
        this.f1281a = z;
    }

    public void run() {
        if (this.f1281a) {
            Log.i("AutoUploadService", "AutoUploadService success! ");
            this.f1282b.m2828d();
            this.f1282b.m2818a(AutoUploadService.f1251b);
        }
        C0811c.m2783b(AutoUploadService.f1250a);
        this.f1282b.getApplicationContext().stopService(new Intent(this.f1282b.getApplicationContext(), AutoUploadService.class));
    }
}
