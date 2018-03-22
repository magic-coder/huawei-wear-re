package com.amap.api.maps;

import android.os.RemoteException;
import com.amap.api.mapcore.ap;
import com.amap.api.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final ap f11992a;

    UiSettings(ap apVar) {
        this.f11992a = apVar;
    }

    public void setScaleControlsEnabled(boolean z) {
        try {
            this.f11992a.mo3957a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.f11992a.mo3960b(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.f11992a.mo3962c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.f11992a.mo3964d(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.f11992a.mo3966e(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.f11992a.mo3968f(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        try {
            this.f11992a.mo3970g(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        try {
            this.f11992a.mo3972h(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.f11992a.mo3975i(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setLogoPosition(int i) {
        try {
            this.f11992a.mo3956a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomPosition(int i) {
        try {
            this.f11992a.mo3959b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getZoomPosition() {
        try {
            return this.f11992a.mo3976j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScaleControlsEnabled() {
        try {
            return this.f11992a.mo3958a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.f11992a.mo3961b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isCompassEnabled() {
        try {
            return this.f11992a.mo3963c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.f11992a.mo3965d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.f11992a.mo3967e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f11992a.mo3969f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.f11992a.mo3971g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.f11992a.mo3973h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getLogoPosition() {
        try {
            return this.f11992a.mo3974i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
