package com.alipay.sdk.auth;

final class C3164e implements Runnable {
    final /* synthetic */ String f10564a;
    final /* synthetic */ AuthActivity f10565b;

    C3164e(AuthActivity authActivity, String str) {
        this.f10565b = authActivity;
        this.f10564a = str;
    }

    public final void run() {
        try {
            this.f10565b.f10553a.loadUrl("javascript:" + this.f10564a);
        } catch (Exception e) {
        }
    }
}
