package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: AddPeroidActivity */
class at implements OnClickListener {
    final /* synthetic */ AddPeroidActivity f5944a;

    at(AddPeroidActivity addPeroidActivity) {
        this.f5944a = addPeroidActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5944a.f5494j = "";
        this.f5944a.f5470C = this.f5944a.f5473F.m8923a();
        for (int i2 = 0; i2 < this.f5944a.f5470C.length; i2++) {
            if (this.f5944a.f5470C[i2]) {
                if (i2 == 0) {
                    this.f5944a.f5494j = this.f5944a.f5494j + "7";
                } else {
                    this.f5944a.f5494j = this.f5944a.f5494j + i2 + "";
                }
            }
        }
        if ("".equals(this.f5944a.f5494j) || this.f5944a.f5494j.trim().length() == 0) {
            C1483c.m6824a(this.f5944a.getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_period_alarm_no_title);
            return;
        }
        this.f5944a.f5488c.dismiss();
        this.f5944a.f5488c.cancel();
        this.f5944a.f5488c = null;
        this.f5944a.m9093c(this.f5944a.f5494j);
        C2538c.m12674b("AddPeroidActivity", "==============repeate:" + this.f5944a.f5494j);
    }
}
