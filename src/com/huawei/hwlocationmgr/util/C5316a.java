package com.huawei.hwlocationmgr.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.CoordinateConverter.CoordType;
import com.amap.api.maps.model.LatLng;
import com.huawei.hwcommonmodel.p064d.C4734m;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwlocationmgr.p456a.C5314a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: LocationMgrUtil */
public class C5316a {
    private static C5316a f19026a = null;
    private Context f19027b = null;
    private HandlerThread f19028c = null;
    private C5318c f19029d = null;
    private ArrayList<C5314a> f19030e = new ArrayList();
    private ArrayList<C5314a> f19031f = new ArrayList();
    private LocationManager f19032g;
    private LocationListener f19033h = null;
    private LocationListener f19034i = null;
    private Location f19035j;
    private long f19036k = 1000;
    private float f19037l = 0.0f;
    private Location f19038m;
    private boolean f19039n = false;
    private LocationListener f19040o = null;
    private long f19041p = 20;
    private float f19042q = 3.0f;
    private List<String> f19043r;
    private boolean f19044s = false;

    public static C5316a m25703a(Context context) {
        C5316a c5316a;
        synchronized (C5316a.class) {
            if (f19026a == null) {
                f19026a = new C5316a(context);
            }
            c5316a = f19026a;
        }
        return c5316a;
    }

    private C5316a(Context context) {
        this.f19027b = context;
        if (this.f19028c == null) {
            this.f19028c = new HandlerThread("LocationMgrUtil");
            this.f19028c.start();
        }
        if (this.f19029d == null) {
            this.f19029d = new C5318c(this, this.f19028c.getLooper());
        }
        m25725h();
    }

    public void m25730a(C5314a c5314a) {
        C2538c.c("LocationMgrUtil", new Object[]{"GPS getLocationObj, callback:", Integer.valueOf(c5314a.hashCode())});
        if (this.f19029d != null && !this.f19031f.contains(c5314a)) {
            this.f19031f.add(c5314a);
            if (!this.f19044s) {
                Message obtainMessage = this.f19029d.obtainMessage(1);
                obtainMessage.arg1 = 2;
                this.f19029d.sendMessage(obtainMessage);
                this.f19044s = true;
            }
        }
    }

    public void m25731a(C5314a c5314a, long j, float f) {
        C2538c.c("LocationMgrUtil", new Object[]{"GPS regLocationChange, callback:", Integer.valueOf(c5314a.hashCode())});
        if (this.f19029d != null && !this.f19030e.contains(c5314a)) {
            this.f19036k = j;
            this.f19037l = f;
            this.f19038m = null;
            this.f19030e.add(c5314a);
            if (!this.f19044s) {
                Message obtainMessage = this.f19029d.obtainMessage(1);
                obtainMessage.arg1 = 1;
                this.f19029d.sendMessage(obtainMessage);
                this.f19044s = true;
            }
        }
    }

    public void m25732b(C5314a c5314a) {
        C2538c.c("LocationMgrUtil", new Object[]{"GPS removeLocationObj, callback:", Integer.valueOf(c5314a.hashCode())});
        if (this.f19030e.contains(c5314a)) {
            this.f19030e.remove(c5314a);
        } else if (this.f19031f.contains(c5314a)) {
            this.f19031f.remove(c5314a);
        }
        if (this.f19029d != null && this.f19030e.size() + this.f19031f.size() == 0) {
            this.f19029d.sendEmptyMessage(2);
        }
    }

    private void m25704a() {
        C2538c.c("LocationMgrUtil", new Object[]{"stopListener() Enter ... "});
        m25723g();
    }

    private static boolean m25708a(Location location) {
        if (location == null) {
            C2538c.b("LocationMgrUtil", new Object[]{"location is null"});
            return false;
        } else if (location.hasAccuracy() && location.getAccuracy() != 0.0f) {
            return true;
        } else {
            C2538c.b("LocationMgrUtil", new Object[]{"invalide location accuracy"});
            return false;
        }
    }

    private void m25712b(Location location) {
        int i = 0;
        C2538c.c("LocationMgrUtil", new Object[]{"updateLocation() enter"});
        if (location != null) {
            if (!C5316a.m25708a(location)) {
                C2538c.b("LocationMgrUtil", new Object[]{"-----!MapTrackingUtils.validateLocation(aLocation)------"});
            } else if ((this.f19030e != null && this.f19030e.size() > 0) || (this.f19031f != null && this.f19031f.size() > 0)) {
                C2538c.c("LocationMgrUtil", new Object[]{"updateLocation() location = " + location.toString()});
                HWLocation hWLocation = new HWLocation(location);
                if (this.f19038m != null) {
                    hWLocation.setComputedInterval(location.getTime() - this.f19038m.getTime());
                    hWLocation.setComputedDistance(m25701a(this.f19038m, location));
                    hWLocation.setComputedSpeed(location.getSpeed());
                } else {
                    hWLocation.setComputedInterval(0);
                    hWLocation.setComputedDistance(0.0f);
                    hWLocation.setComputedSpeed(0.0f);
                }
                this.f19038m = location;
                if (this.f19030e != null) {
                    for (int i2 = 0; i2 < this.f19030e.size(); i2++) {
                        if (this.f19030e.get(i2) != null) {
                            ((C5314a) this.f19030e.get(i2)).mo5127a(hWLocation);
                        }
                    }
                }
                if (this.f19031f != null) {
                    while (i < this.f19031f.size()) {
                        if (this.f19031f.get(i) != null) {
                            ((C5314a) this.f19031f.get(i)).mo5127a(hWLocation);
                        }
                        i++;
                    }
                }
            }
        }
    }

