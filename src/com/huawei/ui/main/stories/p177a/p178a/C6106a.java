package com.huawei.ui.main.stories.p177a.p178a;

import android.content.Context;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: AccountLoginInteractors */
public class C6106a {
    private static C6106a f21075b = null;
    private a f21076a;

    public C6106a(Context context) {
        this.f21076a = a.a(context);
    }

    public static C6106a m27821a(Context context) {
        if (f21075b == null) {
            f21075b = new C6106a(context);
        }
        return f21075b;
    }

    public boolean m27822a() {
        C2538c.b("AccountLoginInteractors", new Object[]{"boolean isLogin()!getIsLogined()=" + this.f21076a.d()});
        return this.f21076a.d();
    }
}
