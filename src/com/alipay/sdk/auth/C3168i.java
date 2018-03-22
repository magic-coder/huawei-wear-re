package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C3168i implements OnClickListener {
    final /* synthetic */ C3166g f10570a;

    C3168i(C3166g c3166g) {
        this.f10570a = c3166g;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10570a.f10567a.cancel();
        this.f10570a.f10568b.f10561a.f10557e = false;
        C3169j.m14010a(this.f10570a.f10568b.f10561a, this.f10570a.f10568b.f10561a.f10554b + "?resultCode=150");
        this.f10570a.f10568b.f10561a.finish();
    }
}
