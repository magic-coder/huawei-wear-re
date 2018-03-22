package com.huawei.hwid.openapi.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.widget.Toast;

class C5220g implements DownloadListener {
    final /* synthetic */ C5218e f18835a;

    C5220g(C5218e c5218e) {
        this.f18835a = c5218e;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f18835a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            Toast.makeText(this.f18835a.getContext(), "browser is abnormal, can not download!", 0).show();
        }
    }
}
