package com.amap.api.mapcore;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

/* compiled from: MyLocationOverlay */
class ba {
    private aa f10997a;
    private Marker f10998b;
    private ac f10999c;
    private MyLocationStyle f11000d;
    private LatLng f11001e;
    private double f11002f;
    private Context f11003g;
    private bj f11004h;
    private int f11005i = 1;
    private boolean f11006j = false;
    private final String f11007k = "location_map_gps_locked.png";
    private final String f11008l = "location_map_gps_3d.png";
    private boolean f11009m = false;

    ba(aa aaVar, Context context) {
        this.f11003g = context;
        this.f10997a = aaVar;
        this.f11004h = new bj(this.f11003g, aaVar);
    }

    public void m14956a(MyLocationStyle myLocationStyle) {
        try {
            this.f11000d = myLocationStyle;
            if (this.f10998b != null || this.f10999c != null) {
                m14950l();
                this.f11004h.m15084a(this.f10998b);
                m14949k();
            }
        } catch (Throwable th) {
            ca.m15831a(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void m14954a(int i) {
        this.f11005i = i;
        this.f11006j = false;
        switch (this.f11005i) {
            case 1:
                m14945g();
                return;
            case 2:
                m14946h();
                return;
            case 3:
                m14947i();
                return;
            default:
                return;
        }
    }

    public void m14952a() {
        if (this.f11004h != null) {
            this.f11004h.m15085b();
        }
    }

    public void m14957b() {
        if (this.f11005i == 3 && this.f11004h != null) {
            this.f11004h.m15083a();
        }
    }

    private void m14945g() {
        if (this.f10998b != null) {
            m14944c(0.0f);
            this.f11004h.m15085b();
            if (!this.f11009m) {
                this.f10998b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.f10998b.setFlat(false);
            m14942b(0.0f);
        }
    }

    private void m14946h() {
        if (this.f10998b != null) {
            m14944c(0.0f);
            this.f11004h.m15085b();
            if (!this.f11009m) {
                this.f10998b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.f10998b.setFlat(false);
            m14942b(0.0f);
        }
    }

    private void m14947i() {
        if (this.f10998b != null) {
            this.f10998b.setRotateAngle(0.0f);
            this.f11004h.m15083a();
            if (!this.f11009m) {
                this.f10998b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_3d.png"));
            }
            this.f10998b.setFlat(true);
            try {
                this.f10997a.mo3776a(C3259o.m15324a(17.0f));
                m14942b(45.0f);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void m14942b(float f) {
        if (this.f10997a != null) {
            try {
                this.f10997a.mo3776a(C3259o.m15339c(f));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void m14944c(float f) {
        if (this.f10997a != null) {
            try {
                this.f10997a.mo3776a(C3259o.m15340d(f));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void m14955a(Location location) {
        if (location != null) {
            this.f11001e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f11002f = (double) location.getAccuracy();
            if (this.f10998b == null && this.f10999c == null) {
                m14949k();
            }
            if (this.f10998b != null) {
                this.f10998b.setPosition(this.f11001e);
            }
            if (this.f10999c != null) {
                try {
                    this.f10999c.mo3987a(this.f11001e);
                    if (this.f11002f != -1.0d) {
                        this.f10999c.mo3985a(this.f11002f);
                    }
                } catch (Throwable e) {
                    ca.m15831a(e, "MyLocationOverlay", "setCentAndRadius");
                    e.printStackTrace();
                }
                m14948j();
                if (this.f11005i != 3) {
                    m14943b(location);
                }
                this.f11006j = true;
            }
        }
    }

    private void m14943b(Location location) {
        float bearing = location.getBearing() % 360.0f;
        if (bearing > BitmapDescriptorFactory.HUE_CYAN) {
            bearing -= 360.0f;
        } else if (bearing < -180.0f) {
            bearing += 360.0f;
        }
        if (this.f10998b != null) {
            this.f10998b.setRotateAngle(-bearing);
        }
    }

    private void m14948j() {
        if (this.f11005i != 1 || !this.f11006j) {
            try {
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(this.f11001e.longitude, this.f11001e.latitude, iPoint);
                this.f10997a.mo3806b(C3259o.m15334a(iPoint));
            } catch (Throwable e) {
                ca.m15831a(e, "MyLocationOverlay", "locaitonFollow");
                e.printStackTrace();
            }
        }
    }

    private void m14949k() {
        if (this.f11000d == null) {
            this.f11000d = new MyLocationStyle();
            this.f11000d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            m14951m();
            return;
        }
        this.f11009m = true;
        m14951m();
    }

    public void m14958c() throws RemoteException {
        m14950l();
        if (this.f11004h != null) {
            this.f11004h.m15085b();
            this.f11004h = null;
        }
    }

    private void m14950l() {
        if (this.f10999c != null) {
            try {
                this.f10997a.mo3800a(this.f10999c.mo3883c());
            } catch (Throwable e) {
                ca.m15831a(e, "MyLocationOverlay", "locationIconRemove");
                e.printStackTrace();
            }
            this.f10999c = null;
        }
        if (this.f10998b != null) {
            this.f10998b.remove();
            this.f10998b.destroy();
            this.f10998b = null;
            this.f11004h.m15084a(null);
        }
    }

    private void m14951m() {
        try {
            this.f10999c = this.f10997a.mo3754a(new CircleOptions().strokeWidth(this.f11000d.getStrokeWidth()).fillColor(this.f11000d.getRadiusFillColor()).strokeColor(this.f11000d.getStrokeColor()).center(new LatLng(0.0d, 0.0d)).zIndex(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            if (this.f11001e != null) {
                this.f10999c.mo3987a(this.f11001e);
            }
            this.f10999c.mo3985a(this.f11002f);
            this.f10998b = this.f10997a.mo3760a(new MarkerOptions().visible(false).anchor(this.f11000d.getAnchorU(), this.f11000d.getAnchorV()).icon(this.f11000d.getMyLocationIcon()).position(new LatLng(0.0d, 0.0d)));
            m14954a(this.f11005i);
            if (this.f11001e != null) {
                this.f10998b.setPosition(this.f11001e);
                this.f10998b.setVisible(true);
            }
            this.f11004h.m15084a(this.f10998b);
        } catch (Throwable e) {
            ca.m15831a(e, "MyLocationOverlay", "myLocStyle");
            e.printStackTrace();
        }
    }

    public void m14953a(float f) {
        if (this.f10998b != null) {
            this.f10998b.setRotateAngle(f);
        }
    }

    public String m14959d() {
        if (this.f10998b != null) {
            return this.f10998b.getId();
        }
        return null;
    }

    public String m14960e() throws RemoteException {
        if (this.f10999c != null) {
            return this.f10999c.mo3883c();
        }
        return null;
    }

    public void m14961f() {
        this.f10999c = null;
        this.f10998b = null;
    }
}
