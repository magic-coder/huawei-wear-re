package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.p190v.C2538c;

/* compiled from: AppHelpActivity */
class C1913d extends WebViewClient {
    final /* synthetic */ AppHelpActivity f6677a;

    private C1913d(AppHelpActivity appHelpActivity) {
        this.f6677a = appHelpActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C2538c.m12674b("AppHelpActivity", "OverrideUrlLoading ", "" + str);
        webView.loadUrl(str);
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f6677a.f6256f.setVisibility(0);
        C2538c.m12674b("AppHelpActivity", "onPageStarted", " url=" + str);
        if (!str.equals("file:///android_asset/nullblank.html")) {
            this.f6677a.m9730p();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f6677a.f6256f.setVisibility(8);
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        C2538c.m12674b("AppHelpActivity", "OverrideUrlLoading ", "failingUrl = ", str2, ", errorCode = ", Integer.valueOf(i), ", description = ", str);
        this.f6677a.f6262l = str2;
        this.f6677a.m9729o();
        super.onReceivedError(webView, i, str, str2);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        C2538c.m12674b("AppHelpActivity", "apphelpActivity Enter doUpdateVisitedHistory");
        super.doUpdateVisitedHistory(webView, str, z);
    }
}
