package com.huawei.sim.esim.qrcode.decoding;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

/* compiled from: FinishListener */
public final class C5915d implements OnCancelListener, OnClickListener, Runnable {
    private final Activity f20280a;

    public C5915d(Activity activity) {
        this.f20280a = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void run() {
        this.f20280a.finish();
    }
}
