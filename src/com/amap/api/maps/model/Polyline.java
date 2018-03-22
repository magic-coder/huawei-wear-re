package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.ak;
import java.util.List;

public class Polyline {
    private final ak f12101a;

    public Polyline(ak akVar) {
        this.f12101a = akVar;
    }

    public void remove() {
        try {
            this.f12101a.mo3880b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f12101a.mo3883c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f12101a.mo3905a((List) list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f12101a.mo3913l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeodesic(boolean z) {
        try {
            if (this.f12101a.mo3914m() != z) {
                List points = getPoints();
                this.f12101a.mo3907b(z);
                setPoints(points);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isGeodesic() {
        return this.f12101a.mo3914m();
    }

    public void setDottedLine(boolean z) {
        this.f12101a.mo3910c(z);
    }

    public boolean isDottedLine() {
        return this.f12101a.mo3915n();
    }

    public void setWidth(float f) {
        try {
            this.f12101a.mo3906b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.f12101a.mo3911h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setColor(int i) {
        try {
            this.f12101a.mo3904a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getColor() {
        try {
            return this.f12101a.mo3912i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f12101a.mo3873a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f12101a.mo3884d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f12101a.mo3877a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f12101a.mo3885e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f12101a.mo3879a(((Polyline) obj).f12101a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f12101a.mo3886f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getNearestLatLng(LatLng latLng) {
        return this.f12101a.mo3903a(latLng);
    }

    public void setTransparency(float f) {
        this.f12101a.mo3909c(f);
    }
}
