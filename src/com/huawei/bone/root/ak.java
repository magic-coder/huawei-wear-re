package com.huawei.bone.root;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: SplashActivity */
class ak implements OnCheckedChangeListener {
    final /* synthetic */ SplashActivity f23307a;

    ak(SplashActivity splashActivity) {
        this.f23307a = splashActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f23307a.f23286n = true;
        } else {
            this.f23307a.f23286n = false;
        }
    }
}
