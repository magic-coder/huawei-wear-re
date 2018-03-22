package com.amap.api.services.core;

import android.os.HandlerThread;
import android.os.Message;

/* compiled from: ManifestConfig */
class C3419m extends HandlerThread {
    final /* synthetic */ C3418l f12490a;

    C3419m(C3418l c3418l, String str) {
        this.f12490a = c3418l;
        super(str);
    }

    public void run() {
        String str = "run";
        Thread.currentThread().setName("ManifestConfigThread");
        Message message = new Message();
        try {
            message.obj = new C3420n(C3418l.f12487c).m16965a();
            message.what = 3;
            if (this.f12490a.f12488d != null) {
                this.f12490a.f12488d.sendMessage(message);
            }
        } catch (Throwable th) {
            message.what = 3;
            if (this.f12490a.f12488d != null) {
                this.f12490a.f12488d.sendMessage(message);
            }
        }
        try {
            C3419m.sleep(10000);
        } catch (Throwable th2) {
            C3409d.m16881a(th2, "ManifestConfig", "mVerfy");
        }
    }
}
