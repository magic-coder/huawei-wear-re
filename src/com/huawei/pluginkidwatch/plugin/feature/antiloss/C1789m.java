package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;

/* compiled from: AntilossActivity */
class C1789m implements Runnable {
    final /* synthetic */ AntilossActivity f4938a;

    C1789m(AntilossActivity antilossActivity) {
        this.f4938a = antilossActivity;
    }

    public void run() {
        C2538c.m12674b("AntilossActivity", "onClick feature_btn_antiloss_close disconnect!!!!");
        if (this.f4938a.f4904w != null) {
            this.f4938a.f4904w.m8301h();
        }
    }
}
