package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.ae;

public final class GroundOverlay {
    private ae f12027a;

    public GroundOverlay(ae aeVar) {
        this.f12027a = aeVar;
    }

    public void remove() {
        try {
            this.f12027a.mo3880b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f12027a.mo3883c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f12027a.mo4076a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.f12027a.mo4081h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDimensions(float f) {
        try {
            this.f12027a.mo4078b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            this.f12027a.mo4075a(bitmapDescriptor);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDimensions(float f, float f2) {
        try {
            this.f12027a.mo4074a(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.f12027a.mo4082i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getHeight() {
        try {
            return this.f12027a.mo4083l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.f12027a.mo4077a(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLngBounds getBounds() {
        try {
            return this.f12027a.mo4084m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setBearing(float f) {
        try {
            this.f12027a.mo4079c(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getBearing() {
        try {
            return this.f12027a.mo4085n();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f12027a.mo3873a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f12027a.mo3884d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f12027a.mo3877a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f12027a.mo3885e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTransparency(float f) {
        try {
            this.f12027a.mo4080d(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getTransparency() {
        try {
            return this.f12027a.mo4086o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            throw new RemoteException();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        return this.f12027a.hashCode();
    }
}
