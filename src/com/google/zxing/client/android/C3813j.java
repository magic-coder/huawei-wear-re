package com.google.zxing.client.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: CaptureActivity */
class C3813j implements OnClickListener {
    final /* synthetic */ CaptureActivity f14818a;

    C3813j(CaptureActivity captureActivity) {
        this.f14818a = captureActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.f14818a.m18932a(true);
        }
    }
}
