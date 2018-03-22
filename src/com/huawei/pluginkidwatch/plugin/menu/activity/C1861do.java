package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.plugin.menu.p165a.ag;

/* compiled from: ElectronicFenceActivity */
class C1861do implements OnClickListener {
    final /* synthetic */ int f6042a;
    final /* synthetic */ ag f6043b;
    final /* synthetic */ dn f6044c;

    C1861do(dn dnVar, int i, ag agVar) {
        this.f6044c = dnVar;
        this.f6042a = i;
        this.f6043b = agVar;
    }

    public void onClick(View view) {
        this.f6044c.f6041a.f5710f.cancel();
        this.f6044c.f6041a.m9345a(this.f6042a, this.f6043b.f5171d.getmFenceId());
    }
}
