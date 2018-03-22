package com.huawei.hwservicesmgr.p076a;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwservicesmgr.a.q;
import com.huawei.hwservicesmgr.n;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneServiceManager */
final class C5357r implements ServiceConnection {
    C5357r() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C2538c.b("PhoneServiceManager", new Object[]{"ServiceConnection callback -"});
        q.a(n.a(iBinder));
        BaseApplication.b().sendBroadcast(new Intent("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS"), com.huawei.hwcommonmodel.b.c.a);
        if (q.b() != null) {
            try {
                q.b().a(q.c());
            } catch (RemoteException e) {
                C2538c.e("PhoneServiceManager", new Object[]{"remote exception -:", e.getMessage()});
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2538c.c("PhoneServiceManager", new Object[]{"remote onServiceDisconnected"});
        if (q.d() != null) {
            try {
                q.d().a(4);
            } catch (RemoteException e) {
                C2538c.e("PhoneServiceManager", new Object[]{"remote exception -:", e.getMessage()});
            }
        }
    }
}
