package com.huawei.hwservicesmgr.p076a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.huawei.hwservicesmgr.C1046a;
import com.huawei.hwservicesmgr.C1048d;
import com.huawei.hwservicesmgr.C1054m;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwservicesmgr.a.r;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneServiceManager */
public class C1045q {
    private static C1054m f2070a;
    private static C1048d f2071b;
    private static C1046a f2072c;
    private static ServiceConnection f2073d = new r();

    private static void m4411b(C1054m c1054m) {
        f2070a = c1054m;
    }

    public static C1054m m4404a() {
        return f2070a;
    }

    public static void m4407a(C1048d c1048d) {
        f2071b = c1048d;
        if (f2070a != null) {
            try {
                f2070a.mo2326a(c1048d);
            } catch (RemoteException e) {
                C2538c.m12680e("PhoneServiceManager", "RemoteException = " + e.getMessage());
            }
        }
    }

    public static void m4406a(C1046a c1046a) {
        f2072c = c1046a;
    }

    public static void m4405a(Context context) {
        if (context != null) {
            C2538c.m12677c("PhoneServiceManager", "----bindService result is mConnection:" + f2073d);
            boolean bindService = context.getApplicationContext().bindService(new Intent(context, PhoneService.class), f2073d, 1);
            C2538c.m12677c("PhoneServiceManager", "----bindService result is " + bindService);
        }
    }

    public static void m4410b(Context context) {
        if (context != null) {
            try {
                context.getApplicationContext().unbindService(f2073d);
            } catch (IllegalArgumentException e) {
                C2538c.m12674b("PhoneServiceManager", "finish IllegalArgumentException");
            }
        }
    }
}
