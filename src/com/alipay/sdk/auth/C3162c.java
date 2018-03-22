package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

final class C3162c implements DownloadListener {
    final /* synthetic */ AuthActivity f10562a;

    C3162c(AuthActivity authActivity) {
        this.f10562a = authActivity;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f10562a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable th) {
        }
    }
}
