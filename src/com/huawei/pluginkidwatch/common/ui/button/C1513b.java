package com.huawei.pluginkidwatch.common.ui.button;

/* compiled from: SlipButtonView */
class C1513b implements Runnable {
    final /* synthetic */ boolean f3562a;
    final /* synthetic */ SlipButtonView f3563b;

    C1513b(SlipButtonView slipButtonView, boolean z) {
        this.f3563b = slipButtonView;
        this.f3562a = z;
    }

    public void run() {
        this.f3563b.setListener(this.f3562a);
        this.f3563b.setChecked(this.f3562a);
    }
}
