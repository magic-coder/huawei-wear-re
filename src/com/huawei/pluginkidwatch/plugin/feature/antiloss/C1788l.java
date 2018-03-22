package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: AntilossActivity */
class C1788l implements Runnable {
    final /* synthetic */ AntilossActivity f4937a;

    C1788l(AntilossActivity antilossActivity) {
        this.f4937a = antilossActivity;
    }

    public void run() {
        C2538c.m12674b("AntilossActivity", "onClick feature_btn_antiloss_close time out finish Dialog and AntilossActivity !!!!");
        if (!this.f4937a.isFinishing()) {
            C1506g.m6979b();
            this.f4937a.finish();
        }
    }
}
