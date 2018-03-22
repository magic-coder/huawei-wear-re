package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.RemoteException;
import com.amap.api.mapcore.an;

public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private an f12122a;

    public Text(an anVar) {
        this.f12122a = anVar;
    }

    public void remove() {
        try {
            this.f12122a.mo3699b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.f12122a != null) {
                this.f12122a.mo3716p();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getId() {
        try {
            return this.f12122a.mo3708h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f12122a.mo3688a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.f12122a.mo3704e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setText(String str) {
        try {
            this.f12122a.mo3934c(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getText() {
        try {
            return this.f12122a.mo3929a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setBackgroundColor(int i) {
        try {
            this.f12122a.mo3931b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getBackgroundColor() {
        try {
            return this.f12122a.mo3923J();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFontColor(int i) {
        try {
            this.f12122a.mo3933c(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFontColor() {
        try {
            return this.f12122a.mo3924K();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFontSize(int i) {
        try {
            this.f12122a.mo3935d(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFontSize() {
        try {
            return this.f12122a.mo3925L();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTypeface(Typeface typeface) {
        try {
            this.f12122a.mo3930a(typeface);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Typeface getTypeface() {
        try {
            return this.f12122a.mo3926M();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAlign(int i, int i2) {
        try {
            this.f12122a.mo3932b(i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getAlignX() {
        try {
            return this.f12122a.mo3927N();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getAlignY() {
        try {
            return this.f12122a.mo3928O();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f12122a.mo3700c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f12122a.mo3715o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Text) {
                return this.f12122a.mo3695a(((Text) obj).f12122a);
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        return this.f12122a.mo3717q();
    }

    public void setObject(Object obj) {
        this.f12122a.mo3690a(obj);
    }

    public Object getObject() {
        return this.f12122a.mo3719s();
    }

    public void setRotate(float f) {
        try {
            this.f12122a.mo3683a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotate() {
        return this.f12122a.mo3721u();
    }

    public void setZIndex(float f) {
        this.f12122a.mo3696b(f);
    }

    public float getZIndex() {
        return this.f12122a.mo3680G();
    }
}
