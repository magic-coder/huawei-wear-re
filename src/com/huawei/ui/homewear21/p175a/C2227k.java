package com.huawei.ui.homewear21.p175a;

import android.widget.CompoundButton;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.homewear21.i;

/* compiled from: HomeFragment */
class C2227k implements IBaseResponseCallback {
    final /* synthetic */ CompoundButton f8139a;
    final /* synthetic */ C2226j f8140b;

    C2227k(C2226j c2226j, CompoundButton compoundButton) {
        this.f8140b = c2226j;
        this.f8139a = compoundButton;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "setAutoLightScreenSwitchStatus err_code =" + i + ",objData = " + obj);
        if (i != 0) {
            a.a(this.f8140b.f8138a.f7992A, i.IDS_music_management_operation_failed);
        }
        this.f8139a.setClickable(true);
    }
}
