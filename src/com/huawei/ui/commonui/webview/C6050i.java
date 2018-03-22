package com.huawei.ui.commonui.webview;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* compiled from: WebViewActivity */
class C6050i implements DownloadListener {
    final /* synthetic */ WebViewActivity f20848a;

    private C6050i(WebViewActivity webViewActivity) {
        this.f20848a = webViewActivity;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.f20848a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
