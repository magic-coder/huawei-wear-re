package com.huawei.pluginaf500.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: HelpActivity */
class am extends WebViewClient {
    final /* synthetic */ HelpActivity f19888a;

    am(HelpActivity helpActivity) {
        this.f19888a = helpActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            this.f19888a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException e) {
        }
        return true;
    }
}
