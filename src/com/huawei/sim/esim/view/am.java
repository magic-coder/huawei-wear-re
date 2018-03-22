package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: WirelessManagerAcitivity */
class am implements OnClickListener {
    final /* synthetic */ WirelessManagerAcitivity f20434a;

    am(WirelessManagerAcitivity wirelessManagerAcitivity) {
        this.f20434a = wirelessManagerAcitivity;
    }

    public void onClick(View view) {
        this.f20434a.f20404d.startActivity(new Intent(this.f20434a, EsimActivationActivity.class));
    }
}
