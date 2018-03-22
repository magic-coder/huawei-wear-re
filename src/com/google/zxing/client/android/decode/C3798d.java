package com.google.zxing.client.android.decode;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

/* compiled from: FinishListener */
public final class C3798d implements OnCancelListener, OnClickListener {
    private final Activity f14776a;

    public C3798d(Activity activity) {
        this.f14776a = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        m19031a();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        m19031a();
    }

    private void m19031a() {
        this.f14776a.finish();
    }
}
