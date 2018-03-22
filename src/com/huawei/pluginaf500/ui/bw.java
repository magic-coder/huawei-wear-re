package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: SleepRemindActivity */
class bw implements OnClickListener {
    final /* synthetic */ SleepRemindActivity f19943a;

    bw(SleepRemindActivity sleepRemindActivity) {
        this.f19943a = sleepRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19943a.m26511b();
        if (3 == C3596n.m18054a()) {
            this.f19943a.m26831m();
        } else if (!(this.f19943a.m26514e() == null || TextUtils.isEmpty(this.f19943a.m26514e().m26560b()))) {
            this.f19943a.m26514e().m26562c();
        }
        this.f19943a.m26817b(5);
    }
}
