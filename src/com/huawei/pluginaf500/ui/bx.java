package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: SleepRemindActivity */
class bx implements OnClickListener {
    final /* synthetic */ SleepRemindActivity f19944a;

    bx(SleepRemindActivity sleepRemindActivity) {
        this.f19944a = sleepRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19944a.finish();
    }
}
