package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: AlarmAddActivity */
class C5801j implements OnClickListener {
    final /* synthetic */ AlarmAddActivity f19963a;

    C5801j(AlarmAddActivity alarmAddActivity) {
        this.f19963a = alarmAddActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19963a.m26511b();
        if (this.f19963a.m26514e() != null) {
            if (3 == C3596n.m18054a()) {
                this.f19963a.m26637o();
            } else {
                this.f19963a.m26514e().m26562c();
            }
        }
        this.f19963a.m26629b(5);
    }
}
