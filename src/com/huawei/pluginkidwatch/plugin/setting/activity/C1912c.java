package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: AppHelpActivity */
class C1912c extends WebChromeClient {
    final /* synthetic */ AppHelpActivity f6652a;

    private C1912c(AppHelpActivity appHelpActivity) {
        this.f6652a = appHelpActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f6652a.f6256f.setProgress(i);
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
