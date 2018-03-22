package com.huawei.pluginkidwatch.plugin.menu.p165a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;

/* compiled from: NotificationHistoryAdapter */
class am implements Runnable {
    final /* synthetic */ at f5193a;
    final /* synthetic */ ah f5194b;

    am(ah ahVar, at atVar) {
        this.f5194b = ahVar;
        this.f5193a = atVar;
    }

    public void run() {
        C2538c.m12674b("NotificationHistoryAdapter", "play complete");
        this.f5193a.f5233v.setImageResource(C1617f.kw_pic_list_play);
        this.f5193a.f5211E.setMax(0);
        this.f5193a.f5211E.setProgress(0);
        this.f5193a.f5208B.setText("00:00:00");
        this.f5194b.f5184l = 0;
        this.f5194b.f5183k = 0;
        this.f5194b.f5187o = "00:00:00";
        if (this.f5194b.f5181i != null) {
            this.f5194b.f5181i.cancel();
            this.f5194b.f5182j = null;
            this.f5194b.f5181i = null;
        }
        this.f5194b.f5179g.set(this.f5193a.f5210D, Integer.valueOf(2));
    }
}
