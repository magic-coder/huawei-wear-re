package com.huawei.al;

import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.a.b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.n.c;
import com.huawei.p108n.C5495a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceMgrUtils */
public class C4028a {
    public static int m19822a(int i) {
        if (i == -1) {
            return 0;
        }
        return C5495a.m26236a(i).m26259e();
    }

    public static String m19823a() {
        String str = "";
        DeviceInfo c = c.a(BaseApplication.b()).c();
        if (c != null) {
            return c.getUUID() + "#ANDROID21";
        }
        return str;
    }

    public static void m19824a(DeviceInfo deviceInfo) {
        C2538c.c("DeviceMgrUtils", new Object[]{"registerDeviceToHiHealth enter"});
        HiDeviceInfo hiDeviceInfo = new HiDeviceInfo();
        hiDeviceInfo.setDeviceUniqueCode(deviceInfo.getUUID() + "#ANDROID21");
        hiDeviceInfo.setDeviceName(deviceInfo.getDeviceName());
        hiDeviceInfo.setDeviceType(C4028a.m19822a(deviceInfo.getProductType()));
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        C2538c.c("DeviceMgrUtils", new Object[]{"registerDeviceToHiHealth mac:", hiDeviceInfo.getDeviceUniqueCode(), " type=", Integer.valueOf(hiDeviceInfo.getDeviceType())});
        b.a(BaseApplication.b()).a(hiDeviceInfo, arrayList, null);
    }
}
