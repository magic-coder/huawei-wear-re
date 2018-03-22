package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.sim.esim.qrcode.QrCodeActivity;

/* compiled from: EsimProfileAcitvity */
class C5947x implements OnClickListener {
    final /* synthetic */ EsimProfileAcitvity f20462a;

    C5947x(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20462a = esimProfileAcitvity;
    }

    public void onClick(View view) {
        this.f20462a.startActivity(new Intent(this.f20462a, QrCodeActivity.class));
        this.f20462a.finish();
    }
}
