package com.alipay.sdk.auth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.p246c.C3172b;
import com.alipay.sdk.p246c.C3173c;

final class C3161b extends WebViewClient {
    final /* synthetic */ AuthActivity f10561a;

    private C3161b(AuthActivity authActivity) {
        this.f10561a = authActivity;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f10561a.f10558f = true;
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f10561a.f10557e) {
            sslErrorHandler.proceed();
            this.f10561a.f10557e = false;
            return;
        }
        this.f10561a.runOnUiThread(new C3166g(this, sslErrorHandler));
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                C3173c a = C3172b.m14015a(this.f10561a, "com.eg.android.AlipayGphone");
                if (a == null || a.m14027a()) {
                    return true;
                }
                if (str.startsWith("intent://platformapi/startapp")) {
                    str = str.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?");
                }
                this.f10561a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Throwable th) {
                return true;
            }
        } else if (!AuthActivity.m13999a(this.f10561a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            webView.stopLoading();
            return true;
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AuthActivity.m14004d(this.f10561a);
        this.f10561a.f10556d.postDelayed(this.f10561a.f10559g, StatisticConfig.MIN_UPLOAD_INTERVAL);
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onPageFinished(WebView webView, String str) {
        AuthActivity.m14007g(this.f10561a);
        this.f10561a.f10556d.removeCallbacks(this.f10561a.f10559g);
    }
}
