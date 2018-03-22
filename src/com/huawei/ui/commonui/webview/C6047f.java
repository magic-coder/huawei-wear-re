package com.huawei.ui.commonui.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: LegalInfoWebViewActivity */
class C6047f extends WebViewClient {
    final /* synthetic */ LegalInfoWebViewActivity f20845a;

    private C6047f(LegalInfoWebViewActivity legalInfoWebViewActivity) {
        this.f20845a = legalInfoWebViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.contains("mailto")) {
            this.f20845a.f20821h.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
        } else {
            webView.loadUrl(str);
        }
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f20845a.f20814a.setVisibility(0);
        this.f20845a.m27634d();
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f20845a.f20814a.setVisibility(8);
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f20845a.m27631c();
        super.onReceivedError(webView, i, str, str2);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }
}
