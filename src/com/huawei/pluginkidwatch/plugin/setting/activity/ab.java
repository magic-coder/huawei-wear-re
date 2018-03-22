package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;

/* compiled from: CheckBillActivity */
class ab implements Runnable {
    final /* synthetic */ CheckBillActivity f6582a;

    ab(CheckBillActivity checkBillActivity) {
        this.f6582a = checkBillActivity;
    }

    public void run() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= watchStatusNum = " + this.f6582a.f6313r);
        if (this.f6582a.f6313r <= 1 || this.f6582a.isFinishing()) {
            this.f6582a.f6297b.sendEmptyMessage(4);
            return;
        }
        this.f6582a.f6313r = this.f6582a.f6313r - 1;
        this.f6582a.m9813j();
    }
}
