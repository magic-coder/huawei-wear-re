package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ContactInfoActivity */
class bj implements OnClickListener {
    final /* synthetic */ ContactInfoActivity f5965a;

    bj(ContactInfoActivity contactInfoActivity) {
        this.f5965a = contactInfoActivity;
    }

    public void onClick(View view) {
        this.f5965a.f5544Q.cancel();
        this.f5965a.f5544Q = null;
        this.f5965a.m9140a(this.f5965a.f5568r);
        C2538c.m12674b("ContactInfoActivity", "========Enter other cancle");
    }
}
