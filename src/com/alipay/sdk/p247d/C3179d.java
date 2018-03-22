package com.alipay.sdk.p247d;

final class C3179d implements Runnable {
    final /* synthetic */ C3176a f10585a;

    C3179d(C3176a c3176a) {
        this.f10585a = c3176a;
    }

    public final void run() {
        if (this.f10585a.f10580b != null) {
            try {
                this.f10585a.f10580b.dismiss();
            } catch (Exception e) {
            }
        }
    }
}
