package com.huawei.pluginkidwatch.plugin.setting.activity;

import cn.com.xy.sms.a.f;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: CheckBillActivity */
class C1935z implements f {
    final /* synthetic */ CheckBillActivity f6703a;

    C1935z(CheckBillActivity checkBillActivity) {
        this.f6703a = checkBillActivity;
    }

    public void execute(Object... objArr) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= queryOperator callback method [" + objArr[0] + "]\t [" + objArr[1] + "]\n");
        if (objArr[1] != null) {
            this.f6703a.m9796b(objArr[1].toString());
        }
        this.f6703a.f6291A.removeCallbacks(this.f6703a.f6296F);
        C1506g.m6979b();
    }
}
