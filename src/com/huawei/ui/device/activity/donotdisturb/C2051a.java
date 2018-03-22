package com.huawei.ui.device.activity.donotdisturb;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NoDisturbSettingActivity */
class C2051a implements OnClickListener {
    final /* synthetic */ NoDisturbSettingActivity f7192a;

    C2051a(NoDisturbSettingActivity noDisturbSettingActivity) {
        this.f7192a = noDisturbSettingActivity;
    }

    public void onClick(View view) {
        if (this.f7192a.f7168c.m10396d() == 2) {
            this.f7192a.m10705n();
        } else {
            this.f7192a.m10703m();
        }
    }
}
