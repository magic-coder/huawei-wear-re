package com.google.zxing.client.android;

import android.text.TextUtils;

/* compiled from: CaptureActivity */
class C3812i implements C3811r {
    final /* synthetic */ CaptureActivity f14817a;

    C3812i(CaptureActivity captureActivity) {
        this.f14817a = captureActivity;
    }

    public void mo4315a(String str) {
        this.f14817a.m18953q();
        if (TextUtils.isEmpty(str)) {
            this.f14817a.m18955s();
            return;
        }
        this.f14817a.m18957u();
        this.f14817a.m18956t();
        this.f14817a.m18931a(str);
    }
}
