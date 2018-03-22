package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4822m;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: DeviceInfoManager */
public class C4868y {
    private static Context f17885b;
    private C4822m f17886a;
    private final Object f17887c;

    private C4868y() {
        this.f17887c = new Object();
        this.f17886a = C4822m.m23245a(f17885b);
    }

    public static C4868y m23620a(@NonNull Context context) {
        f17885b = context.getApplicationContext();
        return aa.f17810a;
    }

    public long m23626a(HiDeviceInfo hiDeviceInfo) {
        C2538c.b("Debug_DeviceInfoManager", new Object[]{"insertDeviceInfoData()"});
        return this.f17886a.mo4566a(C4836a.m23304a(hiDeviceInfo));
    }

    private long m23623c(HiDeviceInfo hiDeviceInfo) {
        if (hiDeviceInfo == null || C4539a.m21748a(hiDeviceInfo.getDeviceUniqueCode())) {
            C2538c.d("Debug_DeviceInfoManager", new Object[]{"updateDeviceInfoData() deviceUUID = null"});
            return 0;
        }
        ContentValues a = C4836a.m23304a(hiDeviceInfo);
        a.remove("createTime");
        C2538c.b("Debug_DeviceInfoManager", new Object[]{"updateDeviceInfoData() update  update = ", Integer.valueOf(this.f17886a.mo4565a(a, m23621b(), m23624c(hiDeviceInfo.getDeviceUniqueCode())))});
        return (long) this.f17886a.mo4565a(a, m23621b(), m23624c(hiDeviceInfo.getDeviceUniqueCode()));
    }

    private boolean m23622b(String str) {
        if (!C4539a.m21748a(str)) {
            return C4841f.m23368f(this.f17886a.mo4568a(m23621b(), m23624c(str), null, null, null));
        }
        C2538c.d("Debug_DeviceInfoManager", new Object[]{"queryDeviceInfoDataExist() deviceUUID = null"});
        return false;
    }

    public boolean m23629b(HiDeviceInfo hiDeviceInfo) {
        boolean a;
        synchronized (this.f17887c) {
            long c;
            if (m23622b(hiDeviceInfo.getDeviceUniqueCode())) {
                c = m23623c(hiDeviceInfo);
            } else {
                c = m23626a(hiDeviceInfo);
            }
            a = C4843h.m23395a(c);
        }
        return a;
    }

    public int m23625a(String str) {
        C2538c.b("Debug_DeviceInfoManager", new Object[]{"getDeviceId"});
        if (!C4539a.m21748a(str)) {
            return C4842g.m23372b(this.f17886a.mo4568a(m23621b(), m23624c(str), null, null, null), "_id");
        }
        C2538c.d("Debug_DeviceInfoManager", new Object[]{"getDeviceId() deviceUUID = null"});
        return 0;
    }

    public HiDeviceInfo m23627a(int i) {
        String[] strArr = new String[]{Integer.toString(i)};
        return C4840e.m23348d(this.f17886a.mo4568a("_id =? ", strArr, null, null, null));
    }

    private String m23621b() {
        return "device_unique_code =? ";
    }

    private String[] m23624c(String str) {
        return new String[]{str};
    }

    public List<HiDeviceInfo> m23628a() {
        return C4840e.m23349e(this.f17886a.mo4568a(null, null, null, null, null));
    }
}
