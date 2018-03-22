package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ContactsListActivity */
class ca implements OnClickListener {
    final /* synthetic */ int f5989a;
    final /* synthetic */ by f5990b;

    ca(by byVar, int i) {
        this.f5990b = byVar;
        this.f5989a = i;
    }

    public void onClick(View view) {
        C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  删除管理员操作");
        this.f5990b.f5985a.m9206a(this.f5990b.f5985a.f5604c, this.f5989a);
    }
}
