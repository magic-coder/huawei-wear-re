package com.huawei.ui.device.activity.donotdisturb;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: NoDisturbSettingActivity */
class C2054d implements OnDismissListener {
    final /* synthetic */ NoDisturbSettingActivity f7196a;

    C2054d(NoDisturbSettingActivity noDisturbSettingActivity) {
        this.f7196a = noDisturbSettingActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f7196a.f7160A = null;
    }
}
