package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileAcitvity */
class aa implements OnClickListener {
    final /* synthetic */ EsimProfileAcitvity f20422a;

    aa(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20422a = esimProfileAcitvity;
    }

    public void onClick(View view) {
        C2538c.b("EsimProfileAcitvity", new Object[]{"mBackButton.setOnClickListene"});
        this.f20422a.startActivity(new Intent(this.f20422a, QrCodeActivity.class));
        this.f20422a.finish();
    }
}
