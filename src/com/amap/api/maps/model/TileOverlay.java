package com.amap.api.maps.model;

import com.amap.api.mapcore.ao;

public final class TileOverlay {
    private ao f12137a;

    public TileOverlay(ao aoVar) {
        this.f12137a = aoVar;
    }

    public void remove() {
        this.f12137a.mo3938a();
    }

    public void clearTileCache() {
        this.f12137a.mo3943b();
    }

    public String getId() {
        return this.f12137a.mo3945c();
    }

    public void setZIndex(float f) {
        this.f12137a.mo3939a(f);
    }

    public float getZIndex() {
        return this.f12137a.mo3947d();
    }

    public void setVisible(boolean z) {
        this.f12137a.mo3941a(z);
    }

    public boolean isVisible() {
        return this.f12137a.mo3948e();
    }

    public boolean equals(Object obj) {
        if (obj instanceof TileOverlay) {
            return this.f12137a.mo3942a(((TileOverlay) obj).f12137a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12137a.mo3949f();
    }
}
