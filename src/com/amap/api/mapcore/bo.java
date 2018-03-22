package com.amap.api.mapcore;

import android.os.Handler;
import android.os.RemoteException;

/* compiled from: UiSettingsDelegateImp */
class bo implements ap {
    final Handler f11181a = new bp(this);
    private aa f11182b;
    private boolean f11183c = true;
    private boolean f11184d = true;
    private boolean f11185e = true;
    private boolean f11186f = false;
    private boolean f11187g = true;
    private boolean f11188h = true;
    private boolean f11189i = true;
    private boolean f11190j = false;
    private int f11191k = 0;
    private int f11192l = 1;

    bo(aa aaVar) {
        this.f11182b = aaVar;
    }

    public void mo3957a(boolean z) throws RemoteException {
        this.f11190j = z;
        this.f11181a.obtainMessage(1).sendToTarget();
    }

    public void mo3960b(boolean z) throws RemoteException {
        this.f11188h = z;
        this.f11181a.obtainMessage(0).sendToTarget();
    }

    public void mo3962c(boolean z) throws RemoteException {
        this.f11189i = z;
        this.f11181a.obtainMessage(2).sendToTarget();
    }

    public void mo3964d(boolean z) throws RemoteException {
        this.f11186f = z;
        this.f11181a.obtainMessage(3).sendToTarget();
    }

    public void mo3966e(boolean z) throws RemoteException {
        this.f11184d = z;
    }

    public void mo3968f(boolean z) throws RemoteException {
        this.f11187g = z;
    }

    public void mo3970g(boolean z) throws RemoteException {
        this.f11185e = z;
    }

    public void mo3972h(boolean z) throws RemoteException {
        this.f11183c = z;
    }

    public void mo3975i(boolean z) throws RemoteException {
        mo3972h(z);
        mo3970g(z);
        mo3968f(z);
        mo3966e(z);
    }

    public void mo3956a(int i) throws RemoteException {
        this.f11191k = i;
        this.f11182b.mo3812d(i);
    }

    public void mo3959b(int i) throws RemoteException {
        this.f11192l = i;
        this.f11182b.mo3815e(i);
    }

    public boolean mo3958a() throws RemoteException {
        return this.f11190j;
    }

    public boolean mo3961b() throws RemoteException {
        return this.f11188h;
    }

    public boolean mo3963c() throws RemoteException {
        return this.f11189i;
    }

    public boolean mo3965d() throws RemoteException {
        return this.f11186f;
    }

    public boolean mo3967e() throws RemoteException {
        return this.f11184d;
    }

    public boolean mo3969f() throws RemoteException {
        return this.f11187g;
    }

    public boolean mo3971g() throws RemoteException {
        return this.f11185e;
    }

    public boolean mo3973h() throws RemoteException {
        return this.f11183c;
    }

    public int mo3974i() throws RemoteException {
        return this.f11191k;
    }

    public int mo3976j() throws RemoteException {
        return this.f11192l;
    }
}
