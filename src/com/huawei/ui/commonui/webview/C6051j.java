package com.huawei.ui.commonui.webview;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: WebViewActivity */
class C6051j extends WebChromeClient {
    final /* synthetic */ WebViewActivity f20849a;

    private C6051j(WebViewActivity webViewActivity) {
        this.f20849a = webViewActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f20849a.f20834g.setProgress(i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return super.onCreateWindow(webView, z, z2, message);
    }
}
