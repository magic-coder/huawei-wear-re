package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.amap.api.maps.model.LatLng;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.LocationData;

/* compiled from: TrackActivity */
class C1828j extends Thread {
    final /* synthetic */ TrackActivity f5142a;
    private boolean f5143b = false;

    C1828j(TrackActivity trackActivity) {
        this.f5142a = trackActivity;
    }

    public void run() {
        this.f5143b = true;
        super.run();
        while (this.f5143b) {
            int size = this.f5142a.f5079E.size();
            for (int i = 0; i < size && this.f5143b; i++) {
                LocationData locationData = (LocationData) this.f5142a.f5079E.get(i);
                if (i == 0) {
                    this.f5142a.f5095U = true;
                    if ("0".equals(locationData.data1)) {
                        this.f5142a.m8702a(locationData);
                    }
                    this.f5142a.m8772m();
                }
                if (i > 0) {
                    double b;
                    LocationData locationData2 = (LocationData) this.f5142a.f5079E.get(i - 1);
                    LatLng latLng = new LatLng(locationData2.lat, locationData2.lon);
                    LatLng latLng2 = new LatLng(locationData.lat, locationData.lon);
                    if (i > 1) {
                        this.f5142a.ae = this.f5142a.m8688a(locationData2, locationData);
                        if ("0".equals(locationData2.data1)) {
                            this.f5142a.m8702a(locationData2);
                        }
                    }
                    this.f5142a.am.setRotateAngle((float) this.f5142a.m8688a(locationData2, locationData));
                    double a = this.f5142a.m8687a(latLng, latLng2);
                    int i2 = latLng.latitude > latLng2.latitude ? 1 : 0;
                    double a2 = this.f5142a.m8686a(a, latLng);
                    if (i2 != 0) {
                        b = this.f5142a.m8685a(a);
                    } else {
                        b = -1.0d * this.f5142a.m8685a(a);
                    }
                    double d = latLng.latitude;
                    while (true) {
                        if (((d > latLng2.latitude ? 1 : 0) ^ i2) == 0 && this.f5143b) {
                            LatLng latLng3;
                            if (a != Double.MAX_VALUE) {
                                latLng3 = new LatLng(d, (d - a2) / a);
                            } else {
                                latLng3 = new LatLng(d, latLng.longitude);
                            }
                            this.f5142a.am.setPosition(latLng3);
                            try {
                                Thread.sleep(80);
                            } catch (InterruptedException e) {
                                String[] strArr = new Object[1];
                                strArr[0] = "Exception e = " + e.getMessage();
                                C2538c.m12680e("KIDWATCH_TrackActivity", strArr);
                                m8796a();
                            }
                            d -= b;
                        }
                    }
                    if (size - 1 == i) {
                        if (!this.f5143b) {
                            break;
                        }
                        this.f5142a.f5096V = true;
                        if (this.f5142a.am != null && this.f5142a.am.isVisible()) {
                            this.f5142a.am.setVisible(false);
                            this.f5142a.am.remove();
                        }
                        if ("0".equals(locationData.data1)) {
                            this.f5142a.m8702a(locationData);
                        }
                        m8796a();
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public void m8796a() {
        this.f5143b = false;
    }
}
