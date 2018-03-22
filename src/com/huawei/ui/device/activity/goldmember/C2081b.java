package com.huawei.ui.device.activity.goldmember;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: HuaweiMemberActivity */
class C2081b implements OnCheckedChangeListener {
    final /* synthetic */ HuaweiMemberActivity f7361a;

    C2081b(HuaweiMemberActivity huaweiMemberActivity) {
        this.f7361a = huaweiMemberActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f7361a.f7282b.sendEmptyMessage(0);
    }
}
