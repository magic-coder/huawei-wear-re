package com.alipay.sdk.p247d;

final class C3178c implements Runnable {
    final /* synthetic */ C3176a f10584a;

    C3178c(C3176a c3176a) {
        this.f10584a = c3176a;
    }

    public final void run() {
        if (this.f10584a.f10580b == null) {
            this.f10584a.f10580b = new C3177b(this.f10584a, this.f10584a.f10581c);
        }
        try {
            if (!this.f10584a.f10580b.isShowing()) {
                this.f10584a.f10580b.show();
            }
        } catch (Exception e) {
        }
    }
}
