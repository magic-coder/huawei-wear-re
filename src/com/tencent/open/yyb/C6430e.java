package com.tencent.open.yyb;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
class C6430e implements DownloadListener {
    final /* synthetic */ AppbarActivity f22314a;

    C6430e(AppbarActivity appbarActivity) {
        this.f22314a = appbarActivity;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)onDownloadStart : url = " + str);
        try {
            this.f22314a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)onDownloadStart : activity aciton_view not found.");
        }
        C6284w c = this.f22314a.m29303i();
        if (c != null) {
            C6438n.m29355a(c.m28849b(), "200", "SDK.APPBAR.HOME ACTION");
        }
    }
}
