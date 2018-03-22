package com.huawei.ui.commonui.webview;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: LegalInfoWebViewActivity */
class C6045d implements OnClickListener {
    final /* synthetic */ LegalInfoWebViewActivity f20844a;

    C6045d(LegalInfoWebViewActivity legalInfoWebViewActivity) {
        this.f20844a = legalInfoWebViewActivity;
    }

    public void onClick(View view) {
        this.f20844a.f20825l.cancel();
        this.f20844a.finish();
    }
}
