package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.sim.esim.qrcode.QrCodeActivity;

/* compiled from: EsimProflieAuthenticationFail */
class aj implements OnClickListener {
    final /* synthetic */ EsimProflieAuthenticationFail f20431a;

    aj(EsimProflieAuthenticationFail esimProflieAuthenticationFail) {
        this.f20431a = esimProflieAuthenticationFail;
    }

    public void onClick(View view) {
        this.f20431a.startActivity(new Intent(this.f20431a, QrCodeActivity.class));
        this.f20431a.finish();
    }
}
