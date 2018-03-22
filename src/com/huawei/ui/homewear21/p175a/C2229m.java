package com.huawei.ui.homewear21.p175a;

import android.widget.CompoundButton;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.homewear21.i;

/* compiled from: HomeFragment */
class C2229m implements IBaseResponseCallback {
    final /* synthetic */ CompoundButton f8142a;
    final /* synthetic */ C2228l f8143b;

    C2229m(C2228l c2228l, CompoundButton compoundButton) {
        this.f8143b = c2228l;
        this.f8142a = compoundButton;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "setRotateSwitchScreenSwitchStatus err_code =" + i + ",objData = " + obj);
        if (i != 0) {
            a.a(this.f8143b.f8141a.f7992A, i.IDS_music_management_operation_failed);
        }
        this.f8142a.setClickable(true);
    }
}
