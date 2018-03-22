package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.ah;
import java.util.List;

public class NavigateArrow {
    private final ah f133a;

    public NavigateArrow(ah ahVar) {
        this.f133a = ahVar;
    }

    public void remove() {
        try {
            this.f133a.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f133a.c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f133a.a(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f133a.m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float f) {
        try {
            this.f133a.b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.f133a.h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTopColor(int i) {
        try {
            this.f133a.a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getTopColor() {
        try {
            return this.f133a.i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public void setSideColor(int i) {
        try {
            this.f133a.b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public int getSideColor() {
        try {
            return this.f133a.l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f133a.a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f133a.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f133a.a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f133a.e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NavigateArrow)) {
            return false;
        }
        try {
            return this.f133a.a(((NavigateArrow) obj).f133a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f133a.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
