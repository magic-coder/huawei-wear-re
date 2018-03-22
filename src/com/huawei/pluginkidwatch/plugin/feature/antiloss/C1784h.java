package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;

/* compiled from: AntilossActivity */
class C1784h implements C1647c {
    final /* synthetic */ AntilossActivity f4933a;

    C1784h(AntilossActivity antilossActivity) {
        this.f4933a = antilossActivity;
    }

    public void mo2560a(int i) {
        C2538c.m12674b("AntilossActivity", "antilossChangeBluetoothState state = " + i);
        if (!this.f4933a.f4901t.isEnabled() || this.f4933a.isFinishing()) {
            return;
        }
        if (2 == i || 3 == i || i == 0 || -1 == i) {
            this.f4933a.f4880K.sendEmptyMessage(i);
        }
    }
}
