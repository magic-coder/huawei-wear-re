package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: CheckBillActivity */
class C1931v implements Runnable {
    final /* synthetic */ CheckBillActivity f6699a;

    C1931v(CheckBillActivity checkBillActivity) {
        this.f6699a = checkBillActivity;
    }

    public void run() {
        if (this.f6699a.f6293C.equals("")) {
            this.f6699a.m9814k();
            return;
        }
        String[] split = this.f6699a.f6293C.split(",");
        this.f6699a.f6314s = split[0];
        this.f6699a.f6315t = split[1];
        C2538c.m12674b("CheckBillActivity", "=checkBill=  getBillCommond  mOperatorNum =  " + this.f6699a.f6314s + " ; balanceOrder = " + this.f6699a.f6315t);
        C1506g.m6979b();
    }
}
