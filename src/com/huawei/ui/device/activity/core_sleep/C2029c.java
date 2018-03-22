package com.huawei.ui.device.activity.core_sleep;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.d.a;
import com.huawei.p190v.C2538c;

/* compiled from: CoreSleepSelectorActivity */
class C2029c implements OnClickListener {
    final /* synthetic */ CoreSleepSelectorActivity f7109a;

    C2029c(CoreSleepSelectorActivity coreSleepSelectorActivity) {
        this.f7109a = coreSleepSelectorActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("CoreSleepSelectorActivity", "showStartCoreSleepSwitchDialog ok click");
        this.f7109a.m10611b();
        Intent intent = new Intent();
        Intent intent2 = new Intent();
        intent2.setAction("action_change_core_sleep_button");
        this.f7109a.f7103a;
        intent.putExtra("status", "1");
        this.f7109a.f7103a;
        intent2.putExtra("status", "1");
        a.b(this.f7109a.f7105c, intent2);
        this.f7109a.setResult(-1, intent);
    }
}
