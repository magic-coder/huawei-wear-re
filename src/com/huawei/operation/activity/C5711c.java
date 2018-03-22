package com.huawei.operation.activity;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;

/* compiled from: WebViewActivity */
class C5711c extends WebChromeClient {
    final /* synthetic */ WebViewActivity f19473a;

    private C5711c(WebViewActivity webViewActivity) {
        this.f19473a = webViewActivity;
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        this.f19473a.m26337a((ValueCallback) valueCallback);
        return true;
    }
}
