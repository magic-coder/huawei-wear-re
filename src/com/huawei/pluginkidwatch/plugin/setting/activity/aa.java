package com.huawei.pluginkidwatch.plugin.setting.activity;

import cn.com.xy.sms.a.f;
import com.huawei.p190v.C2538c;

/* compiled from: CheckBillActivity */
class aa implements f {
    final /* synthetic */ CheckBillActivity f6581a;

    aa(CheckBillActivity checkBillActivity) {
        this.f6581a = checkBillActivity;
    }

    public void execute(Object... objArr) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= OperatorMsg callback method [" + objArr[0] + "]\t [" + objArr[1] + "]\n");
        if (objArr[1] == null || objArr[1].toString().isEmpty() || this.f6581a.f6295E == null) {
            C2538c.m12674b("CheckBillActivity", "=checkBill= mOperatorMsgCallBack   null");
            return;
        }
        C2538c.m12674b("CheckBillActivity", "=checkBill= mOperatorMsgCallBack   [" + objArr[1].toString() + "]");
        this.f6581a.f6291A.removeCallbacks(this.f6581a.f6295E);
        this.f6581a.m9796b(objArr[1].toString());
    }
}
