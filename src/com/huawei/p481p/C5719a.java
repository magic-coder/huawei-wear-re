package com.huawei.p481p;

import android.content.Context;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileManager */
public class C5719a extends a {
    private static C5719a f19491a;

    public C5719a(Context context) {
        super(context);
    }

    public static C5719a m26363a() {
        if (f19491a == null) {
            f19491a = new C5719a(BaseApplication.b());
        }
        return f19491a;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(28);
    }

    protected void onDestroy() {
        super.onDestroy();
        C5719a.m26364b();
        C2538c.c("HWFileManager", new Object[]{"onDestroy() complete"});
    }

    public void m26365a(String str) {
        com.huawei.n.c.a(BaseApplication.b()).b(str);
    }

    private static void m26364b() {
        f19491a = null;
    }
}
