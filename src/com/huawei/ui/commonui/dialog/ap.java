package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SecurityManagerSettingSwitchDialog */
class ap implements OnClickListener {
    final /* synthetic */ an f20661a;
    final /* synthetic */ ao f20662b;

    ap(ao aoVar, an anVar) {
        this.f20662b = aoVar;
        this.f20661a = anVar;
    }

    public void onClick(View view) {
        this.f20661a.dismiss();
        try {
            this.f20662b.m27523b();
        } catch (SecurityException e) {
            C2538c.c(an.f20654a, new Object[]{"SecurityException when opening security manager"});
            this.f20662b.m27531g();
        } catch (Exception e2) {
            C2538c.e(an.f20654a, new Object[]{"Unknown exception occurred when opening security manager " + e2.getMessage()});
        }
    }
}
