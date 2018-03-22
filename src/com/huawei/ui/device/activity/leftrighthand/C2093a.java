package com.huawei.ui.device.activity.leftrighthand;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: LeftRightHandSettingsActivity */
class C2093a implements IBaseResponseCallback {
    final /* synthetic */ boolean f7386a;
    final /* synthetic */ LeftRightHandSettingsActivity f7387b;

    C2093a(LeftRightHandSettingsActivity leftRightHandSettingsActivity, boolean z) {
        this.f7387b = leftRightHandSettingsActivity;
        this.f7386a = z;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("LeftRightHandSettingsActivity", "setLeftOrRightHandWearStatus err_code = " + i + "  state = " + this.f7386a);
    }
}
