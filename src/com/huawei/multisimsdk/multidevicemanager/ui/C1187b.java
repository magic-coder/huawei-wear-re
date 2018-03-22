package com.huawei.multisimsdk.multidevicemanager.ui;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: SignWebActivity */
class C1187b extends WebChromeClient {
    final /* synthetic */ SignWebActivity f2606a;

    C1187b(SignWebActivity signWebActivity) {
        this.f2606a = signWebActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i > SignWebActivity.WEB_VIEW_PROGRESS) {
            this.f2606a.showProgressBar(false);
        }
        super.onProgressChanged(webView, i);
        webView.requestFocus();
    }
}
