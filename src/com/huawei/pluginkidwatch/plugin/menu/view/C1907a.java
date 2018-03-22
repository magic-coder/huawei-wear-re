package com.huawei.pluginkidwatch.plugin.menu.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: FenceAddressEditText */
class C1907a implements OnFocusChangeListener {
    final /* synthetic */ FenceAddressEditText f6249a;

    C1907a(FenceAddressEditText fenceAddressEditText) {
        this.f6249a = fenceAddressEditText;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f6249a.f6245a != null) {
            this.f6249a.f6245a.mo2618a(view, z);
            if (!z) {
            }
        }
    }
}
