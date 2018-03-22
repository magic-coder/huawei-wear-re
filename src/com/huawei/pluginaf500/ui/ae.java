package com.huawei.pluginaf500.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.fenda.hwbracelet.mode.Alarm;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.utils.C5826i;

/* compiled from: AlarmRemindActivity */
class ae implements OnCheckedChangeListener {
    final /* synthetic */ int f19877a;
    final /* synthetic */ ad f19878b;

    ae(ad adVar, int i) {
        this.f19878b = adVar;
        this.f19877a = i;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            ((Alarm) this.f19878b.f19875b.f19721g.get(this.f19877a)).setOnOff(1);
        } else {
            ((Alarm) this.f19878b.f19875b.f19721g.get(this.f19877a)).setOnOff(0);
        }
        if (this.f19878b.f19875b.m26698p() && this.f19878b.f19875b.f19723i) {
            C5826i.m26921a(this.f19878b.f19875b, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19878b.f19875b.f19724j, this.f19878b.f19875b.f19725k);
        }
    }
}
