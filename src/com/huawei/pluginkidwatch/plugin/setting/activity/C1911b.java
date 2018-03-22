package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* compiled from: AppHelpActivity */
class C1911b implements DownloadListener {
    final /* synthetic */ AppHelpActivity f6612a;

    private C1911b(AppHelpActivity appHelpActivity) {
        this.f6612a = appHelpActivity;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.f6612a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
