package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ConformActivity */
class C5924a implements OnClickListener {
    final /* synthetic */ ConformActivity f20421a;

    C5924a(ConformActivity conformActivity) {
        this.f20421a = conformActivity;
    }

    public void onClick(View view) {
        this.f20421a.startActivity(new Intent(this.f20421a, EsimProfileAcitvity.class));
        this.f20421a.finish();
    }
}
