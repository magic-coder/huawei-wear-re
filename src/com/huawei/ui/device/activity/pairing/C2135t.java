package com.huawei.ui.device.activity.pairing;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

/* compiled from: DevicePairGuideActivity */
class C2135t implements OnKeyListener {
    final /* synthetic */ DevicePairGuideActivity f7545a;

    C2135t(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7545a = devicePairGuideActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (this.f7545a.ao != null && this.f7545a.ao.isShowing()) {
                this.f7545a.ao.dismiss();
                this.f7545a.ao = null;
                this.f7545a.m10914b();
            } else if (this.f7545a.ap != null && this.f7545a.ap.isShowing()) {
                this.f7545a.ap.dismiss();
                this.f7545a.ap = null;
                this.f7545a.finish();
            } else if (this.f7545a.as != null && this.f7545a.as.isShowing()) {
                this.f7545a.as.dismiss();
                this.f7545a.as = null;
                this.f7545a.finish();
            } else if (this.f7545a.aq != null && this.f7545a.aq.isShowing()) {
                this.f7545a.m10904a(this.f7545a.f7500f);
            }
        }
        return false;
    }
}
