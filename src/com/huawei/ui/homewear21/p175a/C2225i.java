package com.huawei.ui.homewear21.p175a;

import android.widget.CompoundButton;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.homewear21.i;

/* compiled from: HomeFragment */
class C2225i implements IBaseResponseCallback {
    final /* synthetic */ CompoundButton f8136a;
    final /* synthetic */ C2224h f8137b;

    C2225i(C2224h c2224h, CompoundButton compoundButton) {
        this.f8137b = c2224h;
        this.f8136a = compoundButton;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "setBluetoothOffalertSwitchStatus err_code =" + i + ",objData = " + obj);
        if (i != 0) {
            a.a(this.f8137b.f8135a.f7992A, i.IDS_music_management_operation_failed);
        }
        this.f8136a.setClickable(true);
    }
}
