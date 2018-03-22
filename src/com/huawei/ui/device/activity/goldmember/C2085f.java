package com.huawei.ui.device.activity.goldmember;

import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.device.i;

/* compiled from: VIPMemberActivationActivity */
class C2085f implements Runnable {
    final /* synthetic */ VIPMemberActivationActivity f7365a;

    private C2085f(VIPMemberActivationActivity vIPMemberActivationActivity) {
        this.f7365a = vIPMemberActivationActivity;
    }

    public void run() {
        if (this.f7365a.f7298h != null) {
            if (this.f7365a.f7298h.isShowing()) {
                this.f7365a.f7298h.dismiss();
                this.f7365a.f7298h = null;
            }
            this.f7365a.f7294c.getBackground().setAlpha(255);
            this.f7365a.f7294c.setClickable(true);
            this.f7365a.f7294c.setTextColor(-15884293);
            a.a(this.f7365a.f7295d, i.IDS_main_sns_member_activation_failure);
        }
        C2538c.m12677c(VIPMemberActivationActivity.f7291e, "mCommonDialog.closeProgressDialog  timeout");
    }
}
