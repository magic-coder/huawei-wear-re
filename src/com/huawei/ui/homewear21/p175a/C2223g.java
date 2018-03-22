package com.huawei.ui.homewear21.p175a;

import android.widget.CompoundButton;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.homewear21.i;

/* compiled from: HomeFragment */
class C2223g implements IBaseResponseCallback {
    final /* synthetic */ CompoundButton f8133a;
    final /* synthetic */ C2222f f8134b;

    C2223g(C2222f c2222f, CompoundButton compoundButton) {
        this.f8134b = c2222f;
        this.f8133a = compoundButton;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "setActivityReminder err_code =" + i + ",objData = " + obj);
        if (i != 0) {
            a.a(this.f8134b.f8132a.f7992A, i.IDS_music_management_operation_failed);
        }
        this.f8133a.setClickable(true);
    }
}
