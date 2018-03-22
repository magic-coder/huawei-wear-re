package com.huawei.pluginkidwatch.plugin.menu.view;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FenceAddressEditText */
class C1908b implements TextWatcher {
    final /* synthetic */ FenceAddressEditText f6250a;

    C1908b(FenceAddressEditText fenceAddressEditText) {
        this.f6250a = fenceAddressEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6250a.f6246b = !this.f6250a.f6248d.equals(charSequence.toString());
        if (this.f6250a.f6246b) {
            this.f6250a.f6247c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
    }
}
