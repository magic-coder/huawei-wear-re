package com.huawei.pluginkidwatch.home;

import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: MenuFragment */
class bp implements Runnable {
    final /* synthetic */ bo f4321a;

    bp(bo boVar) {
        this.f4321a = boVar;
    }

    public void run() {
        if (this.f4321a.isAdded()) {
            m7810a();
        }
    }

    private void m7810a() {
        if (this.f4321a.f4304j) {
            this.f4321a.m7809a(this.f4321a.f4304j);
            this.f4321a.f4304j = false;
            this.f4321a.f4293M = false;
            this.f4321a.f4301g.removeCallbacks(this);
            C1497q.m6942a(this.f4321a.f4289I, "Has_been_initiated_shutdown", Boolean.valueOf(false));
            return;
        }
        this.f4321a.m7809a(this.f4321a.f4304j);
        this.f4321a.f4304j = true;
        C1497q.m6942a(this.f4321a.f4289I, "Has_been_initiated_shutdown", Boolean.valueOf(true));
        this.f4321a.f4301g.postDelayed(this, 120000);
    }
}
