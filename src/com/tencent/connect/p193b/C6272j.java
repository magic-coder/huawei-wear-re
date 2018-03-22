package com.tencent.connect.p193b;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.connect.p531a.C6244a;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6272j implements C6252b {
    final /* synthetic */ C6263a f21812a;
    private final C6252b f21813b;
    private final boolean f21814c;
    private final Context f21815d;

    public C6272j(C6263a c6263a, Context context, C6252b c6252b, boolean z, boolean z2) {
        this.f21812a = c6263a;
        this.f21815d = context;
        this.f21813b = c6252b;
        this.f21814c = z;
        C6367n.m29107b("openSDK_LOG", "OpenUi, TokenListener()");
    }

    public void mo5288a(Object obj) {
        C6367n.m29107b("openSDK_LOG", "OpenUi, TokenListener() onComplete");
        obj = (JSONObject) obj;
        try {
            String string = obj.getString("access_token");
            String string2 = obj.getString("expires_in");
            String string3 = obj.getString("openid");
            if (!(string == null || this.f21812a.c == null || string3 == null)) {
                this.f21812a.c.m28847a(string, string2);
                this.f21812a.c.m28850b(string3);
                C6244a.m28702d(this.f21815d, this.f21812a.c);
            }
            string = obj.getString("pf");
            if (string != null) {
                try {
                    this.f21815d.getSharedPreferences("pfStore", 0).edit().putString("pf", string).commit();
                } catch (Throwable e) {
                    e.printStackTrace();
                    C6367n.m29108b("openSDK_LOG", "OpenUi, TokenListener() onComplete error", e);
                }
            }
            if (this.f21814c) {
                CookieSyncManager.getInstance().sync();
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
            C6367n.m29108b("openSDK_LOG", "OpenUi, TokenListener() onComplete error", e2);
        }
        this.f21813b.mo5288a(obj);
        this.f21812a.mo5289a();
        C6367n.m29106b();
    }

    public void mo5287a(C6494d c6494d) {
        C6367n.m29107b("openSDK_LOG", "OpenUi, TokenListener() onError");
        this.f21813b.mo5287a(c6494d);
        C6367n.m29106b();
    }

    public void mo5286a() {
        C6367n.m29107b("openSDK_LOG", "OpenUi, TokenListener() onCancel");
        this.f21813b.mo5286a();
        C6367n.m29106b();
    }
}
