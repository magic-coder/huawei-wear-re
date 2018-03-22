package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: AddAlarmActivity */
class C1868j implements OnClickListener {
    final /* synthetic */ AddAlarmActivity f6173a;

    C1868j(AddAlarmActivity addAlarmActivity) {
        this.f6173a = addAlarmActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6173a.f5375u = "";
        this.f6173a.f5351K = this.f6173a.f5364i.m8923a();
        for (int i2 = 0; i2 < this.f6173a.f5351K.length; i2++) {
            if (this.f6173a.f5351K[i2]) {
                if (i2 == 0) {
                    this.f6173a.f5375u = this.f6173a.f5375u + "7";
                } else {
                    this.f6173a.f5375u = this.f6173a.f5375u + i2 + "";
                }
            }
        }
        if ("".equals(this.f6173a.f5375u) || this.f6173a.f5375u.trim().length() == 0) {
            C1483c.m6824a(this.f6173a.getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_period_alarm_no_title);
            return;
        }
        this.f6173a.f5358c.dismiss();
        this.f6173a.f5358c.cancel();
        this.f6173a.f5358c = null;
        this.f6173a.m8956c(this.f6173a.f5375u);
        C2538c.m12674b("AddAlarmActivity", "==============repeate:" + this.f6173a.f5375u);
    }
}
