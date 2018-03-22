package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.sim.esim.p504a.C5899a;
import com.huawei.sim.esim.qrcode.QrCodeActivity;

/* compiled from: EsimActivationActivity */
class C5933j implements OnClickListener {
    final /* synthetic */ EsimActivationActivity f20446a;

    C5933j(EsimActivationActivity esimActivationActivity) {
        this.f20446a = esimActivationActivity;
    }

    public void onClick(View view) {
        if (C5899a.m27107a(this.f20446a, new String[]{"android.permission.CAMERA"})) {
            this.f20446a.startActivity(new Intent(this.f20446a, QrCodeActivity.class));
            return;
        }
        this.f20446a.requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
    }
}
