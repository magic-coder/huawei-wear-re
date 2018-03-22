package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.ac;

public final class Circle {
    private final ac f12010a;

    public Circle(ac acVar) {
        this.f12010a = acVar;
    }

    public void remove() {
        try {
            this.f12010a.mo3880b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f12010a.mo3883c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCenter(LatLng latLng) {
        try {
            this.f12010a.mo3987a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getCenter() {
        try {
            return this.f12010a.mo3991i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRadius(double d) {
        try {
            this.f12010a.mo3985a(d);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public double getRadius() {
        try {
            return this.f12010a.mo3992l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float f) {
        try {
            this.f12010a.mo3988b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.f12010a.mo3993m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int i) {
        try {
            this.f12010a.mo3986a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            return this.f12010a.mo3994n();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFillColor(int i) {
        try {
            this.f12010a.mo3989b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFillColor() {
        try {
            return this.f12010a.mo3995o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f12010a.mo3873a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f12010a.mo3884d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f12010a.mo3877a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f12010a.mo3885e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.f12010a.mo3879a(((Circle) obj).f12010a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f12010a.mo3886f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            return this.f12010a.mo3990b(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
