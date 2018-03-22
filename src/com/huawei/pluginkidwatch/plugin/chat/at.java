package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatAdapter */
class at implements OnClickListener {
    final /* synthetic */ C1744a f4833a;
    final /* synthetic */ av f4834b;
    final /* synthetic */ as f4835c;

    at(as asVar, C1744a c1744a, av avVar) {
        this.f4835c = asVar;
        this.f4833a = c1744a;
        this.f4834b = avVar;
    }

    public void onClick(View view) {
        boolean z = true;
        if (this.f4835c.f4832h == 1) {
            C2538c.m12674b("ChatAdapter", "==========onCheckedChanged:");
            C1744a c1744a = this.f4833a;
            if (this.f4833a.f4787v) {
                z = false;
            }
            c1744a.f4787v = z;
            this.f4834b.setChecked(this.f4833a.f4787v);
            this.f4835c.f4829e.sendEmptyMessage(1006);
        }
    }
}
