package com.huawei.bone.root;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: ProtocolAndClauseActivity */
class C6800s implements OnCheckedChangeListener {
    final /* synthetic */ ProtocolAndClauseActivity f23342a;

    C6800s(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23342a = protocolAndClauseActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f23342a.m30141a(z);
        if (z) {
            this.f23342a.f23246m.b(true);
        } else {
            this.f23342a.f23246m.b(false);
        }
    }
}
