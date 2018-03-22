package com.amap.api.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.location.core.d;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class LocationManagerProxy {
    public static final String GPS_PROVIDER = "gps";
    public static final String KEY_LOCATION_CHANGED = "location";
    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    public static final String KEY_PROXIMITY_ENTERING = "entering";
    public static final String KEY_STATUS_CHANGED = "status";
    public static final String NETWORK_PROVIDER = "network";
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;
    static Object f114a = new Object();
    private static LocationManagerProxy f115c = null;
    private LocationManager f116b = null;
    private a f117d = null;
    private Context f118e;
    private h f119f;
    private b f120g;
    private ArrayList<PendingIntent> f121h = new ArrayList();
    private Hashtable<String, LocationProviderProxy> f122i = new Hashtable();
    private Vector<i> f123j = new Vector();
    private Vector<i> f124k = new Vector();
    private a f125l = new a(this);

    private static void m106a() {
        f115c = null;
    }

    private LocationManagerProxy(Context context) {
        m107a(context);
    }

    private LocationManagerProxy(Activity activity) {
        m107a(activity.getApplicationContext());
    }

    public static LocationManagerProxy getInstance(Activity activity) {
        try {
            synchronized (f114a) {
                if (f115c == null) {
                    f115c = new LocationManagerProxy(activity);
                }
            }
            return f115c;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static synchronized LocationManagerProxy getInstance(Context context) {
        LocationManagerProxy locationManagerProxy;
        synchronized (LocationManagerProxy.class) {
            try {
                if (f115c == null) {
                    f115c = new LocationManagerProxy(context);
                }
                locationManagerProxy = f115c;
            } catch (Throwable th) {
                th.printStackTrace();
                locationManagerProxy = null;
            }
        }
        return locationManagerProxy;
    }

    private void m107a(Context context) {
        try {
            this.f118e = context;
            this.f116b = (LocationManager) context.getSystemService(KEY_LOCATION_CHANGED);
            this.f117d = a.a(context.getApplicationContext(), this.f116b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addProximityAlert(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            if (this.f117d.g) {
                this.f116b.addProximityAlert(d, d2, f, j, pendingIntent);
            }
            this.f117d.a(d, d2, f, j, pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addGeoFenceAlert(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            if (this.f117d != null) {
                this.f117d.b(d, d2, f, j, pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            if (this.f117d != null) {
                this.f117d.b(pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeProximityAlert(PendingIntent pendingIntent) {
        try {
            if (!(this.f117d == null || !this.f117d.g || this.f116b == null)) {
                this.f116b.removeProximityAlert(pendingIntent);
            }
            if (this.f117d != null) {
                this.f117d.a(pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapLocation getLastKnownLocation(String str) {
        try {
            if (this.f117d == null) {
                return null;
            }
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                return this.f117d.a();
            }
            if (this.f116b == null) {
                return null;
            }
            Location lastKnownLocation = this.f116b.getLastKnownLocation(str);
            if (lastKnownLocation != null) {
                return new AMapLocation(lastKnownLocation);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setGpsEnable(boolean z) {
        try {
            if (this.f117d != null) {
                this.f117d.a(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private synchronized void m108a(String str, long j, float f, AMapLocationListener aMapLocationListener, boolean z) {
        try {
            String str2;
            if (this.f117d == null) {
                this.f117d = a.a(this.f118e.getApplicationContext(), this.f116b);
            }
            if (str == null) {
                str2 = LocationProviderProxy.AMapNetwork;
            } else {
                str2 = str;
            }
            if (LocationProviderProxy.AMapNetwork.equals(str2)) {
                if (this.f117d != null) {
                    this.f117d.a(j, f, aMapLocationListener, LocationProviderProxy.AMapNetwork, z);
                }
            } else if (!"gps".equals(str2)) {
                Looper mainLooper = this.f118e.getMainLooper();
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                this.f123j.add(new i(j, f, aMapLocationListener, str2, false));
                this.f116b.requestLocationUpdates(str2, j, f, this.f125l, mainLooper);
            } else if (this.f117d != null) {
                this.f117d.a(j, f, aMapLocationListener, "gps", z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public synchronized void requestLocationUpdates(String str, long j, float f, AMapLocationListener aMapLocationListener) {
        m108a(str, j, f, aMapLocationListener, false);
    }

    public synchronized void requestLocationData(String str, long j, float f, AMapLocationListener aMapLocationListener) {
        m108a(str, j, f, aMapLocationListener, true);
    }

    public synchronized void removeUpdates(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            try {
                if (this.f117d != null) {
                    this.f117d.a(aMapLocationListener);
                }
                this.f116b.removeUpdates(aMapLocationListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.f123j != null && this.f123j.size() > 0) {
            int size = this.f123j.size();
            int i = 0;
            while (i < size) {
                int i2;
                i iVar = (i) this.f123j.get(i);
                if (aMapLocationListener.equals(iVar.b)) {
                    this.f123j.remove(iVar);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + 1;
            }
            if (this.f123j.size() == 0 && this.f125l != null) {
                this.f116b.removeUpdates(this.f125l);
            }
        }
    }

    public void requestLocationUpdates(String str, long j, float f, PendingIntent pendingIntent) {
        try {
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                if (this.f119f == null) {
                    this.f119f = new h(this);
                }
                if (this.f120g == null) {
                    this.f120g = new b(this);
                }
                this.f119f.a(this.f120g, j, f, str);
                this.f121h.add(pendingIntent);
                return;
            }
            this.f121h.add(pendingIntent);
            this.f116b.requestLocationUpdates(str, j, f, pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeUpdates(PendingIntent pendingIntent) {
        try {
            if (this.f119f != null) {
                this.f121h.remove(pendingIntent);
                if (this.f121h.size() == 0) {
                    this.f119f.a();
                }
            }
            this.f119f = null;
            this.f116b.removeUpdates(pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<String> getAllProviders() {
        try {
            List<String> allProviders = this.f116b.getAllProviders();
            if (allProviders == null) {
                allProviders = new ArrayList();
                allProviders.add(LocationProviderProxy.AMapNetwork);
                allProviders.addAll(this.f116b.getAllProviders());
                return allProviders;
            } else if (allProviders.contains(LocationProviderProxy.AMapNetwork)) {
                return allProviders;
            } else {
                allProviders.add(LocationProviderProxy.AMapNetwork);
                return allProviders;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<String> getProviders(boolean z) {
        try {
            List<String> providers = this.f116b.getProviders(z);
            if (!isProviderEnabled(LocationProviderProxy.AMapNetwork)) {
                return providers;
            }
            if (providers == null || providers.size() == 0) {
                providers = new ArrayList();
            }
            providers.add(LocationProviderProxy.AMapNetwork);
            return providers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<String> getProviders(Criteria criteria, boolean z) {
        try {
            List<String> providers = this.f116b.getProviders(criteria, z);
            if (providers == null || providers.size() == 0) {
                providers = new ArrayList();
            }
            if (!LocationProviderProxy.AMapNetwork.equals(getBestProvider(criteria, z))) {
                return providers;
            }
            providers.add(LocationProviderProxy.AMapNetwork);
            return providers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getBestProvider(Criteria criteria, boolean z) {
        try {
            String str = LocationProviderProxy.AMapNetwork;
            if (criteria == null) {
                return str;
            }
            if (!getProvider(LocationProviderProxy.AMapNetwork).meetsCriteria(criteria)) {
                str = this.f116b.getBestProvider(criteria, z);
            }
            if (!z || d.a(this.f118e)) {
                return str;
            }
            return this.f116b.getBestProvider(criteria, z);
        } catch (Throwable th) {
            th.printStackTrace();
            return "gps";
        }
    }

    public boolean isProviderEnabled(String str) {
        try {
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                return d.a(this.f118e);
            }
            return this.f116b.isProviderEnabled(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public LocationProviderProxy getProvider(String str) {
        if (str == null) {
            try {
                throw new IllegalArgumentException("name不能为空！");
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else if (this.f122i.containsKey(str)) {
            return (LocationProviderProxy) this.f122i.get(str);
        } else {
            LocationProviderProxy a = LocationProviderProxy.a(this.f116b, str);
            this.f122i.put(str, a);
            return a;
        }
    }

    public GpsStatus getGpsStatus(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = null;
        try {
            if (this.f116b != null) {
                gpsStatus2 = this.f116b.getGpsStatus(gpsStatus);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return gpsStatus2;
    }

    public void removeGpsStatusListener(Listener listener) {
        try {
            if (this.f116b != null) {
                this.f116b.removeGpsStatusListener(listener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean addGpsStatusListener(Listener listener) {
        try {
            if (this.f116b != null) {
                return this.f116b.addGpsStatusListener(listener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void addTestProvider(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2) {
        try {
            if (this.f116b != null) {
                this.f116b.addTestProvider(str, z, z2, z3, z4, z5, z6, z7, i, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderEnabled(String str, boolean z) {
        try {
            if (this.f116b != null) {
                this.f116b.setTestProviderEnabled(str, z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderLocation(String str, Location location) {
        try {
            if (this.f116b != null) {
                this.f116b.setTestProviderLocation(str, location);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderStatus(String str, int i, Bundle bundle, long j) {
        try {
            if (this.f116b != null) {
                this.f116b.setTestProviderStatus(str, i, bundle, j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderEnabled(String str) {
        try {
            if (this.f116b != null) {
                this.f116b.clearTestProviderEnabled(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderLocation(String str) {
        try {
            if (this.f116b != null) {
                this.f116b.clearTestProviderLocation(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderStatus(String str) {
        try {
            if (this.f116b != null) {
                this.f116b.clearTestProviderStatus(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestWeatherUpdates(int i, AMapLocalWeatherListener aMapLocalWeatherListener) {
        try {
            this.f117d.a(i, aMapLocalWeatherListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public void destory() {
        try {
            destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            synchronized (f114a) {
                a.c();
                if (this.f122i != null) {
                    this.f122i.clear();
                }
                if (this.f123j != null) {
                    this.f123j.clear();
                }
                if (this.f116b != null) {
                    if (this.f125l != null) {
                        this.f116b.removeUpdates(this.f125l);
                    }
                    if (this.f121h != null) {
                        for (int i = 0; i < this.f121h.size(); i++) {
                            PendingIntent pendingIntent = (PendingIntent) this.f121h.get(i);
                            if (pendingIntent != null) {
                                this.f116b.removeUpdates(pendingIntent);
                            }
                        }
                    }
                }
                if (this.f121h != null) {
                    this.f121h.clear();
                }
                this.f117d = null;
                m106a();
                this.f125l = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getVersion() {
        try {
            return "V1.3.3";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
