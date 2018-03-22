package com.tencent.open.yyb;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
class C6433i extends WebViewClient {
    final /* synthetic */ AppbarActivity f22317a;

    private C6433i(AppbarActivity appbarActivity) {
        this.f22317a = appbarActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f22317a.m29294a(true);
        this.f22317a.f22297f.m29337c();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f22317a.m29294a(false);
        if (!str.startsWith("http") && !str.startsWith("https")) {
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z = true;
        C6367n.m29107b("openSDK_LOG", "-->(AppbarDialog)shouldOverrideUrlLoading : url = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http") || str.startsWith("https")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (str.startsWith("jsb://")) {
            this.f22317a.f22297f.m29330a(str);
            return true;
        } else if (!str.equals("about:blank;") && !str.equals("about:blank")) {
            return false;
        } else {
            if (VERSION.SDK_INT >= 11) {
                z = false;
            }
            return z;
        }
    }
}
