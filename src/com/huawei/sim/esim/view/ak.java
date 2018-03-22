package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ScanFailActivity */
class ak implements OnClickListener {
    final /* synthetic */ ScanFailActivity f20432a;

    ak(ScanFailActivity scanFailActivity) {
        this.f20432a = scanFailActivity;
    }

    public void onClick(View view) {
        this.f20432a.startActivity(new Intent(this.f20432a, EsimActivationActivity.class));
        this.f20432a.finish();
    }
}
