package com.tencent.open.yyb;

import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;

/* compiled from: ProGuard */
class C6426b implements C6252b {
    final /* synthetic */ C6284w f22309a;
    final /* synthetic */ AppbarActivity f22310b;

    C6426b(AppbarActivity appbarActivity, C6284w c6284w) {
        this.f22310b = appbarActivity;
        this.f22309a = c6284w;
    }

    public void mo5287a(C6494d c6494d) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ onError");
        this.f22310b.f22297f.m29336b(1);
    }

    public void mo5288a(Object obj) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ onComplete");
        this.f22310b.f22297f.m29329a(1);
        C6438n.m29355a(this.f22309a.m28849b(), "400", "SDK.APPBAR.HOME.SHARE.QQ");
    }

    public void mo5286a() {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ onCancel");
        this.f22310b.f22297f.m29336b(1);
    }
}
