package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.p190v.C2538c;

public abstract class PopupDialogActivity extends Activity {
    private String f3803a = "PopupDialogActivity";

    protected abstract void mo2598a();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.m12674b(this.f3803a, "==============BackGroundActivity onCreate() ");
        requestWindowFeature(1);
        mo2598a();
    }
}
