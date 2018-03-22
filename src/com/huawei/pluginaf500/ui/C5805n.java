package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: AlarmEditActivity */
class C5805n implements OnClickListener {
    final /* synthetic */ AlarmEditActivity f19967a;

    C5805n(AlarmEditActivity alarmEditActivity) {
        this.f19967a = alarmEditActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19967a.m26511b();
        if (this.f19967a.m26514e() != null) {
            if (3 == C3596n.m18054a()) {
                this.f19967a.m26655o();
            } else {
                this.f19967a.m26514e().m26562c();
            }
        }
        this.f19967a.m26647b(5);
    }
}
