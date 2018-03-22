package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: CheckBillActivity */
class C1934y implements C1378e {
    final /* synthetic */ CheckBillActivity f6702a;

    C1934y(CheckBillActivity checkBillActivity) {
        this.f6702a = checkBillActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("CheckBillActivity", "=checkBill= sendBillCommond FAILURE");
            this.f6702a.f6297b.sendEmptyMessage(4);
            return;
        }
        C2538c.m12674b("CheckBillActivity", "=checkBill= sendBillCommond SUCCESS");
        this.f6702a.m9813j();
    }
}
