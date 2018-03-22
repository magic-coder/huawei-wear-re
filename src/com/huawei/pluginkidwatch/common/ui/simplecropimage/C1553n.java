package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import com.huawei.p190v.C2538c;

/* compiled from: CropImage */
class C1553n implements Runnable {
    final /* synthetic */ C1552m f3715a;

    C1553n(C1552m c1552m) {
        this.f3715a = c1552m;
    }

    public void run() {
        boolean z;
        CropImage cropImage = this.f3715a.f3714e;
        if (this.f3715a.f3713d > 1) {
            z = true;
        } else {
            z = false;
        }
        cropImage.f3650a = z;
        if (this.f3715a.f3713d > 0) {
            for (int i = 0; i < this.f3715a.f3713d; i++) {
                this.f3715a.m7133a(this.f3715a.f3712c[i]);
            }
        } else {
            this.f3715a.m7132a();
        }
        this.f3715a.f3714e.f3664o.invalidate();
        if (this.f3715a.f3714e.f3664o.f3685a.size() == 1) {
            this.f3715a.f3714e.f3652c = (C1554o) this.f3715a.f3714e.f3664o.f3685a.get(0);
            this.f3715a.f3714e.f3652c.m7152a(true);
        }
        if (this.f3715a.f3713d > 1) {
            C2538c.m12680e("CropImage", "Multi face crop help");
        }
    }
}
