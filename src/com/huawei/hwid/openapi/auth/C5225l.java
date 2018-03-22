package com.huawei.hwid.openapi.auth;

import android.webkit.WebView;
import java.util.TimerTask;

class C5225l extends TimerTask {
    final /* synthetic */ WebView f18847a;
    final /* synthetic */ C5222i f18848b;

    C5225l(C5222i c5222i, WebView webView) {
        this.f18848b = c5222i;
        this.f18847a = webView;
    }

    public void run() {
        this.f18848b.f18842f.post(new C5226m(this));
    }
}
