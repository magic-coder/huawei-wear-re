package com.huawei.pluginkidwatch.plugin.feature.antiloss;

/* compiled from: AntilossActivity */
class C1781e implements Runnable {
    final /* synthetic */ C1780d f4930a;

    C1781e(C1780d c1780d) {
        this.f4930a = c1780d;
    }

    public void run() {
        if (this.f4930a.f4929a.f4907z != null && this.f4930a.f4929a.f4907z.isShowing()) {
            this.f4930a.f4929a.f4907z.dismiss();
        }
        this.f4930a.f4929a.m8533r();
    }
}
