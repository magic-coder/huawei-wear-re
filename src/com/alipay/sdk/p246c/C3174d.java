package com.alipay.sdk.p246c;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

final class C3174d implements DownloadListener {
    final /* synthetic */ Activity f10577a;

    C3174d(Activity activity) {
        this.f10577a = activity;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f10577a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable th) {
        }
    }
}
