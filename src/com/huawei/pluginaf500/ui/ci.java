package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: SportRemindActivity */
class ci implements OnClickListener {
    final /* synthetic */ SportRemindActivity f19956a;

    ci(SportRemindActivity sportRemindActivity) {
        this.f19956a = sportRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19956a.m26511b();
        if (3 == C3596n.m18054a()) {
            this.f19956a.m26867n();
        } else if (!(this.f19956a.m26514e() == null || TextUtils.isEmpty(this.f19956a.m26514e().m26560b()))) {
            this.f19956a.m26514e().m26562c();
        }
        this.f19956a.m26844b(5);
    }
}
