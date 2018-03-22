package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: IncomingRemindActivity */
class as implements OnClickListener {
    final /* synthetic */ IncomingRemindActivity f19896a;

    as(IncomingRemindActivity incomingRemindActivity) {
        this.f19896a = incomingRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19896a.f19761b = this.f19896a.f19763d;
        this.f19896a.f19766i.setText(this.f19896a.f19761b);
        this.f19896a.f19762c = this.f19896a.f19764g;
        this.f19896a.f19767j.setText(this.f19896a.f19762c);
        SettingActivity.f19813a.m18185g(this.f19896a.f19761b);
        SettingActivity.f19813a.m18188h(this.f19896a.f19762c);
    }
}
