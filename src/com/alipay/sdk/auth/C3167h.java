package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C3167h implements OnClickListener {
    final /* synthetic */ C3166g f10569a;

    C3167h(C3166g c3166g) {
        this.f10569a = c3166g;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10569a.f10568b.f10561a.f10557e = true;
        this.f10569a.f10567a.proceed();
        dialogInterface.dismiss();
    }
}
