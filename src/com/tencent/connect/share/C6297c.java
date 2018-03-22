package com.tencent.connect.share;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.p532d.C6295g;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import java.util.ArrayList;

/* compiled from: ProGuard */
class C6297c implements C6295g {
    final /* synthetic */ Bundle f21887a;
    final /* synthetic */ String f21888b;
    final /* synthetic */ String f21889c;
    final /* synthetic */ C6252b f21890d;
    final /* synthetic */ Activity f21891e;
    final /* synthetic */ C6294a f21892f;

    C6297c(C6294a c6294a, Bundle bundle, String str, String str2, C6252b c6252b, Activity activity) {
        this.f21892f = c6294a;
        this.f21887a = bundle;
        this.f21888b = str;
        this.f21889c = str2;
        this.f21890d = c6252b;
        this.f21891e = activity;
    }

    public void mo5300a(int i, String str) {
        if (i == 0) {
            this.f21887a.putString("imageLocalUrl", str);
        } else if (TextUtils.isEmpty(this.f21888b) && TextUtils.isEmpty(this.f21889c)) {
            if (this.f21890d != null) {
                this.f21890d.mo5287a(new C6494d(-6, "获取分享图片失败!", null));
                C6367n.m29112e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
            }
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.f21892f.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
            return;
        }
        this.f21892f.m28883c(this.f21891e, this.f21887a, this.f21890d);
    }

    public void mo5301a(int i, ArrayList<String> arrayList) {
    }
}
