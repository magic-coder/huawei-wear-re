package com.amap.api.location;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import java.util.Iterator;

class LocationManagerProxy$b implements AMapLocationListener {
    final /* synthetic */ LocationManagerProxy f10627a;

    LocationManagerProxy$b(LocationManagerProxy locationManagerProxy) {
        this.f10627a = locationManagerProxy;
    }

    public void onLocationChanged(Location location) {
        try {
            if (LocationManagerProxy.a(this.f10627a) != null && LocationManagerProxy.a(this.f10627a).size() > 0) {
                Iterator it = LocationManagerProxy.a(this.f10627a).iterator();
                while (it.hasNext()) {
                    PendingIntent pendingIntent = (PendingIntent) it.next();
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(LocationManagerProxy.KEY_LOCATION_CHANGED, location);
                    intent.putExtras(bundle);
                    pendingIntent.send(LocationManagerProxy.b(this.f10627a), 0, intent);
                }
            }
        } catch (CanceledException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        try {
            if (LocationManagerProxy.a(this.f10627a) != null && LocationManagerProxy.a(this.f10627a).size() > 0) {
                Iterator it = LocationManagerProxy.a(this.f10627a).iterator();
                while (it.hasNext()) {
                    PendingIntent pendingIntent = (PendingIntent) it.next();
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(LocationManagerProxy.KEY_LOCATION_CHANGED, aMapLocation);
                    intent.putExtras(bundle);
                    pendingIntent.send(LocationManagerProxy.b(this.f10627a), 0, intent);
                }
            }
        } catch (CanceledException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
