package com.tencent.connect.avatar;

/* compiled from: ProGuard */
class C6261n implements Runnable {
    final /* synthetic */ C6260m f21786a;

    C6261n(C6260m c6260m) {
        this.f21786a = c6260m;
    }

    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f21786a.post(new C6262o(this));
        this.f21786a.f21778i = false;
    }
}
