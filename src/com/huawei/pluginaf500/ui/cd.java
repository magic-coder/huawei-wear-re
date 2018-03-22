package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.pluginaf500.h;

/* compiled from: SportRemindActivity */
class cd implements OnClickListener {
    final /* synthetic */ SportRemindActivity f19951a;

    cd(SportRemindActivity sportRemindActivity) {
        this.f19951a = sportRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19951a.f19863t.setText(this.f19951a.f19854k + this.f19951a.getString(h.minuter));
    }
}
