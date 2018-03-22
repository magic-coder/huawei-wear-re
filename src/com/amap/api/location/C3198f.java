package com.amap.api.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.location.core.C3191c;
import com.aps.bv;

/* compiled from: IGPSManager */
class C3198f implements LocationListener {
    final /* synthetic */ C3196d f10720a;

    C3198f(C3196d c3196d) {
        this.f10720a = c3196d;
    }

    public void onLocationChanged(Location location) {
        AMapLocation aMapLocation;
        Message message;
        Exception e;
        Throwable th;
        Message message2;
        AMapLocation aMapLocation2;
        try {
            this.f10720a.f10716e.m14081b(true);
            this.f10720a.f10716e.f10639e = SystemClock.elapsedRealtime();
            aMapLocation = null;
            if (location == null) {
                message = new Message();
                message.obj = null;
                message.what = 100;
                if (this.f10720a.f10715d != null) {
                    this.f10720a.f10715d.sendMessage(message);
                }
                this.f10720a.f10716e.f10638d = true;
                if (this.f10720a.f10716e.f10637c != null && this.f10720a.f10716e.f10637c.f10665a != null) {
                    this.f10720a.f10716e.f10637c.f10665a.mo4143a(this.f10720a.f10717f, null);
                    return;
                }
                return;
            }
            if (C3191c.m14121a(location.getLatitude(), location.getLongitude())) {
                double[] a = bv.m17465a(location.getLongitude(), location.getLatitude());
                aMapLocation2 = new AMapLocation(location);
                try {
                    aMapLocation2.setLatitude(a[1]);
                    aMapLocation2.setLongitude(a[0]);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        message = new Message();
                        message.obj = aMapLocation2;
                        message.what = 100;
                        if (this.f10720a.f10715d != null) {
                            this.f10720a.f10715d.sendMessage(message);
                        }
                        this.f10720a.f10716e.f10638d = true;
                        if (this.f10720a.f10716e.f10637c != null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aMapLocation = aMapLocation2;
                        message2 = new Message();
                        message2.obj = aMapLocation;
                        message2.what = 100;
                        if (this.f10720a.f10715d != null) {
                            this.f10720a.f10715d.sendMessage(message2);
                        }
                        this.f10720a.f10716e.f10638d = true;
                        if (!(this.f10720a.f10716e.f10637c == null || this.f10720a.f10716e.f10637c.f10665a == null)) {
                            this.f10720a.f10716e.f10637c.f10665a.mo4143a(this.f10720a.f10717f, aMapLocation);
                        }
                        throw th;
                    }
                }
            }
            aMapLocation2 = new AMapLocation(location);
            message = new Message();
            message.obj = aMapLocation2;
            message.what = 100;
            if (this.f10720a.f10715d != null) {
                this.f10720a.f10715d.sendMessage(message);
            }
            this.f10720a.f10716e.f10638d = true;
            if (this.f10720a.f10716e.f10637c != null && this.f10720a.f10716e.f10637c.f10665a != null) {
                this.f10720a.f10716e.f10637c.f10665a.mo4143a(this.f10720a.f10717f, aMapLocation2);
            }
        } catch (Exception e3) {
            e = e3;
            aMapLocation2 = null;
            e.printStackTrace();
            message = new Message();
            message.obj = aMapLocation2;
            message.what = 100;
            if (this.f10720a.f10715d != null) {
                this.f10720a.f10715d.sendMessage(message);
            }
            this.f10720a.f10716e.f10638d = true;
            if (this.f10720a.f10716e.f10637c != null && this.f10720a.f10716e.f10637c.f10665a != null) {
                this.f10720a.f10716e.f10637c.f10665a.mo4143a(this.f10720a.f10717f, aMapLocation2);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            this.f10720a.f10716e.m14081b(false);
        }
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0 || i == 1) {
            this.f10720a.f10716e.m14081b(false);
        }
    }
}
