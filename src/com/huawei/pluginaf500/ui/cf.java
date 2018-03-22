package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: SportRemindActivity */
class cf implements OnClickListener {
    final /* synthetic */ SportRemindActivity f19953a;

    cf(SportRemindActivity sportRemindActivity) {
        this.f19953a = sportRemindActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f19953a.f19857n == 1) {
            this.f19953a.f19850g = this.f19953a.f19852i = this.f19953a.f19848c.m26996a();
        } else if (this.f19953a.f19857n == 2) {
            this.f19953a.f19851h = this.f19953a.f19853j = this.f19953a.f19848c.m26996a();
        } else if (this.f19953a.f19857n == 3) {
            this.f19953a.f19855l = this.f19953a.f19848c.m26996a();
        } else if (this.f19953a.f19857n == 4) {
            this.f19953a.f19856m = this.f19953a.f19848c.m26996a();
        }
        this.f19953a.f19859p.setText(this.f19953a.f19850g);
        this.f19953a.f19860q.setText(this.f19953a.f19851h);
        this.f19953a.f19861r.setText(this.f19953a.f19855l);
        this.f19953a.f19862s.setText(this.f19953a.f19856m);
    }
}
