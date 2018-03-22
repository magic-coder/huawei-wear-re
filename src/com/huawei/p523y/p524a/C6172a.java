package com.huawei.p523y.p524a;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwservicesmgr.C5368p;
import com.huawei.hwservicesmgr.j;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWOTABaseMgr */
public abstract class C6172a extends a {
    private static C6172a f21633a = null;
    private static IBaseResponseCallback f21634b;
    private static final Object f21635d = new Object();
    private static IBaseResponseCallback f21636e = new C6173b();
    private int f21637c = -1;

    public abstract void mo5184a(String str, int i, String str2, j jVar);

    public abstract void mo5185a(String str, C5368p c5368p);

    public C6172a(Context context) {
        super(context);
    }

    public int m28563a() {
        return this.f21637c;
    }

    protected void m28564a(int i) {
        this.f21637c = i;
    }

    protected static synchronized void m28559a(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (C6172a.class) {
            f21634b = iBaseResponseCallback;
        }
    }

    protected static synchronized void m28560b() {
        synchronized (C6172a.class) {
            f21634b = null;
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(9);
    }

    public static C6172a m28561c() {
        C6172a c6172a = null;
        synchronized (f21635d) {
            if (f21633a != null) {
                f21633a.onDestroy();
                f21633a = null;
            }
            Context b = BaseApplication.b();
            if (b != null) {
                c a = c.a(b);
                if (a == null) {
                    C2538c.e("HWOTABaseMgr", new Object[]{"deviceConfigManager is null!!"});
                } else if (a.c() == null) {
                    C2538c.e("HWOTABaseMgr", new Object[]{"deviceConfigManager.getCurrentDeviceInfo() is null!!"});
                } else {
                    C2538c.c("HWOTABaseMgr", new Object[]{"getOTAInstance, getProductType() = " + a.c().getProductType()});
                    if (a.c().getProductType() == 0 || 1 == a.c().getProductType()) {
                        f21633a = C6174c.m28568a(b);
                        f21633a.m28564a(1);
                    } else if (5 == a.c().getProductType()) {
                        f21633a = new C6177f(b);
                        f21633a.m28564a(2);
                    } else {
                        f21633a = new C6179h(b);
                        f21633a.m28564a(3);
                    }
                    a.a(9, f21636e);
                }
            }
            c6172a = f21633a;
        }
        return c6172a;
    }
}
