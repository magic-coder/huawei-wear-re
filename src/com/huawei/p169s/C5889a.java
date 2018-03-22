package com.huawei.p169s;

import android.support.v4.media.TransportMediator;
import com.huawei.datatype.GPSStruct;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GPSManager */
public class C5889a {
    private static List<IBaseResponseCallback> f20180a = new ArrayList();
    private static List<IBaseResponseCallback> f20181b = new ArrayList();
    private static List<IBaseResponseCallback> f20182c = new ArrayList();
    private static List<IBaseResponseCallback> f20183d = new ArrayList();

    public static List<IBaseResponseCallback> m27087a() {
        return (List) C0978h.a(f20180a);
    }

    public static List<IBaseResponseCallback> m27088b() {
        return (List) C0978h.a(f20182c);
    }

    public static List<IBaseResponseCallback> m27089c() {
        return (List) C0978h.a(f20181b);
    }

    public static List<IBaseResponseCallback> m27090d() {
        return (List) C0978h.a(f20183d);
    }

    public static boolean m27091e() {
        boolean isSupportGPSLocation;
        DeviceCapability b = C1023c.a(BaseApplication.b()).b();
        if (b != null) {
            isSupportGPSLocation = b.isSupportGPSLocation();
        } else {
            isSupportGPSLocation = false;
        }
        C2538c.c("GPSManager", new Object[]{"get Device Support runplan Capacity, capacity=" + isSupportGPSLocation});
        return isSupportGPSLocation;
    }

    public static String m27086a(String str, List<GPSStruct> list, boolean z) {
        int i = 0;
        while (i < list.size()) {
            String str2 = "";
            C2538c.c("GPSManager", new Object[]{"setGPSParameter(): speed is:", Integer.valueOf(((GPSStruct) list.get(i)).getGps_speed())});
            if (-1 != ((GPSStruct) list.get(i)).getGps_speed()) {
                str2 = C0973a.b(((GPSStruct) list.get(i)).getGps_speed());
            }
            String e = C0973a.e(str2.length() / 2);
            String a = a.a(3);
            String str3 = "";
            if (-1 != ((GPSStruct) list.get(i)).getGps_distance()) {
                str3 = a.a(((GPSStruct) list.get(i)).getGps_distance());
            }
            String e2 = a.e(str3.length() / 2);
            String a2 = a.a(4);
            String str4 = "";
            if (-1 != ((GPSStruct) list.get(i)).getGps_altitude()) {
                str4 = a.b(((GPSStruct) list.get(i)).getGps_altitude());
            }
            String e3 = a.e(str4.length() / 2);
            String a3 = a.a(5);
            String str5 = "";
            if (-1 != ((GPSStruct) list.get(i)).getGps_total_distance()) {
                str5 = a.a(((GPSStruct) list.get(i)).getGps_total_distance());
            }
            String e4 = a.e(str5.length() / 2);
            String a4 = a.a(6);
            String str6 = "";
            if (-1 != ((GPSStruct) list.get(i)).getGps_start_time()) {
                str6 = a.a(((GPSStruct) list.get(i)).getGps_start_time());
            }
            String e5 = a.e(str6.length() / 2);
            String a5 = a.a(7);
            String str7 = "";
            if (-1 != ((GPSStruct) list.get(i)).getGps_end_time()) {
                str7 = a.a(((GPSStruct) list.get(i)).getGps_end_time());
            }
            String e6 = a.e(str7.length() / 2);
            String a6 = a.a(8);
            String str8 = "";
            if (-1.0d != ((GPSStruct) list.get(i)).getGps_h_longitude()) {
                str8 = a.a(((GPSStruct) list.get(i)).getGps_h_longitude());
            }
            String e7 = a.e(str8.length() / 2);
            String a7 = a.a(12);
            if (!"".equals(str8)) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): gpsHLongitudeValueHex = " + str8});
            }
            String str9 = "";
            if (-1.0d != ((GPSStruct) list.get(i)).getGps_h_latitude()) {
                str9 = a.a(((GPSStruct) list.get(i)).getGps_h_latitude());
            }
            String e8 = a.e(str9.length() / 2);
            String a8 = a.a(11);
            if (!"".equals(str9)) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): gpsHLatitudeValueHex = " + str9});
            }
            String str10 = "";
            if (-1.0d != ((GPSStruct) list.get(i)).getGps_longitude()) {
                str10 = a.a(((GPSStruct) list.get(i)).getGps_longitude());
            }
            String e9 = a.e(str10.length() / 2);
            String a9 = a.a(10);
            if (!"".equals(str10)) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): gpsLongitudeValueHex = " + str10});
            }
            String str11 = "";
            if (-1.0d != ((GPSStruct) list.get(i)).getGps_latitude()) {
                str11 = a.a(((GPSStruct) list.get(i)).getGps_latitude());
            }
            String e10 = a.e(str11.length() / 2);
            String a10 = a.a(9);
            if (!"".equals(str11)) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): gpsLatitudeValueHex = " + str11});
            }
            String str12 = "";
            if (-1.0d != ((GPSStruct) list.get(i)).getGps_direction()) {
                str12 = a.a(((GPSStruct) list.get(i)).getGps_direction());
            }
            String e11 = a.e(str12.length() / 2);
            String a11 = a.a(13);
            if (!"".equals(str12)) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): gpsDirectionValueHex = " + str12});
            }
            String str13 = "";
            if (-1.0d != ((GPSStruct) list.get(i)).getGps_precision()) {
                str13 = a.a(((GPSStruct) list.get(i)).getGps_precision());
            }
            String e12 = a.e(str13.length() / 2);
            String a12 = a.a(14);
            if (!"".equals(str13)) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): gpsPrecisionValueHex = " + str13});
            }
            String str14 = "";
            if (!z || -1 == ((GPSStruct) list.get(i)).getGps_speed()) {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): noSpeed"});
                str14 = a2 + e2 + str3 + a3 + e3 + str4 + a4 + e4 + str5 + a5 + e5 + str6 + a6 + e6 + str7;
            } else {
                C2538c.c("GPSManager", new Object[]{"setGPSParameter(): haveSpeed"});
                str14 = a + e + str2 + a2 + e2 + str3 + a3 + e3 + str4 + a4 + e4 + str5 + a5 + e5 + str6 + a6 + e6 + str7;
            }
            if (!"".equals(str11)) {
                str14 = str14 + a10 + e10 + str11;
            }
            if (!"".equals(str10)) {
                str14 = str14 + a9 + e9 + str10;
            }
            if (!"".equals(str9)) {
                str14 = str14 + a8 + e8 + str9;
            }
            if (!"".equals(str8)) {
                str14 = str14 + a7 + e7 + str8;
            }
            if (!"".equals(str12)) {
                str14 = str14 + a11 + e11 + str12;
            }
            if (!"".equals(str13)) {
                str14 = str14 + a12 + e12 + str13;
            }
            str = str + a.a(TransportMediator.KEYCODE_MEDIA_RECORD) + a.e(str14.length() / 2) + str14;
            i++;
        }
        return str;
    }
}
