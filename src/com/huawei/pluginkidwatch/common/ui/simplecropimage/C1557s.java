package com.huawei.pluginkidwatch.common.ui.simplecropimage;

/* compiled from: ImageViewTouchBase */
class C1557s implements Runnable {
    final /* synthetic */ float f3740a;
    final /* synthetic */ long f3741b;
    final /* synthetic */ float f3742c;
    final /* synthetic */ float f3743d;
    final /* synthetic */ float f3744e;
    final /* synthetic */ float f3745f;
    final /* synthetic */ C1539q f3746g;

    C1557s(C1539q c1539q, float f, long j, float f2, float f3, float f4, float f5) {
        this.f3746g = c1539q;
        this.f3740a = f;
        this.f3741b = j;
        this.f3742c = f2;
        this.f3743d = f3;
        this.f3744e = f4;
        this.f3745f = f5;
    }

    public void run() {
        float min = Math.min(this.f3740a, (float) (System.currentTimeMillis() - this.f3741b));
        this.f3746g.mo2534a(this.f3742c + (this.f3743d * min), this.f3744e, this.f3745f);
        if (min < this.f3740a) {
            this.f3746g.f3684p.post(this);
        }
    }
}
