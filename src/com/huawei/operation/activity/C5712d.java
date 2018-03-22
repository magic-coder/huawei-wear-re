package com.huawei.operation.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.p190v.C2538c;

/* compiled from: WebViewActivity */
class C5712d extends WebViewClient {
    final /* synthetic */ WebViewActivity f19474a;

    private C5712d(WebViewActivity webViewActivity) {
        this.f19474a = webViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"shouldOverrideUrlLoading OverrideUrlLoading " + str});
        webView.loadUrl(str);
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f19474a.f19464e.setVisibility(0);
        C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"OverrideUrlLoading url:" + str});
        if (this.f19474a.f19465f.m26357a(str)) {
            C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"OverrideUrlLoading false:"});
            this.f19474a.f19465f.setJsEnable(false);
        } else {
            C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"OverrideUrlLoading true:"});
            this.f19474a.f19465f.setJsEnable(true);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        C2538c.b("[Operation Version 1.2]WebViewActivity", new Object[]{"onPageFinished enter url=" + str});
        this.f19474a.f19464e.setVisibility(8);
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"onReceivedError enter" + str2});
        super.onReceivedError(webView, i, str, str2);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"doUpdateVisitedHistory enter" + str});
        super.doUpdateVisitedHistory(webView, str, z);
    }
}
