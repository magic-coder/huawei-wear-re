package com.huawei.pluginkidwatch.common.ui.simplecropimage;

/* compiled from: Util */
class aa implements Runnable {
    final /* synthetic */ C1563z f3693a;

    aa(C1563z c1563z) {
        this.f3693a = c1563z;
    }

    public void run() {
        this.f3693a.f3749a.m7071b(this.f3693a);
        if (this.f3693a.f3750b.getWindow() != null) {
            this.f3693a.f3750b.dismiss();
        }
    }
}
