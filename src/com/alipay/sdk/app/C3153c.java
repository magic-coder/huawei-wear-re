package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.p244a.C3149a;
import com.alipay.sdk.p246c.C3172b;
import com.alipay.sdk.p247d.C3176a;

public final class C3153c extends WebViewClient {
    boolean f10531a;
    private Activity f10532b;
    private boolean f10533c;
    private Handler f10534d;
    private C3176a f10535e;
    private Runnable f10536f = new C3157g(this);

    public C3153c(Activity activity) {
        this.f10532b = activity;
        this.f10534d = new Handler(this.f10532b.getMainLooper());
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f10531a = true;
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C3149a.m13983a("net", "SSLError", "证书错误");
        if (this.f10533c) {
            sslErrorHandler.proceed();
            this.f10533c = false;
            return;
        }
        this.f10532b.runOnUiThread(new C3154d(this, sslErrorHandler));
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return C3172b.m14020a(webView, str, this.f10532b);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f10535e == null) {
            this.f10535e = new C3176a(this.f10532b, "正在加载");
        }
        this.f10535e.m14032a();
        this.f10534d.postDelayed(this.f10536f, StatisticConfig.MIN_UPLOAD_INTERVAL);
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onPageFinished(WebView webView, String str) {
        m13991a();
        this.f10534d.removeCallbacks(this.f10536f);
    }

    private void m13991a() {
        if (this.f10535e != null) {
            this.f10535e.m14033b();
        }
        this.f10535e = null;
    }
}
