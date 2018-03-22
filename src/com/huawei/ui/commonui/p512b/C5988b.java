package com.huawei.ui.commonui.p512b;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PhotoCorp */
class C5988b implements OnClickListener {
    final /* synthetic */ C5987a f20600a;

    C5988b(C5987a c5987a) {
        this.f20600a = c5987a;
    }

    public void onClick(View view) {
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.f20600a.f20596e);
            this.f20600a.f20595d.startActivityForResult(intent, 1);
            this.f20600a.f20599h.dismiss();
        } catch (ActivityNotFoundException e) {
            C2538c.c("PhotoCorp", new Object[]{"ActivityNotFoundException e=" + e.getMessage()});
        }
    }
}
