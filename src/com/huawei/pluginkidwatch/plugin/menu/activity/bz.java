package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ContactsListActivity */
class bz implements OnClickListener {
    final /* synthetic */ int f5986a;
    final /* synthetic */ by f5987b;

    bz(by byVar, int i) {
        this.f5987b = byVar;
        this.f5986a = i;
    }

    public void onClick(View view) {
        C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  转移权限操作");
        this.f5987b.f5985a.m9206a(this.f5987b.f5985a.f5603b, this.f5986a);
    }
}
