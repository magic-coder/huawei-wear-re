package com.huawei.sim.multisim;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;

/* compiled from: MultiSimConfigActivity */
class C5961l implements TextWatcher {
    final /* synthetic */ MultiSimConfigActivity f20534a;

    C5961l(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20534a = multiSimConfigActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"CharSequence " + charSequence.toString() + "length " + charSequence.length()});
        if (this.f20534a.f20480J) {
            this.f20534a.f20480J = false;
            this.f20534a.m27346o();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
