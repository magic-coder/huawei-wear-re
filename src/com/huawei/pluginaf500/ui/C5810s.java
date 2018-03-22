package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: AlarmEditListActivity */
class C5810s implements OnClickListener {
    final /* synthetic */ AlarmEditListActivity f19972a;

    C5810s(AlarmEditListActivity alarmEditListActivity) {
        this.f19972a = alarmEditListActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19972a.m26511b();
        if (this.f19972a.m26514e() != null) {
            if (3 == C3596n.m18054a()) {
                this.f19972a.m26675n();
            } else {
                this.f19972a.m26514e().m26562c();
            }
        }
        this.f19972a.m26665b(5);
    }
}
