package com.huawei.ui.device.activity.smartalarm;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;

/* compiled from: SmartAlarmClockActivity */
class C2156c implements OnItemClickListener {
    final /* synthetic */ SmartAlarmClockActivity f7648a;

    C2156c(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7648a = smartAlarmClockActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f7648a.f7645z = i;
        this.f7648a.m11080k();
        Object obj = this.f7648a.f7643x[this.f7648a.f7645z];
        C2538c.m12677c("SmartAlarmClockActivity", "dialogAheadTime onClick before replace mSmartWakeArrayPosition = " + this.f7648a.f7645z);
        C2538c.m12677c("SmartAlarmClockActivity", "dialogAheadTime onClick before replace aheadTime=" + obj);
        this.f7648a.m11055b(this.f7648a.f7645z);
        this.f7648a.f7620a.setText(obj);
        if (this.f7648a.f7626g.getString(i.IDS_settings_about_huawei_cloud_service_action_turn_off).equals(obj)) {
            this.f7648a.f7621b.setVisibility(8);
        } else {
            this.f7648a.f7621b.setVisibility(0);
        }
        C2538c.m12677c("SmartAlarmClockActivity", "dialogAheadTime onClick after replace aheadTime=" + obj);
        this.f7648a.m11076i();
    }
}
