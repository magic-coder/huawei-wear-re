package com.huawei.pluginkidwatch.home.p156b;

import com.sina.weibo.sdk.statistic.StatisticConfig;

/* compiled from: CheckNewVersionUtils */
class C1636p implements Runnable {
    final /* synthetic */ C1624d f4244a;
    private int f4245b = 30000;
    private int f4246c = 1800000;
    private int f4247d = 0;

    public C1636p(C1624d c1624d, int i, int i2) {
        this.f4244a = c1624d;
        this.f4245b = i;
        this.f4246c = i2;
        C1624d.f4200k = false;
        C1624d.f4201l = 0;
    }

    public void run() {
        if (C1624d.f4200k) {
            this.f4247d = 0;
            C1624d.f4200k = false;
        }
        if (this.f4247d > this.f4246c) {
            this.f4244a.f4219r.removeCallbacks(this);
            return;
        }
        this.f4244a.m7739b(false);
        this.f4247d += this.f4245b;
        this.f4244a.f4219r.postDelayed(this.f4244a.f4220u, StatisticConfig.MIN_UPLOAD_INTERVAL);
    }
}
