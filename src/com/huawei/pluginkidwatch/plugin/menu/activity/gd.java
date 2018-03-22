package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1865h;

/* compiled from: SosContactSortActivity */
class gd implements C1865h {
    final /* synthetic */ SosContactSortActivity f6147a;

    gd(SosContactSortActivity sosContactSortActivity) {
        this.f6147a = sosContactSortActivity;
    }

    public void mo2623a(int i, int i2) {
        C2538c.m12674b("SosContactSortActivity", "==ww== setExchangeDataListener ");
        UserInfo userInfo = (UserInfo) this.f6147a.f5869e.get(i);
        this.f6147a.f5869e.remove(userInfo);
        this.f6147a.f5869e.add(i2, userInfo);
        this.f6147a.f5868d.notifyDataSetChanged();
    }
}
