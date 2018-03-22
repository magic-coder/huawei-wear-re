package com.huawei.ui.commonui.webview;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: LegalInfoWebViewActivity */
class C6044c implements OnClickListener {
    final /* synthetic */ LegalInfoWebViewActivity f20843a;

    C6044c(LegalInfoWebViewActivity legalInfoWebViewActivity) {
        this.f20843a = legalInfoWebViewActivity;
    }

    public void onClick(View view) {
        this.f20843a.f20825l.cancel();
        this.f20843a.f20818e.setVisibility(0);
        this.f20843a.m27638f();
    }
}
