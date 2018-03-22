package com.huawei.appmarket.p348a.p352d;

import android.content.pm.IPackageInstallObserver.Stub;
import android.os.RemoteException;
import com.huawei.appmarket.p348a.p349a.C4212a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public class C4221d extends Stub {
    private C4220c f15848a;

    public C4221d(C4220c c4220c) {
        this.f15848a = c4220c;
    }

    public static final String m20497a() {
        return C4212a.m20466a() + "install.state";
    }

    public void packageInstalled(String str, int i) throws RemoteException {
        if (1 == i) {
            C4241a.m20529a("PackageInstallObserver", "install successfully!!!!!!" + this.f15848a.f15842f);
            return;
        }
        C4241a.m20532b("PackageInstallObserver", "install failed!!!!" + this.f15848a.f15842f + ",rtn:" + i);
        this.f15848a.f15838b = C4223f.NOT_HANDLER;
        C4230m.m20506a(4, 0);
    }
}
