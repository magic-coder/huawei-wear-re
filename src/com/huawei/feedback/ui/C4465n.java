package com.huawei.feedback.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: FeedbackEditActivity */
class C4465n extends WebViewClient {
    final /* synthetic */ FeedbackEditActivity f16597a;

    C4465n(FeedbackEditActivity feedbackEditActivity) {
        this.f16597a = feedbackEditActivity;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        c.d("FeedbackEditActivity", "onReceivedError errorCode=" + i + " description= " + str);
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        c.d("FeedbackEditActivity", "onReceivedSslError: " + (sslError != null ? sslError.toString() : "error is null."));
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("mailto:") && !str.startsWith("geo:") && !str.startsWith("tel:")) {
            return false;
        }
        this.f16597a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || !com.huawei.feedback.c.c(this.f16597a.f16500c, str)) {
            webView.getSettings().setJavaScriptEnabled(false);
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            com.huawei.feedback.c.a(webView);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        CharSequence title = webView.getTitle();
        if (!TextUtils.isEmpty(title) && this.f16597a.ag != null) {
            this.f16597a.ag.setTitle(title);
        }
    }
}
