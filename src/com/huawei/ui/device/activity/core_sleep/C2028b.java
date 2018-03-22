package com.huawei.ui.device.activity.core_sleep;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: CoreSleepSelectorActivity */
class C2028b implements OnClickListener {
    final /* synthetic */ CoreSleepSelectorActivity f7108a;

    C2028b(CoreSleepSelectorActivity coreSleepSelectorActivity) {
        this.f7108a = coreSleepSelectorActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("CoreSleepSelectorActivity", "showStartCoreSleepSwitchDialog cancel click");
        this.f7108a.m10611b();
        this.f7108a.f7104b.setChecked(false);
    }
}
