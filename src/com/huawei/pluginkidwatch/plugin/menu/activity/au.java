package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;

/* compiled from: AlarmActivity */
class au implements OnClickListener {
    final /* synthetic */ AlarmActivity f5945a;

    au(AlarmActivity alarmActivity) {
        this.f5945a = alarmActivity;
    }

    public void onClick(View view) {
        this.f5945a.m9122a(true);
        this.f5945a.f5523n.setVisibility(8);
        this.f5945a.f5521l.setText(this.f5945a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_settings_mult_alarm_loading));
        this.f5945a.m9133e();
    }
}
