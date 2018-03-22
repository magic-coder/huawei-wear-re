package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.ab;

public final class Arc {
    private final ab f11994a;

    public Arc(ab abVar) {
        this.f11994a = abVar;
    }

    public void remove() {
        try {
            this.f11994a.mo3880b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f11994a.mo3883c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float f) {
        try {
            this.f11994a.mo3982b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.f11994a.mo3983h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int i) {
        try {
            this.f11994a.mo3981a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            return this.f11994a.mo3984i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f11994a.mo3873a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f11994a.mo3884d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f11994a.mo3877a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f11994a.mo3885e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Arc)) {
            return false;
        }
        try {
            return this.f11994a.mo3879a(((Arc) obj).f11994a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f11994a.mo3886f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
