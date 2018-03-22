package com.huawei.login.ui.login;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.a.b;
import com.huawei.hwdataaccessmodel.a.d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.p087a.C1092a;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.login.ui.login.util.a;
import com.huawei.login.ui.login.util.c;
import com.huawei.p190v.C2538c;

/* compiled from: LoginInit */
public class C1093a {
    private static C1093a f2218a = null;
    private static int f2219c = -1;
    private Context f2220b = null;

    public static int m4738a() {
        return f2219c;
    }

    public static void m4740a(int i) {
        f2219c = i;
    }

    public static C1093a m4739a(Context context) {
        if (f2218a == null) {
            f2218a = new C1093a(BaseApplication.m2632b());
        }
        return f2218a;
    }

    private C1093a(Context context) {
        this.f2220b = context;
    }

    public void m4742a(Context context, ILoginCallback iLoginCallback) {
        C2538c.m12677c("LoginInit", "Enter login activityContext");
        if (context == null) {
            C2538c.m12680e("LoginInit", "login() activityContext is null !!!");
            return;
        }
        new C1092a(context.getApplicationContext(), iLoginCallback).m4731a(context);
    }

    public void m4743a(Context context, ILoginCallback iLoginCallback, boolean z) {
        C2538c.m12674b("LoginInit", "Enter login activityContext");
        if (context == null) {
            C2538c.m12680e("LoginInit", "login() activityContext is null !!!");
            return;
        }
        new C1092a(context, iLoginCallback).m4733a(context, z);
    }

    public int m4749b() {
        if (BaseApplication.m2632b() != null) {
            return c.a(BaseApplication.m2632b()).g();
        }
        C2538c.m12680e("LoginInit", "BaseApplication.getContext() is null !!!");
        return -1;
    }

    public String m4750c() {
        if (BaseApplication.m2632b() == null) {
            C2538c.m12680e("LoginInit", "mContext is null !!!");
            return "";
        }
        C2538c.m12677c("LoginInit", "getUsetId is ", c.a(BaseApplication.m2632b()).c());
        return c.a(BaseApplication.m2632b()).c();
    }

    public void m4746a(String str) {
        if (BaseApplication.m2632b() == null) {
            C2538c.m12680e("LoginInit", "mContext is null !!!");
            return;
        }
        C2538c.m12677c("LoginInit", "setUsetId is ", str);
        c.a(BaseApplication.m2632b()).a(str);
    }

    public boolean m4751d() {
        if (BaseApplication.m2632b() != null) {
            return c.a(BaseApplication.m2632b()).j();
        }
        C2538c.m12680e("LoginInit", "BaseApplication.getContext() is null !!!");
        return false;
    }

    public void m4748a(boolean z) {
        if (BaseApplication.m2632b() == null) {
            C2538c.m12680e("LoginInit", "BaseApplication.getContext() is null !!!");
            return;
        }
        c.a(BaseApplication.m2632b()).a(z);
    }

    public int m4752e() {
        if (-1 == C1093a.m4738a()) {
            C1093a.m4740a(c.a(BaseApplication.m2632b()).b());
        }
        return C1093a.m4738a();
    }

    public String m4753f() {
        if (a.b() != null) {
            return a.b();
        }
        return c.a(BaseApplication.m2632b()).i();
    }

    public String m4754g() {
        if (a.a() != null) {
            return a.a();
        }
        return c.a(BaseApplication.m2632b()).a();
    }

    public void m4745a(b bVar) {
        if (a.a() == null) {
            c.a(BaseApplication.m2632b()).a(bVar);
        } else if (bVar != null) {
            bVar.a(new d(0, a.a()));
        }
    }

    public void m4747a(String str, b bVar) {
        a.b(str);
        c.a(BaseApplication.m2632b()).c(str, bVar);
    }

    public void m4755h() {
        C2538c.m12677c("LoginInit", "Enter cleanLoginData");
        c.a(BaseApplication.m2632b()).c(null, null);
        c.a(BaseApplication.m2632b()).a(null, null);
        c.a(BaseApplication.m2632b()).a(false);
        C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(20007), "migrate_provide_login_infomation", "migrate_not_support", new C0993c(0));
        C0996a.m3611a(this.f2220b, String.valueOf(30), "kStorage_CoreSleepMgr_Long_LastSyncTime", null, new C0993c());
        a.a(null);
        a.b(null);
        m4741k();
    }

    public void m4756i() {
        C2538c.m12677c("LoginInit", "Enter logout");
        if (BaseApplication.m2632b() == null) {
            C2538c.m12680e("LoginInit", "mContext is null !!!");
            return;
        }
        new Thread(new b(this)).start();
    }

    public void m4744a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("LoginInit", "Enter logoutWhenStTimeout");
        if (BaseApplication.m2632b() == null) {
            C2538c.m12680e("LoginInit", "mContext is null !!!");
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(-1, "");
                return;
            }
            return;
        }
        new Thread(new c(this, iBaseResponseCallback)).start();
    }

    public void m4757j() {
        C2538c.m12677c("LoginInit", "Enter logoutNotExit");
        m4744a(null);
    }

    private void m4741k() {
        C2538c.m12677c("LoginInit", "Enter resetSiteId");
        c.a(BaseApplication.m2632b()).a(-1, new d(this));
    }
}
