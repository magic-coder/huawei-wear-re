package com.tencent.connect.avatar;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ProGuard */
class C6247a implements OnGlobalLayoutListener {
    final /* synthetic */ ImageActivity f21755a;

    C6247a(ImageActivity imageActivity) {
        this.f21755a = imageActivity;
    }

    public void onGlobalLayout() {
        this.f21755a.f21732a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.f21755a.f21748q = this.f21755a.f21739h.m28768a();
        this.f21755a.f21736e.m28776a(this.f21755a.f21748q);
    }
}
