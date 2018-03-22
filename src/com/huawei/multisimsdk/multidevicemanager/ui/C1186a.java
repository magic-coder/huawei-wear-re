package com.huawei.multisimsdk.multidevicemanager.ui;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;

/* compiled from: SignWebActivity */
class C1186a extends WebViewClient {
    final /* synthetic */ SignWebActivity f2605a;

    C1186a(SignWebActivity signWebActivity) {
        this.f2605a = signWebActivity;
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        C1183h.m5282b("SignWebActivity", "onReceivedError");
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webView != null) {
            webView.stopLoading();
            webView.removeAllViews();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C1183h.m5282b("SignWebActivity", "onPageStarted");
        this.f2605a.showProgressBar(true);
    }
}
