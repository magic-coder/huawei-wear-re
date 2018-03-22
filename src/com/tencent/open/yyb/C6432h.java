package com.tencent.open.yyb;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: ProGuard */
class C6432h extends WebChromeClient {
    final /* synthetic */ AppbarActivity f22316a;

    private C6432h(AppbarActivity appbarActivity) {
        this.f22316a = appbarActivity;
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.f22316a.f22295d.setTitle(str);
    }
}
