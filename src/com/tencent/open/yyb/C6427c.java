package com.tencent.open.yyb;

import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;

/* compiled from: ProGuard */
class C6427c implements C6252b {
    final /* synthetic */ C6284w f22311a;
    final /* synthetic */ AppbarActivity f22312b;

    C6427c(AppbarActivity appbarActivity, C6284w c6284w) {
        this.f22312b = appbarActivity;
        this.f22311a = c6284w;
    }

    public void mo5287a(C6494d c6494d) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQzone onError");
        this.f22312b.f22297f.m29336b(2);
    }

    public void mo5288a(Object obj) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQzone onComplete");
        this.f22312b.f22297f.m29329a(2);
        C6438n.m29355a(this.f22311a.m28849b(), "400", "SDK.APPBAR.HOME.SHARE.QZ");
    }

    public void mo5286a() {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQzone onCancel");
        this.f22312b.f22297f.m29336b(2);
    }
}
