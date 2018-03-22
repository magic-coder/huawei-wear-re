package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C3155e implements OnClickListener {
    final /* synthetic */ C3154d f10539a;

    C3155e(C3154d c3154d) {
        this.f10539a = c3154d;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10539a.f10538b.f10533c = true;
        this.f10539a.f10537a.proceed();
        dialogInterface.dismiss();
    }
}
