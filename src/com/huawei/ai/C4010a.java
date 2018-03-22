package com.huawei.ai;

import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* compiled from: AuthenticationManager */
public class C4010a {
    private C4019j f15294a;
    private C4012g f15295b;
    private C4016e f15296c;
    private int f15297d;
    private C4015d f15298e;
    private C4017f f15299f;
    private DeathRecipient f15300g = new C4011b(this);

    public static C4010a m19772a(int i) {
        C4019j e = C4010a.m19778e();
        if (e == null) {
            Log.e("AuthenticationManager", "AuthenticationManager open failed: the AuthenticationService is null");
            return null;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            Log.e("AuthenticationManager", "AuthenticationManager open failed: looper is null!");
            return null;
        }
        try {
            return new C4010a(e, mainLooper, i);
        } catch (Exception e2) {
            Log.e("AuthenticationManager", "fail to open AuthenticationManager");
            return null;
        }
    }

    private C4010a(C4019j c4019j, Looper looper, int i) throws RemoteException {
        this.f15294a = c4019j;
        C4016e c4016e = new C4016e(this, looper);
        this.f15297d = i;
        this.f15295b = new C4014c(this);
        if (this.f15294a.mo4338a(this.f15295b, i)) {
            this.f15296c = c4016e;
            c4019j.asBinder().linkToDeath(this.f15300g, 0);
            return;
        }
        Log.e("AuthenticationManager", "!mService.open(mClient, authenticationType)");
        throw new RuntimeException();
    }

    public void m19781a(C4015d c4015d) {
        this.f15298e = c4015d;
    }

    public void m19780a() {
        try {
            this.f15294a.mo4344b(this.f15295b);
            this.f15294a.asBinder().unlinkToDeath(this.f15300g, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int[] m19782b() {
        try {
            return this.f15294a.mo4345c(this.f15295b);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public int m19779a(C4017f c4017f, int[] iArr, byte[] bArr) {
        if (iArr == null || c4017f == null) {
            throw new NullPointerException();
        }
        this.f15299f = c4017f;
        try {
            return this.f15294a.mo4335a(this.f15295b, iArr, bArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void m19783c() {
        try {
            this.f15294a.mo4336a(this.f15295b);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static int[] m19777d() {
        C4019j e = C4010a.m19778e();
        if (e == null) {
            return new int[0];
        }
        try {
            return e.mo4341a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return new int[0];
        }
    }

    public static boolean m19775b(int i) {
        boolean z = false;
        C4019j e = C4010a.m19778e();
        if (e != null) {
            try {
                z = e.mo4337a(i);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    private static C4019j m19778e() {
        return C4020k.m19802a(ServiceManager.getService("authentication_service"));
    }
}
