package com.huawei.pluginaf500.ui;

import android.telephony.PhoneStateListener;

/* compiled from: FindPhoneActivity */
class ak extends PhoneStateListener {
    final /* synthetic */ FindPhoneActivity f19886a;

    ak(FindPhoneActivity findPhoneActivity) {
        this.f19886a = findPhoneActivity;
    }

    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        if (i != 0 && i != this.f19886a.f19734i) {
            this.f19886a.mo5115j();
            this.f19886a.finish();
        }
    }
}
