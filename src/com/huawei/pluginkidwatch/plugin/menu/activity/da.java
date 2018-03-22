package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EditCustomTimeActivity */
class da implements OnClickListener {
    final /* synthetic */ int f6021a;
    final /* synthetic */ String f6022b;
    final /* synthetic */ cz f6023c;

    da(cz czVar, int i, String str) {
        this.f6023c = czVar;
        this.f6021a = i;
        this.f6022b = str;
    }

    public void onClick(View view) {
        this.f6023c.f6019a.f5648j.cancel();
        this.f6023c.f6019a.f5648j = null;
        for (int i = 0; i < this.f6023c.f6019a.f5657s.length; i++) {
            this.f6023c.f6019a.f5657s[i] = false;
        }
        this.f6023c.f6019a.f5657s[this.f6021a] = true;
        this.f6023c.f6019a.f5653o = this.f6022b;
        this.f6023c.f6019a.m9283a(this.f6022b);
    }
}
