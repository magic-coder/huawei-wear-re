package com.huawei.p169s;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.datatype.GPSStruct;
import com.huawei.datatype.GpsParameter;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4753t;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwlocationmgr.util.C5316a;
import com.huawei.hwlocationmgr.util.HWLocation;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWGPSUtil */
public class C5897j {
    public static boolean m27098a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        C2538c.c("HWGPSUtil", new Object[]{"isGPSLocationEnable：" + locationManager.isProviderEnabled("gps")});
        C2538c.c("HWGPSUtil", new Object[]{"isNetWorkLocationEnable：" + locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER)});
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER);
    }

    public static void m27094a(int i, long j, HWLocation hWLocation, GPSStruct gPSStruct) {
        switch (i) {
            case 0:
                gPSStruct.setGps_speed((int) (hWLocation.getSpeed() * 10.0f));
                return;
            case 1:
                gPSStruct.setGps_distance((long) ((int) (hWLocation.getDistance() * 10.0f)));
                return;
            case 2:
                gPSStruct.setGps_altitude((int) hWLocation.getAltitude());
                return;
            case 3:
                gPSStruct.setGps_total_distance(j);
                return;
            case 4:
                gPSStruct.setGps_longitude(hWLocation.getLongitude());
                gPSStruct.setGps_latitude(hWLocation.getLatitude());
                return;
            case 5:
                Location a = C5316a.m25703a(BaseApplication.b()).m25729a(BaseApplication.b(), (Location) hWLocation);
                gPSStruct.setGps_h_longitude(a.getLongitude());
                gPSStruct.setGps_h_latitude(a.getLatitude());
                return;
            case 6:
                gPSStruct.setGps_direction((double) hWLocation.getBearing());
                return;
            case 7:
                gPSStruct.setGps_precision((double) hWLocation.getAccuracy());
                return;
            default:
                return;
        }
    }

    public static void m27097a(byte[] bArr) {
        C2538c.c("HWGPSUtil", new Object[]{"getResult(): " + C0973a.a(bArr)});
        if (!C4756w.m22742a(bArr)) {
            String a = a.a(bArr);
            if (4 < a.length()) {
                try {
                    C4754u a2 = new C4756w().m22743a(a.substring(4, a.length()));
                    List list = a2.f17338b;
                    List list2 = a2.f17337a;
                    switch (bArr[1]) {
                        case (byte) 1:
                            C5897j.m27096a(list2, list);
                            return;
                        case (byte) 2:
                            C5897j.m27095a(list2);
                            return;
                        case (byte) 3:
                            C5897j.m27099b(list2);
                            return;
                        case (byte) 4:
                            C5897j.m27100c(list2);
                            return;
                        default:
                            return;
                    }
                } catch (C4753t e) {
                    C2538c.e("HWGPSUtil", new Object[]{"接收命令错误"});
                    return;
                }
                C2538c.e("HWGPSUtil", new Object[]{"接收命令错误"});
                return;
            }
            C2538c.e("HWGPSUtil", new Object[]{"接收命令错误"});
        }
    }

    private static void m27096a(List<C4752s> list, List<C4754u> list2) {
        if (list.size() <= 0 || 127 != Integer.parseInt(((C4752s) list.get(0)).m22732a(), 16)) {
            GpsParameter gpsParameter = new GpsParameter();
            for (C4752s c4752s : ((C4754u) list2.get(0)).f17337a) {
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 2:
                        gpsParameter.setGps_info_bitmap(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    case 3:
                        gpsParameter.setGps_para_format(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    case 4:
                        gpsParameter.setGps_para_element_num(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    case 5:
                        gpsParameter.setGps_threshold(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    default:
                        break;
                }
            }
            synchronized (C5889a.m27087a()) {
                if (C5889a.m27087a().size() != 0) {
                    ((IBaseResponseCallback) C5889a.m27087a().get(0)).onResponse(100000, gpsParameter);
                    C5889a.m27087a().remove(0);
                }
            }
            return;
        }
        synchronized (C5889a.m27087a()) {
            if (C5889a.m27087a().size() != 0) {
                ((IBaseResponseCallback) C5889a.m27087a().get(0)).onResponse(Integer.parseInt(((C4752s) list.get(0)).m22733b(), 16), null);
                C5889a.m27087a().remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m27095a(java.util.List<com.huawei.hwcommonmodel.datatypes.C4752s> r6) {
        /*
        r2 = 1;
        r5 = 16;
        r1 = 0;
        r0 = r6.size();
        if (r0 <= 0) goto L_0x001d;
    L_0x000a:
        r3 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r0 = r6.get(r1);
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;
        r0 = r0.m22732a();
        r0 = java.lang.Integer.parseInt(r0, r5);
        if (r3 != r0) goto L_0x001d;
    L_0x001c:
        return;
    L_0x001d:
        r0 = r6.size();
        if (r0 <= 0) goto L_0x004d;
    L_0x0023:
        r3 = r6.iterator();
    L_0x0027:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x004d;
    L_0x002d:
        r0 = r3.next();
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;
        r4 = r0.m22732a();
        r4 = java.lang.Integer.parseInt(r4, r5);
        switch(r4) {
            case 1: goto L_0x0041;
            default: goto L_0x003e;
        };
    L_0x003e:
        r0 = r1;
    L_0x003f:
        r1 = r0;
        goto L_0x0027;
    L_0x0041:
        r0 = r0.m22733b();
        r0 = java.lang.Integer.parseInt(r0, r5);
        if (r2 != r0) goto L_0x003e;
    L_0x004b:
        r0 = r2;
        goto L_0x003f;
    L_0x004d:
        r2 = com.huawei.p169s.C5889a.m27089c();
        monitor-enter(r2);
        r0 = com.huawei.p169s.C5889a.m27089c();	 Catch:{ all -> 0x0073 }
        r0 = r0.size();	 Catch:{ all -> 0x0073 }
        if (r0 == 0) goto L_0x0071;
    L_0x005c:
        r0 = com.huawei.p169s.C5889a.m27089c();	 Catch:{ all -> 0x0073 }
        r3 = 0;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0073 }
        r0 = (com.huawei.hwbasemgr.IBaseResponseCallback) r0;	 Catch:{ all -> 0x0073 }
        r3 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0073 }
        r0.onResponse(r3, r1);	 Catch:{ all -> 0x0073 }
    L_0x0071:
        monitor-exit(r2);	 Catch:{ all -> 0x0073 }
        goto L_0x001c;
    L_0x0073:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0073 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.s.j.a(java.util.List):void");
    }

    private static void m27099b(List<C4752s> list) {
        int i = 0;
        for (C4752s c4752s : list) {
            int parseInt;
            switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                case 127:
                    parseInt = Integer.parseInt(c4752s.m22733b(), 16);
                    break;
                default:
                    parseInt = i;
                    break;
            }
            i = parseInt;
        }
        synchronized (C5889a.m27088b()) {
            if (C5889a.m27088b().size() != 0) {
                ((IBaseResponseCallback) C5889a.m27088b().get(0)).onResponse(i, null);
                C5889a.m27088b().remove(0);
            }
        }
    }

    private static void m27100c(List<C4752s> list) {
        int i = 0;
        for (C4752s c4752s : list) {
            int parseInt;
            switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                case 127:
                    parseInt = Integer.parseInt(c4752s.m22733b(), 16);
                    break;
                default:
                    parseInt = i;
                    break;
            }
            i = parseInt;
        }
        synchronized (C5889a.m27090d()) {
            if (C5889a.m27090d().size() != 0) {
                ((IBaseResponseCallback) C5889a.m27090d().get(0)).onResponse(i, null);
                C5889a.m27090d().remove(0);
            }
        }
    }
}
