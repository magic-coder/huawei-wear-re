package com.tencent.connect.avatar;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
class C6250d implements OnClickListener {
    final /* synthetic */ ImageActivity f21758a;

    C6250d(ImageActivity imageActivity) {
        this.f21758a = imageActivity;
    }

    public void onClick(View view) {
        this.f21758a.m28752a("10656", System.currentTimeMillis() - this.f21758a.f21744m);
        this.f21758a.setResult(0);
        this.f21758a.m28739d();
    }
}
