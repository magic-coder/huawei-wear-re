package com.amap.api.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.os.SystemClock;
import com.amap.api.location.C3184a.C3183a;
import java.util.Iterator;

/* compiled from: IGPSManager */
public class C3196d {
    public LocationManager f10712a = null;
    LocationListener f10713b = new C3197e(this);
    LocationListener f10714c = new C3198f(this);
    private C3183a f10715d;
    private C3184a f10716e;
    private Context f10717f;
    private final Listener f10718g = new C3199g(this);

    C3196d(Context context, LocationManager locationManager, C3183a c3183a, C3184a c3184a) {
        this.f10717f = context;
        this.f10712a = locationManager;
        this.f10716e = c3184a;
        this.f10715d = c3183a;
    }

    void m14171a(long j, float f) {
        try {
            Looper mainLooper = this.f10717f.getMainLooper();
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.f10712a.addGpsStatusListener(this.f10718g);
            this.f10712a.requestLocationUpdates("gps", j, f, this.f10714c, mainLooper);
            this.f10712a.requestLocationUpdates("gps", 5000, 0.0f, this.f10713b, mainLooper);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void m14170a() {
    }

    void m14172b() {
        if (this.f10714c != null) {
            this.f10712a.removeUpdates(this.f10714c);
        }
        if (this.f10718g != null) {
            this.f10712a.removeGpsStatusListener(this.f10718g);
        }
        if (this.f10713b != null) {
            this.f10712a.removeUpdates(this.f10713b);
        }
    }

    private void m14166a(int i, GpsStatus gpsStatus) {
        if (i == 4) {
            int maxSatellites = gpsStatus.getMaxSatellites();
            Iterator it = gpsStatus.getSatellites().iterator();
            int i2 = 0;
            while (it.hasNext() && i2 <= maxSatellites) {
                int i3;
                if (((GpsSatellite) it.next()).usedInFix()) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i2 = i3;
            }
            if (i2 >= 3) {
                this.f10716e.f10643i = SystemClock.elapsedRealtime();
            }
        } else if (i != 1 && i == 2) {
            this.f10716e.m14081b(false);
        }
    }
}
