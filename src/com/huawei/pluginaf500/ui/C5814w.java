package com.huawei.pluginaf500.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.p255a.p256a.C3565a;

/* compiled from: AlarmEditListActivity */
class C5814w implements OnClickListener {
    final /* synthetic */ Alarm f19978a;
    final /* synthetic */ C5813v f19979b;

    C5814w(C5813v c5813v, Alarm alarm) {
        this.f19979b = c5813v;
        this.f19978a = alarm;
    }

    public void onClick(View view) {
        new C3565a(this.f19979b.f19976b).m17899a(this.f19978a.getId());
        this.f19979b.f19976b.f19713g.remove(this.f19978a);
        this.f19979b.f19976b.m26678q();
        this.f19979b.f19976b.f19712d.notifyDataSetChanged();
    }
}
