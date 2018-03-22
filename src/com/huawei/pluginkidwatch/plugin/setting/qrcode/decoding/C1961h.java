package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: CaptureActivityHandler */
class C1961h implements OnDismissListener {
    final /* synthetic */ CaptureActivityHandler f6809a;

    C1961h(CaptureActivityHandler captureActivityHandler) {
        this.f6809a = captureActivityHandler;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f6809a.f6790d) {
            this.f6809a.m10225c();
        } else {
            this.f6809a.m10217a(null);
        }
    }
}
