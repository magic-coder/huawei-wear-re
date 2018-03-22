package com.huawei.hwid.vermanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.cloudservice.C4335a;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: AccountCenterWebViewClient */
public class C5311a extends WebViewClient {
    private C4335a f19022a = null;
    private Context f19023b;

    public C5311a(Context context, C4335a c4335a) {
        this.f19022a = c4335a;
        this.f19023b = context;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C5165e.m24906b("ReleaseAccountCenterWebViewClient", "onPageFinished");
        this.f19022a.mo4611a(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C5165e.m24906b("ReleaseAccountCenterWebViewClient", "onPageStarted");
        this.f19022a.mo4612a(webView, str, bitmap);
    }
}
