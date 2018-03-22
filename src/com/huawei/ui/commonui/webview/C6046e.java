package com.huawei.ui.commonui.webview;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: LegalInfoWebViewActivity */
class C6046e extends WebChromeClient {
    private C6046e() {
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
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
