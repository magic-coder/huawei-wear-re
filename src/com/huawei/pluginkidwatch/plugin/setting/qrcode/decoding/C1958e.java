package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: CaptureActivityHandler */
class C1958e implements OnDismissListener {
    final /* synthetic */ CaptureActivityHandler f6806a;

    C1958e(CaptureActivityHandler captureActivityHandler) {
        this.f6806a = captureActivityHandler;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f6806a.f6790d) {
            this.f6806a.m10225c();
        } else {
            this.f6806a.m10217a(null);
        }
    }
}
