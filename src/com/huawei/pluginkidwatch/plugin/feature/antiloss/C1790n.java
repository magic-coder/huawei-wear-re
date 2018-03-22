package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: AntilossActivity */
class C1790n implements Runnable {
    final /* synthetic */ AntilossActivity f4939a;

    C1790n(AntilossActivity antilossActivity) {
        this.f4939a = antilossActivity;
    }

    public void run() {
        C2538c.m12674b("AntilossActivity", "onClick feature_btn_antiloss_close finish Dialog and AntilossActivity !!!!");
        if (!this.f4939a.isFinishing()) {
            C1506g.m6979b();
            this.f4939a.finish();
        }
    }
}
