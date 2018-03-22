package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.ag;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;

public final class Marker {
    private ag f12061a;

    public Marker(ag agVar) {
        this.f12061a = agVar;
    }

    public void setPeriod(int i) {
        try {
            this.f12061a.mo3685a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getPeriod() {
        try {
            return this.f12061a.mo3722v();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.f12061a.mo3692a((ArrayList) arrayList);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.f12061a.mo3723w();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.f12061a.mo3699b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.f12061a != null) {
                this.f12061a.mo3716p();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getId() {
        try {
            return this.f12061a.mo3708h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPerspective(boolean z) {
        try {
            this.f12061a.mo3703d(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPerspective() {
        try {
            return this.f12061a.mo3720t();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f12061a.mo3688a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.f12061a.mo3704e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTitle(String str) {
        try {
            this.f12061a.mo3691a(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getTitle() {
        try {
            return this.f12061a.mo3709i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setSnippet(String str) {
        try {
            this.f12061a.mo3697b(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getSnippet() {
        try {
            return this.f12061a.mo3710j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                this.f12061a.mo3687a(bitmapDescriptor);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            this.f12061a.mo3684a(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDraggable(boolean z) {
        try {
            this.f12061a.mo3694a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDraggable() {
        return this.f12061a.mo3711k();
    }

    public void showInfoWindow() {
        try {
            this.f12061a.mo3712l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void hideInfoWindow() {
        try {
            this.f12061a.mo3713m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isInfoWindowShown() {
        return this.f12061a.mo3714n();
    }

    public void setVisible(boolean z) {
        try {
            this.f12061a.mo3700c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f12061a.mo3715o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Marker) {
                return this.f12061a.mo3695a(((Marker) obj).f12061a);
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        return this.f12061a.mo3717q();
    }

    public void setObject(Object obj) {
        this.f12061a.mo3690a(obj);
    }

    public Object getObject() {
        return this.f12061a.mo3719s();
    }

    public void setRotateAngle(float f) {
        try {
            this.f12061a.mo3683a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotateAngle() {
        return this.f12061a.mo3721u();
    }

    public void setToTop() {
        try {
            this.f12061a.mo3726z();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeoPoint(IPoint iPoint) {
        this.f12061a.mo3689a(iPoint);
    }

    public IPoint getGeoPoint() {
        return this.f12061a.mo3682I();
    }

    public void setFlat(boolean z) {
        try {
            this.f12061a.mo3705e(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isFlat() {
        return this.f12061a.mo3674A();
    }

    public void setPositionByPixels(int i, int i2) {
        this.f12061a.mo3686a(i, i2);
    }

    public void setZIndex(float f) {
        this.f12061a.mo3696b(f);
    }

    public float getZIndex() {
        return this.f12061a.mo3680G();
    }
}
