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
class C6296b implements C6295g {
    final /* synthetic */ Bundle f21881a;
    final /* synthetic */ String f21882b;
    final /* synthetic */ String f21883c;
    final /* synthetic */ C6252b f21884d;
    final /* synthetic */ Activity f21885e;
    final /* synthetic */ C6294a f21886f;

    C6296b(C6294a c6294a, Bundle bundle, String str, String str2, C6252b c6252b, Activity activity) {
        this.f21886f = c6294a;
        this.f21881a = bundle;
        this.f21882b = str;
        this.f21883c = str2;
        this.f21884d = c6252b;
        this.f21885e = activity;
    }

    public void mo5300a(int i, String str) {
        if (i == 0) {
            this.f21881a.putString("imageLocalUrl", str);
        } else if (TextUtils.isEmpty(this.f21882b) && TextUtils.isEmpty(this.f21883c)) {
            if (this.f21884d != null) {
                this.f21884d.mo5287a(new C6494d(-6, "获取分享图片失败!", null));
                C6367n.m29112e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
            }
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.f21886f.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
            return;
        }
        this.f21886f.m28883c(this.f21885e, this.f21881a, this.f21884d);
    }

    public void mo5301a(int i, ArrayList<String> arrayList) {
    }
}
