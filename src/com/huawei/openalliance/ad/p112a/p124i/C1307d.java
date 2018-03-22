package com.huawei.openalliance.ad.p112a.p124i;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p124i.C1302a.C1291b;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

@SuppressLint({"SetJavaScriptEnabled"})
public class C1307d {
    protected WebView f2817a;
    protected String f2818b;
    protected ProgressBar f2819c = null;
    C1305a f2820d = null;
    C1306b f2821e = null;
    private C1304c f2822f;
    private ActionBar f2823g;
    private C1229o f2824h;
    private String f2825i;
    private Context f2826j;
    private C1291b f2827k;
    private OnKeyListener f2828l = new C1308e(this);
    private OnTouchListener f2829m = new C1309f(this);

    public class C1305a extends WebChromeClient {
        final /* synthetic */ C1307d f2814a;

        public C1305a(C1307d c1307d) {
            this.f2814a = c1307d;
        }

        public void onProgressChanged(WebView webView, int i) {
            if (this.f2814a.f2819c != null) {
                if (i >= 80) {
                    this.f2814a.f2819c.setVisibility(8);
                } else {
                    if (this.f2814a.f2819c.getVisibility() == 8) {
                        this.f2814a.f2819c.setVisibility(0);
                    }
                    this.f2814a.f2819c.setProgress(i);
                }
            }
            super.onProgressChanged(webView, i);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (str == null) {
                str = "详情";
            }
            if (this.f2814a.f2822f != null) {
                this.f2814a.f2822f.m5799a(str);
            } else if (this.f2814a.f2823g != null) {
                this.f2814a.f2823g.setTitle(str);
            }
            super.onReceivedTitle(webView, str);
        }
    }

    public class C1306b extends WebViewClient {
        final /* synthetic */ C1307d f2815a;
        private boolean f2816b = false;

        public C1306b(C1307d c1307d) {
            this.f2815a = c1307d;
        }

        public void onPageFinished(WebView webView, String str) {
            if (!this.f2815a.f2817a.getSettings().getLoadsImagesAutomatically()) {
                this.f2815a.f2817a.getSettings().setLoadsImagesAutomatically(true);
            }
            this.f2815a.f2819c.setVisibility(8);
            this.f2815a.f2819c.setProgress(100);
            if (!this.f2816b) {
                this.f2816b = true;
                C1336d.m5884a("DefaultWebView", "onPageFinished, load finish time is:" + System.currentTimeMillis());
                C1216b c1216b = new C1216b();
                c1216b.setType__("webloadfinish");
                c1216b.setTime__(r0);
                c1216b.setShowid__(this.f2815a.f2825i);
                c1216b.setParamfromserver__(this.f2815a.f2824h);
                C1249b.m5535a(this.f2815a.f2826j, 1, c1216b);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f2815a.f2819c.setVisibility(0);
            this.f2815a.f2819c.setProgress(0);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f2815a.f2817a.loadUrl("about:blank");
            if (this.f2815a.f2819c.getVisibility() == 0) {
                this.f2815a.f2819c.setVisibility(8);
                this.f2815a.f2819c.setProgress(0);
            }
            C1287e.m5685a(this.f2815a.f2817a, this.f2815a.f2819c);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }
    }

    public C1307d(Context context, String str, C1229o c1229o, String str2, WebView webView, ProgressBar progressBar, ActionBar actionBar) {
        this.f2826j = context;
        this.f2817a = webView;
        this.f2818b = str;
        this.f2824h = c1229o;
        this.f2825i = str2;
        this.f2819c = progressBar;
        this.f2823g = actionBar;
    }

    public C1307d(Context context, String str, C1229o c1229o, String str2, WebView webView, ProgressBar progressBar, C1304c c1304c) {
        this.f2826j = context;
        this.f2817a = webView;
        this.f2818b = str;
        this.f2824h = c1229o;
        this.f2825i = str2;
        this.f2819c = progressBar;
        this.f2822f = c1304c;
    }

    String m5806a(String str) {
        return str;
    }

    public void m5807a() {
        if (!C1365i.m6081a(this.f2818b)) {
            if (this.f2818b.indexOf("://") == -1) {
                this.f2818b = "http://" + this.f2818b;
            }
            this.f2818b = m5806a(this.f2818b);
        }
        if (this.f2817a != null) {
            WebSettings settings = this.f2817a.getSettings();
            if (VERSION.SDK_INT >= 19) {
                settings.setLoadsImagesAutomatically(true);
            } else {
                settings.setLoadsImagesAutomatically(false);
            }
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptEnabled(true);
            this.f2817a.removeJavascriptInterface("accessibility");
            this.f2817a.removeJavascriptInterface("accessibilityTraversal");
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setAllowFileAccess(false);
            settings.setCacheMode(-1);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSavePassword(false);
            this.f2820d = new C1305a(this);
            this.f2821e = new C1306b(this);
            this.f2817a.requestFocus();
            this.f2817a.setWebChromeClient(this.f2820d);
            this.f2817a.setWebViewClient(this.f2821e);
            this.f2817a.setOnKeyListener(this.f2828l);
            this.f2817a.setOnTouchListener(this.f2829m);
        }
    }

    public void m5808a(C1291b c1291b) {
        this.f2827k = c1291b;
    }

    public void m5809b() {
        if (this.f2817a == null) {
            return;
        }
        if (C1287e.m5683a(this.f2817a.getContext()) || !C1287e.m5685a(this.f2817a, this.f2819c)) {
            this.f2817a.loadUrl(this.f2818b);
            this.f2817a.postDelayed(new C1310g(this), 1000);
        }
    }
}
