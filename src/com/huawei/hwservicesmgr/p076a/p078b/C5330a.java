package com.huawei.hwservicesmgr.p076a.p078b;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.c;
import com.huawei.hwservicesmgr.p076a.p078b.p459a.C5324a;
import com.huawei.hwservicesmgr.p076a.p078b.p459a.C5326c;
import com.huawei.hwservicesmgr.p076a.p078b.p459a.C5327d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileServicesManager */
public class C5330a {
    private static C5330a f19070a;
    private BroadcastReceiver f19071b = new C5331b(this);

    public static C5330a m25802a() {
        if (f19070a == null) {
            f19070a = new C5330a();
        }
        return f19070a;
    }

    private C5330a() {
        C5324a.m25743a();
        BaseApplication.b().registerReceiver(this.f19071b, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), c.a, null);
    }

    public void m25803a(byte[] bArr) {
        C2538c.c("HWFileServicesManager", new Object[]{"getResult()  message = " + C0973a.a(bArr)});
        C5327d.m25789a(bArr, C5326c.m25769e());
    }
}
