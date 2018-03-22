package com.huawei.pluginaf500.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: SportRemindActivity */
class ca implements OnCheckedChangeListener {
    final /* synthetic */ SportRemindActivity f19948a;

    ca(SportRemindActivity sportRemindActivity) {
        this.f19948a = sportRemindActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f19948a.f19843B = z ? 1 : 0;
    }
}
