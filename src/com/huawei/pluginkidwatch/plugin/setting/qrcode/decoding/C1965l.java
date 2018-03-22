package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

/* compiled from: FinishListener */
public final class C1965l implements OnCancelListener, OnClickListener, Runnable {
    private final Activity f6823a;

    public C1965l(Activity activity) {
        this.f6823a = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public void run() {
        this.f6823a.finish();
    }
}
