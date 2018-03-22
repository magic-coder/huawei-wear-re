package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: FenceModeAdapter */
class af implements OnCheckedChangeListener {
    final /* synthetic */ ag f5166a;
    final /* synthetic */ ad f5167b;

    af(ad adVar, ag agVar) {
        this.f5167b = adVar;
        this.f5166a = agVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f5166a.f5171d.setmIsSelected(z);
        if (!ad.m8817a()) {
            if (z) {
                this.f5167b.f5163d.sendEmptyMessage(3);
            } else {
                this.f5167b.f5163d.sendEmptyMessage(4);
            }
        }
    }
}
