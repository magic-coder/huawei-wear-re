package com.huawei.sim.multisim;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;

/* compiled from: MultiSimConfigActivity */
class C5951b implements TextWatcher {
    final /* synthetic */ MultiSimConfigActivity f20524a;

    C5951b(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20524a = multiSimConfigActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"CharSequence " + charSequence.toString() + "length " + charSequence.length()});
        if (this.f20524a.f20480J && charSequence.length() == 6) {
            this.f20524a.m27347p();
        } else {
            this.f20524a.m27346o();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
