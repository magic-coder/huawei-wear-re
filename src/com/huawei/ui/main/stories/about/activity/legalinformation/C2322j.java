package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.p190v.C2538c;

/* compiled from: PrivacyPolicyActivity */
class C2322j extends WebViewClient {
    final /* synthetic */ PrivacyPolicyActivity f8410a;

    private C2322j(PrivacyPolicyActivity privacyPolicyActivity) {
        this.f8410a = privacyPolicyActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===OverrideUrlLoading " + str);
        if (str.contains("mailto")) {
            this.f8410a.f8394f.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
        } else {
            webView.loadUrl(str);
        }
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f8410a.f8389a.setVisibility(0);
        C2538c.m12674b("PrivacyPolicyActivity", "===www===onPageStarted url=" + str);
        this.f8410a.m11847d();
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===onPageFinished url=" + str);
        this.f8410a.f8389a.setVisibility(8);
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===onReceivedError " + str2);
        this.f8410a.m11845c();
        super.onReceivedError(webView, i, str, str2);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }
}
