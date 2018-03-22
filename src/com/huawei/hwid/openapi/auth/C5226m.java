package com.huawei.hwid.openapi.auth;

class C5226m implements Runnable {
    final /* synthetic */ C5225l f18849a;

    C5226m(C5225l c5225l) {
        this.f18849a = c5225l;
    }

    public void run() {
        if (this.f18849a.f18848b.f18841e != null && this.f18849a.f18848b.f18841e.isShowing()) {
            this.f18849a.f18848b.f18841e.dismiss();
        }
        if (this.f18849a.f18847a != null) {
            this.f18849a.f18847a.setVisibility(0);
        }
    }
}
