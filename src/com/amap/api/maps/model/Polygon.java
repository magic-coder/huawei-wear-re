package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.aj;
import java.util.List;

public final class Polygon {
    private aj f12093a;

    public Polygon(aj ajVar) {
        this.f12093a = ajVar;
    }

    public void remove() {
        try {
            this.f12093a.mo3880b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f12093a.mo3883c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f12093a.mo3895a((List) list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f12093a.mo3901l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float f) {
        try {
            this.f12093a.mo3897b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.f12093a.mo3899h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int i) {
        try {
            this.f12093a.mo3898b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            return this.f12093a.mo3902m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFillColor(int i) {
        try {
            this.f12093a.mo3894a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFillColor() {
        try {
            return this.f12093a.mo3900i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f12093a.mo3873a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f12093a.mo3884d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f12093a.mo3877a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f12093a.mo3885e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            return this.f12093a.mo3896a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Polygon) {
            try {
                z = this.f12093a.mo3879a(((Polygon) obj).f12093a);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public int hashCode() {
        try {
            return this.f12093a.mo3886f();
        } catch (RemoteException e) {
            return super.hashCode();
        }
    }
}
