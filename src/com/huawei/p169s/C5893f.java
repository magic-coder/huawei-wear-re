package com.huawei.p169s;

import com.huawei.datatype.GPSStruct;
import com.huawei.hwlocationmgr.p456a.C5314a;
import com.huawei.hwlocationmgr.util.HWLocation;
import com.huawei.p190v.C2538c;
import com.huawei.s.b;

/* compiled from: HWGPSLocationManager */
class C5893f implements C5314a {
    final /* synthetic */ b f20187a;

    C5893f(b bVar) {
        this.f20187a = bVar;
    }

    public void mo5127a(HWLocation hWLocation) {
        int i = 0;
        C2538c.c("HWGPSLocationManager", new Object[]{"onLocationChanged enter"});
        if (b.a(this.f20187a) != null) {
            GPSStruct gPSStruct = new GPSStruct();
            String stringBuffer = new StringBuffer(Integer.toBinaryString(b.a(this.f20187a).getGps_info_bitmap())).reverse().toString();
            if (hWLocation != null && 0.0f <= hWLocation.getDistance()) {
                b.a(this.f20187a, b.d(this.f20187a) + ((long) ((int) (hWLocation.getDistance() * 10.0f))));
                C2538c.c("HWGPSLocationManager", new Object[]{"onLocationChanged speed=" + hWLocation.getSpeed() + ",distance=" + hWLocation.getDistance() + ",altitude=" + hWLocation.getAltitude() + ",totaldistance=" + b.d(this.f20187a) + ",longitude=" + hWLocation.getLongitude() + ",latitude=" + hWLocation.getLatitude()});
                if (stringBuffer != null) {
                    while (i < stringBuffer.length()) {
                        if ('1' == stringBuffer.charAt(i)) {
                            C5897j.m27094a(i, b.d(this.f20187a), hWLocation, gPSStruct);
                        }
                        i++;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    gPSStruct.setGps_start_time((currentTimeMillis - hWLocation.getComputedInterval()) / 1000);
                    gPSStruct.setGps_end_time(currentTimeMillis / 1000);
                    b.e(this.f20187a).add(gPSStruct);
                    if (1 == b.a(this.f20187a).getGps_para_format() || (2 == b.a(this.f20187a).getGps_para_format() && b.e(this.f20187a).size() == b.a(this.f20187a).getGps_para_element_num())) {
                        this.f20187a.a(b.e(this.f20187a), this.f20187a.e, hWLocation.hasSpeed());
                        b.e(this.f20187a).clear();
                    }
                }
            }
        }
    }

    public void mo5126a(int i, String str) {
        C2538c.e("HWGPSLocationManager", new Object[]{"locationResultCallback return onFailed!"});
    }
}
