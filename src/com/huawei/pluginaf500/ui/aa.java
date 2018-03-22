package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: AlarmRemindActivity */
class aa implements OnClickListener {
    final /* synthetic */ AlarmRemindActivity f19871a;

    aa(AlarmRemindActivity alarmRemindActivity) {
        this.f19871a = alarmRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19871a.m26511b();
        if (this.f19871a.m26514e() != null) {
            if (3 == C3596n.m18054a()) {
                this.f19871a.m26696n();
            } else {
                this.f19871a.m26514e().m26562c();
            }
        }
        this.f19871a.m26684b(5);
    }
}
