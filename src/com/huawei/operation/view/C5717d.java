package com.huawei.operation.view;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.huawei.p190v.C2538c;

/* compiled from: CustomWebView */
class C5717d extends WebChromeClient {
    final /* synthetic */ CustomWebView f19488a;

    private C5717d(CustomWebView customWebView) {
        this.f19488a = customWebView;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f19488a.f19479c.setProgress(i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"onReceivedTitle title:" + str});
        this.f19488a.setBrowserTitle(str);
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"onReceivedTitle mWebViewTitles:" + this.f19488a.f19482f.toString()});
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"onReceivedTouchIconUrl " + str});
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return super.onCreateWindow(webView, z, z2, message);
    }
}
