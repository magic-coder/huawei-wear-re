package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C3156f implements OnClickListener {
    final /* synthetic */ C3154d f10540a;

    C3156f(C3154d c3154d) {
        this.f10540a = c3154d;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10540a.f10537a.cancel();
        this.f10540a.f10538b.f10533c = false;
        C3158h.f10542a = C3158h.m13994a();
        this.f10540a.f10538b.f10532b.finish();
    }
}
