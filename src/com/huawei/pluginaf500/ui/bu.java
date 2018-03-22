package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: SleepRemindActivity */
class bu implements OnClickListener {
    final /* synthetic */ SleepRemindActivity f19941a;

    bu(SleepRemindActivity sleepRemindActivity) {
        this.f19941a = sleepRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19941a.f19833d = this.f19941a.f19835h;
        this.f19941a.f19838k.setText(this.f19941a.f19833d);
        this.f19941a.f19834g = this.f19941a.f19836i;
        this.f19941a.f19839l.setText(this.f19941a.f19834g);
    }
}
