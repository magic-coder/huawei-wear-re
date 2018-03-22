package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.button.C1514c;

/* compiled from: GeneralSettingsActivity */
class es implements C1514c {
    final /* synthetic */ et f6090a;
    final /* synthetic */ er f6091b;

    es(er erVar, et etVar) {
        this.f6091b = erVar;
        this.f6090a = etVar;
    }

    public void mo2610a(boolean z) {
        C2538c.m12674b("GeneralSettingsAdapter", "switch checkState = " + z + "  holder.mItemIndex = " + this.f6090a.f6095d + "   holder.mSettingsItem.mItemTag = " + this.f6090a.f6096e.f6102e);
        this.f6090a.f6096e.f6100c = z;
        if (this.f6090a.f6096e.f6102e.equals("mute_switch_tag")) {
            this.f6091b.f6087a.f5742k = z;
            this.f6091b.f6087a.m9392a("muteSwitch", z);
        } else if (this.f6090a.f6096e.f6102e.equals("sos_switch_tag")) {
            this.f6091b.f6087a.f5743l = z;
            this.f6091b.f6087a.m9392a("SOSSwitch", z);
        } else if (this.f6090a.f6096e.f6102e.equals("reject_call_tag")) {
            this.f6091b.f6087a.f5744m = z;
            this.f6091b.f6087a.m9392a("incomingcallswitch", z);
        }
    }
}
