package com.huawei.hwdatamigrate.hihealth.p068d;

import android.content.Context;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4868y;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4838c;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceInfoCache */
public class C4872c {
    private static Context f17890b;
    private C4876h f17891a;

    private C4872c() {
        this.f17891a = new C4876h();
    }

    public static C4872c m23634a(Context context) {
        f17890b = context.getApplicationContext();
        return C4874e.f17892a;
    }

    public HiDeviceInfo m23635a(int i) {
        if (i <= 0) {
            C2538c.d("Debug_DeviceInfoCache", new Object[]{"getDeviceInfo clientID <= 0"});
            return null;
        }
        Object a = this.f17891a.m23637a(i);
        if (a != null && (a instanceof HiDeviceInfo)) {
            return (HiDeviceInfo) a;
        }
        int b = C4850g.m23559a(f17890b).m23564b(i);
        if (b <= 0) {
            C2538c.d("Debug_DeviceInfoCache", new Object[]{"getDeviceInfo deviceID <= 0, clientID = ", Integer.valueOf(i)});
            return null;
        }
        HiDeviceInfo a2 = C4868y.m23620a(f17890b).m23627a(b);
        if (a2 == null) {
            C2538c.d("Debug_DeviceInfoCache", new Object[]{"getDeviceInfo deviceInfo == null, clientID = ", Integer.valueOf(i)});
            return null;
        }
        a2.setPriority(C4838c.m23333a(a2.getDeviceType()).intValue());
        C2538c.c("Debug_DeviceInfoCache", new Object[]{"getDeviceInfo clientID = ", Integer.valueOf(i), ", deviceInfo = ", a2});
        this.f17891a.m23638a(i, a2);
        return a2;
    }
}