    private void m25711b() {
        if (m25716c()) {
            C2538c.e("LocationMgrUtil", new Object[]{"stopNetworkLocation no permission!"});
        } else if (this.f19034i == null) {
            C2538c.e("LocationMgrUtil", new Object[]{"stopNetworkLocation networkListner is null!"});
        } else {
            this.f19032g.removeUpdates(this.f19034i);
            this.f19034i = null;
        }
    }

    private boolean m25716c() {
        return (ActivityCompat.checkSelfPermission(this.f19027b, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this.f19027b, "android.permission.ACCESS_COARSE_LOCATION") == 0) ? false : true;
    }

    private void m25717d() {
        if (m25716c()) {
            C2538c.e("LocationMgrUtil", new Object[]{"startNetworkLocation no permission!"});
            this.f19044s = false;
        } else if (this.f19043r == null) {
            C2538c.e("LocationMgrUtil", new Object[]{"startNetworkLocation mList is null"});
        } else if (this.f19043r.contains(LocationManagerProxy.NETWORK_PROVIDER)) {
            this.f19034i = new C5319d();
            this.f19032g.requestLocationUpdates(LocationManagerProxy.NETWORK_PROVIDER, this.f19036k, this.f19037l, this.f19034i);
        }
    }

    private void m25705a(int i) {
        this.f19032g = (LocationManager) this.f19027b.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        this.f19043r = this.f19032g.getAllProviders();
        m25707a(true);
        if (this.f19043r != null) {
            m25720e();
            if (2 == i) {
                m25717d();
            }
        }
    }

    private void m25720e() {
        if (m25716c()) {
            C2538c.e("LocationMgrUtil", new Object[]{"startGpsLocation no permission!"});
            if (this.f19031f != null) {
                for (int i = 0; i < this.f19031f.size(); i++) {
                    if (this.f19031f.get(i) != null) {
                        ((C5314a) this.f19031f.get(i)).mo5126a(0, "no permission!");
                    }
                }
            }
            this.f19044s = false;
        } else if (this.f19043r.contains("gps")) {
            this.f19033h = new C5319d();
            this.f19032g.requestLocationUpdates("gps", this.f19036k, this.f19037l, this.f19033h);
        }
    }

    private void m25721f() {
        if (m25716c()) {
            C2538c.e("LocationMgrUtil", new Object[]{"stopGpsLocation no permission!"});
        } else if (this.f19033h == null) {
            C2538c.e("LocationMgrUtil", new Object[]{"stopGpsLocation gpsListener is null!"});
        } else {
            this.f19032g.removeUpdates(this.f19033h);
            this.f19033h = null;
        }
    }

    private void m25723g() {
        if (this.f19032g != null) {
            m25707a(false);
            m25721f();
            m25711b();
            this.f19032g = null;
        }
    }

    private float m25701a(Location location, Location location2) {
        if (location == null || location2 == null) {
            return 0.0f;
        }
        return AMapUtils.calculateLineDistance(new LatLng(location.getLatitude(), location.getLongitude()), new LatLng(location2.getLatitude(), location2.getLongitude()));
    }

    public Location m25729a(Context context, Location location) {
        CoordinateConverter coordinateConverter = new CoordinateConverter(context);
        coordinateConverter.from(CoordType.GPS);
        coordinateConverter.coord(new LatLng(location.getLatitude(), location.getLongitude()));
        LatLng convert = coordinateConverter.convert();
        if (convert != null) {
            location.setLatitude(convert.latitude);
            location.setLongitude(convert.longitude);
        }
        return location;
    }

    private void m25725h() {
        if (this.f19032g == null) {
            this.f19032g = (LocationManager) this.f19027b.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        }
        this.f19039n = this.f19032g.isProviderEnabled("GpsMockProvider");
    }

    private void m25726i() {
        if (m25716c()) {
            C2538c.e("LocationMgrUtil", new Object[]{"requestMockLocation no permission!"});
            return;
        }
        if (this.f19032g == null) {
            this.f19032g = (LocationManager) this.f19027b.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        }
        this.f19040o = new C5319d();
        this.f19032g.requestLocationUpdates("GpsMockProvider", this.f19041p, this.f19042q, this.f19040o);
    }

    private void m25727j() {
        if (this.f19032g == null) {
            C2538c.e("LocationMgrUtil", new Object[]{"unRegMockLocation mMylocationManager is null!"});
            return;
        }
        m25728k();
        this.f19032g = null;
    }

    private void m25728k() {
        if (m25716c()) {
            C2538c.e("LocationMgrUtil", new Object[]{"stopMockLocation no permission!"});
        } else if (this.f19040o == null) {
            C2538c.e("LocationMgrUtil", new Object[]{"stopMockLocation mockListner is null!"});
        } else {
            this.f19032g.removeUpdates(this.f19040o);
            this.f19040o = null;
        }
    }

    private void m25707a(boolean z) {
        String b = C4734m.m22644b(System.currentTimeMillis());
        C2538c.c("LocationMgrUtil", new Object[]{"LocationStatus time = " + b + " isOn = " + String.valueOf(z)});
        a.a(this.f19027b, "locationmgr_status", "locationmgr_key", b + HwAccountConstants.BLANK + r1, new com.huawei.hwdataaccessmodel.a.c());
    }
}
