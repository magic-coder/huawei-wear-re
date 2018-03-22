package com.huawei.ui.commonui.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.p190v.C2538c;

/* compiled from: WebViewActivity */
class C6052k extends WebViewClient {
    final /* synthetic */ WebViewActivity f20850a;

    private C6052k(WebViewActivity webViewActivity) {
        this.f20850a = webViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C2538c.c("WebViewActivity", new Object[]{"-- WebViewActivity load url =url" + str});
        if (this.f20850a.m27646a(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        C2538c.c("WebViewActivity", new Object[]{"-- WebViewActivity load url =url1" + str});
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f20850a.f20834g.setVisibility(0);
        this.f20850a.m27657f();
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f20850a.f20834g.setVisibility(8);
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f20850a.f20836i = str2;
        this.f20850a.m27655e();
        super.onReceivedError(webView, i, str, str2);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }
}
