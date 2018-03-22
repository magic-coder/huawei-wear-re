package com.huawei.ui.device.activity.donotdisturb;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: NoDisturbSettingActivity */
class C2055e implements IBaseResponseCallback {
    final /* synthetic */ NoDisturbSettingActivity f7197a;

    C2055e(NoDisturbSettingActivity noDisturbSettingActivity) {
        this.f7197a = noDisturbSettingActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && ((Integer) obj).intValue() == 100000) {
            this.f7197a.f7165F.sendEmptyMessage(2);
        } else {
            this.f7197a.f7165F.sendEmptyMessage(3);
        }
    }
}
