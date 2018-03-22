package com.aps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.text.SimpleDateFormat;

final class C3511u implements LocationListener {
    private /* synthetic */ bz f13238a;

    C3511u(bz bzVar) {
        this.f13238a = bzVar;
    }

    private static boolean m17630a(Location location) {
        return location != null && "gps".equalsIgnoreCase(location.getProvider()) && location.getLatitude() > -90.0d && location.getLatitude() < 90.0d && location.getLongitude() > -180.0d && location.getLongitude() < 180.0d;
    }

    public final void onLocationChanged(Location location) {
        try {
            long time = location.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(Long.valueOf(time));
            simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            if (time > 0) {
                currentTimeMillis = time;
            }
            if (location != null && C3511u.m17630a(location)) {
                if (location.getSpeed() > ((float) bz.f13105e)) {
                    ab.m17182a(bz.f13108h);
                    ab.m17183b(bz.f13108h * 10);
                } else if (location.getSpeed() > ((float) bz.f13104d)) {
                    ab.m17182a(bz.f13107g);
                    ab.m17183b(bz.f13107g * 10);
                } else {
                    ab.m17182a(bz.f13106f);
                    ab.m17183b(bz.f13106f * 10);
                }
                this.f13238a.f13140y.m17173a();
                C3511u.m17630a(location);
                if (this.f13238a.f13140y.m17173a() && C3511u.m17630a(location)) {
                    location.setTime(System.currentTimeMillis());
                    this.f13238a.f13132q = System.currentTimeMillis();
                    this.f13238a.f13114D = location;
                    if (!this.f13238a.f13126k) {
                        bz.m17484a(this.f13238a, location, 0, currentTimeMillis);
                    } else {
                        ao.m17282a("collector");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
